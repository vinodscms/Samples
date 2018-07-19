package com.company;

import java.util.Scanner;

public class PrintPyramid{
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int count = scanner.nextInt();

        for(int i=1;i<=count;i++) {
            for(int j=0;j<count-i;j++) {
                System.out.print(" ");
            }
            for(int k=0;k<(i*2-1);k++) {
                System.out.print("A");
            }
            System.out.println("");
        }
    }
}
