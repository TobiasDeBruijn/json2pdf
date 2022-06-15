package dev.array21.pdfgen.element;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.itextpdf.commons.utils.Base64;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Image;
import dev.array21.pdfgen.element.content.ImageContent;
import dev.array21.pdfgen.util.ElementUtil;

@JsonAutoDetect
public class ImageElement extends Element<ImageContent> implements Convertable {

    @JsonCreator
    public ImageElement(ImageContent content) {
        super(content);
    }

    @Override
    public PdfElement<Image> convert() {
        byte[] bytes = Base64.decode(this.getContent().getData());
        Image img = new Image(ImageDataFactory.create(bytes))
                .setWidth(this.getContent().getWidth())
                .setHeight(this.getContent().getHeight());
        ElementUtil.applyBorder(img, this.getContent().getBorderSettings());
        return new PdfElement<>(img);
    }
}
