package ejercicios;

/*
 * Define un array de 12 números enteros con nombre num y asigna los valores
 * según la tabla que se muestra a continuación. Muestra el contenido de todos
 * los elementos del array por consola.
 * ¿Qué sucede con los valores de los elementos que no han sido inicializados?
 */

public class Ejercicio04 {
	public static void main(String[] args) {
		// El array se inicializa con todos los valores en 0
		int[] num = new int[12];

		// Rellenar solo algunos huecos
		num[0] = 39;
		num[1] = -2;
		num[4] = 0;
		num[6] = 14;
		num[8] = 5;
		num[9] = 120;

		// Imprimir la tabla
		for (int n : num) {
			System.out.printf("%d ", n);
		}
	}
}
