package regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Softuni {

    String mame;
    String product;
    Double income;

    public String getMame() {
        return mame;
    }

    public void setMame(String mame) {
        this.mame = mame;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Softuni(String mame, String product, Double income) {
        this.mame = mame;
        this.product = product;
        this.income = income;
    }

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        Pattern pat = Pattern.compile("%(?<name>[A-Z][a-z]+)%([^|%$.]*)<(?<product>[\\w]+)>([^|%$.]*)[|](?<amount>\\d+)[|][^|%$.]*?(?<price>[\\d+\\.?\\d*)]+)[$]");
        List<Softuni> workers = new ArrayList<>();
        double sum=0.;
        while (true) {
            String input = read.nextLine();
            if (input.equals("end of shift")) break;

            Matcher matcher = pat.matcher(input);
            if (matcher.find()) {
                Double made = Double.parseDouble(matcher.group("amount")) * Double.parseDouble(matcher.group("price"));

                sum += made;
                System.out.printf("%s: %s - %.2f\n", matcher.group("name"), matcher.group("product"), made);


            }
        }
            System.out.printf("Total income: %.2f",sum);



    }
}
