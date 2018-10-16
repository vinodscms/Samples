package com.testing;

public class InterfaceNewInJava8 implements Inter {
    public static void main(String args[]) {
        InterfaceNewInJava8 obj = new InterfaceNewInJava8();
        obj.display();
        obj.newMethod1();   //default interface method. Even without implementing we are calling it
        Inter.newMethod2(); //Since static method
    }

    @Override
    public void display() {
        System.out.println("Inside display of class: " + a);
    }

    //If we uncomment this obj.newMethod1() will call this method else it will call the one in interface
    //public void newMethod1(){System.out.println("Inside newMethod1 in Class not interface: " + a);}
}

interface Inter{
    int a = 10;
    void display();

    //Below 2 methods are not implemented in Implementation class
    default void newMethod1(){
        System.out.println("Inside new default Method1");
    }

    static void newMethod2(){
        System.out.println("Inside new static Method2");
    }
}

//Conventional way of interface example is GameController. Switches will do actions. Actually games implement it.
//Abstract class ensures we need to implement some methods. Also if a class should not be instantiated(but can create reference).
//Implementation: Abstract class can provide the implementation of interface. Interface can’t provide the implementation of abstract class.
//Accessibility of Data Members: Members of a Java interface are public by default. A Java abstract class can have class members like private, protected, etc