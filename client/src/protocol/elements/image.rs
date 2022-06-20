use serde::Serialize;
use crate::protocol::elements::Element;

/// An image
#[derive(Debug, Clone, Serialize)]
pub struct Image {
    data: String,
    height: f32,
    width: f32,
}

impl Image {
    /// Create a new image with the image provided in base64
    pub fn new_base64(data: String, height: f32, width: f32) -> Self {
        Self {
            data,
            height,
            width,
        }
    }

    /// Create a new image
    pub fn new_bytes(data: &[u8], height: f32, width: f32) -> Self {
        Self {
            data: base64::encode(data),
            height,
            width,
        }
    }
}

#[allow(clippy::from_over_into)]
impl Into<Element> for Image {
    fn into(self) -> Element {
        Element::image(self)
    }
}
