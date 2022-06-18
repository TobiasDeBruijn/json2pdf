use crate::protocol::elements::Element;
use serde::Serialize;

/// A paragraph
#[derive(Debug, Clone, Serialize)]
#[serde(rename_all = "camelCase")]
pub struct Paragraph {
    #[serde(skip_serializing_if = "Option::is_none")]
    font_color: Option<String>,
    #[serde(skip_serializing_if = "Option::is_none")]
    font_size: Option<f32>,
    text: String,
}

impl Paragraph {
    /// Create a new paragraph
    pub fn new<S: AsRef<str>>(text: S) -> Self {
        Self {
            font_color: None,
            font_size: None,
            text: text.as_ref().to_string(),
        }
    }

    /// Set the font color. Must be six digit hex without the `#` prefix
    pub fn font_color(mut self, color: String) -> Self {
        self.font_color = Some(color);
        self
    }

    /// Set the font size
    pub fn font_size(mut self, size: f32) -> Self {
        self.font_size = Some(size);
        self
    }
}

#[allow(clippy::from_over_into)]
impl Into<Element> for Paragraph {
    fn into(self) -> Element {
        Element::paragraph(self)
    }
}
