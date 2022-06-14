package dev.array21.pdfgen.util;

import com.itextpdf.layout.element.AbstractElement;
import dev.array21.pdfgen.protocol.BorderSettings;

public class ElementUtil {

    public static AbstractElement applyBorder(AbstractElement element, BorderSettings borderSettings) {
        if(borderSettings == null) {
            element.setBorder(null);
            return element;
        }

        if(borderSettings.top != null) {
            element.setBorderTop(borderSettings.top.getBorder());
        }

        if(borderSettings.bottom != null) {
            element.setBorderBottom(borderSettings.bottom.getBorder());
        }

        if(borderSettings.left != null) {
            element.setBorderLeft(borderSettings.left.getBorder());
        }

        if(borderSettings.right != null) {
            element.setBorderRight(borderSettings.right.getBorder());
        }

        return element;
    }

}
