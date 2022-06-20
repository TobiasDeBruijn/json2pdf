package dev.array21.pdfgen.document.element;

import com.fasterxml.jackson.annotation.JsonSubTypes.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.array21.pdfgen.document.element.border.BorderSettings;
import dev.array21.pdfgen.document.element.implementation.ImageElement;
import dev.array21.pdfgen.document.element.implementation.ParagraphElement;
import dev.array21.pdfgen.document.element.implementation.TableElement;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @Type(value = ImageElement.class, name = "Image"),
        @Type(value = ParagraphElement.class, name = "Paragraph"),
        @Type(value = TableElement.class, name = "Table")
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
}
