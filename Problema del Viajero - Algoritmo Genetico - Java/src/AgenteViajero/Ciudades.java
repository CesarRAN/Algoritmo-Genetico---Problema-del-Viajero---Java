/**
 * @author CRAN 
 * 16 may. 2021
 * AgenteViajero: Ciudades.java
 */

package AgenteViajero;

public class Ciudades {
	
	private int numCiudades;
	private int[][] matrizCiudades;
	
	public Ciudades(int num) {
		this.numCiudades = num;
		this.matrizCiudades = new int[this.numCiudades][this.numCiudades];
		genCiudades();
		
	}
	
	private void genCiudades(){
		for(int i=0; i < this.numCiudades; i++) {
			for(int j=0; j < this.numCiudades; j++ ) {
				if(i==j) {
					this.matrizCiudades[i][j] = 0;
				}
				if(i<j) {
					this.matrizCiudades[i][j] = (int) (Math.random()*50 + 1);
					this.matrizCiudades[j][i] = this.matrizCiudades[i][j];
				}
			}
		}
	}
	
	public int getNumCiudades() {
		return numCiudades;
	}

	public int getDistanciaCiudades(int j, int i) {
		return matrizCiudades[i][j];
	}
	
}
