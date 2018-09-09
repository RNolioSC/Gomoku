package interfaceGrafica;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import tabuleiro.Jogada;
import tabuleiro.Jogador;
import tabuleiro.Tabuleiro;

public class ViewTabuleiro extends JPanel {
	public static int CELULA_WIDTH = 35;
	public static int CELULA_HEIGHT = 35;
	
	private Tabuleiro tabuleiro;
	
	public ViewTabuleiro() {
		this.setLayout(null);
		this.setBackground( new Color(220,220,220) );
		this.setBounds(0, 0, Window.WIDTH, Window.HEIGHT);
		this.addMouseListener( new EventMouse(this) );
		
		this.tabuleiro = new Tabuleiro();
	}
	public void realizarJogada(Jogada jogada) {
		this.tabuleiro.realizarJogada(jogada);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		this.desenharTabuleiro(g);
	}
	
	private void desenharTabuleiro(Graphics g) {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				this.desenharCelula(g, i, j);
			}
		}
	}
	private void desenharCelula(Graphics g, int x, int y) {
		Jogador celula;
		celula = this.tabuleiro.getCelula(x, y);
		
		int width, height;
		width = ViewTabuleiro.CELULA_WIDTH;
		height = ViewTabuleiro.CELULA_HEIGHT;
		
		int posX, posY;
		posX = x*width +x +20;
		posY = y*height +y +20;
		
		g.setColor(this.getColorCelula(celula));
		g.fillRect(posX, posY, width, height);
	}
	private Color getColorCelula(Jogador celula) {
		if (celula == Jogador.HUMANO) {
			return new Color(0,0,200);
		}
		if (celula == Jogador.MAQUINA) {
			return new Color(200,0,0);
		}
		
		return new Color(150,150,150);
	}
}
