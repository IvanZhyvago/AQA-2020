package Lesson_7.task_2;

public class Main {
        public static void main(String[] args){
            FahrenheitConverter fahrenheitConverter = new FahrenheitConverter();
            System.out.println(fahrenheitConverter.convert(33.7));
            KelvinConverter kelvinConverter = new KelvinConverter();
            System.out.println(kelvinConverter.convert(33.7));
        }
    }

