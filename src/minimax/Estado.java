package minimax;

import tabuleiro.Jogada;

public class Estado {
	private EEstado tipoEstado;
	
	private int nivelAtualNaArvore;
	private int nivelMaxADescerNaArvore;
	
	private boolean[][] matrizTabuleiro;
	private Jogada jogada;
	
	private int valorHeuristico;
	private int valorAlfa;
	private int valorBeta;
	
	public Estado(boolean[][] matrizTabuleiro, EEstado tipoEstado) {
		this.matrizTabuleiro = matrizTabuleiro;
		
		this.valorAlfa = -999999999;
		this.valorBeta = 999999999;
		this.valorHeuristico = -999999999;
		
		this.tipoEstado = tipoEstado;
		
		this.nivelAtualNaArvore = -1;
		this.nivelMaxADescerNaArvore = -1;
	}
	
	public void setJogada(Jogada jogada) {
		this.jogada = jogada;
	}
	public void setValorHeuristico(int valorHeuristico) {
		this.valorHeuristico = valorHeuristico;
	}
	public void setValorAlfa(int valorAlfa) {
		this.valorAlfa = valorAlfa;
	}
	public void setValorBeta(int valorBeta) {
		this.valorBeta = valorBeta;
	}
	public void setTipoEstado(EEstado tipoEstado) {
		this.tipoEstado = tipoEstado;
	}
	public void setNivelAtualNaArvore(int nivelAtualNaArvore) {
		this.nivelAtualNaArvore = nivelAtualNaArvore;
	}
	public void setNivelMaxADescerNaArvore(int nivelMaxADescerNaArvore) {
		this.nivelMaxADescerNaArvore = nivelMaxADescerNaArvore;
	}
	
	public int getValorHeuristico() {
		return this.valorHeuristico;
	}
	public int getValorAlfa() {
		return this.valorAlfa;
	}
	public int getValorBeta() {
		return this.valorBeta;
	}
	public EEstado getTipoEstado() {
		return this.tipoEstado;
	}
	public int getNivelAtualNaArvore() {
		return this.nivelAtualNaArvore;
	}
	public int getNivelMaxADescerNaArvore() {
		return this.nivelMaxADescerNaArvore;
	}
	
	public void calcularValorHeuristico(int valorHeuristicoDoPai) {
		
	}
	
	public void criarEstadosFilho() {
		for (int k = 0; k <= 7; k++) {
			for (int i = -k; i <= k; i++) {
				if (!this.matrizTabuleiro[7+i][7-k]) {
					this.criarJogada(7+i, 7-k);
				}
				
				if (!this.matrizTabuleiro[7+i][7+k]) {
					this.criarJogada(7+i, 7+k);
				}
				
				if (i != -k && i != k) {
					if (!this.matrizTabuleiro[7-k][7+i]) {
						this.criarJogada(7-k, 7+i);
					}
					
					if (!this.matrizTabuleiro[7+k][7+i]) {
						this.criarJogada(7+k, 7+i);
					}
				}
			}
		}
	}
	
	private Jogada criarJogada(int linha, int coluna) {
		Jogada jogadaNova;
		jogadaNova = new Jogada(null, linha, coluna);
		
		EEstado tipoEstadoNovo;
		if (this.tipoEstado == EEstado.MAX) {
			tipoEstadoNovo = EEstado.MIN;
		} else {
			tipoEstadoNovo = EEstado.MAX;
		}
		
		Estado estadoNovo;
		estadoNovo = new Estado(matrizTabuleiro, tipoEstadoNovo);
		estadoNovo.setJogada(jogadaNova);
		estadoNovo.setNivelAtualNaArvore(this.nivelAtualNaArvore+1);
		estadoNovo.setNivelMaxADescerNaArvore(this.nivelMaxADescerNaArvore);
		
		return jogadaNova;
	}
}
