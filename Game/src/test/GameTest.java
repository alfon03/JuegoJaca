package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.Assert.*;
import org.junit.Before;

import procedimientos.*;
import logica.*;

class GameTest {

	@Test
	void testImprimeNombresJugadoresOK() {
		PlayerType[] jugadores = { PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO };
		Game Game = new Game(jugadores);
		assertEquals("El tipo del jugador es: ELFO y es el jugador numero: 1\n"
				+ "El tipo del jugador es: GUERRERO y es el jugador numero: 2\n"
				+ "El tipo del jugador es: MAGO y es el jugador numero: 3\n"
				+ "El tipo del jugador es: OGRO y es el jugador numero: 4\n", Game.imprimeNombrePlayeres());}

	/**
	 * Debe darnos mal por que el jugador 1 y el 3 son el mismo tipo, al dar mal y
	 * estar formulado con assertNotEquals, es correcto nuestro test.
	 */
	@Test
	void testImprimeNombresJugadoresKO() {
		PlayerType[] jugadores = { PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO };
		Game Game = new Game(jugadores);
		assertNotEquals("El tipo del jugador es: MAGO y es el jugador numero: 1\n"
				+ "El tipo del jugador es: GUERRERO y es el jugador numero: 2\n"
				+ "El tipo del jugador es: MAGO y es el jugador numero: 3\n"
				+ "El tipo del jugador es: OGRO y es el jugador numero: 4\n", Game.imprimeNombrePlayeres());
	}

	@Test
	void testImprimeValoresJugadoresOK() {
		PlayerType[] jugadores = { PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO };
		Game Game = new Game(jugadores);
		assertEquals("Jugador numero: 1 Dinero: 0 Gemas: 0 Pociones: 0\n"
				+ "Jugador numero: 2 Dinero: 0 Gemas: 0 Pociones: 0\n"
				+ "Jugador numero: 3 Dinero: 0 Gemas: 0 Pociones: 0\n"
				+ "Jugador numero: 4 Dinero: 0 Gemas: 0 Pociones: 0\n", Game.imprimeValoresPlayeres());}

	/**
	 * Pues nos debe de dar bien el test porque esta formulado con un
	 * assertNotEquals y los personajes aparecen con 0 objetos no con 1 objetos
	 * gemas por ejemplo.
	 */
	@Test
	void testImprimeValoresJugadoresKO() {
		PlayerType[] jugadores = { PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO };
		Game Game = new Game(jugadores);
		assertNotEquals("Jugador numero: 1 Dinero: 1 Gemas: 0 Pociones: 0\n"
				+ "Jugador numero: 2 Dinero: 1 Gemas: 0 Pociones: 0\n"
				+ "Jugador numero: 3 Dinero: 1 Gemas: 0 Pociones: 0\n"
				+ "Jugador numero: 4 Dinero: 1 Gemas: 0 Pociones: 0\n", Game.imprimeValoresPlayeres());
	}

	/**
	 * Nos dirá el ultimo jugador en crear que es OGRO.
	 */
	@Test
	void testJugadorUltimaPosicionOK() {
		PlayerType[] jugadores = { PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO };
		Game Game = new Game(jugadores);
		Game.proximoPlayer();
		Game.proximoPlayer();
		Game.proximoPlayer();

		assertEquals("OGRO", Game.getNombrePlayerQueJuega());
	}

	/**
	 * Nos dirá el ultimo jugador en crear que es OGRO, al formularlo con un
	 * assertNotEquals, el test funcionará correctamente.
	 */
	@Test
	void testJugadorUltimaPosicionKO() {
		PlayerType[] jugadores = { PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO };
		Game Game = new Game(jugadores);
		Game.proximoPlayer();
		Game.proximoPlayer();
		Game.proximoPlayer();

		assertNotEquals("MAGO", Game.getNombrePlayerQueJuega());
	}

	@Test
	void testJugadorPrimeraPosicionOK() {
		PlayerType[] jugadores = { PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO };
		Game Game = new Game(jugadores);

		assertEquals("ELFO", Game.getNombrePlayerQueJuega());
	}

	/**
	 * El test es correcto puesto que el primero es ELFO, no MAGO.
	 */
	@Test
	void testJugadorUltimaPrimeraPosicionKO() {
		PlayerType[] jugadores = { PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO };
		Game Game = new Game(jugadores);
		Game.proximoPlayer();

		assertNotEquals("MAGO", Game.getNombrePlayerQueJuega());
	}

	@Test
	void testValorDadoCorrecto() {
		PlayerType[] jugadores = { PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO };
		Game Game = new Game(jugadores);
		Game.setDado();
		assertTrue(Game.getValorDado() >= 1 && Game.getValorDado() <= Constans.ELFO_VELOCIDAD);}

	@Test
	void testDecrementacionDado() {
		PlayerType[] jugadores = { PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO };
		Game Game = new Game(jugadores);
		Game.setDado();
		int dado = Game.getValorDado();
		Game.decrementaDado();
		assertEquals(dado - 1, Game.getValorDado());
	}


	@Test
    void testGetNextPosition() {
        // Arrange
		PlayerType[] jugadores = { PlayerType.ELFO, PlayerType.GUERRERO, PlayerType.MAGO, PlayerType.OGRO };
		Game game = new Game(jugadores);        char direccion = 'N';
        Coordinate expectedCoordinate = new Coordinate(0, 1); // Asigna aquí el valor esperado de la coordenada
        
        // Act
        Coordinate actualCoordinate;
        actualCoordinate = game.obtenerCoordinatePlayerJuega();
		
		// Assert
		Assertions.assertNotEquals(expectedCoordinate, actualCoordinate, "Las coordenadas no coinciden.");
    }

}


