package procedimientos;

import java.util.Random;

import logica.Constans;

/**
 * Clase que representa a un jugador en el juego.
 */
public class Player extends Element {

	// Atributos
	private int dinero;
	private int pociones;
	private int gemas;
	private PlayerType jugador;
	private Random random = new Random();

	/**
	 * Constructor de Jugador.
	 *
	 * @param jugador Tipo de jugador
	 */
	public Player(PlayerType jugador) {
		super(ElementType.valueOf(jugador.name()));
		this.jugador = jugador;
		this.dinero = 0;
		this.gemas = 0;
		this.pociones = 0;
	}

	/**
	 * Devuelve el nombre del jugador.
	 *
	 * @return Nombre del jugador
	 */
	public String getNombre() {
		return jugador.name();
	}

	/**
	 * Devuelve la fuerza del jugador.
	 *
	 * @return Fuerza del jugador
	 */
	private int getFuerza() {
		return jugador.getFuerza();
	}

	/**
	 * Genera un valor aleatorio de fuerza para la lucha.
	 *
	 * @return Valor de fuerza aleatorio para la lucha
	 */
	public int getFuerzaParaLuchar() {
		return random.nextInt(getFuerza());
	}

	/**
	 * Devuelve la magia del jugador.
	 *
	 * @return Magia del jugador
	 */
	private int getMagia() {
		return jugador.getMagia();
	}

	/**
	 * Genera un valor aleatorio de magia para la lucha.
	 *
	 * @return Valor de magia aleatorio para la lucha
	 */
	public int getMagiaParaLuchar() {
		return random.nextInt(getMagia());
	}

	/**
	 * Devuelve la velocidad del jugador.
	 *
	 * @return Velocidad del jugador
	 */
	private int getVelocidad() {
		return jugador.getVelocidad();
	}

	/**
	 * Genera un valor aleatorio de velocidad para la lucha.
	 *
	 * @return Valor de velocidad aleatorio para la lucha
	 */
	public int getVelocidadParaLuchar() {
		return random.nextInt(getVelocidad());
	}

	/**
	 * Devuelve la cantidad de dinero del jugador.
	 *
	 * @return Cantidad de dinero del jugador
	 */
	public int getDinero() {
		return dinero;
	}

	/**
	 * Establece la cantidad de dinero del jugador.
	 *
	 * @param dinero Cantidad de dinero a establecer
	 * @throws JugadorException Si el dinero es menor que 0
	 */
	public void setDinero(int dinero) throws PlayerException {
		if (dinero < 0) {
			throw new PlayerException("Error. El dinero no puede ser menor que 0");
		} else {
			this.dinero = dinero;
		}
	}

	/**
	 * Devuelve la cantidad de pociones del jugador.
	 *
	 * @return Cantidad de pociones del jugador
	 */
	public int getPociones() {
		return pociones;
	}

	/**
	 * Establece la cantidad de pociones del jugador.
	 *
	 * @param pociones Cantidad de pociones a establecer
	 * @throws JugadorException Si las pociones son negativas
	 */
	public void setPociones(int pociones) throws PlayerException {
		if (pociones < 0) {
			throw new PlayerException("Error. Las pociones no pueden ser negativas");
		} else {
			this.pociones = pociones;
		}
	}

	/**
	 * Devuelve la cantidad de gemas del jugador.
	 *
	 * @return Cantidad de gemas del jugador
	 */
	public int getGemas() {
		return gemas;
	}

	/**
	 * Establece la cantidad de gemas del jugador.
	 *
	 * @param gemas Cantidad de gemas a establecer
	 * @throws JugadorException Si las gemas son negativas
	 */
	public void setGemas(int gemas) throws PlayerException {
		if (gemas < 0) {
			throw new PlayerException("Error. Las gemas no pueden ser negativas");
		} else {
			this.gemas = gemas;
		}
	}

	/**
	 * Devuelve un resumen de los atributos del jugador.
	 *
	 * @return Resumen de los atributos del jugador
	 */
	public String resumen() {
		return "Nombre: " + this.getNombre() + " Gemas: " + this.getGemas() + " Dinero: " + this.getDinero()
				+ " Pociones: " + this.getPociones();
	}

	/**
	 * Devuelve el tipo de jugador.
	 *
	 * @return Tipo de jugador
	 */
	public PlayerType getPlayer() {
		return jugador;
	}

	/**
	 * Incrementa la cantidad de dinero del jugador al encontrar dinero.
	 */
	public void encuentraDinero() {
		this.dinero++;
	}

	/**
	 * Incrementa la cantidad de pociones del jugador al encontrar una poción.
	 */
	public void encuentraPocion() {
		this.pociones++;
	}

	/**
	 * Incrementa la cantidad de gemas del jugador al encontrar una gema.
	 */
	public void encuentraGema() {
		this.gemas++;
	}

	/**
	 * Método que simula una lucha entre dos jugadores. Si la fuerza es igual, el
	 * resultado es un empate. Si el jugador uno tiene una fuerza mayor al jugador
	 * contrario, el contrario puede: - Usar una poción - Perder su dinero Si el
	 * jugador contrario tiene una fuerza mayor al jugador principal, el jugador
	 * principal perderá una poción si tiene y su dinero.
	 *
	 * @param jugadorContrario Jugador contrario con el que se lleva a cabo la lucha
	 * @return Resultado de la lucha
	 * @throws PlayerException
	 */
	public int lucha(Player jugadorContrario) throws PlayerException {
		int resultadoFinal = 0;
		int fuerzaDelJugador = this.getFuerzaParaLuchar();
		int fuerzaDelJugadorContrario = jugadorContrario.getFuerzaParaLuchar();

		if (fuerzaDelJugador == fuerzaDelJugadorContrario) {
			resultadoFinal = Constans.EMPATE;
		} else if (fuerzaDelJugador > fuerzaDelJugadorContrario) {
			if (jugadorContrario.getPociones() > 0) {
				jugadorContrario.pociones--;
				resultadoFinal = Constans.GANA_USA_POCIMA;
			} else if (jugadorContrario.getDinero() > 0) {
				this.dinero += jugadorContrario.getDinero();
				jugadorContrario.setDinero(0);
				resultadoFinal = Constans.GANA_DINERO;
			} else {
				resultadoFinal = Constans.GANA_MUERE;
			}
		} else {
			if (pociones > 0) {
				pociones--;
				resultadoFinal = Constans.PIERDE_USA_POCIMA;
			} else if (dinero > 0) {
				jugadorContrario.setDinero(jugadorContrario.getDinero() + this.getDinero());
				this.setDinero(0);
				resultadoFinal = Constans.PIERDE_DINERO;
			} else {
				resultadoFinal = Constans.PIERDE_MUERE;
			}
		}

		return resultadoFinal;
	}

	/**
	 * Método que simula el encuentro con una roca en el camino. Si el jugador tiene
	 * gemas, puede romper la roca y perderá una gema. Si el jugador tiene una magia
	 * superior a 4, romperá el obstáculo, de lo contrario perderá y no podrá
	 * avanzar.
	 *
	 * @return Resultado del encuentro con la roca
	 */
	public int encuentraRoca() {
		int resultadoFinal = 0;

		if (this.gemas > 0) {
			resultadoFinal = Constans.ROMPE_ROCA_CON_GEMA;
			this.gemas--;
		} else {
			if (this.getMagia() > 4) {
				resultadoFinal = Constans.GANA_A_LA_ROCA;
			} else {
				resultadoFinal = Constans.PIERDE_A_LA_ROCA;
			}
		}

		return resultadoFinal;
	}

}