package regex;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        Pattern pat = Pattern.compile(">>([A-Za-z]\\w+)<<([\\d+\\.\\d+)?\"]+)!(\\d+)");
        ArrayList<String> furniture = new ArrayList<>();
        double sum = 0.;
        while (true) {
            String input = read.nextLine();
            if (input.equals("Purchase")) {

                break;
            }
            Matcher match = pat.matcher(input);
            if (match.find()) {
                furniture.add(match.group(1));
                sum += Double.parseDouble(match.group(2)) * Integer.parseInt(match.group(3));
            }
        }
        System.out.println("Bought furniture:");
        for (String s : furniture
        ) {
            System.out.println(s);
        }
        System.out.printf("Total money spend: %.2f", sum);
    }
}
