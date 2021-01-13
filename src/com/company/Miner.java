package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Miner {


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int i=1;
        Map<String,Integer> mined = new LinkedHashMap<>();
        while(true){
        String inp = input.nextLine();
        if (inp.equals("stop"))
        {break;}
        Integer val = Integer.parseInt(input.nextLine());
         Integer check = mined.putIfAbsent(inp,val);
         if(check != null){
        mined.replace(inp,val+check);}
        }
        for (Map.Entry<String,Integer>out: mined.entrySet()
             ) {
            System.out.println(out.getKey() + " -> " + out.getValue());
        }
    }
}
