package ejercicios;

import helper.Helper;

public class ejercicio1 {
	public static void main(String[] args) {
		int mtrx[][] = new int[3][6];
		
		mtrx[0][1] = 30;
		mtrx[0][2] = 2;
		mtrx[0][5] = 5;
		mtrx[1][0] =75 ;
		mtrx[2][2] = -2;
		mtrx[2][3] = 9;
		mtrx[2][5] = 11;
		
		Helper.printMtrx(mtrx, 2);
	}
}
