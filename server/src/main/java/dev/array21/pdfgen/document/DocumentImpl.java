package dev.array21.pdfgen.document;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import dev.array21.pdfgen.document.element.PdfElement;

public class DocumentImpl extends Document {

    public DocumentImpl(PdfDocument pdfDoc) {
        super(pdfDoc);
    }

    public void add(PdfElement<?> element) {
        if (element.get() instanceof Image) {
            this.add((Image) element.get());
        } else if (element.get() instanceof IBlockElement) {
            this.add((IBlockElement) element.get());
        }
    }
}
