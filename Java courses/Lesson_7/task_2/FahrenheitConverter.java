package Lesson_7.task_2;

public class FahrenheitConverter implements Converter {
    private double fahrenheit;
    @Override
    public double convert(double celsius) {
        fahrenheit = (celsius*9/5)+32;
        return fahrenheit;
    }
}
