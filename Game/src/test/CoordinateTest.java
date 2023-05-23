package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import procedimientos.Coordinate;

class CoordinateTest {

	Coordinate Coordinate1 = new Coordinate(1,1);
	Coordinate Coordinate2 = new Coordinate(-1,-1);
	Coordinate Coordinate3 = new Coordinate(1,-1);
	Coordinate Coordinate4 = new Coordinate(-1,1);
	
	
	@Test
	void testCoordinateBien() {
		Coordinate Coordinate1 = new Coordinate(1,1);
		
		assertEquals(Coordinate1.getX(), 1);
		assertEquals(Coordinate1.getY(), 1);
		assertNotEquals(Coordinate1.getX(), 5);
		assertNotEquals(Coordinate1.getY(), 5);
	}

	@Test
	void testCoordinateMal() {
		Coordinate Coordinate1 = new Coordinate(10000,10000);
		
		assertEquals(Coordinate1.getX(), 0);
		assertEquals(Coordinate1.getY(), 0);
		assertNotEquals(Coordinate1.getX(), 5);
		assertNotEquals(Coordinate1.getY(), 5);
	}

	@Test
	void testMoverAbajoOK() {
		Coordinate Coordinate1 = new Coordinate(1,8);
		assertEquals(Coordinate1.moverAbajo(), true);
		
	}

	@Test
	void testMoverAbajoKO() {
		Coordinate Coordinate1 = new Coordinate(1,9);
		assertEquals(Coordinate1.moverAbajo(), false);
		
	}

	@Test
	void testMoverArribaOK() {
		Coordinate Coordinate1 = new Coordinate(8,1);
		assertEquals(Coordinate1.moverArriba(), true);
		
	}
	
	@Test
	void testMoverArribaKO() {
		Coordinate Coordinate1 = new Coordinate(1,0);
		assertEquals(Coordinate1.moverArriba(), false);
		
	}
	@Test
	void testMoverDerechaOK() {
		Coordinate Coordinate1 = new Coordinate(1,0);
		assertEquals(Coordinate1.moverDerecha(), true);
		
	}

	@Test
	void testMoverDerechaKO() {
		Coordinate Coordinate1 = new Coordinate(9,0);
		assertEquals(Coordinate1.moverDerecha(), false);
		
	}
	@Test
	void testMoverIzquierdaOK() {
		Coordinate Coordinate1 = new Coordinate(9,0);
		assertEquals(Coordinate1.moverIzquierda(), true);
		
	}

	@Test
	void testMoverIzquierdaKO() {
		Coordinate Coordinate1 = new Coordinate(0,9);
		assertEquals(Coordinate1.moverIzquierda(), false);
		
	}
}

