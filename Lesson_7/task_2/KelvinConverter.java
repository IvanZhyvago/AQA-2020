package Lesson_7.task_2;

public class KelvinConverter implements Converter {
    private double kelvin;
    @Override
    public double convert(double celsius) {
        kelvin = celsius + 273.15;
        return kelvin;
    }
}
