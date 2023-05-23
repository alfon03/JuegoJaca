package procedimientos;

/**

Enumerado que almacena el tipo de jugadores que nos podemos encontrar en el tablero.
Se define la fuerza, la magia y la velocidad para cada uno de los jugadores.
*/
import logica.Constans;

public enum PlayerType {
	ELFO(Constans.ELFO_FUERZA, Constans.ELFO_MAGIA, Constans.ELFO_VELOCIDAD),
	GUERRERO(Constans.GUERRERO_FUERZA, Constans.GUERRERO_MAGIA, Constans.GUERRERO_VELOCIDAD),
	MAGO(Constans.MAGO_FUERZA, Constans.MAGO_MAGIA, Constans.MAGO_VELOCIDAD),
	OGRO(Constans.OGRO_FUERZA, Constans.OGRO_MAGIA, Constans.OGRO_VELOCIDAD);

	private int fuerza;
	private int magia;
	private int velocidad;

	/**
	 * Constructor de PlayerType.
	 * 
	 * @param fuerza    Valor de la fuerza del jugador.
	 * @param magia     Valor de la magia del jugador.
	 * @param velocidad Valor de la velocidad del jugador.
	 */
	private PlayerType(int fuerza, int magia, int velocidad) {
		this.fuerza = fuerza;
		this.magia = magia;
		this.velocidad = velocidad;
	}

	/**
	 * Obtiene el valor de la fuerza del jugador.
	 * 
	 * @return Valor de la fuerza del jugador.
	 */
	public int getFuerza() {
		return fuerza;
	}

	/**
	 * Obtiene el valor de la magia del jugador.
	 * 
	 * @return Valor de la magia del jugador.
	 */
	public int getMagia() {
		return magia;
	}

	/**
	 * Obtiene el valor de la velocidad del jugador.
	 * 
	 * @return Valor de la velocidad del jugador.
	 */
	public int getVelocidad() {
		return velocidad;
	}
}