package ejercicios;

/*
 * Define tres arrays de 20 números enteros cada uno, con nombres numeros, cuadrados y cubos.
 * Carga el array numeros con valores aleatorios entre 0 y 100.
 * En el array cuadrados se deben almacenar los cuadrados de los valores que hay en el array numeros.
 * En el array cubos se deben almacenar los cubos de los valores que hay en numeros.
 * A continuación, muestra el contenido de los tres arrays dispuestos en tres columnas.
 */

public class Ejercicio08 {
	public static void main(String[] args) {
		// Crear tablas
		int[] numeros = new int[10];
		int[] cuadrados = new int[numeros.length];
		int[] cubos = new int[numeros.length];

		// Rellenar las tablas
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random() * 100 + 1);
			cuadrados[i] = numeros[i] * numeros[i];
			cubos[i] = numeros[i] * numeros[i] * numeros[i];
		}
		
		// Imprimir las tablas
		System.out.println("Numeros | Cuadrados |  Cubos");
		for (int i = 0; i < numeros.length; i++) {
			System.out.printf("%7d | %9d | %6d\n", numeros[i], cuadrados[i], cubos[i]);
		}
		
	}
}
