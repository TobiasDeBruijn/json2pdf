package dev.array21.pdfgen.document.element.content.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;

@JsonAutoDetect
public class Row {
    private Column[] columns;

    @JsonCreator
    public Row(Column[] columns) {
        this.columns = columns;
    }

    public Column[] getColumns() {
        return columns;
    }

    public void setColumns(Column[] columns) {
        this.columns = columns;
    }
}
