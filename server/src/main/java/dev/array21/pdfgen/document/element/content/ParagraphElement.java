package dev.array21.pdfgen.document.element.content;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
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

    private String fontColor;
    private float fontSize = 20f;
    private String text;

    @JsonCreator
    public ParagraphElement(BorderSettings borderSettings, String fontColor, String text) {
        super(borderSettings);
        this.fontColor = fontColor;
        this.text = text;
    }

    public float getFontSize() {
        return fontSize;
    }

    public void setFontSize(float fontSize) {
        this.fontSize = fontSize;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
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
