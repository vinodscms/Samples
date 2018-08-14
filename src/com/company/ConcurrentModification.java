package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModification {
    public static void main(String args[]) {
        List<String> listOfPhones = new ArrayList<String>(Arrays.asList(
                "iPhone 6S", "iPhone 6", "iPhone 5", "Samsung Galaxy 4", "Nokia Lumia", "HTC"));

        System.out.println("list of phones: " + listOfPhones);

        // Iterating and removing objects from list
        // This is wrong way, will throw ConcurrentModificationException
        for(String phone : listOfPhones){
            if(phone.startsWith("iPhone")){
                // listOfPhones.remove(phone); // will throw exception
            }
        }



        //This also will not throw exception as it is not using Iterator
        System.out.println("List before : " + listOfPhones);
        for(int i=0; i<listOfPhones.size(); i++){
            String phone = listOfPhones.get(i);
            if(phone.contains("Nokia")){
                System.out.println("Removing " + phone);
                listOfPhones.remove(i);
            }
        }
        System.out.println("List after first removal : " + listOfPhones);



        // The Right way, iterating elements using Iterator's remove() method
        for(Iterator<String> itr = listOfPhones.iterator(); itr.hasNext();){
            String phone = itr.next();
            if(phone.startsWith("iPhone")){
                // listOfPhones.remove(phone);  // wrong again
                itr.remove(); // right call
            }
        }
        System.out.println("list after second removal: " + listOfPhones);



    }
}
