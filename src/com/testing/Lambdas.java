package com.testing;

import java.util.function.Predicate;

public class Lambdas {
    public static void main(String args[]) {
        Car car = new Car("BMW","blue");
        Car car2 = new Car("Porsche","red");

        //1. Sample lambda. Defining the functional interface.
        PrintInterface p = (Car x) -> {System.out.print(car.getName());System.out.println(car.getColor());};
        //Making use of the functional interface
        p.print(car);

        //2. Another java functional interface. Predicate.
        Predicate<Car> isRed =  (c) -> (c.getColor().equalsIgnoreCase("red"));
        System.out.println(isRed.test(car));
        System.out.println(isRed.test(car2));
    }
}

//Functional interface that contains only one abstract method
@FunctionalInterface
interface PrintInterface{
    void print(Car car);
}

@FunctionalInterface
interface OtherFunctionalInterface {
    public void oneMethod(int i, double d);   // only abstract method in class

    public String toString();   // Methods overridden from Object class is not counted
    public boolean equals(Object o);

    public static int getSum(int a, int b) {// valid->method static
        return a + b;
    }

    public default int getMulty(int c, int d) {//valid->method default
        return c + d;
    }
}

class Car {
    private String name;
    private String color;
    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }
    public String getName() {        return name;    }
    public String getColor() {        return color;    }
}
