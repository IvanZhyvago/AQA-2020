package aqa.third;
//import aqa.*;
import aqa.first.Book;
import aqa.first.Computer;

import java.security.spec.RSAOtherPrimeInfo;

public class Main {
    public static void main(String[] args) {
//1) Create 2 classes with the same name, but put them in different packages.
// For example, com.domainname.modulename.
// Create a third class with the main method.
// In the main method create two different objects of your classes specifying
// the full name of the classes (including packages).
        aqa.first.SameName sameName1 = new aqa.first.SameName ();
        aqa.second.SameName sameName2 = new aqa.second.SameName ();

//2) Take the classes from the task 1. Create a new test class.
// Import everything (*) from your created packages.
// Now try to create objects of your classes without specifying the packages in front of the class names.
// What happened? How can we avoid this?

//        SameName sameName1 = new SameName ();   // - ERROR

//3) Answer the question: What is a package-private access?
// Create a simple program to demostrate the package-private access.
//Tips:
// - Create two different packages
// - Create 3 classes. 2 classes should be in the first package, 3rd class - in the second package.
// - Create in one of the classes some package-private members(fields or methods).
// - In another two classes create objects of the class with package-private members and try to access its members

        Book book = new Book ("ABCD");
//      book.numberOfPages;  // can't because private



//4) Answer the question: What is a public access? Create a simple program to demostrate the public access.
// You can use tips from the task 3.
        Computer computer = new Computer("Intel");
        System.out.println(computer.memory); // can because public

//5) Answer the question: What is a private access? Create a simple program to demostrate the private access.
//Tips:
// - Create two classes
// - In on of them create private members
// - In the second class create an object of the first class
// - Try to access the private members
        DemonstratePrivateAccess dPA = new DemonstratePrivateAccess ();
//      System.out.println(dPA.name); // can't because private

//6) Create a new class. Make it impossible to create a new object of this class using a constructor.
// Provide an appropriate public method that will allow clients of your class create a new object.

        ConstructorPrivate cP = ConstructorPrivate.makeConstructor ("Ivan");
        System.out.println(cP.name);

//7) What is the difference between package-private access and protected access?
// Private use only in Class
// Package use in Class, Package, Same Package, Different package and can't use in World

//8) Create a new class. Add 5 private fields. Add getter and setters to all the fields.
// Class - GetterANdSetter

// 9) What is the different between static and non-static field of a class?
// Create an example to demostrate this concept.

        DemonstrateStatic ds1 = new DemonstrateStatic ();
        DemonstrateStatic ds2 = new DemonstrateStatic ();
        DemonstrateStatic ds3 = new DemonstrateStatic ();
        DemonstrateStatic ds4 = new DemonstrateStatic ();

        System.out.println("Non Static - " + ds1.getNonStataticInt());
        System.out.println("Non Static - " + ds2.getNonStataticInt());
        System.out.println("Static - " + ds3.getStaticInt());
        System.out.println("Static - " + ds4.getStaticInt());

// 10) How can you create a constant in Java,
// that will be available for everyone outside your class or package?

// Answer: that will be available for everyone outside your class and package

        aqa.third.DemonstrateConstant dc1 = new aqa.third.DemonstrateConstant();
        aqa.second.DemonstrateConstant dc2 = new aqa.second.DemonstrateConstant();
        System.out.println(dc1.DATE_OF_BIRTHDAY);
        System.out.println(dc2.DATE_OF_BIRTHDAY);
//11) Create a class with two different methods and two fields.
// One of methods should be static, another - non-static.
// The same thing should be done with class fields(first - static, second - non-static).
// These two methods should change the corresponding fields of the class when called.
// Create another class with main method to test your code.

        MyClass myClass = new MyClass();
        myClass.anotherChange(100);
        myClass.change(70);
        System.out.println(myClass.a);
        System.out.println(myClass.b);

    }
}
