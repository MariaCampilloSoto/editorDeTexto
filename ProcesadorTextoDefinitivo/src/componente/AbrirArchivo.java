/**
 * @author: María Inmaculada Campillo Soto
 */
package componente;

import java.awt.event.ActionListener;
import java.util.Locale;

import modelo.Componente;

/**
 * Representa los botones de abrir un archivo que puede funcionar como un JToggleButton o
 * un JMenuItem.
 * 
 * @see modelo.Componente
 */
public class AbrirArchivo extends Componente {

	/**
	 * Inicializa un nuevo componente que abre un archivo.
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
	public AbrirArchivo(String imageIconString, String nombreProperty, String nombreDescripcionProperties,
			Locale locale, ActionListener actionListener) {
		super(imageIconString, nombreProperty, nombreDescripcionProperties, locale, actionListener);
	}

}