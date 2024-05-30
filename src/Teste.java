import entidades.Dado;
import entidades.Jogador;

import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {
        Dado dado = new Dado(6);
        Dado dado2 = new Dado(2);
        Dado dado3 = new Dado(1);
        Dado dado4 = new Dado(4);
        Dado dado5 = new Dado(5);
        ArrayList<Dado> dados = new ArrayList<Dado>();
        dados.add(dado);
        dados.add(dado2);
        dados.add(dado3);
        dados.add(dado4);
        dados.add(dado5);
        Jogador j = new Jogador("Bernardo");
        j.getTabela().setSmallStraight(dados);
        System.out.println(j.getTabela().getSmallStraight());
    }
}
