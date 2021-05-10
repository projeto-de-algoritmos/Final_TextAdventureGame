package game;

import game.models.Area;
import game.models.Chefe;
import game.models.Imagens;
import game.models.JogoController;
import game.models.item.*;
import game.servicos.Arquivo;
import grafo.Grafo;
import grafo.Vertice;
import grafo.navegacao.Navegacao;
import services.SugestaoEscrita;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Principal {

    public static void main(String[] args) throws Exception{

        JogoController jogo = JogoController.getJogo();

        Estatua estatuaPeste = new Estatua("Estátua do Cavaleiro da Peste", "A estátua de um dos quatros cavaleiros do apocalipse, sem rosto. ", false, "Sem o rosto, é difícil fazer alguma coisa.");
        Estatua estatuaMorte = new Estatua("Estátua do Cavaleiro da Morte", "A estátua de um dos quatros cavaleiros do apocalipse, sem rosto. ", false, "Sem o rosto, é difícil fazer alguma coisa.");
        Estatua estatuaGuerra = new Estatua("Estátua do Cavaleiro da Guerra", "A estátua de um dos quatros cavaleiros do apocalipse, sem rosto. ", false, "Sem o rosto, é difícil fazer alguma coisa.");
        Estatua estatuaFome = new Estatua("Estátua do Cavaleiro da Fome", "A estátua de um dos quatros cavaleiros do apocalipse, sem rosto. ", false, "Sem o rosto, é difícil fazer alguma coisa.");

        ItemChave mascaraPeste = new ItemChave("Máscara do Cavaleiro da Peste", "Uma das máscaras dos cavaleiros do apocalipse.", false, estatuaPeste, "A máscara encaixa perfeitamente, revelando o cavaleiro da Peste.");
        ItemChave mascaraMorte = new ItemChave("Máscara do Cavaleiro da Morte", "Uma das máscaras dos cavaleiros do apocalipse.", false, estatuaMorte, "A máscara encaixa perfeitamente, revelando o cavaleiro da Morte.");
        ItemChave mascaraGuerra = new ItemChave("Máscara do Cavaleiro da Guerra", "Uma das máscaras dos cavaleiros do apocalipse.", false, estatuaGuerra, "A máscara encaixa perfeitamente, revelando o cavaleiro da Guerra.");
        ItemChave mascaraFome = new ItemChave("Máscara do Cavaleiro da Fome", "Uma das máscaras dos cavaleiros do apocalipse.", false, estatuaFome, "A máscara encaixa perfeitamente, revelando o cavaleiro da Fome.");

        CaixaItem caixaMascaraMorte = new CaixaItem("Caixa dourada", "Uma grande caixa dourada.", false, "A caixa está trancada. Talvez a chave dela esteja por ai em algum lugar...", mascaraMorte);
        ItemChave chaveCaixaMascaraMorte = new ItemChave("Chave dourada", "Uma pequena chave dourada", false, caixaMascaraMorte, "A chave encaixa perfeitamente na caixa dourada, e um leve 'click' pode ser ouvido. Dentro, há uma máscara de um dos cavaleiros do apocalipse. A máscara da morte.");

        //ItemChavePorta chaveSala2 = new ItemChavePorta("Chave 1", "Uma chave para alguma porta trancada.", false);

        Area sala1 = new Area ("Hall de Entrada da Mansão", "O Hall de entrada da Mansão abandonada. Além do chão empoeirado, e o teto extremamente alto, é possível notar quatro estátuas grandes dispostas no centro da sala, que não possuem rosto.");
        Area sala2 = new Area ("Sala 2", "Descrição Sala 2");
        Area sala3 = new Area ("Sala 3", "Descrição Sala 3");
        Area sala4 = new Area ("Sala 4", "Descrição Sala 4");
        Area sala5 = new Area ("Sala 5", "Descrição Sala 5");
        Area sala6 = new Area ("Sala 6", "Descrição Sala 6");
        Area sala7 = new Area ("Sala 7", "Descrição Sala 7");
        Area sala8 = new Area ("Sala 8", "Descrição Sala 8");
        Area sala9 = new Area ("Sala 9", "Descrição Sala 9");
        Area sala10 = new Area ("Sala 10", "Descrição Sala 10");
        Area sala11 = new Area ("Sala 11", "Descrição Sala 11");
        Area sala12 = new Area ("Sala 12", "Descrição Sala 12");
        Area sala13 = new Area ("Sala 13", "Descrição Sala 13");
        Area sala14 = new Area ("Sala 14", "Descrição Sala 14");
        Area sala15 = new Area ("Sala 15", "Descrição Sala 15");
        Area sala16 = new Area ("Sala 16", "Descrição Sala 16");
        Area sala17 = new Area ("Sala 17", "Descrição Sala 17");
        Area sala18 = new Area ("Sala 18", "Descrição Sala 18");
        Area sala19 = new Area ("Sala 19", "Descrição Sala 19");
        Area sala20 = new Area ("Sala 20", "Descrição Sala 20");
        Area sala21 = new Area ("Sala 21", "Descrição Sala 21");
        Area sala22 = new Area ("Sala 22", "Descrição Sala 22");
        Area sala23 = new Area ("Sala 23", "Descrição Sala 23");
        Area sala24 = new Area ("Sala 24", "Descrição Sala 24");
        Area sala25 = new Area ("Sala 25", "Descrição Sala 25");
        Area sala26 = new Area ("Sala 26", "Descrição Sala 26");
        Area sala27 = new Area ("Sala 27", "Descrição Sala 27");
        Area sala28 = new Area ("Sala 28", "Descrição Sala 28");
        Area sala29 = new Area ("Sala 29", "Descrição Sala 29");
        Area sala30 = new Area ("Sala 30", "Descrição Sala 30");
        Area sala31 = new Area ("Sala 31", "Descrição Sala 31");

        jogo.addArea(sala1);
        jogo.addArea(sala2);
        jogo.addArea(sala3);
        jogo.addArea(sala4);
        jogo.addArea(sala5);
        jogo.addArea(sala6);
        jogo.addArea(sala7);
        jogo.addArea(sala8);
        jogo.addArea(sala9);
        jogo.addArea(sala10);
        jogo.addArea(sala11);
        jogo.addArea(sala12);
        jogo.addArea(sala13);
        jogo.addArea(sala14);
        jogo.addArea(sala15);
        jogo.addArea(sala16);
        jogo.addArea(sala17);
        jogo.addArea(sala18);
        jogo.addArea(sala19);
        jogo.addArea(sala20);
        jogo.addArea(sala21);
        jogo.addArea(sala22);
        jogo.addArea(sala23);
        jogo.addArea(sala24);
        jogo.addArea(sala25);
        jogo.addArea(sala26);
        jogo.addArea(sala27);
        jogo.addArea(sala28);
        jogo.addArea(sala29);
        jogo.addArea(sala30);
        jogo.addArea(sala31);

        /* SALA 1*/
        jogo.conectarArea(sala1, sala2, false);
        jogo.conectarArea(sala1, sala3, false);
        jogo.conectarArea(sala1, sala21, false);
        jogo.conectarArea(sala1, sala9, false);

        sala1.addItem(estatuaFome);
        sala1.addItem(estatuaGuerra);
        sala1.addItem(estatuaMorte);
        sala1.addItem(estatuaPeste);

        /* SALA 2*/
        jogo.conectarArea(sala2, sala1, false);
        jogo.conectarArea(sala2, sala5, false);
        jogo.conectarArea(sala2, sala8, false);

        /* SALA 3*/
        jogo.conectarArea(sala3, sala1, false);
        jogo.conectarArea(sala3, sala6, false);

        /* SALA 4*/
        jogo.conectarArea(sala4, sala9, false);
        jogo.conectarArea(sala4, sala11, false);
        sala4.addItem(mascaraPeste);

        /* SALA 5*/
        jogo.conectarArea(sala5, sala2, false);

        /* SALA 6*/
        jogo.conectarArea(sala6, sala3, false);
        sala6.addItem(chaveCaixaMascaraMorte);


        /* SALA 7*/
        jogo.conectarArea(sala7, sala13, false);

        /* SALA 8*/
        jogo.conectarArea(sala8, sala2, false);

        /* SALA 9*/
        jogo.conectarArea(sala9, sala1, false);
        jogo.conectarArea(sala9, sala10, false);
        jogo.conectarArea(sala9, sala4, false);

        /* SALA 10*/
        jogo.conectarArea(sala10, sala9, false);

        /* SALA 11*/
        jogo.conectarArea(sala11, sala4, false);
        jogo.conectarArea(sala11, sala19, false);
        jogo.conectarArea(sala11, sala16, false);
        jogo.conectarArea(sala11, sala18, false);
        jogo.conectarArea(sala11, sala12, false);

        /* SALA 12*/
        jogo.conectarArea(sala12, sala11, false);
        jogo.conectarArea(sala12, sala13, false);
        jogo.conectarArea(sala12, sala14, false);
        jogo.conectarArea(sala12, sala15, false);

        sala12.addItem(mascaraGuerra);


        /* SALA 13*/
        jogo.conectarArea(sala13, sala12, false);
        jogo.conectarArea(sala13, sala7, false);

        /* SALA 14*/
        jogo.conectarArea(sala14, sala12, false);

        /* SALA 15*/
        jogo.conectarArea(sala15, sala12, false);

        /* SALA 16*/
        jogo.conectarArea(sala16, sala11, false);

        /* SALA 17*/
        jogo.conectarArea(sala17, sala18, false);

        /* SALA 18*/
        jogo.conectarArea(sala18, sala17, false);

        /* SALA 19*/
        jogo.conectarArea(sala19, sala11, false);
        jogo.conectarArea(sala19, sala20, false);

        /* SALA 20*/
        jogo.conectarArea(sala20, sala19, false);

        /* SALA 21*/
        jogo.conectarArea(sala21, sala1, false);
        jogo.conectarArea(sala21, sala22, false);

        /* SALA 22*/
        jogo.conectarArea(sala22, sala21, false);
        jogo.conectarArea(sala22, sala25, false);
        jogo.conectarArea(sala22, sala24, false);
        jogo.conectarArea(sala22, sala31, false);

        /* SALA 23*/
        jogo.conectarArea(sala23, sala24, false);

        /* SALA 24*/
        jogo.conectarArea(sala24, sala23, false);
        jogo.conectarArea(sala24, sala26, false);
        jogo.conectarArea(sala24, sala27, false);
        jogo.conectarArea(sala24, sala22, false);
        jogo.conectarArea(sala24, sala28, false);

        /* SALA 25*/
        jogo.conectarArea(sala25, sala22, false);

        /* SALA 26*/
        jogo.conectarArea(sala26, sala24, false);

        /* SALA 27*/
        jogo.conectarArea(sala27, sala24, false);
        sala27.addItem(mascaraFome);


        /* SALA 28*/
        jogo.conectarArea(sala28, sala29, false);
        jogo.conectarArea(sala28, sala30, false);
        jogo.conectarArea(sala28, sala24, false);

        /* SALA 29*/
        jogo.conectarArea(sala29, sala28, false);

        /* SALA 30*/
        jogo.conectarArea(sala30, sala28, false);
        sala30.addItem(caixaMascaraMorte);


        /* SALA 31*/
        jogo.conectarArea(sala31, sala22, false);


        System.out.println("\n\n\n");

    /*
        try {
            Arquivo.imprimeImagemAscii("olhos");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    */
        jogo.iniciarJogo("Caio", 15, sala1, null);

    }


}