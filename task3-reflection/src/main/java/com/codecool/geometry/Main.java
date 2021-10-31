package com.codecool.geometry;

import com.codecool.geometry.containers.ShapeCollection;
import com.codecool.geometry.shapes.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        ShapeCollection shapeCollection = new ShapeCollection();
        shapeCollection.addShape(new Square(4));
        shapeCollection.addShape(new Circle(6));

        for (Shape shape : shapeCollection.getShapes()) {
            Class myClass = shape.getClass();
            Shape object = (Shape) myClass.getConstructors()[0].newInstance(1);
            System.out.println(myClass);
            System.out.println(object.calculateArea());

            myClass.getFields();
        }
    }


}
