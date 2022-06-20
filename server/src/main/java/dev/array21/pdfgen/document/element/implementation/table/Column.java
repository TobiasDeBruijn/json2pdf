package dev.array21.pdfgen.document.element.implementation.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.array21.pdfgen.document.element.border.BorderSettings;
import dev.array21.pdfgen.document.element.Element;

@JsonAutoDetect
public class Column {
    @JsonProperty(required = true)
    private final Element[] elements;
    private BorderSettings borderSettings;

    @JsonCreator
    public Column(Element[] elements) {
        this.elements = elements;
    }

    public Element[] getElements() {
        return elements;
    }

    public BorderSettings getBorderSettings() {
        return borderSettings;
    }
}
