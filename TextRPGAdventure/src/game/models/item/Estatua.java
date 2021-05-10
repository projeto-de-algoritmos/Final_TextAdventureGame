package game.models.item;

public class Estatua extends ItemDesbloqueavel{

    public Estatua(String nome, String descricao, Boolean rastreavel, Boolean coletavel, String mensagemItemBloqueado) {
        super(nome, descricao, rastreavel, coletavel, mensagemItemBloqueado);
    }

    @Override
    public void usarDesbloqueado() {
        System.out.println("");
    }
}
