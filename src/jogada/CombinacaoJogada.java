package jogada;

import lista.ListaJogada;

public class CombinacaoJogada {
	private int numeroBloqueios;
	private ETipoCombinacao tipoCombinacao;
	private ListaJogada listaJogada;
	
	public CombinacaoJogada() {
		this.numeroBloqueios = 0;
		this.listaJogada = new ListaJogada();
		this.tipoCombinacao = ETipoCombinacao.INDEFINIDO;
	}
	
	public boolean addJogada(Jogada jogada) {
		if (this.listaJogada.size() == 0) {
			this.listaJogada.add(jogada);
			return true;
		}
		
		// VERIFICAR O TIPO DA COMBINACAO
		if (this.listaJogada.size() == 1) {
			
		}
		
		return false;
	}
	public void incrementarContadorDeBloqueio() {
		this.numeroBloqueios++;
	}
	public boolean sequenciaBloqueada() {
		if (this.listaJogada.size() > 1 && this.numeroBloqueios > 1) {
			return true;
		}
		if (this.listaJogada.size() == 1 && this.numeroBloqueios == 8) {
			return true;
		}
		return false;
	}
	public boolean sequenciaBloqueadaParcialmente() {
		if (this.listaJogada.size() > 1 && this.numeroBloqueios == 1) {
			return true;
		}
		if (this.listaJogada.size() == 1 && this.numeroBloqueios == 7) {
			return true;
		}
		return false;
	}
}
