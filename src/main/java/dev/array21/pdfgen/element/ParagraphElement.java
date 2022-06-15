package dev.array21.pdfgen.element;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.element.Paragraph;
import dev.array21.pdfgen.element.content.ParagraphContent;
import dev.array21.pdfgen.util.ColorUtil;
import dev.array21.pdfgen.util.ElementUtil;
import dev.array21.pdfgen.util.PdfElement;

@JsonAutoDetect
public class ParagraphElement extends Element<ParagraphContent> implements Convertable {

    @JsonCreator
    public ParagraphElement(ParagraphContent content) {
        super(content);
    }

    @Override
    public PdfElement<Paragraph> convert() {
        int[] fontColor = ColorUtil.getColors(this.getContent().getFontColor());
        Paragraph paragraph = new Paragraph(this.getContent().getText())
                .setFontSize(this.getContent().getFontSize())
                .setFontColor(new DeviceRgb(fontColor[0], fontColor[1], fontColor[2]));
        ElementUtil.applyBorder(paragraph, this.getContent().getBorderSettings());
        return new PdfElement<>(paragraph);
    }
}


