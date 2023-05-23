package main;

import java.util.ArrayList;
import java.util.Scanner;

import procedimientos.*;
import logica.*;

public class MainGame {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) throws GameException, PlayerException {

		try {

			// Crear lista de jugadores disponibles
			ArrayList<PlayerType> jugadores = new ArrayList<>();
			jugadores.add(PlayerType.ELFO);
			jugadores.add(PlayerType.GUERRERO);
			jugadores.add(PlayerType.MAGO);
			jugadores.add(PlayerType.OGRO);

			PlayerType[] ordenJugadores = new PlayerType[Constans.NUM_JUGADORES];

			/**
			 * Seleccionar qué jugador va a ser cada uno, sin permitir jugadores repetidos
			 */
			int numJugadores = 0;
			while (numJugadores < Constans.NUM_JUGADORES - 1) {
				System.out.print("Elija el tipo de jugador: ");
				int i = 1;
				for (PlayerType tipo : jugadores) {
					System.out.print(" (" + i++ + ")" + tipo.name());
				}
				System.out.println(":");

				int tipo = Integer.parseInt(teclado.nextLine());
				if (tipo >= 1 && tipo <= jugadores.size()) {
					ordenJugadores[numJugadores++] = jugadores.get(tipo - 1);
					jugadores.remove(tipo - 1);
				} else {
					System.out.println("Tipo no permitido. Inténtelo de nuevo");
				}
			}
			ordenJugadores[numJugadores] = jugadores.get(0);
			Game game = new Game(ordenJugadores);

			System.out.println(game);
			System.out.println(game.imprimeNombrePlayeres());
			System.out.println(game.imprimeNombrePlayeres());

			while (!game.isTerminado()) {
				// Lanzar el dado
				game.setDado();
				System.out.println("Le toca al jugador " + game.getNombrePlayerQueJuega() + ". El dado saca "
						+ game.getValorDado() + " movimientos");

				for (int i = 0; i < game.getValorDado() && !game.isTerminado(); i++) {
					char direccion;
					do {
						System.out.println("Indique a dónde desea moverse: N: Norte, S: Sur, E: Este u O: Oeste");
						direccion = Character.toUpperCase(teclado.nextLine().charAt(0));
					} while (direccion != 'N' && direccion != 'S' && direccion != 'E' && direccion != 'O');

					System.out.println(game.movePlayer(direccion));

					System.out.println(game);
					System.out.println(game.imprimeNombrePlayeres());
				}

				game.proximoPlayer();
			}

			System.out.println("Juego terminado. El ganador es el: " + game.getNombrePlayerQueJuega());

		} catch (GameException e) {
			System.out.println(e.getMessage());
		}

	}
}
