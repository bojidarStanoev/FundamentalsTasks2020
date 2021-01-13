package Exam;

import java.util.Scanner;
import java.util.TreeMap;

public class Exam3 {
    String name;
    Integer hp;
    Integer mp;

    public Exam3(String name, Integer hp, Integer mp) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
    }

    public String getName() {
        return name;
    }

    public Integer getHp() {
        if(this.hp<=0)
        {System.out.println(this.name + " was disqualified!");}
        return hp;
    }

    public Integer getMp() {
        if(this.mp<=0)
        {System.out.println(this.name + " was disqualified!");}

        return mp;
    }
    public void takeDamage(int damage){
        this.hp-=damage;
    }
    public void strike(){
        this.mp-=1;
    }

    @Override
    public String toString() {
        return name + " - " + hp + " - " + mp;
    }

    public  void addHp(int hp){
        this.hp+=hp;
    }

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        TreeMap<String,Exam3> hero = new TreeMap<>();
        while(true){
        String [] line = read.nextLine().split(":");
        if(line[0].equals("Results"))break;
        if(line[0].equals("Add")){
            String name = line[1];
            int hp= Integer.parseInt(line[2]);
            int mp= Integer.parseInt(line[3]);
            if(hero.containsKey(name)){
                hero.get(name).addHp(hp);
            }
            hero.putIfAbsent(name,new Exam3(name,hp,mp));
        }

            if(line[0].equals("Attack")) {
                String attack = line[1];
                String def = line[2];
                int damage = Integer.parseInt(line[3]);
                if(hero.containsKey(attack) && hero.containsKey(def)){

                    hero.get(def).takeDamage(damage);
                    if(hero.get(def).getHp()<=0)hero.remove(def);
                    hero.get(attack).strike();
                    if (hero.get(attack).getMp()<=0)hero.remove(attack);
                }
            }
            if(line[0].equals("Delete")) {
                String attack = line[1];
                if(attack.equals("All")){
                hero.clear();
                }
                else {
                    hero.remove(attack);
                }
            }
        }
        System.out.println("People count: " + hero.size());
        if(!hero.isEmpty()){

            hero.values().stream().sorted((a,b) ->b.getHp() - a.getHp()).forEach(a ->System.out.println(a.toString()));
        }

    }
}

