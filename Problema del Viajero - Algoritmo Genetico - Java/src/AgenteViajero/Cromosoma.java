/**
 * @author CRAN
 * 16 may. 2021
 * AgenteViajero: Cromosoma.java
 */

package AgenteViajero;

public class Cromosoma {
	
	private int longCromosoma;
	private int [] cromosoma;
	private int distancia;
	
	public Cromosoma(int tam) {
		this.longCromosoma = tam;
		this.cromosoma = new int [this.longCromosoma];
		generarCromosoma();
	}
	
	public Cromosoma(int tam, boolean uwu) {
		this.longCromosoma = tam;
		this.cromosoma = new int [this.longCromosoma];
	}
	
	private void generarCromosoma() {
		int i,j=0,aux;
		boolean flag; 
		for(i=0; i < this.longCromosoma; i++) {
			this.cromosoma[i] = -1;
		}
		while(this.cromosoma[this.longCromosoma-1] == -1) {
			flag = true;
			aux = (int)(Math.random()*this.longCromosoma);
			for(i=0; i <= j && i < this.longCromosoma; i++ ) {
				if(this.cromosoma[i] == aux) {
					flag = false;
				}
			}
			if(flag) {
				this.cromosoma[j] = aux;
				j++;
			}
		}
	}
	
	public void mutarCromosoma() {
		int aux1 = (int)(Math.random()*(this.longCromosoma/2));
		int aux2 = (int)(Math.random()*(this.longCromosoma)+aux1);
		int[] cromosomaAux = new int[this.longCromosoma];
		int i,tam;
		tam = aux1-aux2;
		for(i=0; i<this.longCromosoma ; i++) {
			cromosomaAux[i] = this.cromosoma[i];			
		}
		for(i=aux1; i<tam; i++) {
			this.cromosoma[i] = cromosomaAux[aux2];
			aux2--;
		}
	}
	
	public int getGen(int i) {
		return this.cromosoma[i];
	}
	
	public void setGen(int i, int a) {
		this.cromosoma[i] = a;
	}

	public int getLongCromosoma() {
		return longCromosoma;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	

}
