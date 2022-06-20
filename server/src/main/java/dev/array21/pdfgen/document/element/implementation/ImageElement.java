package dev.array21.pdfgen.document.element.implementation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.itextpdf.commons.utils.Base64;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Image;
import dev.array21.pdfgen.document.element.Element;
import dev.array21.pdfgen.document.element.PdfElement;
import dev.array21.pdfgen.document.element.border.BorderSettings;
import dev.array21.pdfgen.document.element.Convertable;
import dev.array21.pdfgen.util.ElementUtil;

@JsonAutoDetect
public class ImageElement extends Element implements Convertable {

    @JsonProperty(required = true)
    private final String data;
    @JsonProperty(required = true)
    private final float height;
    @JsonProperty(required = true)
    private final float width;

    @JsonCreator
    public ImageElement(BorderSettings borderSettings, String data, float height, float width) {
        super(borderSettings);
        this.data = data;
        this.height = height;
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public String getData() {
        return data;
    }

    @Override
    public <T extends IElement> PdfElement<?> convert() {
        byte[] bytes = Base64.decode(this.getData());
        Image img = new Image(ImageDataFactory.create(bytes))
                .setWidth(this.getWidth())
                .setHeight(this.getHeight());
        ElementUtil.applyBorder(img, this.getBorderSettings());
        return new PdfElement<>(img);
    }
}
