package engine.item;

public abstract class Item {

    private String nome;
    private String descricao;
    private boolean rastreavel;
    private boolean coletavel;

    public Item(String nome, String descricao, boolean rastreavel, boolean coletavel){
        this.nome = nome;
        this.descricao = descricao;
        this.rastreavel = rastreavel;
        this.coletavel = coletavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getRastreavel() {
        return rastreavel;
    }

    public void setRastreavel(Boolean rastreavel) {
        this.rastreavel = rastreavel;
    }

    public boolean isColetavel() {
        return coletavel;
    }

    public void setColetavel(boolean coletavel) {
        this.coletavel = coletavel;
    }

    public abstract void usar();

}
