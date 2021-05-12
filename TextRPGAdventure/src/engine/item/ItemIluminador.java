package engine.item;

public abstract class ItemIluminador extends Item{

    private boolean ligado;

    public ItemIluminador(String nome, String descricao, boolean rastreavel, boolean coletavel, boolean ligado){
        super(nome, descricao, rastreavel, coletavel);

        this.ligado = ligado;
    }

    public ItemIluminador(String nome, String descricao, boolean rastreavel, boolean coletavel){
        super(nome, descricao, rastreavel, coletavel);
        this.ligado = false;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    @Override
    public void usar(){
        iluminar();
    }

    public abstract void iluminar();

}
