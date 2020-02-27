/**
 * @author: Mar�a Inmaculada Campillo Soto
 */
package especial;

import java.util.Locale;

import lamina.LaminaTexto;
import modelo.Especial;

/**
 * La clase "Tamanyo" representa los diferentes tama�os que puede tener cierto texto.
 * 
 * @see modelo.Especial
 */
public class Tamanyo extends Especial<Integer> {

	/**
	 * Inicializa un nuevo objeto de la clase "Tamanyo" con una lista de enteros que ser�n las
	 * opciones que se muestran para cambiar dicho tama�o.
	 *
	 * @param locale              La localizaci�n.
	 * @param laminaTexto         La l�mina de texto que se ve afectada con el cambio del
	 *                            tama�o.
	 * @param nombreProperty      El nombre de la etiqueta del archivo properties que
	 *                            referencia al nombre del componente.
	 * @param numeroElementosMenu El n�mero de elementos que quiere se muestre en el JMenu.
	 * @param elementos           Una lista de n�meros de enteros que se pondr�n en el
	 *                            JComboBox y algunos en el JMenu.
	 */
	public Tamanyo(Locale locale, LaminaTexto laminaTexto, String nombreProperty, int numeroElementosMenu,
			Integer[] elementos) {
		super(locale, laminaTexto, nombreProperty, numeroElementosMenu, elementos);
	}
}
