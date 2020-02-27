/**
 * @author: María Inmaculada Campillo Soto
 */
package especial;

import java.awt.GraphicsEnvironment;
import java.util.Locale;

import lamina.LaminaTexto;
import modelo.Especial;

/**
 * La clase "Fuente" represanta los diferentes nombres de fuentes que tiene el sistema, se
 * puede dar en forma de JComboBoc o JMenu.
 * 
 * @see modelo.Especial
 */
public class Fuente extends Especial<String> {

	/**
	 * Inicializa un nuevo objeto de la clase "Fuente" con una lista de nombre de la fuente.
	 *
	 * @param locale              La localización.
	 * @param laminaTexto         La lámina de texto que se ve afectada con el cambio de la
	 *                            fuente.
	 * @param nombreProperty      El nombre de la etiqueta del archivo properties que
	 *                            referencia al nombre del componente.
	 * @param numeroElementosMenu El número de elementos que quiere se muestre en el JMenu.
	 * @param elementos           Los nombre todas las fuentes que se pone en el JComboBox y
	 *                            algunos en el JMenu.
	 *                            
	 * @see #Fuente(Locale, LaminaTexto, String, int, String[])
	 */
	public Fuente(Locale locale, LaminaTexto laminaTexto, String nombreProperty, int numeroElementosMenu,
			String[] elementos) {
		super(locale, laminaTexto, nombreProperty, numeroElementosMenu, elementos);
	}

	/**
	 * Inicializa un nuevo objeto de la clase "Fuente" con las fuentes del sistema que tiene
	 * instalado.
	 *
	 * @param locale              La localización.
	 * @param laminaTexto         La lámina de texto que se ve afectada con el cambio de la
	 *                            fuente.
	 * @param nombreProperty      El nombre de la etiqueta del archivo properties que
	 *                            referencia al nombre del componente.
	 * @param numeroElementosMenu El número de elementos que quiere se muestre en el JMenu.
	 * 
	 * @see #Fuente(Locale, LaminaTexto, String, int)
	 */
	// Este es diferente al su clase hermana porque se puede sacar las fuentes desde aqui
	public Fuente(Locale locale, LaminaTexto laminaTexto, String nombreProperty, int numeroElementosMenu) {
		this(locale, laminaTexto, nombreProperty, numeroElementosMenu,
				GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
	}

}
