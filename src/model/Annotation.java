package model;
import java.awt.geom.Point2D;


public class Annotation {


    private String tag;     // Name of the identified object
    private Point2D start; // Coordinates x,y of annotated object's origin point
    private Point2D end;    // Coordinates x,y of the annotated object's end point


    public Annotation(String tag, Point2D origin, Point2D end) {
        this.tag = tag;
        this.start = origin;
        this.end = end;
    }

}

