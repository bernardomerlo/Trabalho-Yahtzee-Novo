package entidades;

import java.util.ArrayList;

public class Tabela {
    private int ones;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private int bonus;
    private int total1;

    private int threeOfAKind;
    private int fourOfAKind;
    private int fullHouse;
    private int smallStraight;
    private int largeStraight;
    private int chance;
    private int yahtzee;
    private int totalFinal;

    public int getOnes() {
        return ones;
    }

    public void setOnes(ArrayList<Dado> dados) {
        int total = 0;
        for(Dado d : dados){
            if(d != null){
                if(d.getFace() == 1){
                    total += 1;
                }
            }
        }
        this.ones = total;
    }

    public int getTwos() {
        return twos;
    }

    public void setTwos(ArrayList<Dado> dados) {
        int total = 0;
        for(Dado d : dados){
            if(d != null){
                if(d.getFace() == 2){
                    total += 2;
                }
            }
        }
        this.twos = total;
    }

    public int getThrees() {
        return threes;
    }

    public void setThrees(ArrayList<Dado> dados) {
        int total = 0;
        for(Dado d : dados){
            if(d != null){
                if(d.getFace() == 3){
                    total += 3;
                }
            }
        }
        this.threes = total;
    }

    public int getFours() {
        return fours;
    }

    public void setFours(ArrayList<Dado> dados) {
        int total = 0;
        for(Dado d : dados){
            if(d != null){
                if(d.getFace() == 4){
                    total += 4;
                }
            }
        }
        this.fours = total;
    }

    public int getFives() {
        return fives;
    }

    public void setFives(ArrayList<Dado> dados) {
        int total = 0;
        for(Dado d : dados){
            if(d != null){
                if(d.getFace() == 5){
                    total += 5;
                }
            }
        }
        this.fives = total;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(ArrayList<Dado> dados) {
        int total = 0;
        for(Dado d : dados){
            if(d != null){
                if(d.getFace() == 6){
                    total += 6;
                }
            }
        }
        this.sixes = total;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus() {
        int total = this.ones + this.twos + this.threes + this.fours + this.fives + this.sixes;
        if(total >= 63){
            this.bonus = 35;
        }
    }

    public int getTotal1() {
        return total1;
    }

    public void setTotal1() {
        this.total1 = this.ones + this.twos + this.threes + this.fours + this.fives + this.sixes + this.bonus;
    }

    public void mostrarTabela() {
        System.out.println("Ones: " + this.ones);
        System.out.println("Twos: " + this.twos);
        System.out.println("Threes: " + this.threes);
        System.out.println("Fours: " + this.fours);
        System.out.println("Fives: " + this.fives);
        System.out.println("Sixes: " + this.sixes);
        System.out.println("Three of a Kind: " + this.threeOfAKind);
        System.out.println("Four of a Kind: " + this.fourOfAKind);
        System.out.println("Full House: " + this.fullHouse);
        System.out.println("Small straight: " + this.smallStraight);
        System.out.println("Large straight: " + this.largeStraight);
        System.out.println("Chance: " + this.chance);
        System.out.println("Yahtzee: " + this.yahtzee);
    }
}
