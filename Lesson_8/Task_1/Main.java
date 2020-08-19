package Lesson_8.Task_1;

public class Main {

   static int ownException (int number) {
        try {
            if (number != 0) {
                return number;
            }
            else {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
   }
    public static void main(String[] args){
        Main.ownException(0);
        }
}
