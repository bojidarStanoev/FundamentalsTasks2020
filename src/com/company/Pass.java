package com.company;

import java.util.Scanner;

public class Pass {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        String pass = input.nextLine();
        String adapt="";
        while(true){
            String [] inp = input.nextLine().split(" ");

            if(inp[0].equals("Done")){break;}
            if(inp[0].equals("TakeOdd")){

                for(int i=0;i<pass.length();i++){

                    if (i%2!=0){
                     adapt= adapt.concat(Character.toString(pass.charAt(i)));
                    }
                }
                pass=adapt;
                System.out.println(pass);

            }
            if(inp[0].equals("Cut")){
                int start =Integer.parseInt(inp[1]);
                int end =Integer.parseInt(inp[2])+start;
              String  removed  = pass.substring(start,end);
             pass= pass.replaceFirst(removed,"");
                System.out.println(pass);
            }
            if (inp[0].equals("Substitute")){
            if(pass.contains(inp[1])){

                pass = pass.replace(inp[1],inp[2]);
                System.out.println(pass);
            }
            else{
                System.out.println("Nothing to replace!");
            }


            }

        }
        System.out.println("Your password is: " +pass);

    }
}
