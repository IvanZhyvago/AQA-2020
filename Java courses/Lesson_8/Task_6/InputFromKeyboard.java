package Lesson_8.Task_6;

import java.util.Scanner;

public class InputFromKeyboard implements InterfaceForInput {

    Scanner in = new Scanner(System.in);
    int error;
    int [] num = new int[10] ;



    @Override
    public void readData() {
        while (error>=0) {
            try {
                for (int a = 0; a<10; a++) {
                    System.out.println("Input a number: ");
                    num [a] = in.nextInt();
                }
            } catch (Exception e) {
                System.out.println("Invalid value !!!");
                error = -1;
                for (int a = 0; a < num.length; a++)
                    if (num[a]!= 0) {
                        System.out.println(num[a]); }
            }
        }
    }
}
