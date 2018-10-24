package com.company;

public class DecompileExample {
    private String version="1.2";
    String text;
    public static void main(String args[]) {
        System.out.println(new DecompileExample().version);
    }
}

//cd \out\production\Test\com\company
//javap DecompileExample
//javap -private DecompileExample
//javap -c -private DecompileExample