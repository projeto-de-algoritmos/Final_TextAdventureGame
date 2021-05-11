package game.models;

// Classe responsável por permitir a criação de trechos de código independentes da estrutura padrão que serão executados em todos os laços do gaming loop.
// O método executar será rodado e o código será executado.
// Para que os controladores sejam executados, adicione-os no JogoController com o método addControlador().

public abstract class Controlador {

    private boolean habilitado = true;

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public abstract void executar();
}
