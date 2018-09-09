package interfaceGrafica;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import jogada.Jogada;
import tabuleiro.Jogador;

public class EventMouse implements MouseListener {
	private ViewTabuleiro interfaceTabuleiro;
	
	public EventMouse(ViewTabuleiro interfaceTabuleiro) {
		this.interfaceTabuleiro = interfaceTabuleiro;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int width, height;
		width = ViewTabuleiro.CELULA_WIDTH;
		height = ViewTabuleiro.CELULA_HEIGHT;
		
		int x, y;
		x = e.getX() - 25;
		y = e.getY() - 25;
		
		int posX, posY;
		posX = x / width;
		posY = y / height;
		
		System.out.println(x+", "+y);
		
		this.interfaceTabuleiro.realizarJogada(new Jogada(Jogador.HUMANO, posX, posY));
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
