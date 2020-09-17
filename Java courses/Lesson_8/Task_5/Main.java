package Lesson_8.Task_5;

//5. Throw a NullPointerException from the method iCanThrowException();
//Handle it in the main method.

public class Main {

    public static void main(String[] args) {
        try {
            iCanThrowException();
        } catch (Exception e) {
            System.out.println("No problem with null ^.^ ");
        }
    }

    public static void iCanThrowException() {
        throw new NullPointerException();

    }
}
