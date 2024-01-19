package ejercicios;

/*
 * Diseñar la función: int maximo(int t[]), que devuelva el máximo valor contenido en la tabla t.
 */

public class Ejercicio02 {
	/**
	 * Devuelve el numero mas alto en un array
	 * 
	 * @param t Array del que comprobar los elementos
	 * @return Numero mas lto
	 */
	public static int maximo(int t[]) {
		int max = t[0];

		// Recorrer todo el array y si algun numero es mayor que el primero, guardarlo
		for (int num : t)
			if (max < num)
				max = num;

		return max;
	}

	public static void main(String[] args) {
		int tabla[] = { 35, 759, 136, 7, 3242, 9, 8, 2, 3 };
		System.out.println(maximo(tabla));
	}
}
