package ejercicios;

/*
 * Realiza una función que reciba como parámetro una tabla de enteros y devuelva la suma de todos los valores almacenados
 * en la tabla. Prueba el comportamiento de la función en un método main.
 */

public class Ejercicio01 {
	/**
	 * Suma los numeros de un array de enteros
	 * 
	 * @param arr Array con numeros a sumar
	 * @return Suma de los elementos del array
	 */
	public static int sumaArray(int[] arr) {
		int suma = 0;

		for (int num : arr)
			suma += num;

		return suma;
	}

	public static void main(String[] args) {
		int tabla[] = { 1, 2, 3, 4, 5 };
		System.out.println(sumaArray(tabla));

	}
}
