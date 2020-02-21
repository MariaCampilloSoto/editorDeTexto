package componente;

import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import modelo.Componente;


public class TemasEntorno extends Componente {
	private String nombreEntorno;

	public JMenu getMenuTemaEntorno() {
		JMenu temasEntornoMenu = new JMenu(getNombre());
		
		
		
		return temasEntornoMenu;
	}
	
	public void actualizarEntorno(String nombreEntorno) {
		if(nombreEntorno != null && !this.nombreEntorno.equals(nombreEntorno)) {
			this.nombreEntorno = nombreEntorno;
			try {
				UIManager.setLookAndFeel(nombreEntorno);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
		}
	}
	
	public TemasEntorno(String imageIconString, String nombreProperty, String nombreDescripcionProperty, Locale locale,
			ActionListener actionListener) {
		super(imageIconString, nombreProperty, nombreDescripcionProperty, locale, actionListener);
		nombreEntorno = null;
	}
}
