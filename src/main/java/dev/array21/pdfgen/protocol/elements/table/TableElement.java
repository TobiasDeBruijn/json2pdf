package dev.array21.pdfgen.protocol.elements.table;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AbstractElement;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Table;
import dev.array21.pdfgen.protocol.BorderSettings;
import dev.array21.pdfgen.protocol.Element;
import dev.array21.pdfgen.protocol.IElement;
import dev.array21.pdfgen.util.ElementUtil;

public class TableElement extends Element implements IElement  {
    private TableContent content;

    public static class TableContent extends Content {

        public Row[] rows;
        public float[] pointLayout;
    }

    @Override
    public IBlockElement apply() {
        float[] layout = new float[this.content.rows[0].columns.length];
        if(this.content.pointLayout != null) {
            layout = this.content.pointLayout;
        }

        Table table = new Table(layout);
        ElementUtil.applyBorder(table, this.content.borderSettings);

        if(this.content.rows != null) {
            for(Row row : this.content.rows) {
                table.startNewRow();

                for(Column column : row.columns) {
                    Cell cell = new Cell();
                    ElementUtil.applyBorder(cell, column.borderSettings);

                    if(column.elements != null) {
                        for(Element element : column.elements) {
                            cell.add(element.apply());
                        }
                    }

                    table.addCell(cell);
                }
            }
        }

        return table;
    }
}
