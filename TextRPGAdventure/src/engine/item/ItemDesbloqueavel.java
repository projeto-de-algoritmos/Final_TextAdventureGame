package engine.item;

public abstract class ItemDesbloqueavel extends Item{

    private Boolean desbloqueado;
    private String mensagemItemBloqueado;

    public ItemDesbloqueavel(String nome, String descricao, Boolean rastreavel, Boolean coletavel, String mensagemItemBloqueado) {
        super(nome, descricao, rastreavel, coletavel);
        this.desbloqueado = false;
        this.mensagemItemBloqueado = mensagemItemBloqueado;
    }

    public Boolean getDesbloqueado() {
        return desbloqueado;
    }

    public void setDesbloqueado(Boolean desbloqueado) {
        this.desbloqueado = desbloqueado;
    }

    public abstract void usarDesbloqueado();

    @Override
    public void usar() {
        if(desbloqueado){
            usarDesbloqueado();
        } else {
            System.out.println(mensagemItemBloqueado);
        }
    }

}
