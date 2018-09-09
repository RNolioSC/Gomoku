package minimax;

public class PodaAlfaBeta {
	
	 private static PodaAlfaBeta instance = null; 

	public PodaAlfaBeta() {
		// TODO add coisas
	}
	public static PodaAlfaBeta getInstance() 
    { 
        if (instance == null) 
        	instance = new PodaAlfaBeta(); 
  
        return instance; 
    } 
	
	public int podar(Estado no, int numeroNivelADescer, int alpha, int beta, boolean maximizar) {
		if (numeroNivelADescer == 0 || no.getTipoEstado() == folha){
			return no.getValorHeuristico();
		}
		if (maximizar) {
			int aux = -999999999;
			no.criarEstadosFilho();
			//for(int i=0;) { // para cada filho
				aux = /*max(aux, */podar(filho, numeroNivelADescer-1, alpha, beta, false);
				alpha = Math.max(alpha, aux);
				if(alpha >= beta) {
					break; // podando por beta
				}
			//}
			return aux;
		}else {
			int aux = 999999999;
			//for (i = 0; i) {// para cada filho
				
				aux = /*min(aux, */podar(filho, numeroNivelADescer-1, alpha, beta, true);
				beta = Math.min(beta, aux);
				if(alpha >= beta) {
					break; // podando por alpha
				}
			//}
			return aux;
		}
		
		
		//return 0;
		
		
	}
}
