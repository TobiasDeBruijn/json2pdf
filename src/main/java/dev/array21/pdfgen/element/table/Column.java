package dev.array21.pdfgen.element.table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import dev.array21.pdfgen.element.border.BorderSettings;
import dev.array21.pdfgen.element.Element;

@JsonAutoDetect
public class Column {
    private Element<?>[] elements;
    private BorderSettings borderSettings;

    @JsonCreator
    public Column(Element<?>[] elements) {
        this.elements = elements;
    }

    public Element<?>[] getElements() {
        return elements;
    }

    public void setElements(Element<?>[] elements) {
        this.elements = elements;
    }

    public BorderSettings getBorderSettings() {
        return borderSettings;
    }

    public void setBorderSettings(BorderSettings borderSettings) {
        this.borderSettings = borderSettings;
    }
}
