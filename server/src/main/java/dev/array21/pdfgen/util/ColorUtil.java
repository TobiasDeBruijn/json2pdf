package dev.array21.pdfgen.util;

public class ColorUtil {
    /**
     * Convert a 6 digit hexadecimal color specification to RGB. If `colorHex` is null, black will be returned.
     * Must not include the # prefix.
     * @param colorHex The hex color
     * @return The RGB color
     */
    public static int[] getColors(String colorHex) {
        int[] colors = { 0, 0, 0 };
        if(colorHex != null) {
            char[] hexChars = colorHex.toCharArray();
            colors[0] = Integer.parseInt(String.format("%c%c", hexChars[0], hexChars[1]), 16);
            colors[1] = Integer.parseInt(String.format("%c%c", hexChars[2], hexChars[3]), 16);
            colors[2] = Integer.parseInt(String.format("%c%c", hexChars[4], hexChars[5]), 16);
        }

        return colors;
    }
}
