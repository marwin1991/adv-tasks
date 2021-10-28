package com.codecool.geometry;

import com.codecool.geometry.containers.ShapeCollection;
import com.codecool.geometry.shapes.*;

public class Main {

    public static void main(String[] args) {
        ShapeCollection shapeCollection = new ShapeCollection();
        shapeCollection.addShape(new Square(4));
        shapeCollection.addShape(new Triangle(6, 7, 8));
        shapeCollection.addShape(new Rectangle(4, 6));
        shapeCollection.addShape(new EquilateralTriangle(6, 7));
        shapeCollection.addShape(new Circle(6));

        //TODO
    }


}
