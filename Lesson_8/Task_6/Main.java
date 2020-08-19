package Lesson_8.Task_6;
//6. Write a program that will enter numbers from the keyboard.
//The code for reading numbers from the keyboard must be in the readData method.
//The code inside the readData is wrapped in a try..catch.
//If the user entered some text, instead of entering a number,
//the method should catch the exception and display all previously entered numbers as a result.
//Numbers output from a new line preserving the order of input.

public class Main {
    public static void main(String[] args) {

        InputFromKeyboard inputFromKeyboard = new InputFromKeyboard();
        inputFromKeyboard.readData();
    }
}