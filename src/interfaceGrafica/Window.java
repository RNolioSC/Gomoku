package interfaceGrafica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import tabuleiro.Jogador;

public class Window implements ActionListener {
	public static int WIDTH = 640;
	public static int HEIGHT = 640;
	
	private JFrame jFrame;
	private ViewTabuleiro interfaceTabuleiro;
	
	public Window() {
		this.interfaceTabuleiro = new ViewTabuleiro();
		
		this.jFrame = new JFrame("Gomoku");
		this.jFrame.setLayout(null);
		this.jFrame.setBounds(0, 0, Window.WIDTH, Window.HEIGHT);
		
		this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.jFrame.setContentPane( this.interfaceTabuleiro );
		this.jFrame.setResizable(false);
		this.jFrame.setVisible(true);
		
		Timer timer;
		timer = new Timer(30, this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.jFrame.repaint();
	}
	
	public static void informarVencedor(Jogador jogador) {
		JOptionPane.showMessageDialog(null, jogador+" venceu!", "Fim de jogo!", JOptionPane.DEFAULT_OPTION);
	}
}
