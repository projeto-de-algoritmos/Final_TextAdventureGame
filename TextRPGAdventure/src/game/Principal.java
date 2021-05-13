package game;

import engine.*;
import engine.area.Area;
import engine.area.AreaIluminada;
import engine.item.*;
import engine.personagem.Chefe;
import game.models.EstatuaControlador;
import game.models.item.*;
import game.servicos.Arquivo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Principal {

    public static void main(String[] args) throws Exception{

        System.out.println(" ************************** ESCAPE FROM THE END ************************** ");
        System.out.println(" Escapar de um lugar sombrio enquanto um inimigo terrível te persegue.\n Essa é sua tarefa. \n Algumas instruções antes de começar.");
        System.out.println(" Os seguintes comandos estão disponíveis pra você: ");
        System.out.println(" 1. Olhar ");
        System.out.println(" 2. Andar <local>");
        System.out.println(" 3. Usar <item>");
        System.out.println(" 4. Pegar <item>");
        System.out.println(" 5. Ler <item>");
        System.out.println(" 6. Inventario ");
        System.out.println(" Está pronto ? Claro que não... Boa sorte, você vai precisar. E não demore muito, ou o Fim chegará pra você. ");
        System.out.println(" Ora, claro que eu não sei dizer exatamente como você veio parar aqui. E nem posso te contar como sair, vai ter que descobrir sozinho. A velha mansão dos Scorbits, hein ? Espero que a maldita lenda não seja mesmo verdadeira.");
        System.out.println(" ************************************************************************* ");

        JogoController jogo = JogoController.getJogo();

        Estatua estatuaPeste = new Estatua("Estátua do Cavaleiro da Peste", "A estátua de um dos quatros cavaleiros do apocalipse, sem rosto. ", false, false,"Sem o rosto, é difícil fazer alguma coisa.");
        Estatua estatuaMorte = new Estatua("Estátua do Cavaleiro da Morte", "A estátua de um dos quatros cavaleiros do apocalipse, sem rosto. ", false, false, "Sem o rosto, é difícil fazer alguma coisa.");
        Estatua estatuaGuerra = new Estatua("Estátua do Cavaleiro da Guerra", "A estátua de um dos quatros cavaleiros do apocalipse, sem rosto. ", false, false, "Sem o rosto, é difícil fazer alguma coisa.");
        Estatua estatuaFome = new Estatua("Estátua do Cavaleiro da Fome", "A estátua de um dos quatros cavaleiros do apocalipse, sem rosto. ", false, false, "Sem o rosto, é difícil fazer alguma coisa.");

        List<Estatua> estatuas = new ArrayList<>();
        estatuas.add(estatuaFome);
        estatuas.add(estatuaMorte);
        estatuas.add(estatuaPeste);
        estatuas.add(estatuaGuerra);

        EstatuaControlador estatuaControlador = new EstatuaControlador(estatuas);
        jogo.addControlador(estatuaControlador);

        Mascara mascaraPeste = new Mascara("Máscara do Cavaleiro da Peste", "Uma das máscaras dos cavaleiros do apocalipse.", false, true, estatuaPeste,"A máscara encaixa perfeitamente, revelando o cavaleiro da Peste.","A estátua do cavaleiro da Peste.");
        Mascara mascaraMorte = new Mascara("Máscara do Cavaleiro da Morte", "Uma das máscaras dos cavaleiros do apocalipse.", false, true, estatuaMorte, "A máscara encaixa perfeitamente, revelando o cavaleiro da Morte.", "A estátua do cavaleiro da Morte.");
        Mascara mascaraGuerra = new Mascara("Máscara do Cavaleiro da Guerra", "Uma das máscaras dos cavaleiros do apocalipse.", false, true, estatuaGuerra, "A máscara encaixa perfeitamente, revelando o cavaleiro da Guerra.", "A estátua do cavaleiro da Guerra.");
        Mascara mascaraFome = new Mascara("Máscara do Cavaleiro da Fome", "Uma das máscaras dos cavaleiros do apocalipse.", false, true, estatuaFome, "A máscara encaixa perfeitamente, revelando o cavaleiro da Fome.", "A estátua do cavaleiro da Fome.");

        CaixaItem caixaMascaraMorte = new CaixaItem("Caixa dourada", "Uma grande caixa dourada.", false, true, "A caixa está trancada. Talvez a chave dela esteja por ai em algum lugar...", mascaraMorte);
        ItemChave chaveCaixaMascaraMorte = new ItemChave("Chave dourada", "Uma pequena chave dourada", false, true, caixaMascaraMorte, "A chave encaixa perfeitamente na caixa dourada, e um leve 'click' pode ser ouvido. Dentro, há uma máscara de um dos cavaleiros do apocalipse. A máscara da morte.");

        ItemChavePorta chaveSala1Para21 = new ItemChavePorta("Chave 1", "Uma chave para alguma porta trancada.", false, true);
        ItemChavePorta chaveSala12Para15 = new ItemChavePorta("Chave 2", "Uma chave para alguma porta trancada", false, true);

        Lanterna lanterna = new Lanterna("Lanterna", "Uma lanterna velha. Parece que ainda funciona.", false, true, false, 10);

        ItemDecorativo cadaverSala4 = new ItemDecorativo("Cadáver Homem", "Um cadáver completamente estraçalhado. Há marcas de garras por todo o corpo, e o rosto está completamente desfigurado.", false, false);
        ItemDecorativo cadaver2Sala4 = new ItemDecorativo("Cadáver Feminino", "Um cadáver completamente estraçalhado. Há marcas de garras por todo o corpo, e o está completamente rosto desfigurado. Um dos braços foi arrancado.", false, false);
        ItemDecorativo cadaverSala8 = new ItemDecorativo("Cadáver", "Um cadáver completamente submerso no sangue, com excessão de sua mão pendendo na parede lateral da banheira. Pobre coitado...", false, false);
        ItemDecorativo cadaverSala9 = new ItemDecorativo("Cadáver Cachorro", "Os restos do cachorro da família podem ser encontrados em cima do sofá.", false, false);
        ItemDecorativo cadaverSala16 = new ItemDecorativo("Cadáver Criança", "Um cadáver infantil repousa sobre o berço. Se você não visse o sangue, daria pra achar que está dormindo...", false, false);
        ItemDecorativo cadaverSala23 = new ItemDecorativo("Cadáver", "Um cadáver desmembrado espatifado no chão. Quem sabe onde estão os outros membros...", false, false);
        ItemDecorativo cadaverSala27 = new ItemDecorativo("Cadáver Homem", "Um cadáver esfaqueado até a morte. Foi tão picotado que Jack, o Estripador, estaria orgulhoso...", false, false);

        ItemLegivel diarioSala1 = new ItemLegivel("Página diário 0", "Uma velha página de papel com algo escrito", false, true, Arrays.asList("'As estátuas divinas... A única forma de escaparmos agora. Não sei se terei tempo, mas se encontrar esse bilhete, ache os quatro rostos, e estará livre.'"));
        ItemLegivel diarioSala2 = new ItemLegivel("Página diário 1", "Uma velha página de papel com algo escrito",false, true, Arrays.asList("'Ah, quem dera Lincoln me desse bola... Já fiz de tudo, mas o maldito não me nota. Terei que apelar para meus dotes sedutores mais poderosos.'"));
        ItemLegivel diarioSala13 = new ItemLegivel("Página diário 2", "Uma velha página de papel com algo escrito",false, true, Arrays.asList("'Morfeu, onde diabos está minha chave ?? Sabe que é importante para momentos de crise. Espero que não tenha levado pra sessão reservada...'"));
        ItemLegivel diarioSala15 = new ItemLegivel("Página diário 3", "Uma velha página de papel com algo escrito",false, true, Arrays.asList("'Rose, minha cara... Parece que a maldição da família voltou para nos assombrar. Se achar isso em algum momento, fuja o mais rápido que puder e queime a casa.'"));
        ItemLegivel diarioSala18 = new ItemLegivel("Página diário 4", "Uma velha página de papel com algo escrito",false, true, Arrays.asList("'A alguns dias esse cheiro horrendo vem saindo do banheiro e eu tenho certeza de ter visto algo no armário... Vamos isolar esse quarto imediatamente, papai está preocupado.'"));
        ItemLegivel diarioSala29 = new ItemLegivel("Página diário 5", "Uma velha página de papel com algo escrito",false, true, Arrays.asList("'Ele está a solta, eu não acreditei de forma alguma .... Como é possivel ?! Era só uma maldita lenda dessa família !!'"));

        Area sala1 = new Area ("Hall de Entrada da Mansão", "O Hall de entrada da Mansão abandonada. Além do chão empoeirado, e o teto extremamente alto, é possível notar quatro estátuas grandes dispostas no centro da sala, que não possuem rosto.");
        Area sala2 = new Area ("Quarto 2", "Um quarto abandonado, com roupas de camas poíadas e cheias de poeira. Há pedaços de vidro quebrado próximas ao criado-mudo, e bastante roupas espalhadas pelo chão. Alguém saiu daqui com bastante pressa.");
        Area sala3 = new Area ("Quarto 1", "Um quarto extremamente arrumado, com roupas de camas de cor rosa bem limpas e conservadas. Aparentemente, alguém esteve arrumando esse quarto recentemente. Entretanto, há pegadas de lama no chão em direção a porta de onde você veio.");
        AreaIluminada sala4 = new AreaIluminada ("Sala Visita", "A Sala de Visitas, um local de comunhão e amizades. Entretanto, esse lugar está bastante decrépito. Há sangue espalhados nas paredes e no chão.", false, "A sala está muita escura para enxergar alguma coisa. Alguma fonte de luz poderia ajudar...");
        Area sala5 = new Area ("Closet 1", "Um closet cheio de roupas em bom estado. Não parece ter sujeira por aqui.");
        Area sala6 = new Area ("Banheiro 1", "Um banheiro impecável de limpo, e com cheiro de desinfetante no ar.");
        Area sala7 = new Area ("Fundos da Biblioteca", "Parte dos fundos da biblioteca, abarrotada de livros empilhados e estantes mal organizadas.");
        AreaIluminada sala8 = new AreaIluminada ("Banheiro 2", "Um banheiro completamente imundo, com uma banheira inundada de sangue.", false, "A sala está muita escura para enxergar alguma coisa. Alguma fonte de luz poderia ajudar...");
        Area sala9 = new Area ("Salão Central", "O imenso salão central, símbolo da mansão nas diversas fotos da família. No momento, os móveis estão completamente destruídos e há lama e sangue espalhados por toda parte.");
        Area sala10 = new Area ("Banheiro 7", "O grande banheiro do centro da casa. Não há nada demais aqui, além de um pouco de lama.");
        Area sala11 = new Area ("Corredor 1", "Um longo corredor com portas para vários lados. Pegadas de lama e sangue entram e saem de vários desses lugares.");
        AreaIluminada sala12 = new AreaIluminada ("Biblioteca - Área Principal", "A grande biblioteca, onde estão estantes e mais estantes com livros, a perder de vista. Que lugar extraordinário. E surpreendentemente arrumado.", false, "A sala está muita escura para enxergar alguma coisa. Alguma fonte de luz poderia ajudar...");
        Area sala13 = new Area ("Biblioteca - Área de Leitura", "Mesas longas de madeira e diversas cadeiras, a área de concentração máxima. Há alguns óculos e relógios velhos repousando sobre as mesas, e bastante poeira. Ainda assim, está bem melhor que o resto da casa.");
        Area sala14 = new Area ("Banheiro 5", "Um banheiro limpo e conservado.");
        Area sala15 = new Area ("Biblioteca - Sessão Reservada", "Uma sessão secreta, trancada e protegida ? Que discreto. Nem devem existir segredos guardados aqui, não é mesmo ? ");
        Area sala16 = new Area ("Quarto 4", "Um quarto com decoração bastante infantil. Um berço quebrado, brinquedos esmagados e sangue. Que crueldade...");
        AreaIluminada sala17 = new AreaIluminada ("Banheiro 4", "Um banheiro cheio de lama, até as paredes, e pedaços de porcelana quebrada no chão. Alguém comeu algo que não fez bem...", false, "A sala está muita escura para enxergar alguma coisa. Alguma fonte de luz poderia ajudar...");
        Area sala18 = new Area ("Quarto 5", "Um quarto cheio de lama, e com um cheiro horroroso. Os lençóis estão completamente sujos.");
        Area sala19 = new Area ("Quarto 3", "Um quarto infantil, sem manchas de sangue ou lama. Até o corredor para ele parecia limpo... Talvez esteja vazio a algum tempo.");
        Area sala20 = new Area ("Banheiro 3", "Um banheiro bem infatil e colorido, bastante limpo e cheiroso.");
        Area sala21 = new Area ("Corredor Anexo 2", "Este corredor trancado está cheio de fumaça.. É díficil até de enxergar o que tem do outro lado. E parece estar tão quente...");
        Area sala22 = new Area ("Sala de Jantar", "A imensa sala de jantar da família, agora transformada em um lugar completamente carbonizado. As paredes estão pretas, e há corpos queimados sobre a mesa e sobre as cadeiras. Um churrasco da maldade...");
        Area sala23 = new Area ("Área de Serviço", "A área de serviço, completamente suja de sangue e lama.");
        Area sala24 = new Area ("Cozinha", "A grande cozinha da mansão, também carbonizada. Há até resquícios de fogo entre os armários de madeira. Este lugar não vai aguentar muito tempo.");
        Area sala25 = new Area ("Banheiro 6", "Um banheiro cheio de fumaça e lama.");
        Area sala26 = new Area ("Despensa 2", "Uma despensa completamente revirada, com comida derramada sobre o chão, restos pisoteados e sangue. Muito sangue.");
        AreaIluminada sala27 = new AreaIluminada ("Dispensa 1", "Uma despensa completamente revirada, com comida derramada sobre o chão, restos pisoteados e sangue.", false, "A sala está muita escura para identificar qualquer coisa aqui.");
        Area sala28 = new Area ("Corredor 3", "Um longo corredor com portas para vários lados. Pegadas de lama e sangue entram e saem de vários desses lugares.");
        AreaIluminada sala29 = new AreaIluminada ("Sótão", "O Sótão, depósito superior. É difícil andar aqui com tanto sangue nos pés.", false, "A sala está muita escura para enxergar alguma coisa. Alguma fonte de luz poderia ajudar...");
        AreaIluminada sala30 = new AreaIluminada ("Bunker", "O Bunker secreto, para proteger a família dos desastres. Talvez não tenha adiantado.", false, "A sala está muita escura para enxergar alguma coisa. Alguma fonte de luz poderia ajudar...");
        AreaIluminada sala31 = new AreaIluminada ("Jardim dos Fundos", "Um belo jardim intocado. Mesmo na noite fria, é o lugar mais bonito que alguém poderia vislumbrar. Quem profanaria tamanha beleza ?", false, "A sala está muita escura para enxergar alguma coisa. Alguma fonte de luz poderia ajudar...");

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
        jogo.conectarArea(sala1, sala21, true, chaveSala1Para21);
        jogo.conectarArea(sala1, sala9, false);

        sala1.addItem(estatuaFome);
        sala1.addItem(estatuaGuerra);
        sala1.addItem(estatuaMorte);
        sala1.addItem(estatuaPeste);

        sala1.addItem(diarioSala1);

        /* SALA 2*/
        jogo.conectarArea(sala2, sala1, false);
        jogo.conectarArea(sala2, sala5, false);
        jogo.conectarArea(sala2, sala8, false);
        sala2.addItem(diarioSala2);

        /* SALA 3*/
        jogo.conectarArea(sala3, sala1, false);
        jogo.conectarArea(sala3, sala6, false);
        sala3.addItem(lanterna);

        /* SALA 4*/
        jogo.conectarArea(sala4, sala9, false);
        jogo.conectarArea(sala4, sala11, false);
        sala4.addItem(mascaraPeste);
        sala4.addItem(cadaverSala4);
        sala4.addItem(cadaver2Sala4);

        /* SALA 5*/
        jogo.conectarArea(sala5, sala2, false);

        /* SALA 6*/
        jogo.conectarArea(sala6, sala3, false);
        sala6.addItem(chaveCaixaMascaraMorte);

        /* SALA 7*/
        jogo.conectarArea(sala7, sala13, false);

        /* SALA 8*/
        jogo.conectarArea(sala8, sala2, false);
        sala8.addItem(cadaverSala8);

        /* SALA 9*/
        jogo.conectarArea(sala9, sala1, false);
        jogo.conectarArea(sala9, sala10, false);
        jogo.conectarArea(sala9, sala4, false);
        sala9.addItem(cadaverSala9);

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
        jogo.conectarArea(sala12, sala15, true, chaveSala12Para15);

        sala12.addItem(mascaraGuerra);


        /* SALA 13*/
        jogo.conectarArea(sala13, sala12, false);
        jogo.conectarArea(sala13, sala7, false);
        sala13.addItem(diarioSala13);

        /* SALA 14*/
        jogo.conectarArea(sala14, sala12, false);

        /* SALA 15*/
        jogo.conectarArea(sala15, sala12, false);
        sala15.addItem(mascaraPeste);
        sala15.addItem(diarioSala15);

        /* SALA 16*/
        jogo.conectarArea(sala16, sala11, false);
        sala16.addItem(cadaverSala16);

        /* SALA 17*/
        jogo.conectarArea(sala17, sala18, false);

        /* SALA 18*/
        jogo.conectarArea(sala18, sala17, false);
        sala18.addItem(diarioSala18);

        /* SALA 19*/
        jogo.conectarArea(sala19, sala11, false);
        jogo.conectarArea(sala19, sala20, false);

        /* SALA 20*/
        jogo.conectarArea(sala20, sala19, false);
        sala20.addItem(chaveSala1Para21);

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
        sala23.addItem(cadaverSala23);

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
        sala27.addItem(cadaverSala27);

        /* SALA 28*/
        jogo.conectarArea(sala28, sala29, false);
        jogo.conectarArea(sala28, sala30, false);
        jogo.conectarArea(sala28, sala24, false);

        /* SALA 29*/
        jogo.conectarArea(sala29, sala28, false);
        sala29.addItem(diarioSala29);

        /* SALA 30*/
        jogo.conectarArea(sala30, sala28, false);
        sala30.addItem(caixaMascaraMorte);


        /* SALA 31*/
        jogo.conectarArea(sala31, sala22, false);
        sala31.addItem(chaveSala12Para15);


        System.out.println("\n\n\n");

        /*
        try {
            Arquivo.imprimeImagemAscii("lanterna");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        Chefe theEnd = new Chefe("The End", 30, sala31);
        jogo.iniciarJogo("Caio", 15, sala1, theEnd);

    }


}
