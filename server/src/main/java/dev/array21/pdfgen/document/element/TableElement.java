package dev.array21.pdfgen.document.element;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Table;
import dev.array21.pdfgen.document.element.content.TableContent;
import dev.array21.pdfgen.document.element.table.Column;
import dev.array21.pdfgen.document.element.table.Row;
import dev.array21.pdfgen.util.ElementUtil;

@JsonAutoDetect
public class TableElement extends Element<TableContent> {

    @JsonCreator
    public TableElement(TableContent content) {
        super(content);
    }

    @Override
    public PdfElement<Table> convert() {
        float[] layout = new float[this.getContent().getRows()[0].getColumns().length];
        if (this.getContent().getPointLayout() != null) {
            layout = this.getContent().getPointLayout();
        }

        Table table = new Table(layout);
        ElementUtil.applyBorder(table, this.getContent().getBorderSettings());

        if (this.getContent().getRows() != null) {
            for (Row row : this.getContent().getRows()) {
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
