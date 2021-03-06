package engine.services;

public enum Acao {


    OLHAR(new String[]{"olhar"}, TipoAcao.OLHAR),
    PEGAR(new String[]{"pegar", "catar", "segurar", "coletar"}, TipoAcao.PEGAR),
    ANDAR(new String[]{"andar", "mover", "locomover", "ir"}, TipoAcao.ANDAR),
    USAR(new String[]{"usar", "utilizar"}, TipoAcao.USAR),
    LER(new String[]{"ler", "folhear"}, TipoAcao.LER),
    INVENTARIO(new String[]{"inventario", "itens", "obtidos"}, TipoAcao.INVENTARIO),
    COMANDOS(new String[]{"comandos", "tutorial", "ações", "opções"}, TipoAcao.COMANDOS),
    NADA(new String[]{" "}, TipoAcao.NADA);

    private String[] aliases;
    private TipoAcao tipoAcao;

    Acao(String[] aliases, TipoAcao tipo){
        this.aliases = aliases;
        this.tipoAcao = tipo;
    }

    public String[] getAliases() {
        return aliases;
    }

    public TipoAcao getTipoAcao() {
        return tipoAcao;
    }
}
