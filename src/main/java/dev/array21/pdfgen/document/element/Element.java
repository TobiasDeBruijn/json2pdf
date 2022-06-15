package dev.array21.pdfgen.document.element;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.array21.pdfgen.document.element.content.Content;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @Type(value = ImageElement.class, name = "ImageElement"),
        @Type(value = ParagraphElement.class, name = "ParagraphElement"),
        @Type(value = TableElement.class, name = "TableElement")
})
public abstract class Element<T extends Content> implements Convertable {

    private final T content;

    public Element(T content) {
        this.content = content;
    }


    public T getContent() {
        return content;
    }
}
