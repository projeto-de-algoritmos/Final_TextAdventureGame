package game.models.item;

import engine.item.ItemChave;
import engine.item.ItemDesbloqueavel;
import engine.JogoController;

public class Mascara extends ItemChave {

    private String novaDescricaoDesbloqueado;

    public Mascara(String nome, String descricao, Boolean rastreavel, Boolean coletavel, ItemDesbloqueavel itemDesbloqueavel, String mensagemAoDesbloquear, String novaDescricaoDesbloqueado) {
        super(nome, descricao, rastreavel, coletavel, itemDesbloqueavel, mensagemAoDesbloquear);
        this.novaDescricaoDesbloqueado = novaDescricaoDesbloqueado;
    }



    @Override
    public void usar() {
        if(JogoController.getJogo().getAreaAtualJogador().getItens().contains(this.getItemDesbloqueavel()) || JogoController.getJogo().getJogador().getItens().contains(this.getItemDesbloqueavel())){
            System.out.println(this.getMensagemAoDesbloquear());
            System.out.println("O item " + super.getNome() + " foi removido do inventário !");
            getItemDesbloqueavel().setDesbloqueado(true);
            getItemDesbloqueavel().setDescricao(this.novaDescricaoDesbloqueado);
        }
    }

}
