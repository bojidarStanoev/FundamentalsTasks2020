package Exam;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        String str = read.nextLine();

        while(true){
          String [] input = read.nextLine().split("\\s+");

          if (input[0].equals("End")){break;}
          if(input[0].equals("Translate")){
              str = str.replaceAll(input[1],input[2]);
              System.out.println(str);
          }
            if(input[0].equals("Includes")){
                if(str.contains(input[1])){
                    System.out.println("True");
                }
                else {
                    System.out.println("False");
                }

            }
            if(input[0].equals("Start")){
                if(str.split(" ")[0].equals(input[1])){
                    System.out.println("True");
                }
                else{
                    System.out.println("False");
                }

            }
            if(input[0].equals("Lowercase")){
                str= str.toLowerCase();
                System.out.println(str);
            }
            if(input[0].equals("FindIndex")){
                System.out.println(str.lastIndexOf(input[1]));
            }
            if(input[0].equals("Remove")){
                int start = Integer.parseInt(input[1]);
                int end = Integer.parseInt(input[2]);
               String remove = str.substring(start,start+end);

                str = str.replaceFirst(remove,"");
                System.out.println(str);
            }

        }
    }

}
