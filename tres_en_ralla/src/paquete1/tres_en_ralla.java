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
		System.out.println("Nombre del jugador 1:");
		jugador1 = sc.next();
		
		System.out.println("Nombre del jugador 2:");
		jugador2 = sc.next();
		
//		Da aleatoriamente el jugador que empieza a tirar en la partida
		if (aleatorio.nextInt(2) == 0) {
            turno = jugador1;
            System.out.println(jugador1 + " empieza.");
        } else {
            turno = jugador2;
            System.out.println(jugador2 + " empieza.");
        }
		
		// Variables para controlar el juego
        boolean juegoTerminado = false; // Indica si el juego a terminado
        int movimientos = 0; // Creamos un contador de movimientos
        
        //Hacemos un bucle para mostrar el tablero
        while (!juegoTerminado) { //Hacemos un bucle while
            // Mostrar el tablero 
            System.out.println();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(" " + tablero[i][j] + " "); // MOstramos las csillas del tablero 
                    if (j < 2) System.out.print("|"); // Ponemos los separadores verticales para separar las casillas
                }
                System.out.println();
                if (i < 2) System.out.println("---+---+---"); // Ponemos los separadores horizontales para separar las casillas
            }
            System.out.println();
            
            // Determinar la ficha del jugador actual
            String ficha = turno.equals(jugador1) ? "X" : "O"; 
            
            // Informar al jugador de su ficha
            System.out.println(turno + ", es tu turno. Juegas con la ficha " + ficha + ". Elige una fila y una columna (1-3):"); // Printamos esto por pantalla 
            
            // Pedimos al jugador que haga un movimiento
            int fila = sc.nextInt() - 1; // lee la fila y convierte a indice de array
            int columna = sc.nextInt() - 1; // lee la columna y convierte a indice de array
            
            // Comprobamos si la posición que ha dado es válida
            if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3 || !tablero[fila][columna].equals(" ")) {
                System.out.println("Movimiento erroneo, intentalo de nuevo."); // sino es valida sale el mensaje de error y buelve al principio
                continue; // Si es valida volvemos al principio del bucle
            }
            
            // Ponemos la ficha en el tablero
            tablero[fila][columna] = turno.equals(jugador1) ? "X" : "O"; // Asignar "X" o "O" dependiendo del jugador 
            movimientos++; // Incrementamos contador de movimientos
            
            // Comprobamos si hay un ganador
            boolean ganador = false; // Esta variable indicar si hay un ganador
            for (int i = 0; i < 3; i++) {
                if (tablero[i][0].equals(tablero[i][1]) && tablero[i][1].equals(tablero[i][2]) && !tablero[i][0].equals(" ") || 
                    tablero[0][i].equals(tablero[1][i]) && tablero[1][i].equals(tablero[2][i]) && !tablero[0][i].equals(" ")) {
                    ganador = true; // Abra un ganador si se cumple alguna condición de fila o columna
                    break; //Sale del bucle
                }
            }
            // Comprobamos la diagonal
            if (tablero[0][0].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][2]) && !tablero[0][0].equals(" ") || 
	            tablero[0][2].equals(tablero[1][1]) && tablero[1][1].equals(tablero[2][0]) && !tablero[0][2].equals(" ")) {
            		ganador = true; // Este if sirve para ver si se cumple alguna condición en diagonal
            }
	         
            // Mostrar el tablero final si hay un ganador
            if (ganador) {
                System.out.println("¡" + turno + " ha ganado!");
                System.out.println();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print(" " + tablero[i][j] + " "); // Muestra la casilla
                        if (j < 2) System.out.print("|"); // Muestra los separadores verticales
                    }
                    System.out.println();
                    if (i < 2) System.out.println("---+---+---"); // Muestra los separadores horizontales
                }
                System.out.println();
                juegoTerminado = true; // Terminar el juego
            }
            
            // Comproba si hay empate en la partida
            if (movimientos == 9 && !ganador) {
                System.out.println("¡Han quedado empate!"); // Muestra este mensaje si hay un enpate
                juegoTerminado = true; // Termina el juego
            }
            
            // Cambiar de turno mientras no se haya terminado el juego
            if (!juegoTerminado) { // Este if verifica que mientras no se haya terminado el juego canvie al siguiente jugador
                turno = turno.equals(jugador1) ? jugador2 : jugador1; // Alternar el turno de los juagadores
            }
        } 
        
        // Preguntar al jugador rival si vol tornar a jugar
        System.out.print("¿Quieren jugar otra partida? (s/n): ");
        char revancha = sc.next().charAt(0); // Lee la decisión del jugador rival
        if (revancha == 's') {
            // Reinicia el tablero y el juego
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    tablero[i][j] = " "; // Vacia las casillas
                }
            }
            movimientos = 0; // Reiniciar contador de movimientos
            juegoTerminado = false; // Reiniciar estado del juego
            main(args); // Reinicia el juego desde el principio.
        } else {
            System.out.println("Gracias por jugar. ¡Hasta la próxima!"); // Printara este mensaje por pantalla si no queremos jugar mas.
        }
	}		
}


