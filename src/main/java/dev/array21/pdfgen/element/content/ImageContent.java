package dev.array21.pdfgen.element.content;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import dev.array21.classvalidator.annotations.Required;
import dev.array21.pdfgen.element.border.BorderSettings;

@JsonAutoDetect
public class ImageContent extends Content {

    @Required private final String data;
    private float height;
    private float width;

    @JsonCreator
    public ImageContent(BorderSettings borderSettings, String data, float height, float width) {
        super(borderSettings);
        this.data = data;
        this.height = height;
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public String getData() {
        return data;
    }
}
