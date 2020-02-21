package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JOptionPane;

import modelo.Componente;

public class SalirListener implements ActionListener {
	private String texto;
	private String titulo;
	private Object[] botones;

	public void ponerTextoTitulo(Locale locale) {
		texto = Componente.getRecurso("textSalir", locale);
		titulo = Componente.getRecurso("tituloSalir", locale);
		botones = new Object[] {Componente.getRecurso("botonSi", locale), Componente.getRecurso("botonNo", locale)};
	}

	public SalirListener(Locale locale) {
		ponerTextoTitulo(locale);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int seleccion = JOptionPane.showOptionDialog(null, texto, titulo, JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE, null, botones, botones[0]);
		if (JOptionPane.YES_OPTION == seleccion) {
			System.exit(0);
		}
	}

}