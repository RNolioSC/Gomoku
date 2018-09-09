package lista;

import jogada.Jogada;

public class ItemLista {
	private ItemLista proximo;
	private Jogada jogada;
	
	public ItemLista(Jogada jogada) {
		this.proximo = null;
		this.jogada = jogada;
	}
	public ItemLista addItemEmOrdem(ItemLista itemLista) {
		if (itemLista.sucessor(this)) {
			this.proximo = itemLista;
			return this;
		}
		
		itemLista.proximo = this;
		return itemLista;
	}
	
	private boolean sucessor(ItemLista itemLista) {
		return this.jogada.sucessor(itemLista.jogada);
	}
}
