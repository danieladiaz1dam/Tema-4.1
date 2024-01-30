package ejercicio01;

class Pos {
	// Coordenada horizontal
	int x;
	// Coordenada vertical
	int y;

	/**
	 * Constructor vacio
	 */
	public Pos() {
	}

	/**
	 * Constructor que toma las coordenadas x e y como parámetros y las asigna a la
	 * instancia de la clase.
	 * 
	 * @param x Coordenada horizontal.
	 * @param y Coordenada vertical.
	 */
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	 /**
     * Compara si esta posición es igual a otra posición dada.
     * 
     * @param otherPos Otra posición a comparar.
     * @return true si las coordenadas son iguales, false de lo contrario.
     */
	public boolean equals(Pos otherPos) {
		return x == otherPos.x && y == otherPos.y;
	}

	 /**
     * Compara si esta posición es igual a unas coordenadas dadas.
     * 
     * @param x Coordenada horizontal a comparar.
     * @param y Coordenada vertical a comparar.
     * @return true si las coordenadas son iguales, false de lo contrario.
     */
	public boolean equals(int x, int y) {
		return this.x == x && this.y == y;
	}
}

public class Mosca {
	// Colores
	final String BLUE = "\u001b[36m";
	final String RED = "\u001b[31m";
	final String RESET = "\u001b[0m";

	// Tamaño base del tablero
	final int BASE_BOARD_SIZE = 4;
	// Tablero
	int board[];
	// Posicion del jugador
	Pos playerPos;
	// Posicion de la mosca
	Pos flyPos;
	// Dificultad
	int difficulty;

	/**
	 * Constructor vacío
	 */
	public Mosca() {
		// Dificultad normal
		this.difficulty = 1;
		board = new int[BASE_BOARD_SIZE * BASE_BOARD_SIZE];
	}

	/** 
	 * Constructor
	 * 
	 * @param difficulty dificultad del juego, entro 0 y 2
	 */
	public Mosca(int difficulty) {
		// Si la dificultad no esta entre 0 y 2, resetearla a 1
		if (difficulty < 0 || difficulty > 2) {
			System.out.printf("%sDificultad inválida, se cambiara a Normal.%s\n", RED, RESET);
			this.difficulty = 1;
		}
		else
			this.difficulty = difficulty;

		// Hacer un tablero 2D con el tamaño especificado
		board = new int[(BASE_BOARD_SIZE + this.difficulty) * (BASE_BOARD_SIZE + this.difficulty)];

		// Generar posicion de la mosca
		spawnFly();

		// Inicializar jugador fuera del tablero
		playerPos = new Pos(-2, -2);
	}

	/**
	 * Genera la mosca
	 */
	void spawnFly() {
		flyPos = new Pos();
		flyPos.x = (int) (Math.random() * (BASE_BOARD_SIZE + difficulty));
		flyPos.y = (int) (Math.random() * (BASE_BOARD_SIZE + difficulty));
	}

	/**
	 * Imprime el tablero con la posicion del jugador
	 */
	public void printBoard() {
		System.out.printf("Tablero: \n");
		// Imprimir tablero
		for (int i = 0; i < BASE_BOARD_SIZE + difficulty; i++) {
			for (int j = 0; j < BASE_BOARD_SIZE + difficulty; j++) {

				// Imprimir Jugador
				if (playerPos.x == j && playerPos.y == i)
					System.out.printf("[%s★%s]", BLUE, RESET);

				// Imprimir Mosca
				// else if (flyPos.x == j && flyPos.y == i) System.out.printf("[%s★%s]", RED, RESET);

				// Imprimir Casilla
				else
					System.out.printf("[ ]");
			}

			System.out.println();
		}
	}

	/**
	 * Mueve el jugador
	 * 
	 * @param x Posicion horizontal
	 * @param y Posicion vertical
	 * @return true si se ha movido, false si la posicion es fuera del tablero
	 */
	public boolean movePlayer(Pos newPos) {
		// Si esta fuera del tablero
		if (newPos.x < 0 || newPos.y < 0)
			return false;

		// Si esta fuera del tablero
		if (newPos.x >= BASE_BOARD_SIZE + difficulty || newPos.y >= BASE_BOARD_SIZE + difficulty)
			return false;

		// Si esta dentro
		playerPos = newPos;
		return true;
	}

	/**
	 * Mueve la mosca si es nacesario
	 * @return true si se ha movido, false en caso contrario
	 */
	public boolean moveMosca() {
		if (
				playerPos.equals(flyPos.x - 1, flyPos.y - 1) ||
				playerPos.equals(flyPos.x, flyPos.y - 1) 	 ||
				playerPos.equals(flyPos.x + 1, flyPos.y - 1) ||
				playerPos.equals(flyPos.x - 1, flyPos.y) 	 ||
			//	playerPos.equals(flyPos.x, flyPos.y)         ||
				playerPos.equals(flyPos.x + 1, flyPos.y) 	 ||
				playerPos.equals(flyPos.x - 1, flyPos.y + 1) ||
				playerPos.equals(flyPos.x, flyPos.y + 1) 	 ||
				playerPos.equals(flyPos.x + 1, flyPos.y + 1)
		) {
			spawnFly();
			return true;
			
		} else	
			return false;
	}
	
	/**
	 * Comprobar si se ha ganado el juego
	 * @return true si se ha ganado, false en caso contrario
	 */
	public boolean win() {
		return playerPos.equals(flyPos);
	}
}
