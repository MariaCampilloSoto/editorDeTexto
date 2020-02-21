package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JOptionPane;

import modelo.Componente;

public class SalirListener implements ActionListener {
	
	private String texto;
	private String titulo;
	
	public void ponerTextoTitulo(Locale locale) {
		texto = Componente.getRecurso("textSalir", locale);
		titulo = Componente.getRecurso("tituloSalir", locale);
	}
	
	public SalirListener(Locale locale) {
		ponerTextoTitulo(locale);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int seleccion = JOptionPane.showConfirmDialog(null,
				texto, titulo,JOptionPane.YES_NO_OPTION);
		if (JOptionPane.YES_OPTION == seleccion) {
			System.exit(0);
		}
	}

}
