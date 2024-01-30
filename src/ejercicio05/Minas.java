package ejercicio05;

import helper.Helper;

public class Minas {
	// Campo de minas
	// -1 = mina
	int mineField[];

	// Lo que conocemos del campo
	boolean knownMineField[];

	// Puntuacion
	int score = 0;

	/**
	 * Constructor
	 */
	public Minas() {
		// Numero de minas colocadas, variable de posicion
		int nMines = 0, pos;
		int surroundingMines;

		// Inicializar campo de minas
		mineField = new int[20];
		knownMineField = new boolean[20];

		// Poner las minas
		while (nMines < 6) {
			// Posicion random
			pos = (int) (Math.random() * mineField.length);

			// Si no existe ya una mina en esa posicion, ponerla
			if (mineField[pos] == 0) {
				mineField[pos] = -1;
				nMines++;
			}
		}

		// Rellenar el resto de numeros
		// Si el primer espacio es una mina
		if (mineField[1] == -1)
			mineField[0] = 1;

		// Si el ultimo espacio es una mina
		if (mineField[mineField.length - 2] == -1)
			mineField[mineField.length - 1] = 1;

		// Mirar cuantas minas hay al rededor de cada casilla y colocar el numero en
		// esta
		for (int i = 1; i < mineField.length - 1; i++) {
			surroundingMines = 0;

			// Si la casilla no contiene una mina
			if (mineField[i] != -1) {
				if (mineField[i - 1] == -1)
					surroundingMines++;
				if (mineField[i + 1] == -1)
					surroundingMines++;

				mineField[i] = surroundingMines;
			}
		}
	}

	/**
	 * Imprime el campo de minas entero
	 */
	public void printWholeMineField() {
		String str = "|";
		for (int place : mineField) {
			switch (place) {
			case -1:
				// Mina
				str += "%s%s \u1F4A %s|".formatted(Helper.WHITE, Helper.RED_BACKGROUND, Helper.RESET);
				break;
			case 0:
				str += "%s 0 %s|".formatted(Helper.GREEN, Helper.RESET);
				break;
			case 1:
				str += "%s 1 %s|".formatted(Helper.YELLOW, Helper.RESET);
				break;
			case 2:
				str += "%s 2 %s|".formatted(Helper.RED, Helper.RESET);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + place);
			}
		}

		System.out.println(str);
	}

	/**
	 * Imprime solo las casillas que se conocen del campo de minas
	 */
	public void printKnownMineField() {
		String str = "|";
		for (int i = 0; i < mineField.length; i++) {
			if (knownMineField[i]) {
				switch (mineField[i]) {
				case -1:
					// Mina
					str += "%s%s \u1F4A %s|".formatted(Helper.WHITE, Helper.RED_BACKGROUND, Helper.RESET);
					break;
				case 0:
					str += "%s 0 %s|".formatted(Helper.GREEN, Helper.RESET);
					break;
				case 1:
					str += "%s 1 %s|".formatted(Helper.YELLOW, Helper.RESET);
					break;
				case 2:
					str += "%s 2 %s|".formatted(Helper.RED, Helper.RESET);
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + mineField[i]);
				}
			} else {
				str += " ? |";
			}
		}

		System.out.println(str);
	}

	/**
	 * Mira lo que hay en una casilla. Añade puntuacion si no se encuentra una bomba
	 * 
	 * @param pos Casilla en la que mirar
	 * @return Devuelve lo que hay en la casilla
	 */
	public int checkPos(int pos) {
		if (knownMineField[pos] == false) {
			knownMineField[pos] = true;

			if (mineField[pos] != -1)
				score++;
		}

		return mineField[pos];
	}

	/**
	 * Devuelve puntuacion
	 * 
	 * @return score La puntuacion
	 */
	public int getScore() {
		return score;
	}
}
