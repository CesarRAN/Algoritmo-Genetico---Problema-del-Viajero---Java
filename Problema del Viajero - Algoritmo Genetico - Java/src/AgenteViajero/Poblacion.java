/**
 * @author CRAN
 * 16 may. 2021
 * AgenteViajero: Poblacion.java
 */

package AgenteViajero;

public class Poblacion {
	
	private Cromosoma[] poblacion;
	private int tamPoblacion;
	private int longitud;
	//private float ProbabilidadMutacion;
	
	
	public Poblacion(int tam,int n) {
		this.tamPoblacion = tam;
		this.longitud = tam;
		this.poblacion = new Cromosoma[this.tamPoblacion];
		genPoblacion(n);
	}
	
	public Poblacion(int tam) {
		this.tamPoblacion = tam;
		this.longitud = 0;
		this.poblacion = new Cromosoma[this.tamPoblacion];
	}
	
	private void genPoblacion(int n) {
		
		for(int i=0; i<this.tamPoblacion; i++) {
			Cromosoma aux = new Cromosoma(n);
			poblacion[i] = aux;
		}
	}

	public void evaluarIndividuos(Ciudades mapa) {
		int distancia;
		int ciudadA, ciudadB;
		for(int i=0; i<this.tamPoblacion; i++) {
			distancia = 0;
			for(int j=0; j<mapa.getNumCiudades()-1; j++) {
				ciudadA = this.poblacion[i].getGen(j);
				ciudadB = this.poblacion[i].getGen(j+1);
				distancia = distancia + mapa.getDistanciaCiudades(ciudadA, ciudadB);
			}
			this.poblacion[i].setDistancia(distancia);
		}
	}
	
	public Cromosoma cruzamuento(Cromosoma padreA, Cromosoma padreB) {
		
		Cromosoma hijo = new Cromosoma(padreA.getLongCromosoma(), true);
		int j,i;
		int[][] cromosomaBase= new int[2][padreA.getLongCromosoma()];
		for( i=0; i<padreA.getLongCromosoma(); i++) {
			cromosomaBase[0][i] = i;
			cromosomaBase[1][i] = 1;
		}
		
		for( i=0; i<padreA.getLongCromosoma(); i++) {
			if(i<padreA.getLongCromosoma()/2) {
				hijo.setGen(i,padreA.getGen(i));
				cromosomaBase[1][padreA.getGen(i)] = 0;
			}
			else {
				hijo.setGen(i,padreB.getGen(i));
			}
		}
		
		for( i=padreA.getLongCromosoma()/2; i<padreA.getLongCromosoma(); i++) {
			if(cromosomaBase[1][hijo.getGen(i)] == 0) {
				for(j=0; cromosomaBase[1][j] == 0; j++ );
				hijo.setGen(i, cromosomaBase[0][j]);
				cromosomaBase[1][j] = 0;				
			}
			else {
				cromosomaBase[1][hijo.getGen(i)] = 0;
			}
		}
		
		return hijo;
	}
	
	public Cromosoma individuoOptimo() {
		Cromosoma optimo = poblacion[0];
		for(int i=0; i<this.tamPoblacion-1; i++) {
			if(this.poblacion[i].getDistancia()>this.poblacion[i+1].getDistancia()) {
				optimo = this.poblacion[i+1];
			}
		}
		
		
		return optimo;
	}
	
	public int[][] Seleccion() {
		int i;
		int[][] cromosomaBase= new int[2][this.poblacion[0].getLongCromosoma()];
		for( i=0; i<this.poblacion[0].getLongCromosoma(); i++) {
			cromosomaBase[0][i] = i;
			cromosomaBase[1][i] = 1;
		}
		
				
		for(i=0; i<(this.tamPoblacion)-1; i++) {
			if(i < this.poblacion[0].getLongCromosoma()) {
				if(this.poblacion[i].getDistancia()<this.poblacion[i+1].getDistancia()) {
					cromosomaBase[1][i+1] = 0;
				}
				else {
					cromosomaBase[1][i] = 0;
				}
			}
			i++;
		}
		return cromosomaBase;
	}
	
	public void setIndividuo(Cromosoma Cr) {
		if(this.longitud<this.tamPoblacion) {
			this.poblacion[this.longitud] = Cr;
			this.longitud++;
		}
	}
		
	public int getTamPoblacion() {
		return tamPoblacion;
	}

	public void setTamPoblacion(int tamPoblacion) {
		this.tamPoblacion = tamPoblacion;
	}
	
	public Cromosoma getIndividuo(int i) {
		return poblacion[i];
	}

	public Cromosoma[] getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Cromosoma[] poblacion) {
		this.poblacion = poblacion;
	}

	public int getLongitud() {
		return longitud;
	}

	/**public float getProbabilidadMutacion() {
		return ProbabilidadMutacion;
	}

	public void setProbabilidadMutacion(float probabilidadMutacion) {
		ProbabilidadMutacion = probabilidadMutacion;
	}**/
	
}
