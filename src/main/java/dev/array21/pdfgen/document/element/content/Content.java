package dev.array21.pdfgen.document.element.content;

import com.fasterxml.jackson.annotation.JsonSubTypes.*;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.array21.pdfgen.document.element.border.BorderSettings;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @Type(value = ImageContent.class, name = "ImageContent"),
        @Type(value = ParagraphContent.class, name = "ParagraphContent"),
        @Type(value = TableContent.class, name = "TableContent")
})
public abstract class Content {

    private BorderSettings borderSettings;

    @JsonCreator
    public Content(BorderSettings borderSettings) {
        this.borderSettings = borderSettings;
    }

    public BorderSettings getBorderSettings() {
        return borderSettings;
    }

    public void setBorderSettings(BorderSettings borderSettings) {
        this.borderSettings = borderSettings;
    }
}
