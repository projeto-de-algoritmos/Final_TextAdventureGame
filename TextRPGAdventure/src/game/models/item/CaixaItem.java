package game.models.item;

import engine.item.Item;
import engine.item.ItemDesbloqueavel;
import engine.JogoController;

public class CaixaItem extends ItemDesbloqueavel {

    private Item itemColetavel;

    public CaixaItem(String nome, String descricao, Boolean rastreavel, Boolean coletavel, String mensagemItemBloqueado, Item itemColetavel) {
        super(nome, descricao, rastreavel, coletavel, mensagemItemBloqueado);
        this.itemColetavel = itemColetavel;
    }

    @Override
    public void usarDesbloqueado() {

        if(this.itemColetavel != null) {
            JogoController.getJogo().getJogador().addItem(itemColetavel);
            System.out.println("Você coletou o seguinte item guardado na caixa: " + itemColetavel.getNome());
            this.itemColetavel = null;
        } else {
            System.out.println("Parece que já retiraram o que estava aqui.");
        }

    }
}
