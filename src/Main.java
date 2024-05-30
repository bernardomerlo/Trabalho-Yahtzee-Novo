import entidades.Jogador;
import entidades.Jogo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Jogador jogador = new Jogador("Bernardo");
        Jogador jogador1 = new Jogador("Maria");
        Jogador jogador2 = new Jogador("Jose");
        ArrayList<Jogador> lista = new ArrayList<>();
        lista.add(jogador);
        lista.add(jogador1);
        lista.add(jogador2);

        Jogo jogo = new Jogo(lista);
        jogo.jogar(sc);


    }
}