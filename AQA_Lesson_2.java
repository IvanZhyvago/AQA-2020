import java.util.Arrays;

public class AQA_Lesson_2 {

    public static double areaCircle (double radius) { return Math.PI*Math.pow(radius, 2); }
    public static double areaRectangle (double length, double width) { return length*width; }

    public static int factorialCalculates (int number) {
        int result = 1;
        for (int i = 1; i<= number; i++){
            result = result*i;
        }
        return result; }
    public static void figuresPrint (char kindOfFigures){

        String [] [] figure;
        if (kindOfFigures == 'a') {
            figure = new String [8][7];
            for (int i =0;i<figure.length;i++){
                System.out.println();
                for (int a=0;a<figure[0].length;a++){
                    figure [i][a] = "*";
                    System.out.print(figure[i][a]);
                }
            }

        }
        else if (kindOfFigures == 'b') {
            figure = new String [5][7];
            for (int i =0;i<figure.length;i++){
                System.out.println();
                for (int a=0;a<figure[0].length;a++) {
                    if ((i==0 || i == 4) || (a == 0 || a == 6)){
                    figure[i][a] = "*";
                    System.out.print(figure[i][a]);
                    }
                    else {
                        figure[i][a] = " ";
                        System.out.print(figure[i][a]);
                    }
                }
            }
        }
        else if (kindOfFigures == 'c') {
            figure = new String [7][7];
            for (int i =0;i<figure.length;i++){
                System.out.println();
                for (int a=0;a<figure[0].length;a++) {
                    if (a<=i){
                        figure[i][a] = "*";
                        System.out.print(figure[i][a]);
                    }
                    else {
                        figure[i][a] = " ";
                        System.out.print(figure[i][a]);
                    }
                }
            }

        }
        else if (kindOfFigures == 'd') {
            figure = new String [5][9];
            for (int i =0;i<figure.length;i++){
                System.out.println();
                for (int a=0;a<figure[0].length;a++) {
                    if ((i == 0 && a == 4) || (i==1 && a>=3 && a <=5) || (i==2 && a>=2 && a <=6) ||
                            (i==3 && a>=1 && a <=7) || (i==4 && a>=0 && a <=8)){
                        figure[i][a] = "*";
                        System.out.print(figure[i][a]);
                    }
                    else {
                        figure[i][a] = " ";
                        System.out.print(figure[i][a]);
                    }
                }
            }

        }
        else {
            System.out.println ("Avalible value: a,b,c,d");
        }
    };

    //1) Create a simple program, that creates two integers and print the result of calculation of their addition,
// substruction, multiplication and division.
    public static void main (String [] args) {
        int one = 2;
        int two = 5;

        System.out.println("Home Task #2 part #1:");
        System.out.println(one + two);
        System.out.println(one - two);
        System.out.println(one * two);
        System.out.println(two / one);

//2) Create a simple program that calculates and prints the square of a rectangle and a circle.
// Import and use Math class.

        System.out.println("Home Task #2 part #2:");
        System.out.println("Area of Circle: " + areaCircle(12.99));
        System.out.println("Area of Rectangle: " + areaRectangle(12, 10));

//3) Create an array of 10 integers. Fill this array using for-loop with random numbers.
// Print all the elements of this array to the console. Each element from the new line.
        System.out.println("Home Task #2 part #3:");

        int[] arrayTen = new int[10];
        for (int i = 0; i < 10; i++) {
            arrayTen[i] = 0 + (int) (Math.random() * 100);
            System.out.println(arrayTen[i]);
//4) Create an array of 10 integers.
// Find the square root of each element and put the to result array.
// Print the result array to the console.
        }

        System.out.println("Home Task #2 part #4:");

        for (int i = 0; i < 10; i++) {
            arrayTen[i] = (int) Math.sqrt(arrayTen[i]);
            System.out.println(arrayTen[i]);
        }
// 5) Create a program that calculates the factorial of an integer value n.
        System.out.println("Home Task #2 part #5:");
        System.out.println(factorialCalculates(5));

// 6) Create a program that print to the console following figures.
// Use loops, asterisks("*") and spaces (" ").
        System.out.println("Home Task #2 part #6:");
        figuresPrint('a');
        figuresPrint('b');
        figuresPrint('c');
        figuresPrint('d');
        System.out.println ();


//7) Create an array of 10 integers.
// Calculate and print the sum of all its elements except the first one and the last one.
        System.out.println("Home Task #2 part #7:");
        int summ = 0;
        for (int i : arrayTen) {
            summ = summ +i;
        }
        summ = summ - arrayTen [0] - arrayTen [9];
        System.out.println(summ);

//8) Print all the numbers from 1 to 100 that are divisible by 3 or divisible by 5, but not divisible by 2.
        System.out.println("Home Task #2 part #8:");
        for (int i=1;i<=100;i++){
            if ( (0 == (i%3)) && (0 == (i%5)) ){
                System.out.println ("divisible by 3 and 5 --> " + i);
            }
            else if (0 == (i%5)) {
                System.out.println ("divisible by 5 --> " + i);
            }
            else if (0 == (i%3)) {
                System.out.println ("divisible by 3 --> " + i);
            }
        }
//9) Create an array of any length and fill it with random integers.
// Using loops and conditions sort this array and print it out to the console.
// You can use any sorting algorithm you want. Do not use build-in methods to sort the array.
        System.out.println("Home Task #2 part #9:");
        int[] array20 = new int[20];
        System.out.print("Before Sorting: ");
        for (int i = 0; i < 20; i++) {
            array20[i] = (int) (Math.random() * 100);
            System.out.print(array20[i] + ", ");
        }
        System.out.println("");
        Arrays.sort(array20);
        System.out.printf("After Sorting : %s",
                Arrays.toString(array20));

    }
}
