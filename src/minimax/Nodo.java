package minimax;

import java.util.ArrayList;

public class Nodo {
	private Estado estado;
	private ETipoNodo tipoNodo;
	private ArrayList<Nodo> arrayNodoFilho;
	
	private int nivelAtualNaArvore;
	private int nivelMaxADescerNaArvore;
	
	public Nodo(ETipoNodo tipoNodo, int nivelAtualNaArvore, int nivelMaxADescerNaArvore, Estado estado) {
		this.estado = estado;
		this.tipoNodo = tipoNodo;
		this.arrayNodoFilho = new ArrayList<Nodo>();
		
		this.nivelAtualNaArvore = nivelAtualNaArvore;
		this.nivelMaxADescerNaArvore = nivelMaxADescerNaArvore;
	}
	
	public void addNodoFilho(Nodo nodoFilho) {
		this.arrayNodoFilho.add(nodoFilho);
	}
	public void setTipoNodo(ETipoNodo tipoNodo) {
		this.tipoNodo = tipoNodo;
	}
	
	public ArrayList<Nodo> getArrayNodoFilho() {
		return this.arrayNodoFilho;
	}
	public ETipoNodo getTipoNodo() {
		return this.tipoNodo;
	}
}
