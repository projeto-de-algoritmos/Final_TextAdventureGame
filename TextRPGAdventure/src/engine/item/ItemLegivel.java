package engine.item;

import java.util.List;

public class ItemLegivel extends Item{

    private List<String> textos;

    public ItemLegivel(String nome, String descricao, Boolean rastreavel, Boolean coletavel, List<String> textos){
        super(nome, descricao, rastreavel, coletavel);

        if(textos != null) {
            this.textos = textos;
        }
    }

    @Override
    public void usar() {

        if(textos == null || textos.isEmpty()){
            System.out.println("Não há nada escrito aqui !");
            return;
        }

        for(String texto: textos){
            System.out.println(texto);
        }

    }
}
