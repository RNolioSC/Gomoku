package tabuleiro;

public class AvaliarJogada {
	public AvaliarJogada() {
		// TODO Auto-generated constructor stub
	}

	public void avaliar(Tabuleiro tabuleiro, Jogador jogador, int x, int y) { // peca nova colocada em (x,y)
		// TODO: tratar out of bounds

		// retorna somente a melhor sequencia existente

		//TODO: isto assume que i = jogador?
		// horizontal
		for (int i = -4; i < 5; i++) {
			for (int j = i + 1; j < 5; j++) {
				if (tabuleiro.getCelula(x + i, y + j) == jogador) {
					continue;
				} else {
					int tamanhoSeq = j - i;
					if (tamanhoSeq > 1) {
						System.out.println("Encontramos uma " + tamanhoSeq + "-pla.");
					}
					break;
				}
			}
		}
		// vertical
		for (int j = -4; j < 5; j++) {
			for (int i = j + 1; i < 5; i++) {
				if (tabuleiro.getCelula(x + i, y + j) == jogador) {
					continue;
				} else {
					int tamanhoSeq = i - j;
					if (tamanhoSeq > 1) {
						System.out.println("Encontramos uma " + tamanhoSeq + "-pla.");
					}
					break;
				}
			}
		}

		// diagonal TODO: bugado
		for (int i = -4; i < 5; i++) {
			for (int j = i+1; j < 5; j++) {
				System.out.println(i+",  "+j);
				System.out.println("pos ver="+(j)+",  "+(j));
				if (tabuleiro.getCelula(x + j, y + j) == jogador) {
					System.out.println("cont");
					continue;
				} else {
					int tamanhoSeq = j - i;
					if (tamanhoSeq > 1) {
						System.out.println("Encontramos uma " + tamanhoSeq + "-pla de "+i+" a "+j);
					}
				break;
				}
			}
		}
		
		//diagonal inverso:
		for (int i = 4; i > -5; i--) {
			for (int j = i+1; j < 5; j++) {
				//TODO
			}
			
		}

	}

}
