package com.mycompany.invmgtsys.app.Demo;

public abstract class Shapes {
    private int sides;

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getSides() {
        return this.sides;
    }

    public abstract double calculateArea();
    public abstract double calculatePerimeter();
}
