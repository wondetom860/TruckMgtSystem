package com.mycompany.invmgtsys.app.Demo;

public interface Polygon {
    double calculatePolygonPerimeter();
    public default void displayType(){
        System.out.println(this.getClass().getSimpleName());
    }
}
