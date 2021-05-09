package game.models.item;

import game.models.JogoController;

public class ItemChave extends Item{

    private ItemDesbloqueavel itemDesbloqueavel;
    private String mensagemAoDesbloquear;

    public ItemChave(String nome, String descricao, Boolean rastreavel, ItemDesbloqueavel itemDesbloqueavel, String mensagemAoDesbloquear) {
        super(nome, descricao, rastreavel);
        this.itemDesbloqueavel = itemDesbloqueavel;
        this.mensagemAoDesbloquear = mensagemAoDesbloquear;
    }

    public ItemDesbloqueavel getItemDesbloqueavel() {
        return itemDesbloqueavel;
    }

    @Override
    public void usar() {
        if(JogoController.getJogo().getAreaAtualJogador().getItens().contains(itemDesbloqueavel) || JogoController.getJogo().getJogador().getItens().contains(itemDesbloqueavel)){
            System.out.println(mensagemAoDesbloquear);
            System.out.println("O item " + super.getNome() + " foi removido do inventário !");
            itemDesbloqueavel.setDesbloqueado(true);
        }
    }

}
