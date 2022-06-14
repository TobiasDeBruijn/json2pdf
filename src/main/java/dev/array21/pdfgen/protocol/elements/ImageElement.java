package dev.array21.pdfgen.protocol.elements;

import com.itextpdf.commons.utils.Base64;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import dev.array21.classvalidator.annotations.Required;
import dev.array21.pdfgen.protocol.Element;
import dev.array21.pdfgen.protocol.IElement;
import dev.array21.pdfgen.util.ElementUtil;
import dev.array21.pdfgen.util.PdfElement;

public class ImageElement extends Element implements IElement {

    @Required
    public ImageContent content;

    public static class ImageContent extends Content {
        @Required
        public String data64;

        public float height = 100;
        public float width = 100;
    }

    @Override
    public PdfElement<Image> apply() {
        byte[] bytes = Base64.decode(this.content.data64);
        Image img = new Image(ImageDataFactory.create(bytes))
                .setWidth(this.content.width)
                .setHeight(this.content.height);
        ElementUtil.applyBorder(img, this.content.borderSettings);

        return new PdfElement<>(img);
    }
}
