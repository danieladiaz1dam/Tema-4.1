package ejercicios;

/*
 * Partiendo de la tabla creada en el ejercicio 1, mostrar la suma de todos los
 * números aleatorios que se guardan en la tabla.
 */

public class Ejercicio02 {
	public static void main(String[] args) {
		// Crear tabla
		int[] tabla = new int[10];
		int suma = 0;

		// Rellenar tabla
		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = (int) (Math.random() * 100 + 1);
		}

		// Calcula la suma
		for (int num : tabla) {
			suma += num;
		}

		// Imprimir la tabla
		for (int num  : tabla) {
			System.out.printf("%d ", num);
		}

		// Imprimir la suma
		System.out.printf("\nSuma: %d", suma);
	}
}
