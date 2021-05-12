package engine.item;

import engine.JogoController;

public class ItemChavePorta extends Item{

    private Boolean usadoComSucesso;

    public ItemChavePorta(String nome, String descricao, Boolean rastreavel, Boolean coletavel) {
        super(nome, descricao, rastreavel, coletavel);
        this.usadoComSucesso = false;
    }

    @Override
    public void usar() {
        String caminhoAberto = JogoController.getJogo().desbloquearCaminho(this);

        if(caminhoAberto != null) {
            System.out.println("Uma das portas se abre. O seguinte caminho agora está disponível: " + caminhoAberto);
            System.out.println("O item " + super.getNome() + " foi removido do inventário !");
            this.usadoComSucesso = true;
        } else {
            System.out.println(" Aparentemente, essa chave não abre nenhuma destas portas. ");
        }

    }

    public Boolean getUsadoComSucesso() {
        return usadoComSucesso;
    }
}
