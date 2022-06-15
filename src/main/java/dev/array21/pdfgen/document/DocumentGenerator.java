package dev.array21.pdfgen.document;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import dev.array21.pdfgen.element.Convertable;
import dev.array21.pdfgen.util.PdfElement;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;

@Component
public class DocumentGenerator {

    public byte[] generate(DocumentSpecification spec) {
        // Create the document itself
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DocumentImpl document = createPdfDocument(outputStream);

        // Apply the configured margins, if any
        applyDocumentSettings(document, spec);

        if (spec.getElements() != null) {
            for (Convertable convertable : spec.getElements()) {
                PdfElement<?> element = convertable.convert();
                document.add(element);
            }
        }

        document.close();
        return outputStream.toByteArray();
    }

    private void applyDocumentSettings(Document document, DocumentSpecification spec) {
        if (spec.getSettings() == null) {
            return;
        }
        document.setRightMargin(spec.getSettings().getRightMargin());
        document.setBottomMargin(spec.getSettings().getBottomMargin());
        document.setTopMargin(spec.getSettings().getTopMargin());
        document.setLeftMargin(spec.getSettings().getLeftMargin());
    }

    private DocumentImpl createPdfDocument(ByteArrayOutputStream outputStream) {
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outputStream));
        return new DocumentImpl(pdfDocument);
    }
}
