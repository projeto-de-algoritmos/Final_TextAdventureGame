package game.models.item;

public class Estatua extends ItemDesbloqueavel{

    public Estatua(String nome, String descricao, Boolean rastreavel, String mensagemItemBloqueado) {
        super(nome, descricao, rastreavel, mensagemItemBloqueado);
    }

    @Override
    public void usarDesbloqueado() {
        System.out.println("Parece que já retiraram o que estava aqui.");
    }
}
