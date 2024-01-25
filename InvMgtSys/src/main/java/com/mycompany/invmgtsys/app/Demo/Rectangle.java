package com.mycompany.invmgtsys.app.Demo;

public class Rectangle extends Shapes implements Polygon,Line{
    double lenght, width;

    public Rectangle(double lenght, double width) {
        setSides(4);
        this.lenght = lenght;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return lenght * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (lenght + width);
    }

    @Override
    public double getLargestLineLength() {
        return Math.max(lenght, width);
    }

    @Override
    public double calculatePolygonPerimeter() {
        return 2 * (lenght + width);
    }
}
