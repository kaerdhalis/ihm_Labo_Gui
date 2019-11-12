public class Annotation {
    private double startX;
    private double startY;
    private double  width;
    private double height;

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
}
