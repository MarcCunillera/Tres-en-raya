package paquete1;

import java.util.Random;
import java.util.Scanner;

public class tres_en_ralla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("--------------------------");
		System.out.println("-      Tres en raya      -");
		System.out.println("--------------------------");
		
		Scanner sc = new Scanner(System.in);
		Random aleatorio = new Random();
		
		String[][] tablero = new String[3][3];
		String jugador1, jugador2, turno;
		
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
				
		// Inicializamos el tablero
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = " "; // Casillas vacías
            }
        }
        
//      Pedimos por pantalla el nombre de los jugadores
		System.out.println("Inserta el nombre del jugador 1:");
		jugador1 = sc.next();
		
		System.out.println("Inserta el nombre del jugador 2:");
		jugador2 = sc.next();
		
//		Da aleatoriamente el jugador que empieza a tirar en la partida
		if (aleatorio.nextInt(2) == 0) {
            turno = jugador1;
            System.out.println(jugador1 + " empieza.");
        } else {
            turno = jugador2;
            System.out.println(jugador2 + " empieza.");
        }
	}

}
