/**
 * @author: Mar�a Inmaculada Campillo Soto
 */
package componente;

import java.awt.event.ActionListener;
import java.util.Locale;

import modelo.Componente;

/**
 * Representa los botones de convertir cierto texto al estilo cursiva, funciona como
 * JToggleButton o JMenuItem.
 * 
 * @see modelo.Componente
 */
public class Cursiva extends Componente {

	/**
	 * Inicializa un nuevo componente que pone el texto en cursiva.
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
	public Cursiva(String imageIconString, String nombreProperty, String nombreDescripcionProperties, Locale locale,
			ActionListener actionListener) {
		super(imageIconString, nombreProperty, nombreDescripcionProperties, locale, actionListener);
	}
}
