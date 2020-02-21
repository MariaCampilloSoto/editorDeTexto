package componente;

import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Locale;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.KeyStroke;
import javax.swing.text.DefaultEditorKit;

import lamina.LaminaTexto;
import modelo.Componente;

public class MenuEditor extends JMenu {
	private static final long serialVersionUID = 1L;

	private Action aCopiar;
	private Action aCortar;
	private Action aPegar;
	
	private Locale locale;
	
	public void ponerNombreAcciones(Locale locale) {
		//Es como cambiar idioma
		aCopiar.putValue(Action.NAME, Componente.getRecurso("textCopiar", locale));
		aCortar.putValue(Action.NAME, Componente.getRecurso("textCortar", locale));
		aPegar.putValue(Action.NAME, Componente.getRecurso("textPegar", locale));
	}
	
	public MenuEditor(String title, LaminaTexto laminaTexto) {
		super(title);
		locale = getLocale();
		ActionMap acciones = laminaTexto.getTextPane().getActionMap();

		aCopiar = acciones.get(DefaultEditorKit.copyAction);
		aCopiar.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		aCopiar.putValue(Action.SMALL_ICON,
				new ImageIcon(new ImageIcon(Componente.getRecurso("imagenCopiar", getLocale())).getImage()
						.getScaledInstance(Componente.ANCHO_IMAGEN, Componente.ALTO_IMAGEN, Image.SCALE_DEFAULT)));

		aCortar = acciones.get(DefaultEditorKit.cutAction);
		aCortar.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
		aCortar.putValue(Action.SMALL_ICON,
				new ImageIcon(new ImageIcon(Componente.getRecurso("imagenCortar", getLocale())).getImage()
						.getScaledInstance(Componente.ANCHO_IMAGEN, Componente.ALTO_IMAGEN, Image.SCALE_DEFAULT)));

		aPegar = acciones.get(DefaultEditorKit.pasteAction);
		aPegar.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		aPegar.putValue(Action.SMALL_ICON,
				new ImageIcon(new ImageIcon(Componente.getRecurso("imagenPegar", getLocale())).getImage()
						.getScaledInstance(Componente.ANCHO_IMAGEN, Componente.ALTO_IMAGEN, Image.SCALE_DEFAULT)));
		
		ponerNombreAcciones(locale);

		add(aCopiar);
		add(aCortar);
		add(aPegar);

	}

}
