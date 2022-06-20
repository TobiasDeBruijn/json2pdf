use crate::protocol::border::BorderSettings;
use serde::Serialize;

mod image;
mod paragraph;
mod table;

pub use image::*;
pub use paragraph::*;
pub use table::*;

#[derive(Debug, Clone, Serialize)]
#[serde(untagged)]
enum ElementData {
    Image(Image),
    Paragraph(Paragraph),
    Table(Table),
}

#[derive(Debug, Clone, Serialize)]
enum ElementType {
    ImageContent,
    ParagraphContent,
    TableContent,
}

#[derive(Debug, Clone, Serialize)]
pub struct Element {
    #[serde(flatten)]
    data: ElementData,
    #[serde(skip_serializing_if = "Option::is_none")]
    #[serde(rename = "borderSettings")]
    border_settings: Option<BorderSettings>,
    #[serde(rename = "type")]
    content_type: ElementType,
}

impl Element {
    /// Image element
    pub fn image(image: Image) -> Self {
        Self {
            content_type: ElementType::ImageContent,
            data: ElementData::Image(image),
            border_settings: None,
        }
    }

    /// Table element
    pub fn table(table: Table) -> Self {
        Self {
            content_type: ElementType::TableContent,
            data: ElementData::Table(table),
            border_settings: None,
        }
    }

    /// Paragraph element
    pub fn paragraph(paragraph: Paragraph) -> Self {
        Self {
            content_type: ElementType::ParagraphContent,
            data: ElementData::Paragraph(paragraph),
            border_settings: None,
        }
    }

    /// Set the border of the element
    pub fn border(mut self, border: BorderSettings) -> Self {
        self.border_settings = Some(border);
        self
    }
}
