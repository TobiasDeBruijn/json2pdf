package dev.array21.pdfgen.protocol;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AbstractElement;
import com.itextpdf.layout.element.IBlockElement;

public class Element implements IElement {

    private String type;

    @Override
    public IBlockElement apply() {
        return null;
    }

    public static class Content {
        public BorderSettings borderSettings;
    }
}
