package lista;

import jogada.Jogada;

public class ListaJogada {
	private ItemLista first;
	private int size;
	
	public ListaJogada() {
		this.first = null;
		this.size = 0;
	}
	public void add(Jogada jogada) {
		ItemLista itemJogada;
		itemJogada = new ItemLista(jogada);
		
		this.size++;
		
		if (this.first == null) {
			this.first = itemJogada;
			return;
		}
		
		this.first.addItemEmOrdem(itemJogada);
	}
	public int size() {
		return this.size;
	}
	public ItemLista getFirstItem() {
		return this.first;
	}
}
