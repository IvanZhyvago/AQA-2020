package Lesson_6.task_4;
//4) Create a class A. Add several fields, two methods and parameterized constructors to it.
// Create a class B that extends class A.
// Demonstrate in you program how class's B constructor should call class's A constructor to create a new object.
// Override one method of the class A to fully change it's behavior.
// Override another method to add some extra functionality to it, but it should then call class's A method.
// Create a test class and create several objects of class A and class B and call their methods.

public class A {
    private String name;
    private double number;


    A (String name) {
        this.name = name;
    }

    public void setNameToUpperCase() {
        System.out.println("We are in method setNameToUpperCase");
        name = name.toUpperCase();
        System.out.println("Your name -> " + name);

    }

    public double randomNumber () {
        System.out.println("We are in method randomNumber");
        number = Math.random() * 100;
        System.out.println("Your lucky number is " + number);
        return number;

    }
}
