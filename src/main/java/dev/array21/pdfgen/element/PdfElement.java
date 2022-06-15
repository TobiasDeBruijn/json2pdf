package dev.array21.pdfgen.element;

import com.itextpdf.layout.element.IElement;

public class PdfElement<T extends IElement> {

    private final T inner;

    public PdfElement(T t) {
        this.inner = t;
    }

    public T get() {
        return this.inner;
    }
}
