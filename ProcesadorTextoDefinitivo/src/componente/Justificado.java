/**
 * @author: Mar�a Inmaculada Campillo Soto
 */
package componente;

import java.awt.event.ActionListener;
import java.util.Locale;

import modelo.Componente;

/**
 * Un objeto que puede justificar el texto del editor de texto, este objeto puede
 * funcionar como JToggleButton o JMenuItem.
 * 
 * @see modelo.Componente
 */
public class Justificado extends Componente {

	/**
	 * Inicializa un nuevo objeto Justificado.
	 *
	 * @param imageIconString             El nombre de la etiqueta del archivo properties que
	 *                                    referencia al enlace de la imagen del componente.
	 * @param nombreProperty              El nombre de la etiqueta del archivo properties que
	 *                                    referencia al nombre del componente.
	 * @param nombreDescripcionProperties El nombre de la etiqueta del archivo properties que
	 *                                    referencia a la descripci�n del componente.
	 * @param locale                      La localizaci�n.
	 * @param actionListener              El escuchador que tendr� el componente.
	 */
	public Justificado(String imageIconString, String nombreProperty, String nombreDescripcionProperties, Locale locale,
			ActionListener actionListener) {
		super(imageIconString, nombreProperty, nombreDescripcionProperties, locale, actionListener);
	}

}
