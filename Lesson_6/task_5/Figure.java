package Lesson_6.task_5;
//5) Create an abstract class Figure. Add fields width and height to it.
// Add an abstract method "calculateArea" which should be overriden by the concrete figures to calculate its area.

abstract class Figure {
    protected double width;
    protected double height;

    abstract double calculateArea (int width, int height);
}
