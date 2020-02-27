/**
 * @author: María Inmaculada Campillo Soto
 */
package componente;

import java.awt.event.ActionListener;
import java.util.Locale;

import modelo.Componente;

/**
 * Representa un objeto que cambia el texto con un estilo de subrayado, este objeto se
 * puede dar en forma de JToggleButton o JMenuItem.
 * 
 * @see modelo.Componente
 */
public class Subrayado extends Componente {

	/**
	 * Inicializa un objeto de esta clase.
	 *
	 * @param imageIconString             El nombre de la etiqueta del archivo properties que
	 *                                    referencia al enlace de la imagen del componente.
	 * @param nombreProperty              El nombre de la etiqueta del archivo properties que
	 *                                    referencia al nombre del componente.
	 * @param nombreDescripcionProperties El nombre de la etiqueta del archivo properties que
	 *                                    referencia a la descripcion del componente.
	 * @param locale                      La localización.
	 * @param actionListener              El escuchador que tendrá el componente.
	 */
	public Subrayado(String imageIconString, String nombreProperty, String nombreDescripcionProperties, Locale locale,
			ActionListener actionListener) {
		super(imageIconString, nombreProperty, nombreDescripcionProperties, locale, actionListener);
	}
}
