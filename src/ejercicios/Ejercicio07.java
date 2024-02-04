package ejercicios;

import helper.Helper;

/**
 * Ejercicio07
 */
public class Ejercicio07 {
	/**
	 * "Rota" la matriz, cambia las rows por las columns
	 * 
	 * @param mtrx Matriz para rotar
	 * @return Matrix rotada
	 */
	public static int[][] transpose(int mtrx[][]) {
		final int newMtrx[][] = new int[mtrx[0].length][mtrx.length];

		for (int i = 0; i < newMtrx.length; i++) {
			for (int j = 0; j < newMtrx[i].length; j++) {
				newMtrx[i][j] = mtrx[j][i];
			}
		}

		return newMtrx;
	}

	/**
	 * Metodo Main
	 * @param args
	 */
	public static void main(String[] args) {
		int mtrx[][] = new int[4][4];

		for (int i = 0; i < mtrx.length; i++) {
			for (int j = 0; j < mtrx[i].length; j++) {
				mtrx[i][j] = i * mtrx.length + j + 1;
			}
		}

		Helper.printMtrx(mtrx, 2);

		mtrx = transpose(mtrx);

		System.out.println();
		Helper.printMtrx(mtrx, 2);
	}
}
