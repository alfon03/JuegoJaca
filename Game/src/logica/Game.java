package logica;

import java.util.ArrayList;
import java.util.HashMap;

import procedimientos.*;

public class Game {

	private HashMap<Coordinate, Element> tablero;
	private ArrayList<Coordinate> CoordinatePlayeres;
	private int PlayerJuega;
	private int dado;

	/**
	 * Constructor Que crea un tablero y añade los Playeres en base a la constante,
	 * llamando al metodo crearPlayeres.
	 * 
	 * @param personaje
	 */
	public Game(PlayerType[] personaje) {
		super();
		int contador = 0;
		setCoordinatePlayeres(new ArrayList<>());
		setTablero(new HashMap<>());
		crearTablero();
		while (contador < Constans.NUM_JUGADORES) {
			if (crearPlayer(personaje[contador])) {
				contador++;
			}
		}

	}

	/**
	 * Constructor que crea un tablero y añade los jugadores en base a una lista de
	 * tipos de jugadores, invocando al método crearJugadores.
	 * 
	 * @param tiposJugadores Una lista de tipos de jugadores.
	 */
	private boolean crearPlayer(PlayerType tipo) {
		boolean crear = false;
		Player Player = new Player(tipo);
		Coordinate Coordinate = new Coordinate();
		while (getCoordinatePlayeres().contains(Coordinate)) {
			Coordinate = new Coordinate();
		}
		if (this.getTablero().get(Coordinate) == null) {
			getCoordinatePlayeres().add(Coordinate);
			getTablero().put(Coordinate, Player);
			crear = true;
		}

		return crear;
	}

	/**
	 * Creo el tablero con los metodos creardinero, creargemas, crearpociones,
	 * crearrocas. Todos los elementos menos los Playeres
	 */
	private void crearTablero() {
		crearDinero();
		crearGemas();
		crearPociones();
		crearRocas();
	}

	/**
	 * Método utilizado para crear rocas en el juego. El límite de creación está
	 * determinado por la constante NUM_ROCAS. En este método, se crea una
	 * coordenada y un elemento de tipo Roca. Luego se verifica en el mapa (tablero)
	 * si el valor correspondiente a la coordenada es nulo, lo que indica que hay
	 * espacio disponible para crear la roca. En ese caso, se agrega la coordenada y
	 * el elemento (roca) al tablero, y se incrementa el contador de rocas creadas.
	 */
	private void crearRocas() {
		int contador = 0;
		while (contador < Constans.NUM_ROCAS) {
			Coordinate coor1 = new Coordinate();
			Element e = new Element(ElementType.ROCA);
			if (getTablero().get(coor1) == null) {
				this.getTablero().put(coor1, e);
				contador++;
			}

		}
	}

	/**
	 * Metodo que sirve para crear gemas con el limite de la constante NUM DINERO.
	 * crea tipos de elemento DINERO, se crea una Coordinate generada aleatoria, y
	 * se comprueba que el valor de esa Coordinate en el tablero esta vacia, osea es
	 * null, si es null pues en dicha casilla le inserta el elemento.
	 */
	private void crearDinero() {
		int contador = 0;
		while (contador < Constans.NUM_DINERO) {
			Coordinate Coordinate = new Coordinate();
			Element elemento = new Element(ElementType.DINERO);
			if (getTablero().get(Coordinate) == null) {
				this.getTablero().put(Coordinate, elemento);
				contador++;
			}

		}

	}

	/**
	 * Método que devuelve el elemento que se encuentra en la coordenada
	 * especificada.
	 * 
	 * @param coord La coordenada de la cual se desea obtener el elemento.
	 * @return El elemento presente en la coordenada especificada.
	 */
	public Element obtenerElementoTablero(Coordinate coord) {
		return this.getTablero().get(coord);
	}

	/**
	 * Método utilizado para obtener la coordenada del jugador que está jugando
	 * actualmente.
	 * 
	 * @return La coordenada del jugador que está jugando en este momento.
	 */
	public Coordinate obtenerCoordinatePlayerJuega() {
		return this.getCoordinatePlayeres().get(PlayerJuega);
	}

	/**
	 * Metodo que sirve para crear gemas con el limite de la constante NUM GEMA.
	 * crea tipos de elemento GEMA, se crea una Coordinate generada aleatoria, y se
	 * comprueba que el valor de esa Coordinate en el tablero esta vacia, osea es
	 * null, si es null pues en dicha casilla le inserta el elemento.
	 */
	private void crearGemas() {
		int contador = 0;
		while (contador < Constans.NUM_GEMAS) {
			Coordinate coor1 = new Coordinate();
			Element e = new Element(ElementType.GEMA);
			if (getTablero().get(coor1) == null) {
				this.getTablero().put(coor1, e);
				contador++;
			}

		}
	}

	/**
	 * Método utilizado para crear gemas en el juego. El límite de creación está
	 * determinado por la constante NUM_GEMAS. En este método, se crean elementos de
	 * tipo GEMA y se generan coordenadas aleatorias. Luego se verifica en el
	 * tablero si la coordenada correspondiente está vacía, es decir, si su valor es
	 * nulo. Si la coordenada está disponible, se inserta el elemento (gema) en esa
	 * casilla del tablero y se incrementa el contador de gemas creadas.
	 */
	private void crearPociones() {
		int contador = 0;
		while (contador < Constans.NUM_POCIONES) {
			Coordinate coor1 = new Coordinate();
			Element e = new Element(ElementType.POCION);
			if (getTablero().get(coor1) == null) {
				this.getTablero().put(coor1, e);
				contador++;
			}

		}
	}

	/**
	 * Método utilizado para determinar si el juego ha terminado. El juego
	 * finalizará cuando solo quede un jugador o cuando un jugador tenga todo el
	 * dinero del juego.
	 * 
	 * @return true si el juego ha terminado, false en caso contrario.
	 */
	public boolean isTerminado() {
		boolean terminar = false;
		boolean dinero = false;
		for (Element elemento : this.getTablero().values()) {
			if (elemento instanceof Player) {
				if (((Player) elemento).getDinero() == Constans.DINERO) {
					dinero = true;
				}
			}
		}
		if (this.getCoordinatePlayeres().size() == 1 || dinero) {
			terminar = true;
		}
		return terminar;
	}

	/**
	 * Método utilizado para eliminar a un jugador. Recibe una coordenada como
	 * parámetro y elimina tanto la coordenada de la lista CoordinatePlayeres como
	 * del tablero.
	 * 
	 * @param coordenada La coordenada del jugador que se desea eliminar.
	 */
	private void eliminarPlayer(Coordinate Coordinate) {
		this.getCoordinatePlayeres().remove(Coordinate);
		this.getTablero().remove(Coordinate);
	}

	/**
	 * Método que imprime el nombre de los jugadores en el tablero y devuelve una
	 * cadena con el nombre del jugador junto con un número del 1 al 4 para
	 * identificarlos.
	 * 
	 * @return Una cadena con el nombre de los jugadores y su número
	 *         correspondiente.
	 */
	public String imprimeNombrePlayeres() {
		int contador = 1;
		StringBuilder sb = new StringBuilder();

		for (Coordinate Coordinate : this.getCoordinatePlayeres()) {
			Player Playeres = (Player) getTablero().get(Coordinate);
			sb.append("El tipo del Player es: " + Playeres.getNombre() + " y es el Player numero: " + contador + "\n");
			contador++;
		}
		return sb.toString();
	}

	/**
	 * 
	 * Método que devuelve el valor del dado.
	 * 
	 * @return El valor actual del dado.
	 */
	public int getValorDado() {
		return dado;
	}

	/**
	 * Método que decrementa el valor del dado.
	 * 
	 * @return El nuevo valor del dado después de la decrementación.
	 */
	public int decrementaDado() {
		return this.dado--;
	}

	/**
	 * Método utilizado para asignar el valor del dado correspondiente a los
	 * movimientos que le han salido al jugador que está jugando actualmente.
	 */
	public void setDado() {
		this.dado = ((Player) getTablero().get(getCoordinatePlayeres().get(PlayerJuega))).getVelocidadParaLuchar();
	}

	/**
	 * Método utilizado para cambiar la posición de un jugador en el juego. Recibe
	 * una coordenada como parámetro y realiza las siguientes acciones:
	 * 
	 * Obtiene la coordenada actual del jugador que está jugando actualmente
	 * (PlayerJuega) desde la lista CoordinatePlayeres. Obtiene el jugador
	 * correspondiente a la coordenada actual desde el tablero. Remueve la
	 * coordenada actual y el jugador del tablero. Remueve la coordenada actual de
	 * la lista CoordinatePlayeres. Inserta la nueva coordenada en la posición del
	 * jugador que está jugando actualmente en la lista CoordinatePlayeres. Inserta
	 * la nueva coordenada y el jugador en el tablero.
	 * 
	 * @param nuevaCoordenada La nueva coordenada a la cual se desea mover al
	 *                        jugador.
	 */
	private void cambiaPlayerAPosicion(Coordinate Coordinate) {
		Coordinate coor = getCoordinatePlayeres().get(PlayerJuega);
		Player jug = (Player) getTablero().get(coor);

		getTablero().remove(coor);
		getCoordinatePlayeres().remove(PlayerJuega);
		getCoordinatePlayeres().add(PlayerJuega, Coordinate);
		getTablero().put(Coordinate, jug);
	}

	/**
	 * metodo que imprime, devuelve, los Playeres con sus valores de dinero,
	 * pociones y gemas.
	 * 
	 * @return
	 */
	public String imprimeValoresPlayeres() {
		int contador = 1;
		StringBuilder sb = new StringBuilder();

		for (Coordinate Coordinate : this.getCoordinatePlayeres()) {
			Player Player = (Player) getTablero().get(Coordinate);
			sb.append("Player numero: " + contador + " Dinero: " + Player.getDinero() + " Gemas: " + Player.getGemas()
					+ " Pociones: " + Player.getPociones() + "\n");
			contador++;
		}
		return sb.toString();
	}

	/**
	 * Método que imprime los valores de los jugadores, como su dinero, gemas y
	 * pociones, y devuelve una cadena con esta información.
	 * 
	 * @return Una cadena con los valores de los jugadores.
	 */
	public Coordinate getNextPosition(char direccion) throws GameException {
		if (direccion != 'N' && direccion != 'S' && direccion != 'E' && direccion != 'O') {
			throw new GameException("Error en la direcciÃ³n.");
		}
		Coordinate coor;
		try {
			coor = getCoordinatePlayeres().get(PlayerJuega).clone();
			if (direccion == 'N') {
				coor.moverArriba();
			} else if (direccion == 'S') {
				coor.moverAbajo();
			} else if (direccion == 'E') {
				coor.moverDerecha();
			} else {
				coor.moverIzquierda();
			}
		} catch (CloneNotSupportedException e) {
			throw new GameException(e.getMessage());
		}
		return coor;
	}

	/**
	 * Método que representa el tablero en formato no gráfico y devuelve una cadena
	 * con la información.
	 * 
	 * @return Una cadena que representa el tablero en formato no gráfico.
	 */
	@Override
	public String toString() {
		StringBuilder resul = new StringBuilder();
		resul.append(barra());
		resul.append("     |");

		for (int fila = 0; fila < Constans.TAMANNO; fila++) {
			for (int columna = 0; columna < Constans.TAMANNO; columna++) {
				Coordinate coor = new Coordinate(columna, fila);

				if (this.getTablero().get(coor) != null) {
					resul.append(" " + this.getTablero().get(coor).getTipo().getSimbolo() + " ");
				} else {
					resul.append("   ");
				}

				resul.append("|");
			}
			resul.append("\n");
			resul.append(barra());
			resul.append("     |");
		}
		resul.delete(resul.length() - 5, resul.length());
		return resul.toString();
	}

	/**
	 * Método utilizado para avanzar al siguiente jugador en el turno de juego.
	 * Actualiza el atributo PlayerJuega para indicar el índice del siguiente
	 * jugador en la lista CoordinatePlayeres. Si el jugador actual es el último de
	 * la lista, se reinicia el turno y el siguiente jugador será el primero de la
	 * lista.
	 */
	public void proximoPlayer() {
		if (this.PlayerJuega == getCoordinatePlayeres().size() - 1) {
			this.PlayerJuega = 0;
		} else {
			PlayerJuega++;
		}
	}

	/**
	 * Método que devuelve la información del ganador del juego. Si solo queda un
	 * jugador en el tablero, se considera ganador y se devuelve su información. En
	 * caso contrario, se busca en el tablero si hay algún jugador que tenga todo el
	 * dinero y se devuelve la información del primer jugador encontrado con esa
	 * condición.
	 * 
	 * @return Una cadena con la información del ganador.
	 */
	public String getGanador() {
		StringBuilder resultado = new StringBuilder();
		if (this.getCoordinatePlayeres().size() == 1) {
			Player Player = (Player) getTablero().get(getCoordinatePlayeres().get(0));
			resultado.append(Player.toString());

		} else {

			for (Element siguiente : getTablero().values()) {
				if (siguiente instanceof Player) {
					Player Player = ((Player) siguiente);
					if (Player.getDinero() == Constans.NUM_DINERO) {
						resultado.append(Player);
					}
				}
			}
		}
		return resultado.toString();
	}

	/**
	 * Método que devuelve el nombre del tipo de jugador que está jugando
	 * actualmente.
	 * 
	 * @return El nombre del tipo de jugador que juega.
	 */
	public String getNombrePlayerQueJuega() {
		StringBuilder sb = new StringBuilder();
		Coordinate coor = this.getCoordinatePlayeres().get(PlayerJuega);

		Player Player = (Player) this.getTablero().get(coor);
		sb.append(Player.getNombre());
		return sb.toString();
	}

	/**
	 * Obtener movimiento del jugador.
	 * 
	 * @return El valor del movimiento del jugador.
	 */
	public int getMovimientoPlayer() {
		Coordinate coor = this.getCoordinatePlayeres().get(PlayerJuega);
		Player Player = (Player) this.getTablero().get(coor);
		return Player.getFuerzaParaLuchar();
	}

	/**
	 * Método auxiliar para imprimir una barra en pantalla.
	 * 
	 * @return Una cadena que representa una barra.
	 */
	private String barra() {
		StringBuilder resul = new StringBuilder();
		resul.append("     ");
		for (int i = 0; i < Constans.TAMANNO * 4; i++) {
			resul.append("-");
		}
		resul.append("\n");
		return resul.toString();
	}

	/**
	 * Mueve el Player en la dirección especificada y realiza las acciones
	 * correspondientes.
	 * 
	 * @param direction La dirección en la que se desea mover al Player.
	 * @return Un mensaje con el resultado de la acción.
	 * @throws GameException   Si la dirección no es válida.
	 * @throws PlayerException Si hay algún error relacionado con el Player.
	 */
	public String movePlayer(char direction) throws GameException, PlayerException {
		// Si no es una direcciÃ³n vÃ¡lida, mando un exception
		String resul = "";
		Player Player = (Player) this.getTablero().get(this.getCoordinatePlayeres().get(PlayerJuega));

		Coordinate coordDestino = getNextPosition(direction);

		// Verificar si hay algo en la casilla de destino
		Element elemento = this.getTablero().get(coordDestino);

		if (elemento != null) { // La casilla esta ocupada hay algun elemento
			if (elemento instanceof Player) {

				Player enemigo = (Player) elemento;
				int resultadoLucha = Player.lucha(enemigo);
				switch (resultadoLucha) {
				case Constans.EMPATE:
					resul = "Empate entre los Playere";
					break;
				case Constans.GANA_USA_POCIMA:
					resul = "El Player " + Player.getNombre() + " gana. Le quita una pócima al enemigo";
					break;
				case Constans.GANA_DINERO:
					resul = "El Player " + Player.getNombre() + " gana. Le quita el dinero al enemigo";
					break;
				case Constans.GANA_MUERE:
					resul = "El Player " + Player.getNombre() + " gana. El enemigo muere";
					this.eliminarPlayer(coordDestino);

					break;
				case Constans.PIERDE_USA_POCIMA:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita una pócima al Player";
					break;
				case Constans.PIERDE_DINERO:
					resul = "El enemigo " + enemigo.getNombre() + " gana. Le quita el dinero al Player";
					break;
				case Constans.PIERDE_MUERE:
					resul = "El enemigo " + enemigo.getNombre() + " gana. El Player muere";
					this.eliminarPlayer(this.getCoordinatePlayeres().get(PlayerJuega));
					dado = 0;

					this.PlayerJuega--;
					break;
				}
			} else if (elemento.getTipo() == ElementType.ROCA) {
				int resultadoRoca = Player.encuentraRoca();
				switch (resultadoRoca) {
				case Constans.ROMPE_ROCA_CON_GEMA:
					resul = "El Player " + Player.getNombre() + " rompe la roca con una gema";
					this.cambiaPlayerAPosicion(coordDestino);
					break;

				case Constans.GANA_A_LA_ROCA:
					resul = "El Player " + Player.getNombre() + " gana a la roca";
					this.cambiaPlayerAPosicion(coordDestino);
					break;

				case Constans.PIERDE_A_LA_ROCA:
					resul = "El Player " + Player.getNombre() + " pierde. No se mueve";
					break;
				}
			} else if (elemento.getTipo() == ElementType.GEMA) {
				Player.encuentraGema();
				this.cambiaPlayerAPosicion(coordDestino);

			} else if (elemento.getTipo() == ElementType.DINERO) {
				Player.encuentraDinero();
				this.cambiaPlayerAPosicion(coordDestino);

			} else if (elemento.getTipo() == ElementType.POCION) {
				Player.encuentraPocion();
				this.cambiaPlayerAPosicion(coordDestino);

			}

		} else {
			this.cambiaPlayerAPosicion(coordDestino);
		}

		return resul;
	}

	public ArrayList<Coordinate> getCoordinatePlayeres() {
		return CoordinatePlayeres;
	}

	public void setCoordinatePlayeres(ArrayList<Coordinate> coordinatePlayeres) {
		CoordinatePlayeres = coordinatePlayeres;
	}

	public HashMap<Coordinate, Element> getTablero() {
		return tablero;
	}

	public void setTablero(HashMap<Coordinate, Element> tablero) {
		this.tablero = tablero;
	}

}
