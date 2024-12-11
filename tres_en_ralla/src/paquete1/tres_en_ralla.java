package paquete1;

public class tres_en_ralla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("--------------------------");
		System.out.println("-      Tres en raya      -");
		System.out.println("--------------------------");
		
		System.out.println("--- Reglas del juego: ---\n"
			+ "\n"
			+ "El juego preguntará los nombres del jugador 1 y del jugador 2.\n"
			+ "\n"
			+ "Se lanzará una \"moneda\" (se escoge aleatoriamente) para elegir quien empezara primero, el jugador 1 o el jugador 2.\n"
			+ "\n"
			+ "Los dos jugadores irán poniendo las fichas hasta que:\n"
			+ "\n"
			+ "Uno de los dos jugadores haya conseguido poner 3 fichas en línea, ya sea horizontalmente, verticalmente o diagonalmente.\n"
			+ "\n"
			+ "Haya un empate debido a que no quedan mas huecos libres en el tablero.\n"
			+ "\n"
			+ "Cuando termina el juego se preguntara si quieren echar la revancha o finalizar el juego."
			+ "\n");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
				
		String[][] tablero = new String[3][3];
		
		// Inicializamos el tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = " "; // Casillas vacías
            }
        }
	}

}
