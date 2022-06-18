use crate::protocol::elements::Element;
use crate::BorderSettings;
use serde::Serialize;

/// A table
#[derive(Debug, Default, Clone, Serialize)]
#[serde(rename_all = "camelCase")]
pub struct Table {
    rows: Vec<Row>,
    #[serde(skip_serializing_if = "Option::is_none")]
    point_layout: Option<Vec<f32>>,
}

impl Table {
    /// Create an empty table
    pub fn new() -> Self {
        Self::default()
    }

    /// Add a row to the table
    pub fn add_row(mut self, row: Row) -> Self {
        self.rows.push(row);
        self
    }

    /// Set all rows in the table
    pub fn set_rows(mut self, rows: Vec<Row>) -> Self {
        self.rows = rows;
        self
    }

    /// The the point layout for the table.
    /// Refer to the [iText documentation](https://api.itextpdf.com/iText7/java/7.1.1/com/itextpdf/layout/element/Table.html#Table-float:A-)
    pub fn set_point_layout(mut self, layout: Vec<f32>) -> Self {
        self.point_layout = Some(layout);
        self
    }
}

#[allow(clippy::from_over_into)]
impl Into<Element> for Table {
    fn into(self) -> Element {
        Element::table(self)
    }
}

/// A row in a table
#[derive(Debug, Default, Clone, Serialize)]
pub struct Row {
    columns: Vec<Column>,
}

impl Row {
    /// Create an empty row
    pub fn new() -> Self {
        Self::default()
    }

    /// Add a column to the row
    pub fn add_column(mut self, column: Column) -> Self {
        self.columns.push(column);
        self
    }

    /// Set all columns in the row
    pub fn set_columns(mut self, columns: Vec<Column>) -> Self {
        self.columns = columns;
        self
    }
}

/// A column in a row
#[derive(Debug, Default, Clone, Serialize)]
#[serde(rename_all = "camelCase")]
pub struct Column {
    border_settings: Option<BorderSettings>,
    elements: Vec<Element>,
}

impl Column {
    /// Create an empty column
    pub fn new() -> Self {
        Self::default()
    }

    /// Add an element to the column
    pub fn add_element(mut self, element: Element) -> Self {
        self.elements.push(element);
        self
    }

    /// Set the elements in the column
    pub fn set_elements(mut self, elements: Vec<Element>) -> Self {
        self.elements = elements;
        self
    }

    /// Set the border settings for the column
    pub fn set_border(mut self, border: BorderSettings) -> Self {
        self.border_settings = Some(border);
        self
    }
}
