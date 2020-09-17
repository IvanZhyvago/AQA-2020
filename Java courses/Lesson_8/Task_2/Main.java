package Lesson_8.Task_2;
//2. Fix the method with try-catch to get the correct result of division:

public class Main {
    public static void main(String[] args) {
        System.out.println(divideByZero());
    }

    public static int divideByZero() {
        try {
            int a = 5;
            int b = 0;
            return a / b;
        } catch (ArithmeticException AE){
            System.out.println("Incorrect values !!!");
            return -1;

        }
    }
}


