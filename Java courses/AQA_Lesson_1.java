public class AQA_Lesson_1 {
// 2) Write a program which creates and initializes all primitive data types.
    byte testByte = 8;
    char testChar1 = 16;
    char testChar2 = 'A';
    short testShort = -10;
    int testInt = 44444;
    float testFloat = 1.44444f;
    double testDouble = 5.55;
    boolean testBoolean = true;
// 3) Create an integer variable "a". Try to assign a value to it the doesn't match the allowed range.
// What happened? Find in your favorite search engine the explanation.

    public static void main (String [] args) {
        System.out.println("Home Task #1 part #3:");
        int a = Integer.MAX_VALUE;
        System.out.println (a);
        a = a + 1;
        System.out.println ("doesn't match the allowed range:" + a);

// Answer: Because the integer overflows. When it overflows, the next value is Integer.MIN_VALUE

// 4) Answer the question: What the difference between integers and floating-point numbers?
// Answer: Integers and floats are two different kinds of numerical data.
// An integer is a number without a decimal point. A float is a floating-point number, which means it is a number that has a decimal place.
// Floats are used when more precision is needed.

// 5) Read about ASCII. Write unicodes for all characters in a word "Hello".
        System.out.println("Home Task #1 part #5:");
        char upperH = 72;
        char lowerE = 101;
        char lowerL = 108;
        char lowerO = 111;
        System.out.println (""+upperH+lowerE+lowerL+lowerL+lowerO);
//why without "" don't work?


//6) Create a simple program with several constants.
// Try to reassign a value for any of them and compile you program. What happened?

        final int SCORE_CONST = 100;
        final double PI = 3.1415;
//        SCORE_CONST = SCORE_CONST + 1; - Cannot assign a value to final variable 'SCORE_CONST'

// 7) Create an array of 10 integers.
// Initialize this array with any values except 0. Print the length of the array to a console.
        System.out.println("Home Task #1 part #7:");

        int [] testArrayInt = new int [10];
        for (int i =1; i<=10; i++){
            testArrayInt [i-1] = i;
        }
        System.out.println(testArrayInt[0]);
        System.out.println(testArrayInt[9]);
        System.out.println(testArrayInt.length);

//8) Create an array of 5 doubles.
// Get the first and the last element of the array an write them to variables.
        System.out.println("Home Task #1 part #8:");

        double [] testArrayDouble = new double [5];
        for (int i =0; i <5; i++){
            testArrayDouble [i] = 0.5 + i;
        }

        double firstElement = testArrayDouble [0];
        double lastElement = testArrayDouble[testArrayDouble.length - 1];
        System.out.println(firstElement);
        System.out.println(lastElement);
    }
}
