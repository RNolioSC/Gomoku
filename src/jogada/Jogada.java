package jogada;

import tabuleiro.Jogador;

public class Jogada {
	private Jogador jogador;
	private int x, y;
	
	public Jogada(Jogador jogador, int x, int y) {
		this.jogador = jogador;
		
		this.x = x;
		this.y = y;
	}
	
	public Jogador getJogador() {
		return this.jogador;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	
	public boolean sucessor(Jogada jogada) {
		if (jogada.x < this.x) {
			return true;
		}
		if (jogada.x > this.x) {
			return false;
		}
		if (jogada.y < this.y) {
			return true;
		}
		
		return false;
	}
}
