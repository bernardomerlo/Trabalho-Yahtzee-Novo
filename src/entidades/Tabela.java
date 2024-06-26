package entidades;

import java.util.ArrayList;
import java.util.Comparator;

public class Tabela {
    private Integer ones;
    private Integer twos;
    private Integer threes;
    private Integer fours;
    private Integer fives;
    private Integer sixes;
    private Integer bonus;
    private Integer total1;
    private Integer threeOfAKind;
    private Integer fourOfAKind;
    private Integer fullHouse;
    private Integer smallStraight;
    private Integer largeStraight;
    private Integer chance;
    private Integer yahtzee;
    private Integer totalFinal;

    public int getOnes() {
        return ones;
    }

    public void setOnes(ArrayList<Dado> dados) {
        int total = 0;
        for (Dado d : dados) {
            if (d != null) {
                if (d.getFace() == 1) {
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
        for (Dado d : dados) {
            if (d != null) {
                if (d.getFace() == 2) {
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
        for (Dado d : dados) {
            if (d != null) {
                if (d.getFace() == 3) {
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
        for (Dado d : dados) {
            if (d != null) {
                if (d.getFace() == 4) {
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
        for (Dado d : dados) {
            if (d != null) {
                if (d.getFace() == 5) {
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
        for (Dado d : dados) {
            if (d != null) {
                if (d.getFace() == 6) {
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
        if (total >= 63) {
            this.bonus = 35;
        }
    }

    public int getTotal1() {
        return total1;
    }

    public void setTotal1() {
        this.total1 = this.ones + this.twos + this.threes + this.fours + this.fives + this.sixes + this.bonus;
    }

    public int getThreeOfAKind() {
        return threeOfAKind;
    }

    public void setThreeOfAKind(ArrayList<Dado> dados) {
        dados = ordenaDados(dados);

        boolean sequencia = false;
        int i = 0;
        while (!sequencia) {
            if (i > dados.size()) {
                break;
            }
            if (i + 1 < 5 && i + 2 < 5) {
                if (dados.get(i).getFace() == dados.get(i + 1).getFace() && dados.get(i).getFace() == dados.get(i + 2).getFace()) {
                    this.threeOfAKind = dados.get(i).getFace() * 3;
                    sequencia = true;
                }
            }
            i++;
        }
    }

    public int getFourOfAKind() {
        return fourOfAKind;
    }

    public void setFourOfAKind(ArrayList<Dado> dados) {
        dados = ordenaDados(dados);

        int primeiro = dados.get(0).getFace();
        int segundo = dados.get(1).getFace();
        int terceiro = dados.get(2).getFace();
        int quarto = dados.get(3).getFace();
        int quinto = dados.get(4).getFace();

        if (primeiro == segundo && segundo == terceiro && terceiro == quarto || segundo == terceiro && terceiro == quarto && quarto == quinto) {
            this.fourOfAKind = terceiro * 4;
        }

        for (Dado d : dados) {
            if (d != null) {
                System.out.println(d.getFace());
            }
        }
    }

    public int getFullHouse() {
        return fullHouse;
    }

    public void setFullHouse(ArrayList<Dado> dados) {
        dados = ordenaDados(dados);
        boolean doisPrimeiros = dados.get(0).getFace() == dados.get(1).getFace();
        boolean primeiroETerceiro = dados.get(0).getFace() == dados.get(2).getFace();
        boolean ultimos = dados.get(3).getFace() == dados.get(4).getFace();

        boolean terceiroEUltimo = dados.get(2).getFace() == dados.get(3).getFace();
        boolean quartoEUlimo = dados.get(3).getFace() == dados.get(4).getFace();
        if (doisPrimeiros && primeiroETerceiro && ultimos) {
            this.fullHouse = 35;
        } else if (doisPrimeiros && terceiroEUltimo && quartoEUlimo) {
            this.fullHouse = 35;
        }
    }

    public Integer getSmallStraight() {
        return smallStraight;
    }

    public void setSmallStraight(ArrayList<Dado> dados) {
        dados = ordenaDados(dados);

        int dado0 = dados.get(0).getFace();
        int dado1 = dados.get(1).getFace();
        int dado2 = dados.get(2).getFace();
        int dado3 = dados.get(3).getFace();
        int dado4 = dados.get(4).getFace();
        boolean valores = dado1 + 1 == dado2 && dado2 + 1 == dado3;

        if (dado0 + 1 == dado1 && valores || valores && dado3 + 1 == dado4) {
            this.smallStraight = 30;
        }

        for (Dado d : dados) {
            if (d != null) {
                System.out.println(d.getFace());
            }
        }
    }

    public Integer getLargeStraight() {
        return largeStraight;
    }

    public void setLargeStraight(ArrayList<Dado> dados) {
        dados = ordenaDados(dados);

        int dado0 = dados.get(0).getFace();
        int dado1 = dados.get(1).getFace();
        int dado2 = dados.get(2).getFace();
        int dado3 = dados.get(3).getFace();
        int dado4 = dados.get(4).getFace();
        boolean verificacao = dado0 + 1 == dado1 && dado1 + 1 == dado2 && dado2 + 1 == dado3 && dado3 + 1 == dado4;

        if (verificacao) {
            this.largeStraight = 40;
        }

        for (Dado d : dados) {
            if (d != null) {
                System.out.println(d.getFace());
            }
        }
    }

    public Integer getChance() {
        return chance;
    }

    public void setChance(ArrayList<Dado> dados) {
        this.chance = dados.get(0).getFace() + dados.get(1).getFace() + dados.get(2).getFace() + dados.get(3).getFace() + dados.get(4).getFace();
    }

    public Integer getYahtzee() {
        return yahtzee;
    }

    public void setYahtzee(ArrayList<Dado> dados) {
        if (dados.get(0).getFace() == dados.get(1).getFace() && dados.get(1).getFace() == dados.get(2).getFace() && dados.get(2).getFace() == dados.get(3).getFace() && dados.get(2).getFace() == dados.get(4).getFace()) {
            if (this.yahtzee == 50) {
                this.yahtzee += 100;
            } else {
                this.yahtzee = 50;
            }
        }
    }

    public Integer getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(Integer totalFinal) {
        this.totalFinal = this.total1 + this.threeOfAKind + this.fourOfAKind + this.fullHouse + this.smallStraight + this.largeStraight + this.chance + this.yahtzee;
    }

    public void mostrarTabela() {
        System.out.println("Tabela de Pontos Atual");
        System.out.println("1.Ones: " + (this.ones != null ? this.ones : 0));
        System.out.println("2.Twos: " + (this.twos != null ? this.twos : 0));
        System.out.println("3.Threes: " + (this.threes != null ? this.threes : 0));
        System.out.println("4.Fours: " + (this.fours != null ? this.fours : 0));
        System.out.println("5.Fives: " + (this.fives != null ? this.fives : 0));
        System.out.println("6.Sixes: " + (this.sixes != null ? this.sixes : 0));
        System.out.println("7.Three of a Kind: " + (this.threeOfAKind != null ? this.threeOfAKind : 0));
        System.out.println("8.Four of a Kind: " + (this.fourOfAKind != null ? this.fourOfAKind : 0));
        System.out.println("9.Full House: " + (this.fullHouse != null ? this.fullHouse : 0));
        System.out.println("10.Small straight: " + (this.smallStraight != null ? this.smallStraight : 0));
        System.out.println("11.Large straight: " + (this.largeStraight != null ? this.largeStraight : 0));
        System.out.println("12.Chance: " + (this.chance != null ? this.chance : 0));
        System.out.println("13.Yahtzee: " + (this.yahtzee != null ? this.yahtzee : 0));
    }

    public void mostraTabelaDeEscolha() {
        System.out.println("Tabela de Escolha, digite somente um dos valores que aparecem abaixo:");
        System.out.println((this.ones != null ? "Ones já selecionado" : "1.Ones: " + 0));
        System.out.println((this.twos != null ? "Twos já selecionado" : "2.Twos: " + 0));
        System.out.println((this.threes != null ? "Threes já selecionado" : "3.Threes: " + 0));
        System.out.println((this.fours != null ? "Fours já selecionado" : "4.Fours: " + 0));
        System.out.println((this.fives != null ? "Fives já selecionado" : "5.Fives: " + 0));
        System.out.println((this.sixes != null ? "Sixes já selecionado" : "6.Sixes: " + 0));
        System.out.println((this.threeOfAKind != null ? "Three of a Kind já selecionado" : "7.Three of a Kind: " + 0));
        System.out.println((this.fourOfAKind != null ? "Four of a Kind já selecionado" : "8.Four of a Kind: " + 0));
        System.out.println((this.fullHouse != null ? "Full House já selecionado" : "9.Full House: " + 0));
        System.out.println((this.smallStraight != null ? "Small Straight já selecionado" : "10.Small Straight: " + 0));
        System.out.println((this.largeStraight != null ? "Large Straight já selecionado" : "11.Large Straight: " + 0));
        System.out.println((this.chance != null ? "Chance já selecionado" : "12.Chance: " + 0));
        System.out.println((this.yahtzee != null ? "Yahtzee já selecionado" : "13.Yahtzee: " + 0));
    }


    private static ArrayList<Dado> ordenaDados(ArrayList<Dado> dados) {
        dados.sort(new Comparator<Dado>() {
            @Override
            public int compare(Dado d1, Dado d2) {
                return Integer.compare(d1.getFace(), d2.getFace());
            }
        });
        return dados;
    }
}
