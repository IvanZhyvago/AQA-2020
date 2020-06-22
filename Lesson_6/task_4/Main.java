package Lesson_6.task_4;
//4) Create a class A. Add several fields, two methods and parameterized constructors to it.
// Create a class B that extends class A.
// Demonstrate in you program how class's B constructor should call class's A constructor to create a new object.
// Override one method of the class A to fully change it's behavior.
// Override another method to add some extra functionality to it, but it should then call class's A method.
// Create a test class and create several objects of class A and class B and call their methods.

public class Main {


    public static void main(String[] args) {
        B b = new B ("class b");
        b.setNameToUpperCase();
        b.randomNumber();

        A a = new A("class a");
        a.setNameToUpperCase();
        a.randomNumber();

    }
}
