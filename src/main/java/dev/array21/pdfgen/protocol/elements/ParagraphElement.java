package dev.array21.pdfgen.protocol.elements;

import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AbstractElement;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Paragraph;
import dev.array21.pdfgen.protocol.Element;
import dev.array21.pdfgen.protocol.IElement;
import dev.array21.pdfgen.util.ColorUtil;
import dev.array21.pdfgen.util.ElementUtil;
import dev.array21.pdfgen.util.PdfElement;

public class ParagraphElement extends Element implements IElement {

    private ParagraphContent content;

    public static class ParagraphContent extends Content {
        public float fontSize = 20;
        public String text;

        public String fontColor;
    }

    @Override
    public PdfElement<Paragraph> apply() {
        int[] fontColor = ColorUtil.getColors(this.content.fontColor);
        Paragraph paragraph = new Paragraph(this.content.text)
                .setFontSize(this.content.fontSize)
                .setFontColor(new DeviceRgb(fontColor[0], fontColor[1], fontColor[2]));

        ElementUtil.applyBorder(paragraph, this.content.borderSettings);

        return new PdfElement<>(paragraph);
    }
}


