package MapLambda;

import java.util.*;

public class Plants {
    public Plants(Double rating) {

    }

    public List<Double> getRating() {
        return rating;
    }

    public void setRating(List<Double> rating) {
        this.rating = rating;
    }

    public Plants(String name, Integer rarity) {
        this.name = name;
        this.rarity = rarity;
        this.rating = new ArrayList<>();

    }

    String name;
    Integer rarity;
    List<Double> rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }
    public void addRating(Double rate){
        this.rating.add(rate);
    }
    public Double avr(){
        Double sum =0.00;
        if(rating.isEmpty())return  sum;
        for (Double val: rating
             ) {
            sum+=val;
        }
        return sum/rating.size();
    }


    @Override
    public String toString() {
        return  "- " + name + "; Rarity: " + rarity + "; Rating: " + String.format("%.2f",this.avr());    }

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int times = Integer.parseInt((read.nextLine()));int i=0;
        Map<String,Plants> plants = new LinkedHashMap<>();
        while(i < times){
            String [] info = read.nextLine().split("<->");
            plants.put(info[0],new Plants(info[0],Integer.parseInt(info[1])));
            i++;
        }
        while(true){
            String [] inp= read.nextLine().split(" ");
            if(inp[0].equals("Exhibition"))break;

            if(inp[0].equals("Rate:")){
                if(plants.containsKey(inp[1])){
                    plants.get(inp[1]).addRating(Double.parseDouble(inp[3]));
                continue;
                }
            }
           else  if(inp[0].equals("Update:")) {
                if (plants.containsKey(inp[1])) {
                plants.get(inp[1]).setRarity(Integer.parseInt(inp[3]));
                continue;
                }

            }
             else if(inp[0].equals("Reset:")) {
                if (plants.containsKey(inp[1])) {
                    plants.get(inp[1]).setRating(new ArrayList<Double>());
                continue;
                }
            }

                System.out.println("error");

        }
        System.out.println("Plants for the exhibition:");
         plants.values().stream().sorted((a,b)->{
             if(a.getRarity()!= b.getRarity()){return Double.compare(b.getRarity(),a.getRarity()); }
             else{
                return Double.compare(b.avr(),a.avr());
             }
         }).forEach( p ->System.out.println(p.toString()));
    }
}
