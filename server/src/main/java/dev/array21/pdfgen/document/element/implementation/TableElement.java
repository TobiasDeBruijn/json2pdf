package dev.array21.pdfgen.document.element.implementation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Table;
import dev.array21.pdfgen.document.element.Element;
import dev.array21.pdfgen.document.element.Convertable;
import dev.array21.pdfgen.document.element.PdfElement;
import dev.array21.pdfgen.document.element.border.BorderSettings;
import dev.array21.pdfgen.document.element.implementation.table.Column;
import dev.array21.pdfgen.document.element.implementation.table.Row;
import dev.array21.pdfgen.util.ElementUtil;

@JsonAutoDetect
public class TableElement extends Element implements Convertable {

    @JsonProperty(required = true)
    private final Row[] rows;

    private final float[] pointLayout;

    @JsonCreator
    public TableElement(BorderSettings borderSettings, Row[] rows, float[] pointLayout) {
        super(borderSettings);
        this.rows = rows;
        this.pointLayout = pointLayout;
    }

    public Row[] getRows() {
        return rows;
    }

    public float[] getPointLayout() {
        return pointLayout;
    }

    @Override
    public PdfElement<Table> convert() {
        float[] layout = new float[this.getRows()[0].getColumns().length];
        if (this.getPointLayout() != null) {
            layout = this.getPointLayout();
        }

        Table table = new Table(layout);
        ElementUtil.applyBorder(table, this.getBorderSettings());

        if (this.getRows() != null) {
            for (Row row : this.getRows()) {
                table.startNewRow();

                for (Column column : row.getColumns()) {
                    Cell cell = new Cell();
                    ElementUtil.applyBorder(cell, column.getBorderSettings());

                    if (column.getElements() != null) {
                        for (Convertable convertable : column.getElements()) {
                            PdfElement<?> element = convertable.convert();
                            cell.add((IBlockElement) element.get());
                        }
                    }

                    table.addCell(cell);
                }
            }
        }

        return new PdfElement<>(table);
    }
}
