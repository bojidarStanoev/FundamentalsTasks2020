package Exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        Integer l = Integer.parseInt(read.nextLine());
        int i=0;
        Pattern pat = Pattern.compile("!(?<command>[A-Z][a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})\\]");
        while (i<l){
            String inp = read.nextLine();
            Matcher matcher = pat.matcher(inp);


            if (matcher.find()){
              char []  mes = matcher.group("message").toCharArray();
              System.out.print(matcher.group("command") + ":");
                for (char c: mes
                     ) {
                    System.out.print(" " + (int)c );
                }
                System.out.println();
            }
            else {
                System.out.println("The message is invalid");
            }


            i++;
        }
    }
}
