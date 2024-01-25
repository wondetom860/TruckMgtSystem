package com.mycompany.invmgtsys.app.Demo;

public class Demo {
    public static void main(String[] args) {
        try {
            System.out.println(5/0);
            int[] nums = new int[] { 1, 2, 3, 4, 5 };
            nums[7] = 18;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Something wrong happened." + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Error: Arithmatic exception happened." + e.getMessage());
        }catch(Exception e){
            System.out.println("Error: Arithmatic exception happened." + e.getMessage());
        }

        // Rectangle rec = new Rectangle(55.5, 22.2);
        // System.out.println("Rectangle:\nSides: " + rec.getSides());
        // System.out.println("Lenght:" + rec.lenght);
        // System.out.println("Width:" + rec.width);
        // System.out.println("Area: " + rec.calculateArea());
        // System.out.println("Perimeter: " + rec.calculatePerimeter());

        // Circle cc = new Circle(19.25);

        // System.out.println("\n\nCircle:\nSides: " + cc.getSides());
        // System.out.println("Radious:" + cc.radious);
        // System.out.println("Area: " + cc.calculateArea());
        // System.out.println("Perimeter: " + cc.calculatePerimeter());

    }
}
