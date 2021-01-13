package com.company;

import java.util.Scanner;

public class Tour {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StringBuilder course= new StringBuilder();
                course.append(input.nextLine());

        while(true){
            String []inp= input.nextLine().split("[ :]");
            if(inp[0].equals("Travel")){break;}

            if (inp[0].equals("Add")){
                int index= Integer.parseInt(inp[2]);
                if(index<course.length()){
                    course.insert(index,inp[3]);
                }
            System.out.println(course.toString());
            }
            if (inp[0].equals("Remove")){

                int start= Integer.parseInt(inp[2]);
                int end= Integer.parseInt(inp[3]);
                if(end<course.length()&& start>=0){
                    course.delete(start,end+1);

                }
                System.out.println(course.toString());
            }
            if (inp[0].equals("Switch")){
            String temp = course.toString().replaceAll(inp[1],inp[2]);
            course.setLength(0);
            course.append(temp);
            System.out.println(course.toString());
            }

        }
        System.out.println("Ready for world tour! Planned stops: " + course.toString());
    }
}
