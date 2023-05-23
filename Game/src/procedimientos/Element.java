package procedimientos;

import java.util.Objects;

/**
 * Clase que representa un elemento del juego.
 */
public class Element {

	// Tipo de elemento
	protected ElementType tipo;

	/**
	 * Constructor de la clase Element.
	 *
	 * @param tipo Tipo de elemento
	 */
	public Element(ElementType tipo) {
		this.tipo = tipo;
	}

	/**
	 * Devuelve una representación en cadena del objeto Element.
	 *
	 * @return Cadena que representa el objeto Element
	 */
	@Override
	public String toString() {
		return "Elemento, tipo = " + tipo;
	}

	/**
	 * Devuelve el tipo de elemento.
	 *
	 * @return Tipo de elemento
	 */
	public ElementType getTipo() {
		return tipo;
	}

	/**
	 * Calcula el código hash del objeto Element.
	 *
	 * @return Código hash del objeto Element
	 */
	@Override
	public int hashCode() {
		return Objects.hash(tipo);
	}

	/**
	 * Compara si el objeto Element es igual a otro objeto dado.
	 *
	 * @param obj Objeto a comparar
	 * @return true si son iguales, false en caso contrario
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return tipo == other.tipo;
	}
}