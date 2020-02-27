/**
 * @author: María Inmaculada Campillo Soto
 */
package especial;

import java.util.Locale;

import lamina.LaminaTexto;
import modelo.Especial;

/**
 * La clase "Tamanyo" representa los diferentes tamaños que puede tener cierto texto.
 * 
 * @see modelo.Especial
 */
public class Tamanyo extends Especial<Integer> {

	/**
	 * Inicializa un nuevo objeto de la clase "Tamanyo" con una lista de enteros que serán las
	 * opciones que se muestran para cambiar dicho tamaño.
	 *
	 * @param locale              La localización.
	 * @param laminaTexto         La lámina de texto que se ve afectada con el cambio del
	 *                            tamaño.
	 * @param nombreProperty      El nombre de la etiqueta del archivo properties que
	 *                            referencia al nombre del componente.
	 * @param numeroElementosMenu El número de elementos que quiere se muestre en el JMenu.
	 * @param elementos           Una lista de números de enteros que se pondrán en el
	 *                            JComboBox y algunos en el JMenu.
	 */
	public Tamanyo(Locale locale, LaminaTexto laminaTexto, String nombreProperty, int numeroElementosMenu,
			Integer[] elementos) {
		super(locale, laminaTexto, nombreProperty, numeroElementosMenu, elementos);
	}
}
