package dev.array21.pdfgen.document;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.array21.pdfgen.document.element.Element;

public class DocumentSpecification {
    @JsonProperty(required = true)
    private final Element[] elements;
    private final DocumentSettings settings;

    public DocumentSpecification(Element[] elements, DocumentSettings settings) {
        this.elements = elements;
        this.settings = settings;
    }

    public Element[] getElements() {
        return elements;
    }

    public DocumentSettings getSettings() {
        return settings;
    }
}
