/**
 * @author: María Inmaculada Campillo Soto
 */
package componente;

import java.awt.event.ActionListener;
import java.util.Locale;

import modelo.Componente;

/**
 * La clase "Salir" representa los botones, tanto JToggleButton como JMenuItem, que tienen
 * la funionalidad de salir del editor de texto.
 * 
 * @see modelo.Componente
 */
public class Salir extends Componente {

	/**
	 * Inicializa un objeto de la clase Salir.
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
	public Salir(String imageIconString, String nombreProperty, String nombreDescripcionProperties, Locale locale,
			ActionListener actionListener) {
		super(imageIconString, nombreProperty, nombreDescripcionProperties, locale, actionListener);
	}
}
