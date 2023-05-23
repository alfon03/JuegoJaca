package procedimientos;

import logica.Constans;

/**
 * Enumerado que almacena el tipo de elementos que se pueden encontrar en el
 * tablero. Cada elemento tiene un tipo, un símbolo y un archivo de imagen
 * asociado.
 */
public enum ElementType {

	ROCA(Constans.ROCA, 'R', "roca.png"),
	DINERO(Constans.DINERO, 'D', "dinero.png"),
	GEMA(Constans.GEMA, 'Y', "gema.png"), POCION(Constans.POCION, 'P', "pocion.png"),
	ELFO(Constans.ELFO, 'E', "elfo.png"), GUERRERO(Constans.GUERRERO, 'G', "guerrero.png"),
	MAGO(Constans.MAGO, 'M', "mago.png"), OGRO(Constans.OGRO, 'O', "ogro.png");

	private int tipo;
	private char simbolo;
	private String imagen;

	/**
	 * Constructor de ElementType.
	 *
	 * @param tipo    Tipo de elemento
	 * @param simbolo Símbolo del elemento
	 * @param imagen  Archivo de imagen asociado al elemento
	 */
	private ElementType(int tipo, char simbolo, String imagen) {
		this.tipo = tipo;
		this.simbolo = simbolo;
		this.imagen = imagen;
	}

	/**
	 * Devuelve el tipo del elemento.
	 *
	 * @return Tipo del elemento
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * Devuelve el símbolo del elemento.
	 *
	 * @return Símbolo del elemento
	 */
	public char getSimbolo() {
		return simbolo;
	}

	/**
	 * Devuelve el archivo de imagen asociado al elemento.
	 *
	 * @return Archivo de imagen del elemento
	 */
	public String getImagen() {
		return imagen;
	}
}