package dev.array21.pdfgen.document.element.implementation.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect
public class Row {
    @JsonProperty(required = true)
    private Column[] columns;

    @JsonCreator
    public Row(Column[] columns) {
        this.columns = columns;
    }

    public Column[] getColumns() {
        return columns;
    }
}
