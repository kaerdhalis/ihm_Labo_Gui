package model;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Label {
    private String name;
    private Color color;
    private ArrayList<Annotation> annotations;
    public Label(String name, Color color) {
        this.name = name;
        this.color = color;
        annotations= new ArrayList<>();
    }

    public void addAnnotation(Annotation a){
        annotations.add(a);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        for (Annotation a:annotations) {
            a.getJfxLabel().setText(getName());
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        for (Annotation a:annotations) {
            a.getRectangle().setStroke(getColor());
            a.getJfxLabel().setTextFill(getColor());
        }
    }

    public String toString() {
        return name +","+color.toString()+",";
    }
}
