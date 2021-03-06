package com.codecool.geometry.shapes;


import com.codecool.geometry.utilities.FormulaProvider;

/**
 * This is a abstract class representing geometrical shape.
 */
public abstract class Shape {

    public String name;

    private final String perimeterFormula;
    private final String areaFormula;

    protected Shape(String className) {
        this.perimeterFormula = FormulaProvider.getPerimeterForShape(className);
        this.areaFormula = FormulaProvider.getAreaForShape(className);
    }


    /**
     * Calculates shape's area.
     *
     * @return area of the shape
     */

    public abstract double calculateArea();


    /**
     * Calculates shape's perimeter.
     *
     * @return perimeter of the shape
     */
    public abstract double calculatePerimeter();

    /**
     * Check if all args are greater than 0
     * Throws IllegalArgumentException if any of the parameters is 0 or less.
     *
     * @param args
     * @return true if all of args are greater than 0
     */
    public static boolean checkIfArgsGreaterThanZero(float... args) {
        return false;
    }

    public String getPerimeterFormula() {
        return perimeterFormula;
    }

    public String getAreaFormula() {
        return areaFormula;
    }
}
