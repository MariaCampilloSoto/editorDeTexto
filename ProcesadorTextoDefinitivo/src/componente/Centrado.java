/**
 * @author: María Inmaculada Campillo Soto
 */
package componente;

import java.awt.event.ActionListener;
import java.util.Locale;

import modelo.Componente;

/**
 * Representa los botones de centrar el texto en una lamina, funciona como JToggleButton o
 * JMenuItem.
 * 
 * @see modelo.Componente
 */
public class Centrado extends Componente {

	/**
	 * Inicializa un nuevo componente que alinea el texto en el centro.
	 *
	 * @param imageIconString             El nombre de la etiqueta del archivo properties que
	 *                                    referencia al enlace de la imagen del componente.
	 * @param nombreProperty              El nombre de la etiqueta del archivo properties que
	 *                                    referencia al nombre del componente.
	 * @param nombreDescripcionProperties El nombre de la etiqueta del archivo properties que
	 *                                    referencia a la descripción del componente.
	 * @param locale                      La localización.
	 * @param actionListener              El escuchador que tendrá el componente.
	 */
	public Centrado(String imageIconString, String nombreProperty, String nombreDescripcionProperties, Locale locale,
			ActionListener actionListener) {
		super(imageIconString, nombreProperty, nombreDescripcionProperties, locale, actionListener);
	}
}
