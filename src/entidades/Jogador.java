package entidades;

import java.util.ArrayList;

public class Jogador {
    private String nome;
    private Integer pontos;
    private ArrayList<Dado> dadosAtuais;
    private ArrayList<Dado> dadosGuardados;
    private ArrayList<Dado> dadosFinais;
    private Tabela tabela;
    private Integer quantDadosSalvos;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.dadosAtuais = new ArrayList<Dado>();
        this.tabela = new Tabela();
        this.dadosGuardados = new ArrayList<Dado>();
        this.quantDadosSalvos = 0;
        iniciarLista();
        iniciaVazios();
    }

    private void iniciaVazios() {
        for(int i= 0; i<5;i++){
            this.dadosGuardados.add(null);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public ArrayList<Dado> getDadosAtuais() {
        return dadosAtuais;
    }

    public void setDadosAtuais(ArrayList<Dado> dadosAtuais) {
        this.dadosAtuais = dadosAtuais;
    }

    public Tabela getTabela() {
        return tabela;
    }

    public void setTabela(Tabela tabela) {
        this.tabela = tabela;
    }

    public ArrayList<Dado> getDadosGuardados() {
        return dadosGuardados;
    }

    public void setDadosGuardados(ArrayList<Dado> dadosGuardados) {
        this.dadosGuardados = dadosGuardados;
    }

    public Integer getQuantDadosSalvos() {
        return quantDadosSalvos;
    }

    public void setQuantDadosSalvos(Integer quantDadosSalvos) {
        this.quantDadosSalvos += quantDadosSalvos;
    }

    public ArrayList<Dado> getDadosFinais() {
        return dadosFinais;
    }

    public void setDadosFinais(ArrayList<Dado> dadosFinais) {
        this.dadosFinais = dadosFinais;
    }

    private void iniciarLista(){
        for(int i= 0; i<5;i++){
            Dado d = new Dado();
            this.dadosAtuais.add(d);
        }
    }

    public void rolarDados(){
        for(Dado d : this.dadosAtuais){
            if(d != null){
                d.rolar();
                System.out.printf("Face %d: %d\n", this.dadosAtuais.indexOf(d),d.getFace());
            }
        }
    }

    public void calculaDadosFinal(){
        this.dadosFinais = new ArrayList<Dado>();
        for(Dado d : this.dadosGuardados){
            if(d != null){
                this.dadosFinais.add(d);
            }
        }
        for(Dado d : this.dadosAtuais){
            if(d != null){
                this.dadosFinais.add(d);
            }
        }
    }
}
