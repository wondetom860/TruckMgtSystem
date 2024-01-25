package com.mycompany.invmgtsys.app.Demo;

public class Circle extends Shapes {
    double radious;

    public Circle(double radious) {
        this.radious = radious;
        setSides(0);
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radious, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radious;
    }

}





/*
 * Public abstract methods
 * Public static final variables
 * concrete classes are forced to implement abstract methods
 * interfaces are not.
 * Exceptions
 * 
 * 
 * 
 */