use crate::protocol::document_settings::DocumentSettings;
use serde::Serialize;
use std::fmt::Debug;

mod border;
mod document_settings;
mod elements;

pub use border::*;
pub use document_settings::*;
pub use elements::*;

/// The specification for the PDF document
#[derive(Debug, Default, Clone, Serialize)]
pub struct DocumentSpecification {
    #[serde(skip_serializing_if = "Option::is_none")]
    settings: Option<DocumentSettings>,
    elements: Vec<Element>,
}

impl DocumentSpecification {
    /// Create a new specification with no elements
    pub fn new() -> Self {
        Self::default()
    }

    /// Add an element to the document
    pub fn add_element(mut self, element: Element) -> Self {
        self.elements.push(element);
        self
    }

    /// Set all elements for the document
    pub fn set_elements(mut self, elements: Vec<Element>) -> Self {
        self.elements = elements;
        self
    }

    /// Set the document  settings
    pub fn set_document_settings(mut self, document_settings: DocumentSettings) -> Self {
        self.settings = Some(document_settings);
        self
    }
}
