package MapLambda;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Order {
    String name;
    Double price;

    public void setPrice(Double price) {
        this.price = price;
    }
    public void addCount(Integer count){
        this.count+=count;
    }
    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getCount() {
        return count;
    }

    public Order(String name, Double price, Integer count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    Integer count;


    @Override
    public String toString() {
        return this.name+ " -> " + String.format("%.2f",(Double)price*count);
    }

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        Map<String,Order> products = new LinkedHashMap<>();

        while(true){
            String [] line = read.nextLine().split(" ");
            if(line[0].equals("buy"))break;

            String name = line[0];
            Double price = Double.parseDouble(line[1]);
            int c = Integer.parseInt(line[2]);
            if(products.containsKey(name)){
                products.get(name).setPrice(price);
                products.get(name).addCount(c);
            }
            products.putIfAbsent(name,new Order(name,price,c));

        }
        products.entrySet().forEach(k->{
            System.out.println(k.getValue().toString());

        });


    }
}

