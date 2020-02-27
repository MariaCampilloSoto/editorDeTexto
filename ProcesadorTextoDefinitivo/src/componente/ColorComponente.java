/**
 * @author: María Inmaculada Campillo Soto
 */
package componente;

import java.awt.event.ActionListener;
import java.util.Locale;

import modelo.Componente;

/**
 * Representa los botones del color, el cual puede cambiar el color del texto, funciona
 * como JToggleButton y JMenuItem.
 * 
 * @see modelo.Componente
 */
public class ColorComponente extends Componente {

	/**
	 * Inicializa un nuevo componente que cambia de color el texto.
	 *
	 * @param imageIconString           El nombre de la etiqueta del archivo properties que
	 *                                  referencia al enlace de la imagen del componente.
	 * @param nombreProperty            El nombre de la etiqueta del archivo properties que
	 *                                  referencia al nombre del componente.
	 * @param nombreDescripcionProperty El nombre de la etiqueta del archivo properties que
	 *                                  referencia a la descripción del componente.
	 * @param locale                    La localización.
	 * @param actionListener            El escuchador que tendrá el componente.
	 */
	public ColorComponente(String imageIconString, String nombreProperty, String nombreDescripcionProperty,
			Locale locale, ActionListener actionListener) {
		super(imageIconString, nombreProperty, nombreDescripcionProperty, locale, actionListener);
	}
}
