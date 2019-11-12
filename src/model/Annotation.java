package model;


import javafx.scene.shape.Rectangle;

public class Annotation {
    private double startX;
    private double startY;
    private double  width;
    private double height;

    private Rectangle rectangle;
    private javafx.scene.control.Label jfxLabel;
    private Label label;

    public Annotation(double startX, double startY, double width, double height, Label label) {
        this.startX = startX;
        this.startY = startY;
        this.width = width;
        this.height = height;
        this.label = label;
    }

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Label getLabel() {
        return label;
    }

    public String toString() {
        return label.toString() +startX+","+startY+","+width+","+height;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public javafx.scene.control.Label getJfxLabel() {
        return jfxLabel;
    }

    public void setJfxLabel(javafx.scene.control.Label jfxLabel) {
        this.jfxLabel = jfxLabel;
    }
}
