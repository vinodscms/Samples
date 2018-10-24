package com.testing;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdasImpl {
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

        System.out.println("-------------------------");
        //BiPredicate
        BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
        System.out.println(bi.test(2, 3));
        System.out.println(bi.test(4, 3));

        System.out.println("-------------------------");

        //Function functional interface. Has apply method. Just like Predicate or BinaryOperator
        Function<Integer,Integer> square = x -> x * x;
        System.out.println(square.apply(3));

        //OR from a Util class using :: operator
        square = LambdasImpl::calculateSquare;
        System.out.println(square.apply(4));

        System.out.println("-------------------------");

        //Stream and filter
        List<Integer> list = new ArrayList<>(Arrays.asList(2,5,7,6,10,9,12,13,17,14));
        System.out.println("square of the max odd number between 3 and 11 in the given list is :" + findSquareOfList(list));

        System.out.println("-------------------------");
        //Java Optional
        String name = "something";
        Optional<String> opt = Optional.of(name);
        opt.ifPresent(n -> System.out.println("length of string:" + n.length()));//true and print
        opt = Optional.ofNullable(null);
        System.out.println(opt.isPresent());   //false

        String nullName = null;
        Optional.ofNullable(nullName).orElse("john");
        Optional.ofNullable(nullName).orElseGet(() -> "john");
        //Optional.ofNullable(nullName).orElseGet(this::getDefaultName);  //to get some default name from objects getDefaultName method
        //Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new); // if nothing works then throw new exception

        String password = " password ";
        Optional<String> passOpt = Optional.of(password);
        boolean correctPassword = passOpt
                .map(String::trim)
                .filter(pass -> pass.equals("password"))
                .isPresent();
        System.out.println(correctPassword);

        System.out.println("-------------------------");

        System.out.println("Anonymous inner class and lambda");
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world one!");
            }
        };

        // Lambda Runnable
        Runnable r2 = () -> System.out.println("Hello world two!");

        // Run threads
        r1.run();
        r2.run();

    }

    private static Integer calculateSquare(Integer a) {
        return a * a;
    }

    public static int findSquareOfList(List<Integer> numbers) {
        Predicate<Integer> lessThan11 = (x) -> x < 11;
        return numbers.stream()
                .filter(LambdasImpl::isOdd) 		//Predicate is functional interface and
                .filter(LambdasImpl::isGreaterThan3)	// we are using lambdas to initialize it
                .filter(lessThan11)	// rather than anonymous inner classes
                .max(Comparator.naturalOrder())    //use reverseOrder() to give square of 25 in the list
                .map(i -> i * i)
                .get();
    }
    public static boolean isOdd(int i) { return i % 2 != 0;}
    public static boolean isGreaterThan3(int i){return i > 3;}
    public static boolean isLessThan11(int i){ return i < 11; }
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
    }   //static and default methods not counted

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
