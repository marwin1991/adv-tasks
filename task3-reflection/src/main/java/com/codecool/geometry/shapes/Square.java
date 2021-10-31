package com.codecool.geometry.shapes;

public class Square extends Rectangle {

    private String privateName = "abcd";


    public Square(double a) {
        super(a, a, "Square");
    }

    @Override
    public String toString() {
        return "Square, " + "a=" + super.getWidth();
    }

    private void helloFromPrivate(){
        System.out.println("hello from private");
    }
}
