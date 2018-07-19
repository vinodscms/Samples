package com.company;

import java.util.function.Predicate;

public class PredicateExamples {

    public static void main(String args[]) {
        Predicate<Integer> greaterthan25 = (i) -> i > 25;
        System.out.println(greaterthan25.test(32));

        Dog dog = new Dog(6,88);
        System.out.println(dog.getAge()+"-"+dog.getPower());

        PredicateLibrary obj = new PredicateLibrary();
        obj.print();

        System.out.println(PredicateLibrary.YoungAndStrong.test(dog));

        System.out.println(PredicateLibrary.YoungButWeak.test(dog));

    }
}

class PredicateLibrary {
    public static final Predicate<Dog> YoungAndStrong =  (o) -> (o.getAge() < 7 && o.getPower()>70);
    public static final Predicate<Dog> YoungButWeak =  (o) -> (o.getAge() < 7 && o.getPower()<70);

    public void print() {
        System.out.println("Print in PredicateLibrary");
    }
}

class Dog {
    int age;
    int power;

    public Dog(int age,int power) {
        this.age=age;this.power=power;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
