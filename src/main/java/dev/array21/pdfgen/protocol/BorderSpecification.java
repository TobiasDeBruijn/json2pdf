package dev.array21.pdfgen.protocol;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import dev.array21.pdfgen.util.ColorUtil;

public class BorderSpecification {
    public float width = 1;
    // 6 character hexadecimal color without the '#'
    public String color;

    public Border getBorder() {
        int[] colors = ColorUtil.getColors(this.color);
        Border border = new SolidBorder(this.width);
        border.setColor(new DeviceRgb(colors[0], colors[1], colors[2]));
        return border;
    }
}
