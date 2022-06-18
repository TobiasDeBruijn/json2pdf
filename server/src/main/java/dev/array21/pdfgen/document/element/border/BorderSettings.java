package dev.array21.pdfgen.document.element.border;

public class BorderSettings {
    private BorderSpecification top;
    private BorderSpecification bottom;
    private BorderSpecification right;
    private BorderSpecification left;

    public BorderSettings() {
    }

    public BorderSettings(BorderSpecification top, BorderSpecification bottom, BorderSpecification right, BorderSpecification left) {
        this.top = top;
        this.bottom = bottom;
        this.right = right;
        this.left = left;
    }

    public BorderSpecification getTop() {
        return top;
    }

    public void setTop(BorderSpecification top) {
        this.top = top;
    }

    public BorderSpecification getBottom() {
        return bottom;
    }

    public void setBottom(BorderSpecification bottom) {
        this.bottom = bottom;
    }

    public BorderSpecification getRight() {
        return right;
    }

    public void setRight(BorderSpecification right) {
        this.right = right;
    }

    public BorderSpecification getLeft() {
        return left;
    }

    public void setLeft(BorderSpecification left) {
        this.left = left;
    }
}
