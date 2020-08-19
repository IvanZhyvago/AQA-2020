package Lesson_8.Task_3;
//3. Finish the program to handle all the possible exceptions

public class Main {

    public static void main(String[] args) {
        int a = args.length;
        System.out.println(a);

        try {
            int b = 10 / a;
            int[] c = {0};
            System.out.println(c[1]);
        } catch (ArithmeticException AE) {
            System.out.println(AE);
        } catch (ArrayIndexOutOfBoundsException AIOOBE) {
            System.out.println(AIOOBE);
        }
    }
}
