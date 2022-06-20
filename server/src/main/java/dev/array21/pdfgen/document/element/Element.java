package dev.array21.pdfgen.document.element;

import com.fasterxml.jackson.annotation.JsonSubTypes.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.array21.pdfgen.document.element.border.BorderSettings;
import dev.array21.pdfgen.document.element.content.ImageElement;
import dev.array21.pdfgen.document.element.content.ParagraphElement;
import dev.array21.pdfgen.document.element.content.TableElement;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @Type(value = ImageElement.class, name = "ImageContent"),
        @Type(value = ParagraphElement.class, name = "ParagraphContent"),
        @Type(value = TableElement.class, name = "TableContent")
})
public abstract class Element implements Convertable {

    private BorderSettings borderSettings;

    @JsonCreator
    public Element(BorderSettings borderSettings) {
        this.borderSettings = borderSettings;
    }

    public BorderSettings getBorderSettings() {
        return borderSettings;
    }

    public void setBorderSettings(BorderSettings borderSettings) {
        this.borderSettings = borderSettings;
    }
}
