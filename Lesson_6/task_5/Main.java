package Lesson_6.task_5;
//5) Create an abstract class Figure. Add fields width and height to it.
// Add an abstract method "calculateArea" which should be overriden by the concrete figures to calculate its area.

public class Main {


    public static void main(String[] args) {
        Square square = new Square();
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();

        System.out.println("triangle area: "  + triangle.calculateArea(10,20));
        System.out.println("rectangle area: "  + rectangle.calculateArea(10,20));
        System.out.println("square area: "  + square.calculateArea(10,20));
    }
}
