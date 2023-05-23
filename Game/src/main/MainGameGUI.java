package main;

import java.util.ArrayList;
import java.util.Scanner;

import procedimientos.*;
import logica.GameGUI;
import logica.GameException;
import logica.Constans;


public class MainGameGUI {

	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		try {
			
			ArrayList<PlayerType> jugadores = new ArrayList<>();
			jugadores.add(PlayerType.ELFO);
			jugadores.add(PlayerType.GUERRERO);
			jugadores.add(PlayerType.MAGO);
			jugadores.add(PlayerType.OGRO);
			
			PlayerType[] ordenJugadores = new PlayerType[Constans.NUM_JUGADORES];
			
			/**
			 * Hay que elegir qué jugador va a ser cada uno, pero no se permiten jugadores repetidos
			 */
			int numJugadores =0;
			while (numJugadores < Constans.NUM_JUGADORES - 1 ) {
				System.out.print("Elija el tipo de jugador: ");
				int i =1;
				for (PlayerType tipo :jugadores) {
					System.out.print(" (" + i++ + ")" + tipo.name());
				}
				System.out.println(":");

				int tipo = Integer.parseInt(scanner.nextLine());
				if (tipo >=1 && tipo < jugadores.size()) {
					ordenJugadores[numJugadores++]= jugadores.get(tipo-1);
					jugadores.remove(tipo-1);
				}else {
					System.out.println("Tipo no permitido. Inténtelo de nuevo");
				}
				
			}
			ordenJugadores[numJugadores] = jugadores.get(0);
			GameGUI juego = new GameGUI(ordenJugadores);	
						
		}catch (GameException e) {
			System.out.println(e.getMessage());
		}

	}

}