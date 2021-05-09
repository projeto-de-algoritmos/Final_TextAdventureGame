package game.models;

import game.models.item.Arma;
import game.models.item.Item;
import game.models.item.ItemChave;
import game.models.item.ItemConsumivel;

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
            }
        }

        getItens().remove(itensRemovidos);
    }

    public Area getAreaAtual() {
        return areaAtual;
    }

    public void setAreaAtual(Area areaAtual) {
        this.areaAtual = areaAtual;
    }
}
