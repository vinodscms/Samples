package com.samples;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityQueueImpl {
    public static void main(String args[]) {
        int[] numbers = { 10, 1, 5, 3, 4, 7, 6, 2, 9, 8, 11 };
        Queue<Integer> pq1 = new PriorityBlockingQueue<>();  //For thread safety or concurrency
        for (int n : numbers) {
            pq1.add(n);
        }
        System.out.println("Queue Initial: " + pq1);

        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int n : numbers) {
            pq2.add(n);
        }
        System.out.println("Queue Reverse Priority: " + pq2);

        // return highest priority element in the queue without removing it
        System.out.println("peek: " + pq2.peek());
        // print size of the queue
        System.out.println("size: " + pq2.size());
        // return highest priority element and removes it from the queue
        System.out.println("poll: " + pq2.poll());

        System.out.println("Queue After Poll : " + pq2);

        EmployeeComparator ecmp = new EmployeeComparator();
        PriorityQueue<Employee> employeePriorityQueue = new PriorityQueue<>(ecmp);

        employeePriorityQueue.add(new Employee("Edmund",115000));
        employeePriorityQueue.add(new Employee("Zara",105000));
        employeePriorityQueue.add(new Employee("Adele",100000));
        employeePriorityQueue.add(new Employee("Simone",145000));
        employeePriorityQueue.add(new Employee("Beth",128000));

        while (!employeePriorityQueue.isEmpty()) {
            System.out.println(employeePriorityQueue.remove());
        }
    }

    private static class EmployeeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.salary.compareTo(o2.salary);
        }
    }

    static class Employee {
        String name;
        Integer salary;
        Employee(String name,Integer salary) {
            this.name= name;
            this.salary=salary;
        }
        @Override
        public String toString(){
            return "Employee[" + name +"," +salary +"]";
        }
    }

}
