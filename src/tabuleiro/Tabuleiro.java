package tabuleiro;

import interfaceGrafica.Window;
import jogada.Jogada;

public class Tabuleiro {
	private Jogador jogadorNaVez;
	private Jogador[][] tabuleiro;
	private boolean jogoEmAndamento;
	private VerificarVitoria verificarVitoria;
	
	public Tabuleiro() {
		this.jogoEmAndamento = true;
		this.jogadorNaVez = Jogador.HUMANO;
		
		this.tabuleiro = new Jogador[15][15];
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				this.tabuleiro[i][j] = null;
			}
		};
		
		this.verificarVitoria = new VerificarVitoria(this);
	}
	
	public boolean realizarJogada(Jogada jogada) {
		if (this.verificarJogadaValida(jogada)) {
			int posX, posY;
			posX = jogada.getX();
			posY = jogada.getY();
			
			this.tabuleiro[posX][posY] = this.jogadorNaVez;
			
			if (this.verificarVitoria.verificarVitoria( new Jogada(this.jogadorNaVez, jogada.getX(), jogada.getY()) )) {//jogada)) {
				Window.informarVencedor(jogadorNaVez);
				this.jogoEmAndamento = false;
			}
			this.alterarJogadorNaVez();
			
			return true;
		}
		
		return false;
	}
	public Jogador getCelula(int x, int y) {
		return this.tabuleiro[x][y];
	}
	public boolean jogoEmAndamento() {
		return this.jogoEmAndamento;
	}
	private void alterarJogadorNaVez() {
		if (this.jogadorNaVez == Jogador.HUMANO) {
			this.jogadorNaVez = Jogador.MAQUINA;
		} else {
			this.jogadorNaVez = Jogador.HUMANO;
		}
	}
	private boolean verificarJogadaValida(Jogada jogada) {
		int xJogada, yJogada;
		xJogada = jogada.getX();
		yJogada = jogada.getY();
		
		if (xJogada < 0 || xJogada > 14 || yJogada < 0 || yJogada > 14) {
			return false;
		}
		
		if (!this.jogoEmAndamento()) {
			return false;
		}
		if (jogada.getJogador() != this.jogadorNaVez) {
			//return false;
		}
		if (this.tabuleiro[xJogada][yJogada] != null) {
			return false;
		}
		
		return true;
	}
}
