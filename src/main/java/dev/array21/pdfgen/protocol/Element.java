package dev.array21.pdfgen.protocol;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AbstractElement;
import com.itextpdf.layout.element.BlockElement;
import com.itextpdf.layout.element.IAbstractElement;
import com.itextpdf.layout.element.IBlockElement;
import dev.array21.pdfgen.util.PdfElement;

public class Element implements IElement {

    private String type;

    @Override
    public <T extends com.itextpdf.layout.element.IElement> PdfElement<T> apply() {
        return null;
    }

    public static class Content {
        public BorderSettings borderSettings;
    }
}
