package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Barcode {
    public static boolean legit(String barcode){
        String regex = "(@#+)([A-Z][A-Za-z0-9]{4,})[A-Z](@#+)";
        Pattern pat = Pattern.compile(regex);
        Matcher matcher = pat.matcher(barcode);
        if(matcher.find()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int times = Integer.parseInt(input.nextLine());

        for(int i=0;i<times;i++){

            String barcode= input.nextLine();
            if(legit(barcode)){
            Pattern pat = Pattern.compile("\\d+");
            Matcher matcher= pat.matcher(barcode);
                String group="";
            while (matcher.find()){

                group += matcher.group();
            }
            if (group.equals(""))group="00";
                System.out.println("Product group: " + group);
            }

            else{
                System.out.println("Invalid barcode");
            }

        }



    }
}
