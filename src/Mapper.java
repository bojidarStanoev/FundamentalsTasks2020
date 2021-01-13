import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mapper {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Pattern pat = Pattern.compile("([=/])([A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pat.matcher(input.nextLine());

        ArrayList<String> destination = new ArrayList<String>();
        while(matcher.find()){
            destination.add(matcher.group(2));

        }
        int points =0;



            for (String s : destination){
            points += s.toCharArray().length;

        }

        System.out.print("Destinations: " + String.join(", ",destination) );

        System.out.println();
            System.out.println("Travel Points: " + points);

        }

    }
