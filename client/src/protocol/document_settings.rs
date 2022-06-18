use serde::Serialize;

/// Settings for the document.
/// If a margin is unset, the server's defaults will be used
#[derive(Debug, Clone, Default, Serialize)]
#[serde(rename_all = "camelCase")]
pub struct DocumentSettings {
    #[serde(skip_serializing_if = "Option::is_none")]
    bottom_margin: Option<f32>,
    #[serde(skip_serializing_if = "Option::is_none")]
    top_margin: Option<f32>,
    #[serde(skip_serializing_if = "Option::is_none")]
    left_margin: Option<f32>,
    #[serde(skip_serializing_if = "Option::is_none")]
    right_margin: Option<f32>,
}

impl DocumentSettings {
    /// Create an empty object
    pub fn new() -> Self {
        Self::default()
    }

    /// Set the bottom margin.
    pub fn bottom_margin(mut self, bottom_margin: f32) -> Self {
        self.bottom_margin = Some(bottom_margin);
        self
    }

    /// Set the top margin.
    pub fn top_margin(mut self, top_margin: f32) -> Self {
        self.top_margin = Some(top_margin);
        self
    }

    /// Set the left margin.
    pub fn left_margin(mut self, left_margin: f32) -> Self {
        self.left_margin = Some(left_margin);
        self
    }

    /// Set the right margin.
    pub fn right_margin(mut self, right_margin: f32) -> Self {
        self.right_margin = Some(right_margin);
        self
    }
}
