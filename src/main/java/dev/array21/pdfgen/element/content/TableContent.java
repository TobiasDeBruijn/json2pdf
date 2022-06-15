package dev.array21.pdfgen.element.content;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import dev.array21.pdfgen.element.border.BorderSettings;
import dev.array21.pdfgen.element.table.Row;

@JsonAutoDetect
public class TableContent extends Content {

    private Row[] rows;
    private float[] pointLayout;

    @JsonCreator
    public TableContent(BorderSettings borderSettings, Row[] rows, float[] pointLayout) {
        super(borderSettings);
        this.rows = rows;
        this.pointLayout = pointLayout;
    }

    public Row[] getRows() {
        return rows;
    }

    public void setRows(Row[] rows) {
        this.rows = rows;
    }

    public float[] getPointLayout() {
        return pointLayout;
    }

    public void setPointLayout(float[] pointLayout) {
        this.pointLayout = pointLayout;
    }
}
