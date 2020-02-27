/**
 * @author: María Inmaculada Campillo Soto
 */
package modelo;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

/**
 * La clase "Lamina" que contiene una lista de componentes que la integran.
 */
public class Lamina extends JPanel {

	/** La constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** La constante NUMERO_MAXIMO_TAMANYO. */
	// Constante y variable
	public static final int NUMERO_MAXIMO_TAMANYO = 84;

	/** La lista de componente. */
	private List<Componente> componentes;

	/**
	 * Añade un componente.
	 *
	 * @param componente El componente a añadir.
	 */
	public void anyadirComponente(Componente componente) {
		componentes.add(componente);
	}

	/**
	 * Añade un componente en una posición especifica.
	 *
	 * @param index      El índice
	 * @param componente El componente
	 */
	public void anyadirComponente(int index, Componente componente) {
		componentes.add(index, componente);
	}

	/**
	 * Inicializa una nueva lámina.
	 */
	public Lamina() {
		componentes = new LinkedList<Componente>();
	}

	/**
	 * Obtiene los componentes.
	 *
	 * @return los componentes
	 */
	public List<Componente> getComponentes() {
		return componentes;
	}
}
