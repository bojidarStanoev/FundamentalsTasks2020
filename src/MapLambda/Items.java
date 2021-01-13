package MapLambda;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Items {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        TreeMap<String,Integer> junk = new TreeMap<>();
        LinkedHashMap<String,Integer> mats = new LinkedHashMap<>();
        mats.put("shards",0);
        mats.put("fragments",0);
        mats.put("motes",0);
        Boolean goalReached = false;
        while(true){

            String [] line = read.nextLine().split("\\s+");
            for(int i =0;i<line.length;i++){
                if(i%2!=0){
                    line[i]=line[i].toLowerCase();
                    if(line[i].equalsIgnoreCase("shards")){
                        if(mats.get(line[i])+ Integer.parseInt(line[i-1])>=250){
                            System.out.println("Shadowmourne obtained!");
                            mats.put(line[i],Integer.parseInt(line[i-1])+mats.get(line[i])-250);
                            goalReached=true;
                            break;
                        }
                    mats.put(line[i],mats.get(line[i])+Integer.parseInt(line[i-1]));
                    }
                    else if(line[i].equalsIgnoreCase("fragments")){

                        if(mats.get(line[i])+Integer.parseInt(line[i-1])>=250){
                            System.out.println("Valanyr obtained!");
                            mats.put(line[i],Integer.parseInt(line[i-1])+mats.get(line[i])-250);
                            goalReached=true;
                            break;}
                        mats.put(line[i],mats.get(line[i])+Integer.parseInt(line[i-1]));
                    }
                    else if(line[i].equalsIgnoreCase("motes")){

                        if(mats.get(line[i])+Integer.parseInt(line[i-1])>=250){
                            System.out.println("Dragonwrath obtained!");
                            mats.put(line[i],Integer.parseInt(line[i-1])+mats.get(line[i])-250);
                            goalReached=true;
                            break;}
                    mats.put(line[i],mats.get(line[i])+Integer.parseInt(line[i-1]));
                    }
                    else{
                        if(junk.containsKey(line[i])){
                            junk.put(line[i],junk.get(line[i])+Integer.parseInt(line[i-1]));
                        }
                        else{
                            junk.put(line[i],Integer.parseInt(line[i-1]));
                        }
                    }
                }
                            }
            if (goalReached){break;}
        }


        mats.entrySet().stream().sorted((a,b)->{
            if(b.getValue()!=a.getValue())
            {return Integer.compare(b.getValue(),a.getValue());}
                else{
                return a.getKey().compareTo(b.getKey());
            }

        }).forEach((k)->System.out.println(k.getKey() + ": " + k.getValue()));
        for (Map.Entry<String,Integer> entry : junk.entrySet()
             ) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }}

