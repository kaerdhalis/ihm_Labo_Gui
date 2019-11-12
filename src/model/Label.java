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
    public void update(){
        for (Annotation a:annotations) {
            a.getRectangle().setStroke(getColor());

        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String toString() {
        return name +","+color.toString()+",";
    }
}
