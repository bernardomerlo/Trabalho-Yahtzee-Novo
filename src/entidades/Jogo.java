package entidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Jogo {
    private ArrayList<Jogador> jogadores;

    public Jogo(ArrayList<Jogador> jogadores){
        this.jogadores = jogadores;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public void jogar(Scanner sc){
        for(int jogadores = 0; jogadores<this.jogadores.size(); jogadores++){
            Jogador jogadorAtual = this.jogadores.get(jogadores);
            System.out.println("Vez do(a) jogador(a) " + jogadorAtual.getNome());
            for(int rodada = 0; rodada<3; rodada++){
                jogadorAtual.rolarDados();
                if(rodada <= 1) {
                    System.out.println("Deseja salvar algum dado? (s/n)");
                    String resposta = sc.nextLine();
                    if (resposta.charAt(0) == 's') {
                        System.out.println("Digite a quantidade de dados que deseja salvar: ");
                        int quantidadeASerSalvo = sc.nextInt();
                        sc.nextLine();
                        jogadorAtual.setQuantDadosSalvos(quantidadeASerSalvo);
                        if(jogadorAtual.getQuantDadosSalvos() == 5){
                            break;
                        }
                        for (int salvo = 0; salvo < quantidadeASerSalvo; salvo++) {
                            System.out.println("Digite o dado que deseja ser salvo: ");
                            int numeroDadoASerSalvo = sc.nextInt();
                            sc.nextLine();
                            jogadorAtual.getDadosGuardados().add(numeroDadoASerSalvo, jogadorAtual.getDadosAtuais().get(numeroDadoASerSalvo));
                            jogadorAtual.getDadosAtuais().set(numeroDadoASerSalvo, null);
                            System.out.println("Dado Salvo!\n");
                        }
                    }
                }
            }
            jogadorAtual.calculaDadosFinal();

            System.out.println("Seus dados: ");
            for(Dado d : jogadorAtual.getDadosFinais()){
                System.out.println(d);
            }
            calculaPontos(sc, jogadorAtual);
        }
    }

    private void calculaPontos(Scanner sc, Jogador jogador) {
        jogador.getTabela().mostrarTabela();
        ArrayList<Dado> dados = jogador.getDadosFinais();
        System.out.println("Digite aonde voce deseja salvar: ");
        int salvo = sc.nextInt();
        Tabela tabelaJogadorAtual = jogador.getTabela();
        switch (salvo){
            case(1):
                tabelaJogadorAtual.setOnes(dados);
                break;
            case(2):
                tabelaJogadorAtual.setTwos(dados);
                break;
            case(3):
                tabelaJogadorAtual.setThrees(dados);
                break;
            case(4):
                tabelaJogadorAtual.setFours(dados);
                break;
            case(5):
                tabelaJogadorAtual.setFives(dados);
                break;
            case(6):
                tabelaJogadorAtual.setSixes(dados);
                break;
            case(7):
                tabelaJogadorAtual.setThreeOfAKind(dados);
                break;
            case(8):
                tabelaJogadorAtual.setFourOfAKind(dados);
                break;
            case(9):

                break;
            case(10):

                break;
            case(11):

                break;
        }
        jogador.getTabela().mostrarTabela();
    }



}
