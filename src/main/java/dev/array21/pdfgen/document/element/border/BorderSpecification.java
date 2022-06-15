package dev.array21.pdfgen.document.element.border;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import dev.array21.pdfgen.util.ColorUtil;

@JsonAutoDetect
public class BorderSpecification {
    private float width;
    // 6 character hexadecimal color without the '#'
    private String color;

    @JsonCreator
    public BorderSpecification(float width, String color) {
        this.width = width;
        this.color = color;
    }

    public Border getBorder() {
        int[] colors = ColorUtil.getColors(this.getColor());
        Border border = new SolidBorder(this.getWidth());
        border.setColor(new DeviceRgb(colors[0], colors[1], colors[2]));
        return border;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
