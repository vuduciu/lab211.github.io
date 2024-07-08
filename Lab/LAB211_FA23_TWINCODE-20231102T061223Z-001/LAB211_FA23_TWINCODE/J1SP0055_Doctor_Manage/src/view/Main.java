/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author bravee06
 */
public class Main {
    public static void main(String[] args) {
        // Creating an empty HashMap
        HashMap<String, Integer> hash_map = new HashMap<String, Integer>();
  
        // Mapping int values to string keys
        hash_map.put("Geeks", 10);
        hash_map.put("4", 15);
        hash_map.put("Geeks", 20);
        hash_map.put("Welcomes", 25);
        hash_map.put("You", 30);
  
        // Displaying the HashMap
//        System.out.println("Initial Mappings are: " + hash_map);
  
        Set<String> keySet = hash_map.keySet();
        for(Object o : keySet){
//            System.out.println(o);
            System.out.println(hash_map.get(o));
        }
    }
}
