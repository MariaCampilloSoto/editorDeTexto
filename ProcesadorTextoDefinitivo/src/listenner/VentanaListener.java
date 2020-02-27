/**
 * @author: María Inmaculada Campillo Soto
 */
package listenner;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

import javax.swing.JOptionPane;

import modelo.Componente;

/**
 * El escuchador que recibe eventos de ventana, actua cuando se cierra el editor de texto
 * y muestra una ventana emergente antes de salir.
 *
 * @see ventana.Ventana
 */
public class VentanaListener extends WindowAdapter {

	/** Los botones de la ventana emergente. */
	private Object[] botones;

	/** El texto de la ventana emergente. */
	private String texto;

	/** El título de la ventana emergente. */
	private String titulo;

	/**
	 * Poner el texto correspondiente en la ventana emergente según la localidad.
	 *
	 * @param locale La localidad.
	 */
	public void ponerTextoTitulo(Locale locale) {
		texto = Componente.getRecurso("textSalir", locale);
		titulo = Componente.getRecurso("tituloSalir", locale);
		botones = new Object[] { Componente.getRecurso("botonSi", locale), Componente.getRecurso("botonNo", locale) };
	}

	/**
	 * Inicializa un nuevo escuchador de ventana.
	 *
	 * @param locale the locale
	 */
	public VentanaListener(Locale locale) {
		ponerTextoTitulo(locale);
	}

	/**
	 * Método cuando la ventana va a cerrarse.
	 *
	 * @param e El evento
	 */
	public void windowClosing(WindowEvent e) {
		int seleccion = JOptionPane.showOptionDialog(null, texto, titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
		if (JOptionPane.YES_OPTION == seleccion) {
			System.exit(0);
		}
	}
}
