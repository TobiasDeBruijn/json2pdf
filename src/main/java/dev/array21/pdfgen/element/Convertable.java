package dev.array21.pdfgen.element;

import com.itextpdf.layout.element.IElement;
import dev.array21.pdfgen.util.PdfElement;

public interface Convertable {

    <T extends IElement> PdfElement<?> convert();
}
