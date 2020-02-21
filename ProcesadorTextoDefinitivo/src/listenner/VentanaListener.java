package listenner;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

import javax.swing.JOptionPane;

import modelo.Componente;

public class VentanaListener extends WindowAdapter {

	private Object[] botones;
	private String texto;
	private String titulo;

	public void ponerTextoTitulo(Locale locale) {
		texto = Componente.getRecurso("textSalir", locale);
		titulo = Componente.getRecurso("tituloSalir", locale);
		botones = new Object[] { Componente.getRecurso("botonSi", locale), Componente.getRecurso("botonNo", locale) };
	}

	public VentanaListener(Locale locale) {
		ponerTextoTitulo(locale);
	}

	public void windowClosing(WindowEvent e) {
		int seleccion = JOptionPane.showOptionDialog(null, texto, titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
		if (JOptionPane.YES_OPTION == seleccion) {
			System.exit(0);
		}
	}
}
