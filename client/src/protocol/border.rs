use serde::Serialize;

/// Settings for the border of an element.
/// If a side is left unset, no border will be created for that side
#[derive(Debug, Clone, Default, Serialize)]
pub struct BorderSettings {
    #[serde(skip_serializing_if = "Option::is_none")]
    bottom: Option<BorderSpecification>,
    #[serde(skip_serializing_if = "Option::is_none")]
    top: Option<BorderSpecification>,
    #[serde(skip_serializing_if = "Option::is_none")]
    left: Option<BorderSpecification>,
    #[serde(skip_serializing_if = "Option::is_none")]
    right: Option<BorderSpecification>,
}

/// Settings for a specific border
#[derive(Debug, Clone, Serialize)]
pub struct BorderSpecification {
    width: f32,
    #[serde(skip_serializing_if = "Option::is_none")]
    color: Option<String>,
}

impl BorderSpecification {
    /// Create a new border
    pub fn new(width: f32) -> Self {
        Self {
            width,
            color: None,
        }
    }

    /// Set the border's color.
    /// The color should be a six digit hex color without the `#` prefix.
    pub fn color(mut self, color: String) -> Self {
        self.color = Some(color);
        self
    }
}

impl BorderSettings {
    /// Create an empty object
    pub fn new() -> Self {
        Self::default()
    }

    /// Set the bottom border
    pub fn bottom(mut self, spec: BorderSpecification) -> Self {
        self.bottom = Some(spec);
        self
    }

    /// Set the top border
    pub fn top(mut self, spec: BorderSpecification) -> Self {
        self.top = Some(spec);
        self
    }

    /// Set the left border
    pub fn left(mut self, spec: BorderSpecification) -> Self {
        self.left = Some(spec);
        self
    }

    /// Set the right border
    pub fn right(mut self, spec: BorderSpecification) -> Self {
        self.right = Some(spec);
        self
    }
}
