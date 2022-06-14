package dev.array21.pdfgen.util;

import com.itextpdf.layout.element.IElement;

public class PdfElement<T extends IElement> {
    private T inner;

    public PdfElement(T t) {
        this.inner = t;
    }

    public T get() {
        return this.inner;
    }
}
