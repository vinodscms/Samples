package com.testing;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utilities {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("A", "B", "C", "D");
        List<String> list2 = Arrays.asList("A", "D", "E");
        Map<Boolean, List<String>> map = list1.stream().collect(Collectors.partitioningBy(list2::contains));
        System.out.println(map);
        System.out.println(list1.stream().collect(Collectors.partitioningBy(list2::contains)).get(true).size()>0);
    }
}
