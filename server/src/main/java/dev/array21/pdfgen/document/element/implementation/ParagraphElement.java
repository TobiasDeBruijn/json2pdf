package dev.array21.pdfgen.document.element.implementation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.element.Paragraph;
import dev.array21.pdfgen.document.element.Element;
import dev.array21.pdfgen.document.element.PdfElement;
import dev.array21.pdfgen.document.element.border.BorderSettings;
import dev.array21.pdfgen.document.element.Convertable;
import dev.array21.pdfgen.util.ColorUtil;
import dev.array21.pdfgen.util.ElementUtil;

@JsonAutoDetect
public class ParagraphElement extends Element implements Convertable {

    private final String fontColor;
    private final float fontSize = 20f;
    @JsonProperty(required = true)
    private final String text;

    @JsonCreator
    public ParagraphElement(BorderSettings borderSettings, String fontColor, String text) {
        super(borderSettings);
        this.fontColor = fontColor;
        this.text = text;
    }

    public float getFontSize() {
        return fontSize;
    }

    public String getText() {
        return text;
    }

    public String getFontColor() {
        return fontColor;
    }
    @Override
    public PdfElement<Paragraph> convert() {
        int[] fontColor = ColorUtil.getColors(this.getFontColor());
        Paragraph paragraph = new Paragraph(this.getText())
                .setFontSize(this.getFontSize())
                .setFontColor(new DeviceRgb(fontColor[0], fontColor[1], fontColor[2]));
        ElementUtil.applyBorder(paragraph, this.getBorderSettings());
        return new PdfElement<>(paragraph);
    }
}
