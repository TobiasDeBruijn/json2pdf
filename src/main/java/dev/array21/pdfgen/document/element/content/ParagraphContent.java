package dev.array21.pdfgen.document.element.content;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import dev.array21.pdfgen.document.element.border.BorderSettings;

@JsonAutoDetect
public class ParagraphContent extends Content {

    private String fontColor;
    private float fontSize = 20f;
    private String text;

    @JsonCreator
    public ParagraphContent(BorderSettings borderSettings, String fontColor, String text) {
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
}
