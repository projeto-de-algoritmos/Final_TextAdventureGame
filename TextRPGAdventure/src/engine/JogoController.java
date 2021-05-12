package engine;

import engine.area.Area;
import engine.area.AreaIluminada;
import engine.grafo.Aresta;
import engine.grafo.Grafo;
import engine.grafo.Vertice;
import engine.item.Item;
import engine.item.ItemChavePorta;
import engine.personagem.Chefe;
import engine.personagem.Jogador;
import engine.services.InterpreteJogador;
import engine.navegacao.Navegacao;
import engine.services.SugestaoEscrita;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public final class JogoController {

    private static JogoController jogo;
    private Jogador jogador;
    private Chefe chefe;
    private Grafo grafo = new Grafo();
    private static InterpreteJogador interpreteJogador;

    private Integer turnoAtualJogador;
    private Integer turnoAtualJogo;
    private Integer turnoAtualChefe;

    private Boolean jogoAcabou = false;
    private Boolean vencedor = false;

    private List<Controlador> controladores = new ArrayList<>();

    public void iniciarJogo(String nome, Integer vida, Area areaInicial){
        iniciarJogo(nome, vida, areaInicial, null);
    }

    public void iniciarJogo(String nome, Integer vida, Area areaInicial, Chefe chefe){
        this.chefe = chefe;
        jogador = new Jogador(nome, vida, areaInicial);
        interpreteJogador = new InterpreteJogador();
        Navegacao navegacao = new Navegacao();
        Scanner scanner = new Scanner(System.in);
        turnoAtualJogo = 1;
        turnoAtualChefe = 1;
        turnoAtualJogador = 1;

        //Andamento do jogo - Só para no fim do jogo;
        while(!jogoAcabou){
            System.out.println("=============================================================");
            // 0 - Printar turno atual
            //System.out.println("Turno atual: " + turnoAtualJogo);
            //System.out.println("Local do personagem: " + jogador.getAreaAtual().getNome());
            //System.out.println("Local do boss: " + chefe.getAreaAtual().getNome());

            // 1 - identifica a área atual
            Area areaAtual = identificarAreaAtual();

            // 2 - verifica e executa ação desejada - interprete
            if(turnoAtualJogador <= turnoAtualJogo){

                // 3 - descreve a área e itens
                System.out.println(areaAtual.getDescricao());
                String comando = scanner.nextLine();
                interpreteJogador.interpretarString(comando);
            } else {
                System.out.println("O personagem ainda não finalizou a ação !");
            }

            // 4 - Realiza ações do chefe
           if(chefe != null && !jogoAcabou){
                if(turnoAtualChefe <= turnoAtualJogo){
                    chefe.agir();
                }
            }
            // 5 - Reseta os padrões de iluminação
            resetarIluminacaoPadrao(areaAtual);

           // 6 - Verifica se o jogador possui iluminação ligada
            jogador.verificarIluminacaoEmUso();

            // 7 - verifica controllers específicas
            executarControlador();

            // 8 - verificações de itens e outras coisas
            jogador.verificarItensEsgotadosOuQuebrados();

            // 9 - verifica se o jogo acabou
            if(jogoAcabou){
                if(vencedor) {
                    System.out.println("Parabéns, você venceu !");
                } else {
                    System.out.println("Fim de jogo.");
                }
            }

            System.out.println("\n\n\n\n");
            turnoAtualJogo++;
        }
    }

    public static JogoController getJogo() {
        if (jogo == null) {
            jogo = new JogoController();
        }

        return jogo;
    }

    public void executarControlador(){
        for(Controlador controlador : controladores){
            if(controlador.isHabilitado())
                controlador.executar();
        }
    }

    public void addControlador(Controlador controlador){
        this.controladores.add(controlador);
    }

    public void removerVida(Integer quantidade){
        Integer vidaAtual = jogador.getVida();
        jogador.setVida(vidaAtual - quantidade);
    }

    public void adicionarVida(Integer quantidade){
        Integer vidaAtual = jogador.getVida();
        jogador.setVida(vidaAtual + quantidade);
    }

    public void resetarIluminacaoPadrao(Area areaAtual){
        for(Area area: JogoController.getJogo().listarAreasJogo()){
            if(!areaAtual.equals(area)){
                if(area instanceof AreaIluminada){
                    AreaIluminada areaIluminada = (AreaIluminada) area;
                    areaIluminada.setIluminacaoAtual(areaIluminada.getIluminacaoPadrao());
                }
            }
        }
    }

    public Area getAreaAtualJogador(){
        return jogador.getAreaAtual();
    }

    public Item coletarItem(String nomeItemDesejado) {

        Area areaAtual = getJogo().identificarAreaAtual();
        Item itemColetado = null;

        if(areaAtual != null) {
            for(Item item : areaAtual.getItens()) {
                if(item.getNome().toLowerCase().contains(nomeItemDesejado.toLowerCase()) || nomeItemDesejado.toLowerCase().contains(item.getNome().toLowerCase())) {
                    itemColetado = item;
                }
            }

            if( itemColetado != null) {
                if(itemColetado.isColetavel()){
                    areaAtual.getItens().remove(itemColetado);
                    return itemColetado;
                } else {
                    System.out.println("Este não é um item coletável. Tente usá-lo mesmo assim !");
                }

            }

        } else {
            System.out.println("Erro desconhecido ao identificar área atual !");
        }

        return null;
    }

    public Area identificarAreaAtual(){
        Navegacao navegacao = new Navegacao();

        Vertice area = navegacao.buscaVertice(grafo, this.getAreaAtualJogador().getNome());

        if(area instanceof Area) {
            Area areaAtual = ((Area) area);
            return areaAtual;
        } else {
            System.out.println("Erro desconhecido ao identificar área atual !");
            return null;
        }
    }

    public void addArea(Area area){
        this.grafo.addVertice(area);
        SugestaoEscrita.addLocal(area.getNome());
    }

    public void conectarArea(int distancia, Area origem, Area destino, boolean caminhoBloqueado, ItemChavePorta chave){
        this.grafo.addAresta(distancia, origem, destino, caminhoBloqueado, chave);

    }

    public void conectarArea(Area origem, Area destino, boolean caminhoBloqueado, ItemChavePorta chave){
        this.grafo.addAresta(origem, destino, caminhoBloqueado, chave);

    }

    public void conectarArea(Area origem, Area destino, boolean caminhoBloqueado){
        this.grafo.addAresta(origem, destino, caminhoBloqueado);
    }


    public Item identificarItemInventario(String nomeItemDesejado) {

        for(Item item : jogador.getItens()) {
            if(item.getNome().toLowerCase().contains(nomeItemDesejado.toLowerCase()) || nomeItemDesejado.toLowerCase().contains(item.getNome().toLowerCase()) ) {
                return item;
            }
        }

        System.out.println("Este item não foi encontrado !");

        return null;
    }

    public void exibirInventario(){
        if(getJogador().getItens().size() == 0){
            System.out.println("O inventário está vazio !");
        } else {
            System.out.println(" ********************* INVENTÁRIO ********************* ");
            for(Item item: getJogador().getItens()){
                System.out.println(item.getNome() + ": " + item.getDescricao());
            }
            System.out.println(" ****************************************************** ");
        }
    }

    public void addItemJogador(Item e){
        jogador.getItens().add(e);
        System.out.println ("O item " + e.getNome() + " foi coletado com sucesso !");
    }

    public void atualizarAreaAtual(Area area){
        jogador.setAreaAtual(area);
    }

    public Area identificarAreaConectada(Area salaAtual, String salaFinal) {
        Navegacao navegacao = new Navegacao();

        Vertice verticeFinal = navegacao.retornarAreaConectada(salaAtual, salaFinal);

        if(verticeFinal != null && verticeFinal instanceof Area){
            Area areaFinal =  (Area) verticeFinal;

            return areaFinal;
        }

        return null;
    }

    public Integer identificaDistancia(Area salaAtual, Area areaDesejada) {
        Navegacao navegacao = new Navegacao();

        Aresta caminho = navegacao.retornarCaminhoConectado(salaAtual, areaDesejada);

        if(caminho != null){
            return caminho.getPeso();
        }

        return null;
    }

    public String desbloquearCaminho(ItemChavePorta chave){
        String nomeSalaDesbloqueada = null;

        for(Aresta sala: getAreaAtualJogador().getAdjacencias()){
            if(sala.getChaveCaminho() != null && sala.getChaveCaminho().equals(chave)){
                sala.setCaminhoBloqueado(false);
                nomeSalaDesbloqueada = sala.getDestino().getNome();
            }
        }

        return nomeSalaDesbloqueada;
    }

    public void imprimeMapaJogo(){
        grafo.imprimeGrafo();
    }

    public List<Area> listarAreasJogo(){
        List<Area> areas = new ArrayList<>();

        for(Vertice vertice: grafo.getVertices()){
            if(vertice instanceof Area){
                Area area = (Area) vertice;
                areas.add(area);
            }
        }

        return areas;
    }

    public Area perseguirJogador(){
        LinkedList<Vertice> caminho = Navegacao.menorCaminho(grafo, chefe.getAreaAtual(), jogador.getAreaAtual());

        Area areaAlvo = null;

        if(caminho != null){
            areaAlvo = (Area) caminho.get(1);
        }

       return areaAlvo;

    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void incrementarTurnosJogador(Integer turnosGastos){
        this.turnoAtualJogador += turnosGastos;
    }

    public void incrementarTurnosChefe(Integer turnosGastos){
        this.turnoAtualChefe += turnosGastos;
    }

    public void finalizarJogo(boolean vencedor, String mensagem){
        this.vencedor = vencedor;
        this.jogoAcabou = true;
        System.out.println(mensagem);
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Integer getTurnoAtualJogador() {
        return turnoAtualJogador;
    }

    public Integer getTurnoAtualChefe() {
        return turnoAtualChefe;
    }
}
