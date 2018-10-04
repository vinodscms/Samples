package com.testing;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierConsumer {
    public static void main(String args[]) {

        //Consumer. Consume an input, do some operation on the object without returning any result.
        Consumer<String> consumer = SupplierConsumer::printNames;
        consumer.accept("John");
        consumer.accept("Cindy");
        consumer.accept("Raymond");

        System.out.println("-----------------------");

        //consumer with andThen
        Consumer<String> consumerWithAndThen = consumer.andThen( i-> System.out.println("(printed "+i+")"));
        List<String> names= Arrays.asList("Rojer","Mark","Jimmy");
        printList(names,consumerWithAndThen);

        System.out.println("-----------------------");

        //Supplier. The supplier can be used in all contexts where there is no input but an output is expected.
        //Supplier instance with lambda expression
        Supplier<String> helloStrSupplier = () -> new String("Hello");
        String helloStr = helloStrSupplier.get();
        System.out.println("String is->"+helloStr+"<-");

        //Supplier instance using method reference to default constructor
        Supplier<String> emptyStrSupplier = String::new;
        String emptyStr = emptyStrSupplier.get();
        System.out.println("String in emptyStr is->"+emptyStr+"<-");

        //Supplier instance using method reference to a static method
        Supplier<Date> dateSupplier= SupplierConsumer::getSystemDate;
        Date systemDate = dateSupplier.get();
        System.out.println("systemDate->" + systemDate);

        System.out.println("-----------------------");

        //BiConsumer. Takes 2 values and performs something
        Map<Integer,String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        BiConsumer<Integer,String> biConsumer = (key, value) ->
                System.out.println("Key:"+ key+" Value:"+ value);
        map.forEach(biConsumer);
    }

    private static void printNames(String name) {
        System.out.println(name);
    }

    public static void printList(List<String> listOfIntegers, Consumer<String> consumer){
        for(String s:listOfIntegers){
            consumer.accept(s);
        }
    }

    public static Date getSystemDate() {
        return new Date();
    }
}
