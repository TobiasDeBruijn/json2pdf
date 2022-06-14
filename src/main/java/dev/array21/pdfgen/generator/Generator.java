package dev.array21.pdfgen.generator;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Image;
import dev.array21.pdfgen.protocol.DocumentSpecification;
import dev.array21.pdfgen.protocol.Element;

import java.io.ByteArrayOutputStream;

public class Generator {

    public static byte[] generate(DocumentSpecification spec) {
        // Create the document itself
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = createPdfDocument(outputStream);

        // Apply the configured margins, if any
        document = applyDocumentSettings(document, spec);

        if(spec.elements != null) {
            for(Element element : spec.elements) {
                // Yuck
                Object inner = element.apply().get();
                if(inner instanceof IBlockElement) {
                    document.add((IBlockElement) inner);
                } else if (inner instanceof Image) {
                    document.add((Image) inner);
                }
            }
        }

        document.close();
        return outputStream.toByteArray();
    }

    private static Document applyDocumentSettings(Document document, DocumentSpecification spec) {
        if(spec.settings == null) {
            return document;
        }

        document.setRightMargin(spec.settings.rightMargin);
        document.setBottomMargin(spec.settings.bottomMargin);
        document.setTopMargin(spec.settings.topMargin);
        document.setLeftMargin(spec.settings.leftMargin);

        return document;
    }

    private static Document createPdfDocument(ByteArrayOutputStream outputStream) {
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outputStream));
        Document document = new Document(pdfDocument);
        return document;
    }
}
