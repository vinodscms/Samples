package com.samples;

import java.util.Arrays;

public class GridSearch {
    public static void main(String args[]) {
        System.out.println("Start");
        int mat[][] = {
                {31,38,44,51,56,65},
                {45,55,56,63,69,79},
                {56,63,73,75,76,82},
                {63,65,81,84,88,89},
                {73,83,86,91,99,109},
                {78,87,95,103,107,116},
                {82,91,104,107,112,119},
                {88,96,114,121,126,134},
                {91,104,120,128,138,148},
                {101,114,123,135,144,153},
                {103,116,129,138,146,155}};

        search(mat, 102);
    }
    private static void search(int[][] mat, int x) {

        int i = 0;
        int j = mat[0].length-1;
        int k = mat.length;

        while ( i < k && j >= 0 )
        {
            if ( mat[i][j] == x )
            {
                System.out.print("Found at "+ i + " " + j);
                return;
            }
            if ( mat[i][j] > x )
                j--;
            else
                i++;
        }

        System.out.print("Element not found");
        return;

    }
}
