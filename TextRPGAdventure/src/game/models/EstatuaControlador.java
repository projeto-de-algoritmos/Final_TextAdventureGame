package game.models;

import engine.Controlador;
import engine.JogoController;
import game.models.item.Estatua;

import java.util.List;

public class EstatuaControlador extends Controlador {

    List<Estatua> estatuas;

    public EstatuaControlador(List<Estatua> estatuas){
        this.estatuas = estatuas;
    }

    @Override
    public void executar() {
        if(estatuas.size() <= 0) {
            System.out.println("Adicione ao menos uma estátua aqui !");
            return;
        }

        for(Estatua estatua: estatuas){
            if(!estatua.getDesbloqueado()){
                return;
            }
        }

        String mensagemConclusao = "Você coletou as quatro máscaras e as colocou no seu devido lugar. A porta da mansão se abre e você consegue escapar antes que seja tarde demais.";
        JogoController.getJogo().finalizarJogo(true, mensagemConclusao);
    }
}
