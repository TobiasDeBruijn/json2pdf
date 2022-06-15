package dev.array21.pdfgen.document;

public class DocumentSettings {
    private float bottomMargin = 4;
    private float topMargin = 4;
    private float leftMargin = 4;
    private float rightMargin = 4;

    public DocumentSettings() {
    }

    public DocumentSettings(float bottomMargin, float topMargin, float leftMargin, float rightMargin) {
        this.bottomMargin = bottomMargin;
        this.topMargin = topMargin;
        this.leftMargin = leftMargin;
        this.rightMargin = rightMargin;
    }

    public float getBottomMargin() {
        return bottomMargin;
    }

    public void setBottomMargin(float bottomMargin) {
        this.bottomMargin = bottomMargin;
    }

    public float getTopMargin() {
        return topMargin;
    }

    public void setTopMargin(float topMargin) {
        this.topMargin = topMargin;
    }

    public float getLeftMargin() {
        return leftMargin;
    }

    public void setLeftMargin(float leftMargin) {
        this.leftMargin = leftMargin;
    }

    public float getRightMargin() {
        return rightMargin;
    }

    public void setRightMargin(float rightMargin) {
        this.rightMargin = rightMargin;
    }
}
