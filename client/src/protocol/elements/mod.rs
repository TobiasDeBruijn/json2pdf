use crate::protocol::border::BorderSettings;
use serde::Serialize;

mod image;
mod paragraph;
mod table;

pub use image::*;
pub use paragraph::*;
pub use table::*;

#[derive(Debug, Clone, Serialize)]
#[allow(clippy::enum_variant_names)]
enum ElementType {
    ImageElement,
    ParagraphElement,
    TableElement,
}

#[derive(Debug, Clone, Serialize)]
#[serde(untagged)]
enum ElementContentData {
    Image(Image),
    Paragraph(Paragraph),
    Table(Table),
}

#[derive(Debug, Clone, Serialize)]
enum ElementContentType {
    ImageContent,
    ParagraphContent,
    TableContent,
}

#[derive(Debug, Clone, Serialize)]
struct ElementContent {
    #[serde(flatten)]
    c: ElementContentData,
    #[serde(skip_serializing_if = "Option::is_none")]
    #[serde(rename = "borderSettings")]
    border_settings: Option<BorderSettings>,
    #[serde(rename = "type")]
    content_type: ElementContentType,
}

/// An element in the document
#[derive(Debug, Clone, Serialize)]
pub struct Element {
    #[serde(rename = "type")]
    element_type: ElementType,
    content: ElementContent,
}

impl Element {
    /// Image element
    pub fn image(image: Image) -> Self {
        Self {
            element_type: ElementType::ImageElement,
            content: ElementContent {
                content_type: ElementContentType::ImageContent,
                c: ElementContentData::Image(image),
                border_settings: None,
            },
        }
    }

    /// Table element
    pub fn table(table: Table) -> Self {
        Self {
            element_type: ElementType::TableElement,
            content: ElementContent {
                content_type: ElementContentType::TableContent,
                c: ElementContentData::Table(table),
                border_settings: None,
            },
        }
    }

    /// Paragraph element
    pub fn paragraph(paragraph: Paragraph) -> Self {
        Self {
            element_type: ElementType::ParagraphElement,
            content: ElementContent {
                content_type: ElementContentType::ParagraphContent,
                c: ElementContentData::Paragraph(paragraph),
                border_settings: None,
            },
        }
    }

    /// Set the border of the element
    pub fn border(mut self, border: BorderSettings) -> Self {
        self.content.border_settings = Some(border);
        self
    }
}
