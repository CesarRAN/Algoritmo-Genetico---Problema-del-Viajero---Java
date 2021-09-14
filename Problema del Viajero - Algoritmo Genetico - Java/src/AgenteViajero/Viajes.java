/**
 * @author CRAN
 * 16 may. 2021
 * AgenteViajero: Viajes.java
 */

package AgenteViajero;
import java.util.Arrays;
import java.util.Scanner;

public class Viajes {
	
	
	public static void main (String [ ] args) {
		//n max =5518;
		int numCiudades=10;
		int tamPoblacion=10;
		/**Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese el numero de Ciudades: ");
		numCiudades = sc.nextInt(); 
		System.out.println("Ingrese el tamaño de la poblacion: ");
		tamPoblacion = sc.nextInt();**/
		
		if((tamPoblacion%2)!=0)
			tamPoblacion++;
		
		int[][] poblacionBase= new int[2][tamPoblacion];
		//int[] poblacionSeleccionada = new int [tamPoblacion];
		//int[] poblacionAux = new int [tamPoblacion];
		Ciudades mapa = new Ciudades(numCiudades);
		Poblacion poblacion = new Poblacion(tamPoblacion,numCiudades);
		Poblacion poblacionB = new Poblacion(tamPoblacion,numCiudades);
		String[][] strArray = new String[numCiudades][numCiudades];
		
		for(int i=0; i<numCiudades; i++) {
			for(int j=0; j<numCiudades; j++) {
				if(mapa.getDistanciaCiudades(i, j)<10) {
					strArray[i][j] = String.valueOf("0"+mapa.getDistanciaCiudades(i, j));
				}
				else {
					strArray[i][j] = String.valueOf(mapa.getDistanciaCiudades(i, j));
				}
			}
		}
		
		for(int i=0; i<numCiudades; i++) {
			System.out.println(Arrays.toString(strArray[i]));
		}
		
		poblacion.evaluarIndividuos(mapa);
		poblacionB = poblacion;
		for(int i=0; i<10000; i++) {
			
			poblacionBase = poblacion.Seleccion();
			Poblacion poblacionNueva = new Poblacion(tamPoblacion);
			for(int j=0; j<10; j++) {
				if(poblacionBase[1][j]==1)
					poblacionNueva.setIndividuo(poblacion.getIndividuo(poblacionBase[0][j]));
			}
			
			System.out.println(poblacionNueva.getLongitud());
			
			for(int j=0; j<(tamPoblacion/2); j++) {
				if((tamPoblacion/2)-j!=1) {
					poblacionNueva.setIndividuo(poblacion.cruzamuento(poblacionNueva.getIndividuo(j), poblacionNueva.getIndividuo(j+1)));
					poblacionNueva.setIndividuo(poblacion.cruzamuento(poblacionNueva.getIndividuo(j+1), poblacionNueva.getIndividuo(j)));
				}
				else {
					poblacionNueva.setIndividuo(poblacion.cruzamuento(poblacionNueva.getIndividuo(j), poblacionNueva.getIndividuo(j+1)));
				}
				j++;
			}
			poblacion =	poblacionNueva;
			poblacion.evaluarIndividuos(mapa);
		}
		
		Cromosoma Optimo = poblacion.individuoOptimo();
		Cromosoma OptimoB = poblacionB.individuoOptimo();
		//System.out.println("La distancia minima inicial: " + OptimoB.getDistancia());
		System.out.println("La distancia optima es: " + Optimo.getDistancia());
		
		
		
		
		/**Poblacion poblacion = new Poblacion(5,n);
		Cromosoma padreB = poblacion.getIndividuo(1);
		Cromosoma padreA = poblacion.getIndividuo(0);
		
		Cromosoma hijo = poblacion.cruzamuento(poblacion.getIndividuo(0),poblacion.getIndividuo(1));
		
		String[] strArrayA = new String[n];
		String[] strArrayB = new String[n];
		String[] strArrayH = new String[n];
        
        
        /for (int i = 0; i < n ; i++) {
            strArrayA[i] = String.valueOf(padreA.getGen(i));
            strArrayB[i] = String.valueOf(padreB.getGen(i));
            strArrayH[i] = String.valueOf(hijo.getGen(i));
        }
 
        System.out.println(Arrays.toString(strArrayA));
        System.out.println(Arrays.toString(strArrayB));
        System.out.println(Arrays.toString(strArrayH));**/
		
	}
	

}
