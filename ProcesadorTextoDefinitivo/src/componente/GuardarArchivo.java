/**
 * @author: María Inmaculada Campillo Soto
 */
package componente;

import java.awt.event.ActionListener;
import java.util.Locale;

import modelo.Componente;

/**
 * Representa los botones para guardar un archivo, puede representar como JToggleButton o
 * JMenuItem.
 * 
 * @see modelo.Componente
 */
public class GuardarArchivo extends Componente {

	/**
	 * Inicializa un nuevo componente que guarda el archivo.
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
	public GuardarArchivo(String imageIconString, String nombreProperty, String nombreDescripcionProperties,
			Locale locale, ActionListener actionListener) {
		super(imageIconString, nombreProperty, nombreDescripcionProperties, locale, actionListener);
	}

}
