package Lesson_8.Task_7;

public class Main {
    public static void main(String[] args) {
        Example ex1 = new Example("Donald", "Duck");
        Example ex2 = new Example("Donald", "Duck");
        Example ex3 = new Example("Duck", "Donald");

        System.out.println(ex1.equals(ex2));
        System.out.println(ex1.equals(ex3));
        System.out.println(ex2.equals(ex3));

        System.out.println(ex1.hashCode());
        System.out.println(ex2.hashCode());
        System.out.println(ex3.hashCode());
    }
}
