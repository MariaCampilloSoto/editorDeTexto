/**
 * @author: María Inmaculada Campillo Soto
 */
package principal;

import ventana.Ventana;

/**
 * La clase "Principal" que crea un objeto ventana e ejecuta el editor de texto.
 */
public class Principal {

	/**
	 * El método principal que es único hilo de ejecución del programa.
	 *
	 * @param args Los argumentos del programa
	 */
	public static void main(String[] args) {
		Ventana v = new Ventana();
	}
}
