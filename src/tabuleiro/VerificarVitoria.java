package tabuleiro;

public class VerificarVitoria {
	private Tabuleiro tabuleiro;
	
	public VerificarVitoria(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	
	public boolean verificarVitoria(Jogada jogada) {
		Jogador jogador;
		jogador = jogada.getJogador();
		
		int x, y;
		x = jogada.getX();
		y = jogada.getY();
		
		if (this.venceuVertical(jogador, x, y)) {
			return true;
		}
		if (this.venceuHorizontal(jogador, x, y)) {
			return true;
		}
		if (this.venceuDiagonalPrincipal(jogador, x, y)) {
			return true;
		}
		if (this.venceuDiagonalSecundaria(jogador, x, y)) {
			return true;
		}
		return false;
	}
	
	private boolean venceuVertical(Jogador jogador, int x, int y) {
		int numeroCombinacoes;
		numeroCombinacoes = 1;
		numeroCombinacoes = this.combinacoesVerticalCima(jogador, numeroCombinacoes, x, y-1);
		numeroCombinacoes = this.combinacoesVerticalBaixo(jogador, numeroCombinacoes, x, y+1);
		
		if (numeroCombinacoes >= 5) {
			return true;
		}
		
		return false;
	}
	private boolean venceuHorizontal(Jogador jogador, int x, int y) {
		int numeroCombinacoes;
		numeroCombinacoes = 1;
		numeroCombinacoes = this.combinacoesHorizontalEsquerda(jogador, numeroCombinacoes, x-1, y);
		numeroCombinacoes = this.combinacoesHorizontalDireita(jogador, numeroCombinacoes, x+1, y);
		
		if (numeroCombinacoes >= 5) {
			return true;
		}
		
		return false;
	}
	private boolean venceuDiagonalPrincipal(Jogador jogador, int x, int y) {
		int numeroCombinacoes;
		numeroCombinacoes = 1;
		numeroCombinacoes = this.combinacoesDiagonalPrincipalEsquerda(jogador, numeroCombinacoes, x-1, y-1);
		numeroCombinacoes = this.combinacoesDiagonalPrincipalDireita(jogador, numeroCombinacoes, x+1, y+1);
		
		if (numeroCombinacoes >= 5) {
			return true;
		}
		
		return false;
	}
	private boolean venceuDiagonalSecundaria(Jogador jogador, int x, int y) {
		int numeroCombinacoes;
		numeroCombinacoes = 1;
		numeroCombinacoes = this.combinacoesDiagonalSecundariaEsquerda(jogador, numeroCombinacoes, x-1, y+1);
		numeroCombinacoes = this.combinacoesDiagonalSecundariaDireita(jogador, numeroCombinacoes, x+1, y-1);
		
		if (numeroCombinacoes >= 5) {
			return true;
		}
		
		return false;
	}
	
	private int combinacoesVerticalCima(Jogador jogador, int numeroCombinacoes, int x, int y) {
		if (!this.continuarVerificacao(x, y, numeroCombinacoes)) {
			return numeroCombinacoes;
		}
		if (this.tabuleiro.getCelula(x, y) == jogador) {
			return this.combinacoesVerticalCima(jogador, numeroCombinacoes+1, x, y-1);
		}
		return numeroCombinacoes;
	}
	private int combinacoesVerticalBaixo(Jogador jogador, int numeroCombinacoes, int x, int y) {
		if (!this.continuarVerificacao(x, y, numeroCombinacoes)) {
			return numeroCombinacoes;
		}
		if (this.tabuleiro.getCelula(x, y) == jogador) {
			return this.combinacoesVerticalBaixo(jogador, numeroCombinacoes+1, x, y+1);
		}
		return numeroCombinacoes;
	}
	private int combinacoesHorizontalDireita(Jogador jogador, int numeroCombinacoes, int x, int y) {
		if (!this.continuarVerificacao(x, y, numeroCombinacoes)) {
			return numeroCombinacoes;
		}
		if (this.tabuleiro.getCelula(x, y) == jogador) {
			return this.combinacoesHorizontalDireita(jogador, numeroCombinacoes+1, x+1, y);
		}
		return numeroCombinacoes;
	}
	private int combinacoesHorizontalEsquerda(Jogador jogador, int numeroCombinacoes, int x, int y) {
		if (!this.continuarVerificacao(x, y, numeroCombinacoes)) {
			return numeroCombinacoes;
		}
		if (this.tabuleiro.getCelula(x, y) == jogador) {
			return this.combinacoesHorizontalEsquerda(jogador, numeroCombinacoes+1, x-1, y);
		}
		return numeroCombinacoes;
	}
	private int combinacoesDiagonalPrincipalDireita(Jogador jogador, int numeroCombinacoes, int x, int y) {
		if (!this.continuarVerificacao(x, y, numeroCombinacoes)) {
			return numeroCombinacoes;
		}
		if (this.tabuleiro.getCelula(x, y) == jogador) {
			return this.combinacoesDiagonalPrincipalDireita(jogador, numeroCombinacoes+1, x+1, y+1);
		}
		return numeroCombinacoes;
	}
	private int combinacoesDiagonalPrincipalEsquerda(Jogador jogador, int numeroCombinacoes, int x, int y) {
		if (!this.continuarVerificacao(x, y, numeroCombinacoes)) {
			return numeroCombinacoes;
		}
		if (this.tabuleiro.getCelula(x, y) == jogador) {
			return this.combinacoesDiagonalPrincipalEsquerda(jogador, numeroCombinacoes+1, x-1, y-1);
		}
		return numeroCombinacoes;
	}
	private int combinacoesDiagonalSecundariaDireita(Jogador jogador, int numeroCombinacoes, int x, int y) {
		if (!this.continuarVerificacao(x, y, numeroCombinacoes)) {
			return numeroCombinacoes;
		}
		if (this.tabuleiro.getCelula(x, y) == jogador) {
			return this.combinacoesDiagonalSecundariaDireita(jogador, numeroCombinacoes+1, x+1, y-1);
		}
		return numeroCombinacoes;
	}
	private int combinacoesDiagonalSecundariaEsquerda(Jogador jogador, int numeroCombinacoes, int x, int y) {
		if (!this.continuarVerificacao(x, y, numeroCombinacoes)) {
			return numeroCombinacoes;
		}
		if (this.tabuleiro.getCelula(x, y) == jogador) {
			return this.combinacoesDiagonalSecundariaEsquerda(jogador, numeroCombinacoes+1, x-1, y+1);
		}
		return numeroCombinacoes;
	}
	
	private boolean continuarVerificacao(int x, int y, int numeroCombinacoes) {
		if (!this.dentroDosLimitesDoTabuleiro(x, y) || (numeroCombinacoes >= 5)) {
			return false;
		}
		return true;
	}
	private boolean dentroDosLimitesDoTabuleiro(int x, int y) {
		if ((x < 0 || y < 0) || (x > 14 || y > 14)) {
			return false;
		}
		return true;
	}
}
