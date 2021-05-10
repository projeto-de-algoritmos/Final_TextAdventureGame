package game.models.item;

public class ItemDecorativo extends Item{

    public ItemDecorativo(String nome, String descricao, Boolean rastreavel, Boolean coletavel){
        super(nome, descricao, rastreavel, coletavel);
    }

    @Override
    public void usar() {
        System.out.println(getDescricao());
    }
}
