package regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
      Map<String,Integer> racer =  new LinkedHashMap<>();
              String [] line = read.nextLine().split(",\\s+");
        for (String s : line
             ) {
            racer.put(s,0);
        }
      while(true){

          String input = read.nextLine();
          if (input.equals("end of race"))break;
          Pattern letter= Pattern.compile("[A-Za-z]");
          Pattern  number = Pattern.compile("\\d");
          Matcher match = letter.matcher(input);
          String name = "";
          while(match.find()){
              name+=match.group();
          }

          if(racer.containsKey(name)){
              Integer distance=0;
              match=number.matcher(input);

              while(match.find()){
                distance+=Integer.parseInt(match.group());
              }

              racer.put(name,racer.get(name)+distance);
          }
      }

        List<String> winner = racer.entrySet().stream().sorted((a,b)->b.getValue()-a.getValue()).limit(3).map(Map.Entry::getKey).collect(Collectors.toList());

        int i=0;
        if(!winner.get(0).equals("")){
        for (String s: winner
             ) {


                if(i==0)
                System.out.println("1st place: " + winner.get(i));
                if(i==1)
                System.out.println("2nd place: " + winner.get(i));
                if(i==2)
                System.out.println("3rd place: " + winner.get(i));
            i++;
        }}


}
}
