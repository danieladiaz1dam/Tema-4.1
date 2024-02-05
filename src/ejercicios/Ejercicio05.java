package ejercicios;

/**
 * Ejercicio05
 */
public class Ejercicio05 {
	/**
	 * Metodo Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Matriz que rellenar y calcular
		final int mtrx[][] = new int[4][5];
		int suma, sumaTotal = 0;

		// Rellenar el array
		for (int i = 0; i < mtrx.length; i++) {
			for (int j = 0; j < mtrx[i].length; j++) {
				mtrx[i][j] = (int) (100 + Math.random() * 900); // 100 ~ 999
			}
		}

		// Calcular las sumas de las rows
		for (int i = 0; i < mtrx.length; i++) {
			suma = 0;
			for (int j = 0; j < mtrx[i].length; j++) {
				System.out.printf("%4d ", mtrx[i][j]);
				suma += mtrx[i][j];
			}
			System.out.printf("| %d\n", suma);
		}

		// Calcular las sumas de las columns
		System.out.printf("%s\n", "-".repeat(31));
		for (int j = 0; j < mtrx[0].length; j++) {
			suma = 0;

			for (int[] fila : mtrx) {
				for (int value : fila) {
					suma += value;
				}
			}

			sumaTotal += suma;
			System.out.printf("%4d ", suma);
		}
		System.out.printf("| %d", sumaTotal);
	}
}
