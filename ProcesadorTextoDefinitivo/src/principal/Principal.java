/**
 * @author: Mar�a Inmaculada Campillo Soto
 */
package principal;

import ventana.Ventana;

/**
 * La clase "Principal" que crea un objeto ventana e ejecuta el editor de texto.
 */
public class Principal {

	/**
	 * El m�todo principal que es �nico hilo de ejecuci�n del programa.
	 *
	 * @param args Los argumentos del programa
	 */
	public static void main(String[] args) {
		Ventana v = new Ventana();
	}
}
