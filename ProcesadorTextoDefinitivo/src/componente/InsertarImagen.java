/**
 * @author: Mar�a Inmaculada Campillo Soto
 */
package componente;

import java.awt.event.ActionListener;
import java.util.Locale;

import modelo.Componente;

/**
 * Representa un objeto que puede ser representado como un JToggleButton o JMenuItem que
 * insertar� una imagen en el editor de texto.
 * 
 * @see modelo.Componente
 */
public class InsertarImagen extends Componente {

	/**
	 * Inicializa un objeto InsertarImagen.
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
	public InsertarImagen(String imageIconString, String nombreProperty, String nombreDescripcionProperties,
			Locale locale, ActionListener actionListener) {
		super(imageIconString, nombreProperty, nombreDescripcionProperties, locale, actionListener);
	}
}
