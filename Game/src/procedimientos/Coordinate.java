package procedimientos;

import java.util.Objects;
import java.util.Random;

import logica.Constans;

public class Coordinate {

	private int x;
	private int y;

	/**
	 * Constructor que genera una Coordinate aleatoria dentro de los límites del
	 * tablero.
	 */
	public Coordinate() {
		super();
		Random random = new Random();
		this.x = random.nextInt(Constans.TAMANNO);
		this.y = random.nextInt(Constans.TAMANNO);
	}

	/**
	 * Constructor que crea una Coordinate con valores específicos, si están dentro
	 * de los límites del tablero. Si los valores están fuera de los límites, se
	 * establece la Coordinate en (0, 0).
	 *
	 * @param x El valor de la Coordinate x.
	 * @param y El valor de la Coordinate y.
	 */
	public Coordinate(int x, int y) {
		super();
		if (x >= 0 && x <= Constans.TAMANNO - 1 && y >= 0 && y <= Constans.TAMANNO - 1) {
			this.x = x;
			this.y = y;
		} else {
			this.x = 0;
			this.y = 0;
		}
	}

	/**
	 * Obtiene el valor de la Coordinate x.
	 *
	 * @return El valor de la Coordinate x.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Obtiene el valor de la Coordinate y.
	 *
	 * @return El valor de la Coordinate y.
	 */
	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "Coordinate x = " + x + ", Coordinate y = " + y + "";
	}

	/**
	 * Mueve la Coordinate hacia la derecha. Si está en el borde del tablero,
	 * devuelve false.
	 *
	 * @return true si la Coordinate se movió hacia la derecha, false de lo
	 *         contrario.
	 */
	public boolean moverDerecha() {
		if (x == Constans.TAMANNO - 1) {
			return false;
		} else {
			x++;
			return true;
		}
	}

	/**
	 * Mueve la Coordinate hacia la izquierda. Si está en el borde izquierdo,
	 * devuelve false.
	 *
	 * @return true si la Coordinate se movió hacia la izquierda, false de lo
	 *         contrario.
	 */
	public boolean moverIzquierda() {
		if (x == 0) {
			return false;
		} else {
			x--;
			return true;
		}
	}

	/**
	 * Mueve la Coordinate hacia arriba. Si está en el borde del tablero, devuelve
	 * false.
	 *
	 * @return true si la Coordinate se movió hacia arriba, false de lo contrario.
	 */
	public boolean moverArriba() {
		if (y == 0) {
			return false;
		} else {
			y--;
			return true;
		}
	}

	/**
	 * Mueve la Coordinate hacia abajo. Si está en el borde del tablero, devuelve
	 * false.
	 *
	 * @return true si la Coordinate se movió hacia abajo, false de lo contrario.
	 */
	public boolean moverAbajo() {
		if (y == Constans.TAMANNO - 1) {
			return false;
		} else {
			y++;
			return true;
		}
	}

	@Override
	public Coordinate clone() throws CloneNotSupportedException {
		return new Coordinate(this.x, this.y);
	}
}