/**
 * @author: María Inmaculada Campillo Soto
 */
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

/**
 * La clase "MenuEditor" representa un JMenu en el editor de texto, su funcionalidad general
 * de cortar, copiar o pegar contenido en el editor de texto.
 */
public class MenuEditor extends JMenu {

	/** La constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** La accion de copiar. */
	private Action aCopiar;

	/** La accion de cortar. */
	private Action aCortar;

	/** La accion de pegar. */
	private Action aPegar;

	/** La localidad que tiene la ccion. */
	private Locale locale;

	/**
	 * Poner nombre a las acciones acciones.
	 *
	 * @param locale the locale
	 */
	public void ponerNombreAcciones(Locale locale) {
		// Es como cambiar idioma
		aCopiar.putValue(Action.NAME, Componente.getRecurso("textCopiar", locale));
		aCortar.putValue(Action.NAME, Componente.getRecurso("textCortar", locale));
		aPegar.putValue(Action.NAME, Componente.getRecurso("textPegar", locale));
	}

	/**
	 * Inicializa un nuevo editor que es un menu.
	 *
	 * @param title       El nombre, texto del menu
	 * @param laminaTexto Una lámina texto para añadir las acciones creadas.
	 */
	public MenuEditor(String title, LaminaTexto laminaTexto) {
		super(title);
		locale = getLocale();
		// Creamos las acciones de copiar, cortar y pegar
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
