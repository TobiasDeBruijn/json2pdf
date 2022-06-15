package dev.array21.pdfgen.element;

import com.itextpdf.layout.element.IElement;

public interface Convertable {

    <T extends IElement> PdfElement<?> convert();
}
