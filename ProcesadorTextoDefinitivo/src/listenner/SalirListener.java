/**
 * @author: María Inmaculada Campillo Soto
 */
package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JOptionPane;

import modelo.Componente;

/**
 * El escuchador que recibe eventos de la clase "Salir" e interactua con el editor de
 * texto y muestra una ventana emergente antes de salir.
 *
 * @see componente.Salir
 */
public class SalirListener implements ActionListener {

	/** El texto de la ventana emergente. */
	private String texto;

	/** El título de la ventana emergente. */
	private String titulo;

	/** Los botones de la ventana emergente. */
	private Object[] botones;

	/**
	 * Poner el texto correspondiente en la ventana emergente según la localidad.
	 *
	 * @param locale La localidad
	 */
	public void ponerTextoTitulo(Locale locale) {
		texto = Componente.getRecurso("textSalir", locale);
		titulo = Componente.getRecurso("tituloSalir", locale);
		botones = new Object[] { Componente.getRecurso("botonSi", locale), Componente.getRecurso("botonNo", locale) };
	}

	/**
	 * Inicializa un nuevo escuchador.
	 *
	 * @param locale La localidad
	 */
	public SalirListener(Locale locale) {
		ponerTextoTitulo(locale);
	}

	/**
	 * Método de acción realizada.
	 *
	 * @param e El evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int seleccion = JOptionPane.showOptionDialog(null, texto, titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
		if (JOptionPane.YES_OPTION == seleccion) {
			System.exit(0);
		}
	}

}
