package Lesson_6.task_5;
//5) Create an abstract class Figure. Add fields width and height to it.
// Add an abstract method "calculateArea" which should be overriden by the concrete figures to calculate its area.

public class Main extends Figure {

    @Override
    double calculateArea (int width, int height) {
        return width*height;
    }

    public static void main(String[] args) {
        Main main = new Main ();
        System.out.println(main.calculateArea(10,20));
    }
}
