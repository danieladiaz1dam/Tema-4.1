package ejercicios;

/*
 * Crea una tabla de enteros de longitud 10 que se inicializará con números aleatorios comprendidos entre 1 y 100.  
 */

public class Ejercicio01 {
	public static void main(String[] args) {
		// Crear tabla
		int[] tabla = new int[10];

		// Rellenar tabla
		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = (int) (Math.random() * 100 + 1);
		}
		
		//Imprimir tabla
		for (int num : tabla) {
			System.out.printf("%d ", num);
		}
	}
}
