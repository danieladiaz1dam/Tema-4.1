package ejercicios;

import helper.Helper;

/**
 * Ejercicio08
 */
public class Ejercicio08 {
	/**
	 * Mira si un array es simetrico
	 * 
	 * @param mtrx
	 * @return true si es simetrico, false en caso contrario
	 */
	public static boolean isSymmetric(int mtrx[][]) {
		boolean symmetric = true;
		int i = 0, j = 0;

		if (mtrx.length != mtrx[0].length)
			symmetric = false;
		
		else {
			while (symmetric && i < mtrx.length) {
				j = 0;
				while (symmetric && j < mtrx[0].length) {
					if (mtrx[i][j] != mtrx[j][i])
						symmetric = false;

					j++;
				}
				i++;
			}
		}

		return symmetric;
	}

	/**
	 * Metodo main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		final int mtrx[][] = new int[][] { { 1, 1, 1 }, { 1, 2, 1 }, { 1, 1, 1 } };

		Helper.printMtrx(mtrx);

		System.out.println(isSymmetric(mtrx) ? "La tabla es simetrica" : "La tabla no es simetrica");
	}
}
