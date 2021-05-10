package grafo;


import game.models.item.ItemChave;
import game.models.item.ItemChavePorta;

public class Aresta {

	private int peso;
	private Vertice origem;
	private Vertice destino;
	private boolean caminhoBloqueado;
	private ItemChavePorta chaveCaminho;

	public Aresta(int peso, Vertice origem, Vertice destino, boolean caminhoBloqueado){
		this.peso = peso;
		this.origem = origem;
		this.destino = destino;
		this.caminhoBloqueado = caminhoBloqueado;
		this.chaveCaminho = null;
	}

	public Aresta(int peso, Vertice origem, Vertice destino, boolean caminhoBloqueado, ItemChavePorta chaveCaminho){
		this.peso = peso;
		this.origem = origem;
		this.destino = destino;
		this.caminhoBloqueado = caminhoBloqueado;
		this.chaveCaminho = chaveCaminho;
	}

	public int getPeso() {
		return peso;
	}

	public Vertice getOrigem() {
		return origem;
	}

	public Vertice getDestino() {
		return destino;
	}

	public boolean isCaminhoBloqueado() {
		return caminhoBloqueado;
	}

	public ItemChavePorta getChaveCaminho() {
		return chaveCaminho;
	}

	public void setCaminhoBloqueado(boolean caminhoBloqueado) {
		this.caminhoBloqueado = caminhoBloqueado;
	}
}
