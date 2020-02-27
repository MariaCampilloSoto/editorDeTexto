/**
 * @author: Mar�a Inmaculada Campillo Soto
 */
package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JOptionPane;

import modelo.Componente;

/**
 * El escuchador que recibe eventos de un JMenuItem en concreto de la ventana, el cual
 * cuando se pulsa aparece una ventana emegente con informaci�n sobre el editor.
 *
 * @see ventana.Ventana
 */
public class AcercaDeListener implements ActionListener {

	/** Los botones de la ventana emergente. */
	private Object[] botones;

	/** El texto de la ventana emergente. */
	private String texto;

	/** El t�tulo de la ventana emergente. */
	private String titulo;

	/**
	 * Poner el texto correspondiente en la ventana emergente seg�n la localidad.
	 *
	 * @param locale La localidad.
	 */
	public void ponerTextoTitulo(Locale locale) {
		texto = Componente.getRecurso("textAcercaDeVentana", locale);
		titulo = Componente.getRecurso("tituloAcercaDeItem", locale);
		botones = new Object[] { Componente.getRecurso("botonAceptar", locale) };
	}

	/**
	 * Inicializa un nuevo escuchador.
	 *
	 * @param locale the locale
	 */
	public AcercaDeListener(Locale locale) {
		ponerTextoTitulo(locale);
	}

	/**
	 * M�todo de acci�n realizada.
	 *
	 * @param e El evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showOptionDialog(null, texto, titulo, JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null,
				botones, botones[0]);
	}

}
