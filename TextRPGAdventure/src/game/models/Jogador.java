package game.models;

import game.models.item.*;

import java.util.ArrayList;
import java.util.List;

public class Jogador extends Personagem{

    private Area areaAtual;

    public Jogador(String nome, Integer vida, Area areaAtual){
        super(nome, vida);
        this.areaAtual = areaAtual;
    }

    public void verificarItensEsgotadosOuQuebrados(){
        List<Item> itensRemovidos = new ArrayList<>();

        for(Item item : getItens()){
            if(item instanceof ItemConsumivel) {
                if(((ItemConsumivel) item).getCargas() <= 0){
                    itensRemovidos.add(item);
                }
            } else if(item instanceof Arma) {
                if(((Arma) item).getDurabilidade() <= 0){
                    itensRemovidos.add(item);
                }
            } else if (item instanceof ItemChave) {
                if(((ItemChave) item).getItemDesbloqueavel().getDesbloqueado()){
                    itensRemovidos.add(item);
                }
            } else if (item instanceof ItemChavePorta) {
                if(((ItemChavePorta) item).getUsadoComSucesso()){
                    itensRemovidos.add(item);
                }
            }
        }

        for(Item item: itensRemovidos)
            getItens().remove(item);
    }

    public Area getAreaAtual() {
        return areaAtual;
    }

    public void setAreaAtual(Area areaAtual) {
        this.areaAtual = areaAtual;
    }
}
