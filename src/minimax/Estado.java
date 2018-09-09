package minimax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import tabuleiro.Jogada;

public class Estado {
	private boolean[][] matrizTabuleiro;
	private Jogada jogadaEstadoAnterior;
	private Jogada jogadaEstado;
	
	private int valorHeuristico;
	private int valorAlfa;
	private int valorBeta;
	
	public Estado(Jogada jogadaAnterior, boolean[][] matrizTabuleiro) {
		this.matrizTabuleiro = matrizTabuleiro;
		this.jogadaEstadoAnterior = jogadaAnterior;
		
		this.valorAlfa = -999999999;
		this.valorBeta = 999999999;
		this.valorHeuristico = -999999999;
	}
	
	public void setJogada(Jogada jogada) {
		this.jogadaEstado = jogada;
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
	
	public int getValorHeuristico() {
		return this.valorHeuristico;
	}
	public int getValorAlfa() {
		return this.valorAlfa;
	}
	public int getValorBeta() {
		return this.valorBeta;
	}
	
	public void calcularValorHeuristico(int valorHeuristicoDoPai) {
		
	}
	
	public ArrayList<Estado> getArrayEstadoDerivado() {
		ArrayList<Estado> arrayEstadoDerivado;
		arrayEstadoDerivado = new ArrayList<Estado>();
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (this.matrizTabuleiro[i][j]) {
					continue;
				}
				
				Jogada jogadaDerivada;
				jogadaDerivada = new Jogada(null, i, j);
				
				Estado estadoDerivado;
				estadoDerivado = new Estado(this.jogadaEstado, matrizTabuleiro);
				estadoDerivado.setJogada(jogadaDerivada);
				
				arrayEstadoDerivado.add(estadoDerivado);
			}
		}
		
		this.ordenarArray(arrayEstadoDerivado);
		
		return arrayEstadoDerivado;
	}
	
	private void ordenarArray(ArrayList<Estado> array) {
		Comparator<Estado> comparator;
		comparator = new Comparator<Estado>() {
			@Override
			public int compare(Estado estado1, Estado estado2) {
				if (estado1.getValorHeuristico() < estado2.getValorHeuristico()) {
					return -1;
				}
				if (estado1.getValorHeuristico() > estado2.getValorHeuristico()) {
					return 1;
				}
				
				return 0;
			}
		};
		
		Collections.sort(array, comparator);
	}
}
