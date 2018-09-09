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
	
	public Estado(boolean[][] matrizTabuleiro, EEstado tipoEstado, Jogada jogada) {
		this.matrizTabuleiro = matrizTabuleiro;
		
		this.jogada = jogada;
		this.tipoEstado = tipoEstado;
		
		this.valorAlfa = -999999999;
		this.valorBeta = 999999999;
		
		this.nivelAtualNaArvore = -1;
		this.nivelMaxADescerNaArvore = -1;
		
		this.calcularValorHeuristicoDaJogada();
	}
	private void calcularValorHeuristicoDaJogada() {
		
		
		if (this.nivelAtualNaArvore == this.nivelMaxADescerNaArvore) {
			this.valorAlfa = this.valorHeuristico;
			this.valorBeta = this.valorHeuristico;
		}
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
	
	public void descerArvore() {
		if (this.nivelAtualNaArvore >= this.nivelMaxADescerNaArvore) {
			return;
		}
		
		for (int k = 0; k <= 7; k++) {
			for (int i = -k; i <= k; i++) {
				if (!this.matrizTabuleiro[7+i][7-k]) {
					this.criarEstadoFilho(7+i, 7-k);
					
					if (this.valorAlfa >= this.valorBeta) {
						return;
					}
				}
				
				if (!this.matrizTabuleiro[7+i][7+k]) {
					this.criarEstadoFilho(7+i, 7+k);
					
					if (this.valorAlfa >= this.valorBeta) {
						return;
					}
				}
				
				if (i != -k && i != k) {
					if (!this.matrizTabuleiro[7-k][7+i]) {
						this.criarEstadoFilho(7-k, 7+i);
						
						if (this.valorAlfa >= this.valorBeta) {
							return;
						}
					}
					
					if (!this.matrizTabuleiro[7+k][7+i]) {
						this.criarEstadoFilho(7+k, 7+i);
						
						if (this.valorAlfa >= this.valorBeta) {
							return;
						}
					}
				}
			}
		}
	}
	
	private Estado criarEstadoFilho(int linha, int coluna) {
		Jogada jogadaNova;
		jogadaNova = new Jogada(null, linha, coluna);
		
		EEstado tipoEstadoNovo;
		if (this.tipoEstado == EEstado.MAX) {
			tipoEstadoNovo = EEstado.MIN;
		} else {
			tipoEstadoNovo = EEstado.MAX;
		}
		
		Estado estadoFilho;
		estadoFilho = new Estado(matrizTabuleiro, tipoEstadoNovo, jogadaNova);
		estadoFilho.setNivelAtualNaArvore(this.nivelAtualNaArvore+1);
		estadoFilho.setNivelMaxADescerNaArvore(this.nivelMaxADescerNaArvore);
		
		estadoFilho.descerArvore();
		
		if (this.tipoEstado == EEstado.MAX) {
			this.valorAlfa = Math.max(estadoFilho.valorBeta, this.valorAlfa);
			this.valorHeuristico = Math.max(estadoFilho.valorHeuristico, this.valorHeuristico);
		} else {
			this.valorBeta = Math.min(estadoFilho.valorAlfa, this.valorBeta);
			this.valorHeuristico = Math.min(estadoFilho.valorHeuristico, this.valorHeuristico);
		}
		
		return estadoFilho;
	}
}
