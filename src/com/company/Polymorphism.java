package com.company;

public class Polymorphism {
    public static void main(String args[]) {

        Super s = new Sub();
        s.print();
        //s.diffMethod();  //Super object cannot call sub method unless extended
    }
}

class Super {
    public Super() {
        System.out.println("Super constructor");
    }

    public void print() {
        System.out.println("In Super");
    }
}

class Sub extends Super {
    public Sub() {
        System.out.println("Sub constructor");
    }
    public void print() {
        System.out.println("In Sub");
    }

    public void diffMethod() {
        System.out.println("In Diff Method");
    }
}
