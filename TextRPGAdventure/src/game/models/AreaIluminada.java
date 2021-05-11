package game.models;

import game.models.item.Item;

import java.util.List;

public class AreaIluminada extends Area {

    private Boolean iluminacaoPadrao;
    private Boolean iluminacaoAtual = false;
    private String descricaoSemIluminacao;

    public AreaIluminada(String nome, String descricao, boolean iluminacaoPadrao, String descricaoSemIluminacao){
        super(nome, descricao);
        this.iluminacaoPadrao = iluminacaoPadrao;
        this.descricaoSemIluminacao = descricaoSemIluminacao;

    }

    public AreaIluminada(String nome, String descricao, List<Item> itens, List<Inimigo> inimigos, boolean iluminacaoPadrao, String descricaoSemIluminacao){
        super(nome, descricao, itens, inimigos);
        this.iluminacaoPadrao = iluminacaoPadrao;
        this.descricaoSemIluminacao = descricaoSemIluminacao;
    }

    public Boolean getIluminacaoPadrao() {
        return iluminacaoPadrao;
    }

    public void setIluminacaoPadrao(Boolean iluminacaoPadrao) {
        this.iluminacaoPadrao = iluminacaoPadrao;
    }

    public Boolean getIluminacaoAtual() {
        return iluminacaoAtual;
    }

    public void setIluminacaoAtual(Boolean iluminacaoAtual) {
        this.iluminacaoAtual = iluminacaoAtual;
    }

    @Override
    public void mostrarDescricaoDetalhada() {

        if(iluminacaoAtual) {
            super.mostrarDescricaoDetalhada();
        } else {
            System.out.println(descricaoSemIluminacao);
        }

    }

}
