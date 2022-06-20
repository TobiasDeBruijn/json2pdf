package dev.array21.pdfgen.util;

import com.itextpdf.layout.element.AbstractElement;
import dev.array21.pdfgen.document.element.border.BorderSettings;

public class ElementUtil {

    public static void applyBorder(AbstractElement<?> element, BorderSettings borderSettings) {
        if(borderSettings == null) {
            element.setBorder(null);
            return;
        }

        if(borderSettings.getTop() != null) {
            element.setBorderTop(borderSettings.getTop().getBorder());
        }

        if(borderSettings.getBottom() != null) {
            element.setBorderBottom(borderSettings.getBottom().getBorder());
        }

        if(borderSettings.getLeft() != null) {
            element.setBorderLeft(borderSettings.getLeft().getBorder());
        }

        if(borderSettings.getRight() != null) {
            element.setBorderRight(borderSettings.getRight().getBorder());
        }
    }
}
