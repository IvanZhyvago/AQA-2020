import java.util.Random;

//1. Create a class "Human". A human should have the following attributes: weight, age, first name, last name, height.
//Requirements:
//a) Create a class Human with all the required fields to store the information (variable types you could choose by yourself).
//b) Add to the class a constructor with parameters which initialize all the fields.
class Human {
    int weight;
    int age;
    int height;
    String firstName;
    String lastName;

    Human (int weight, int age, int height, String firstName, String lastName ) {
        this.weight = weight;
        this.age = age;
        this.height = height;
        this.firstName = firstName;
        this.lastName = lastName;

    }


}

//2. Implement the method fight() depending on weight, strength and age of the boxer:
//You should write dependency by yourself. The method should return true or false if our boxer won or lost.
//Requirements:
//a) if ourBoxer.fight(anotherBoxer) returns true, then anotherBoxer.fight(outBoxer) should return false;

class Boxer {
    public int age;
    public int weight;
    public int strength;

    public Boxer(int age, int weight, int strength) {
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    static Boxer ourBoxer = new Boxer (22, 75, 300);

    public static boolean fight(Boxer anotherBoxer) {
        boolean result;
        if ( (ourBoxer.age < anotherBoxer.age && ourBoxer.weight > anotherBoxer.weight) ||
                (ourBoxer.strength - anotherBoxer.strength) > 100) {
            result = true;
            return result;
        }
        else {
            result = false;
            return result;
        }
    }
}

//3. Create 3 different classes to demonstrate the relationships "has-a" and "uses-a".
// They can be anything you want. For example: Car - Engine - Wheels

class Engine {

    int priceEngine;
    public Engine(int priceEngine){
        this.priceEngine = priceEngine;
    }

    public int getPrice (){return priceEngine;}

}
class Wheels {

    int priceWheels;
    public Wheels (int priceWheels ){
        this.priceWheels = priceWheels;
    }

    public int getPrice (){return priceWheels;}
}
class Car {
// Has-a relation
    Wheels wheels = new Wheels (80000);
    Engine engine = new Engine(7500);
    int exampleHas_a = wheels.getPrice() + engine.getPrice();
// Uses-a relation
    Wheels wheel;
    public void exampleUses_a (Wheels wheels){
        this.wheel = wheels;
    }
}

//4. Create a class Calculator.
// It should have three fields: double firstValue, double secondValue and String operation.
// Create all required constructors to properly initialize your object.
// Consider the case when user does not provide any parameters when creates a new object.
// Write a method "calculate" that takes these two values and return the result of the calculation according to the operation.
// Write the test class which contains the main method.
// In this main method you should create your Calculator object and do some calculation to test your code,
// by calling your "calculate" method.
// Print all results to the console.

class Calculator {
    double firstValue;
    double secondValue;
    String operation = "";

    Calculator() {
        this(Math.random() * 100,Math.random() * 100, "*");

/*      System.out.println ("Method #2");
        System.out.println("No args constructor Calculator(), all values random: ");
        this.firstValue = Math.random() * 100;
        this.secondValue = Math.random();
        this.operation = "*";

        */
    }

    Calculator(double firstValue, double secondValue, String operation) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.operation = operation;
    }

    public double calculate() {
        double result;
        if (operation.equals("+")) {
            return result = firstValue + secondValue;
        } else if (operation.equals("-")) {
            return result = firstValue - secondValue;
        } else if (operation.equals("*")) {
            return result = firstValue * secondValue;
        } else if (operation.equals("/")) {
            return result = firstValue / secondValue;
        } else {
            System.out.println("In operation available only following values: +,-,*,/");
            return 0;
        }
    }
}

//5. Create a simple class with a bunch of constructors.
// All these constructors should take different number of parameters.
// Demonstrate in your class, how we can call one constructor from another.

class S1mple {
    int number;
    boolean bool;
    String name;

    public S1mple (String name){
        this.name = name;
        System.out.println("You are in constructor #1");
    }

    public S1mple (String name, int number){
        this(name);
        this.number = number;
        System.out.println("You are in constructor #2");
    }
    public S1mple (String name, int number, boolean bool){
        this(name,number);
        this.bool = bool;
        System.out.println("You are in constructor #3");
    }





}

//6.6. Create a simple class with any 3 fields.
// Demonstrate in your class how we can use "this" keyword to refer to the object,
// from which a constructor or a method was invoked.

class Keyword {
    boolean firstValue = true;
    double secondValue = 44.44;
    char thirdValue = 'y';

    Keyword (boolean firstValue, double secondValue, char thirdValue) {
        System.out.println ("constructor value --> " + firstValue);
        System.out.println ("class value --> " + this.firstValue);
        System.out.println ("constructor value --> " + secondValue);
        System.out.println ("class value --> " + this.secondValue);
        System.out.println ("constructor value --> " + thirdValue);
        System.out.println ("class value --> " + this.thirdValue);
    }
}

//7. Create a simple class with some fields.
// Demonstrate in your class how we can use initialization blocks.

class Initialization {
    static int nextId;
    int id;
    String car;
    double price;
    {
        System.out.println("Inside initialization block");
        id = nextId;
        nextId = nextId + 2 ;
    }

    static {
        var randomNumber = new Random();
        nextId = randomNumber.nextInt(10000);
    }

    Initialization (String car, double price) {
        this.car = car;
        this.price = price;
    }

    Initialization () {
        this.car = "Shoes !!!";
        this.price = 1;
    }

    public int getId () {
        return this.id;
    }

}

//8. Find the information about the order of initialation, when you create a new object of a class:
//When constructors, initialization blocks are being executed. When fields are initialized with default values.

class InitializationDefaultValues {
    static int[] numArray = new int[10];
    static {
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = (int) (100.0 * Math.random());
        }
    }

    void getArray (){
        for (int a : numArray) {
            System.out.print(a + " ");
        }
        System.out.println();
    }


}

//9. Write your own example of the recursive function.
// You can find a lot of examples on the Internet.

class RecursiveFunction {
     void recursive (int number) {
        if (number < 100){
            System.out.println("Your number is: " + number + " but we need 100");
            recursive(number + 1);
        }
        else {
            System.out.println("We are finish, your number = 100");
        }
    }

}

//10. Create a simple class with overloaded methods.
// Write another class to demonstrate the concept of methods overloading.

class overloadedMethods {
    void getCarPrice () {
        System.out.println ("Google don't understand what a car you want !");
    }
    void getCarPrice (String name){
        System.out.println ("Nice choice: " + name + " what colour ?");
    }
    void getCarPrice (String name, String color){
        System.out.println ("Nice choice: " + name +" "+ color + " what year ?");
    }
    void getCarPrice (String name, String color, int year){
        System.out.println ("Nice choice: " + name +" "+ color +" "+ year);
        int price = year*100;
        System.out.println ("Your price: " + price + "$");
    }
}

public class AQA_Lesson_4 {
    public static void main(String[] args) {
        System.out.println("Home Task #4 part #2:");
        System.out.println(Boxer.fight(new Boxer(22,80,99)));
        System.out.println(Boxer.fight(new Boxer(22,80,400)));

        System.out.println("Home Task #4 part #4:");
        Calculator plus = new Calculator(77,88,"+");
        System.out.println("plus: " + plus.calculate());
        Calculator minus = new Calculator(44,22,"-");
        System.out.println("minus: " + minus.calculate());
        Calculator multiply = new Calculator(11,77,"*");
        System.out.println("multiply: "+ multiply.calculate());
        Calculator divide = new Calculator(100,9,"/");
        System.out.println("divide: "+ divide.calculate());
        Calculator empty = new Calculator ();
        System.out.println(empty.calculate());

        System.out.println("Home Task #4 part #5:");
        //S1mple simple = new S1mple("Kyky");
        //S1mple simple2 = new S1mple("Kyky", 10);
        S1mple simple3 = new S1mple("Kyky", 10, true);

        System.out.println("Home Task #4 part #6:");
        Keyword keyword = new Keyword (false,22.3,'n');

        System.out.println("Home Task #4 part #7:");
        Initialization initialization = new Initialization ();
        Initialization initialization2 = new Initialization ("Mazerati",999999.99999);
        System.out.println(initialization.getId());
        System.out.println(initialization2.getId());

        System.out.println("Home Task #4 part #8:");
        new InitializationDefaultValues().getArray();
        new InitializationDefaultValues().getArray();
        new InitializationDefaultValues().getArray();

        System.out.println("Home Task #4 part #9:");
        new RecursiveFunction().recursive(90);

        System.out.println("Home Task #4 part #10:");
        new overloadedMethods().getCarPrice();
        new overloadedMethods().getCarPrice("Ferrari");
        new overloadedMethods().getCarPrice("Ford","Green");
        new overloadedMethods().getCarPrice("Lexus", "black", 2020);


    }
}
