package dev.array21.pdfgen.protocol;

import com.itextpdf.layout.element.BlockElement;
import com.itextpdf.layout.element.IAbstractElement;
import com.itextpdf.layout.element.IBlockElement;
import dev.array21.pdfgen.util.PdfElement;

public interface IElement {

    <T extends com.itextpdf.layout.element.IElement> PdfElement apply();
}
