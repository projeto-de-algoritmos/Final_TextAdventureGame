package game.models.item;

import game.models.AreaIluminada;
import game.models.JogoController;

public class Lanterna extends ItemIluminador{

    private Integer qntBateria;

    public Lanterna(String nome, String descricao, Boolean rastreavel, Boolean coletavel, boolean ligado, Integer qntBateria) {
        super(nome, descricao, rastreavel, coletavel, ligado);
        this.qntBateria = qntBateria;
    }

    @Override
    public void iluminar() {
        this.setLigado(!this.isLigado());

        if(qntBateria <= 0){
            System.out.println("A lanterna está sem bateria. Talvez tenha alguma perdida por ai...");
        } else {
            if(this.isLigado()){
                System.out.println("A lanterna está ligada");

            } else {
                System.out.println("A lanterna está desligada.");
            }

            iluminarArea();

        }
    }

    public void iluminarArea(){
        if(JogoController.getJogo().getAreaAtualJogador() instanceof AreaIluminada){
            AreaIluminada areaAtual = (AreaIluminada) JogoController.getJogo().getAreaAtualJogador();
            if(this.isLigado())
                areaAtual.setIluminacaoAtual(true);
            else
                areaAtual.setIluminacaoAtual(areaAtual.getIluminacaoPadrao());
        }
    }

}
