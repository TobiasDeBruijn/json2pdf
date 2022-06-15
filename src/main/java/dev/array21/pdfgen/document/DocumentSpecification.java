package dev.array21.pdfgen.document;


import dev.array21.pdfgen.element.Element;

public class DocumentSpecification {
    private final Element<?>[] elements;
    private final DocumentSettings settings;

    public DocumentSpecification(Element<?>[] elements, DocumentSettings settings) {
        this.elements = elements;
        this.settings = settings;
    }

    public Element<?>[] getElements() {
        return elements;
    }

    public DocumentSettings getSettings() {
        return settings;
    }
}
