package com.company;

import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        String [] strarr = input.nextLine().split(" ");

        Map<Character,Integer> c = new LinkedHashMap<>();
        for (String str :strarr) {
            for (int i=0;i<str.length();i++)
             {
                 Character s = str.charAt(i);
                if (!c.containsKey(s)) {
                    c.put(s, 0);
                }

                c.put(s, c.get(s) + 1);


            }
        }
        for(Map.Entry<Character,Integer>out : c.entrySet()){

            System.out.println(out.getKey() + " -> " + out.getValue());
        }
    }
}
