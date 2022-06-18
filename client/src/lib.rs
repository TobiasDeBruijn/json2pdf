//! json2pdf Client library
//!
//! This library is a client library for the json2pdf server. json2pdf is a Java webserver that generates PDF
//! documents from a JSON model.
//!
//! ## Example
//! Generate a PDF documentation with some text and an image
//! ```no_run
//! use json2pdf_client::*;
//!
//! async fn generate_pdf() {
//!     let spec = DocumentSpecification::new()
//!         .add_element(Element::paragraph(Paragraph::new("Hello world!"))
//!             .border(BorderSettings::new()
//!                 .bottom(BorderSpecification::new(4f32))))
//!         .add_element(Element::image(Image::new_bytes(&Vec::new(), 400f32, 400f32)));
//!
//!     let data = pdf("http://localhost:8080", &spec).await.unwrap();
//! }
//! ```

mod protocol;

pub use protocol::*;
use reqwest::ClientBuilder;

const USER_AGENT: &str = "PDF Rust Client Library";

/// Generate a PDF document accordign to the provided specification
///
/// # Errors
///
/// If the server returns an error
pub async fn pdf<S: AsRef<str>>(
    server: S,
    spec: &DocumentSpecification,
) -> Result<Vec<u8>, reqwest::Error> {
    Ok(ClientBuilder::new()
        .user_agent(USER_AGENT)
        .build()
        .unwrap()
        .get(format!("{}/generate", server.as_ref()))
        .json(spec)
        .send()
        .await?
        .error_for_status()?
        .bytes()
        .await?
        .to_vec())
}

#[cfg(feature = "blocking")]
pub mod blocking {
    use crate::{DocumentSpecification, USER_AGENT};
    use reqwest::blocking::ClientBuilder;

    /// Generate a PDF document accordign to the provided specification
    ///
    /// # Errors
    ///
    /// If the server returns an error
    pub fn pdf<S: AsRef<str>>(
        server: S,
        spec: &DocumentSpecification,
    ) -> Result<Vec<u8>, reqwest::Error> {
        Ok(ClientBuilder::new()
            .user_agent(USER_AGENT)
            .build()
            .unwrap()
            .get(format!("{}/generate", server.as_ref()))
            .json(spec)
            .send()?
            .error_for_status()?
            .bytes()?
            .to_vec())
    }
}
