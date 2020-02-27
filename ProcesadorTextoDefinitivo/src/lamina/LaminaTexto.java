/**
 * @author: María Inmaculada Campillo Soto
 */
package lamina;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import modelo.Componente;

/**
 * La clase "LaminaTexto" que contiene un JTextPane donde se pondrá el texto del editor.
 * 
 * @see JScrollPane
 * @see JTextPane
 */
public class LaminaTexto extends JScrollPane {

	/** La constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** El undo manager. */
	// Variables
	private UndoManager undoManager;

	/** La acción de deshacer. */
	private UndoAction undoAction;

	/** La acción de rehacer. */
	private RedoAction redoAction;

	/** El popup menú. */
	private JPopupMenu popupMenu;

	/** El panel de texto. */
	private JTextPane textPane;

	/** La localidad. */
	private Locale locale;

	/**
	 * Inicializa una lámina de texto.
	 */
	public LaminaTexto() {
		// Iniciar las variables
		locale = getLocale();
		undoManager = new UndoManager();
		undoAction = new UndoAction();
		redoAction = new RedoAction();

		textPane = new JTextPane();
		textPane.setAutoscrolls(false);
		// Obtener el documento para hacer el deshacer y el hacer
		textPane.getDocument().addUndoableEditListener(new UndoListener());

		// Creacion del popup pero se añadirán elementos en la ventana
		popupMenu = new JPopupMenu();
		textPane.setComponentPopupMenu(popupMenu);

		setViewportView(textPane);
	}

	/**
	 * Obtiene el popup menú.
	 *
	 * @return el popup menú
	 */
	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}

	/**
	 * Obtiene el JtextPane.
	 *
	 * @return the text pane
	 */
	public JTextPane getTextPane() {
		return textPane;
	}

	/**
	 * Obtiene la acción de deshacer.
	 *
	 * @return la acción deshacer
	 */
	public UndoAction getUndoAction() {
		return undoAction;
	}

	/**
	 * Obtiene la acción de rehacer.
	 *
	 * @return la acción rehacer
	 */
	public RedoAction getRedoAction() {
		return redoAction;
	}

	/**
	 * Cambiar idioma y las etiquetas de rehacer y deshacer.
	 *
	 * @param locale La localidad.
	 */
	public void cambiarIdiomaUndoRedo(Locale locale) {
		if (!this.locale.equals(locale)) {
			// Poner los nombres y que luego al cambiar de idioma sea más fácil
			undoAction.putValue(Action.NAME, Componente.getRecurso("textDeshacer", locale));
			redoAction.putValue(Action.NAME, Componente.getRecurso("textRedo", locale));
		}
	}

	/**
	 * La clase "UndoListener" recive eventos de deshacer y hacer, extiende de
	 * "UndoableEditListener".
	 *
	 * @see UndoAction
	 * @see RedoAction
	 * @see UndoableEditListener
	 */
	// Listener para el deshacer y rehacer
	private class UndoListener implements UndoableEditListener {

		/**
		 * Método llamado cuando editamos es texto.
		 *
		 * @param e El evento
		 */
		@Override
		public void undoableEditHappened(UndoableEditEvent e) {
			// Actualizar ambos componentes
			undoManager.addEdit(e.getEdit());
			undoAction.update();
			redoAction.update();
		}

	}

	/**
	 * La clase "UndoAction", una acción cuya funcionalidad es de deshacer los cambios que han
	 * habido en el texto.
	 * 
	 * @see AbstractAction
	 */
	// Clase deshacer
	private class UndoAction extends AbstractAction {

		/** La constante serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/**
		 * Inicializa una nueva accion de deshacer.
		 */
		public UndoAction() {
			// Ponemos el nombre y el atajo de teclado
			setLocale(locale);
			this.putValue(Action.NAME, Componente.getRecurso("textDeshacer", locale));
			this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
			this.setEnabled(false);
		}

		/**
		 * Método actionPerformed.
		 *
		 * @param arg0 El evento.
		 */
		// Al ser un AbstractAction es necesario implementarlo
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (this.isEnabled()) {
				undoManager.undo();
				undoAction.update();
				redoAction.update();
			}
		}

		/**
		 * Actualiza el botón de deshacer, lo habilita si hay algo que deshacer.
		 */
		// Método para actualizar los valores que se van a retomar
		public void update() {
			this.putValue(Action.NAME, Componente.getRecurso("textDeshacer", locale));
			this.setEnabled(undoManager.canUndo());
		}

	}

	/**
	 * La clase RedoAction representa la acción de rehacer.
	 */
	// Igual que la clase UndoAction
	class RedoAction extends AbstractAction {

		/** La constante serialVersionUID. */
		private static final long serialVersionUID = 1L;

		/**
		 * Instacion un nuevo objeto de la clase RedoAction.
		 */
		public RedoAction() {
			setLocale(locale);
			this.putValue(Action.NAME, Componente.getRecurso("textRedo", locale));
			this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_DOWN_MASK));
			this.setEnabled(false);
		}

		/**
		 * El método actionPerformed de la clase.
		 *
		 * @param e El evento.
		 */
		public void actionPerformed(ActionEvent e) {
			if (this.isEnabled()) {
				undoManager.redo();
				undoAction.update();
				redoAction.update();
			}
		}

		/**
		 * Actualiza el botón de rehacer, lo habilita si hay algo que rehacer.
		 */
		public void update() {
			this.putValue(Action.NAME, Componente.getRecurso("textRedo", locale));
			this.setEnabled(undoManager.canRedo());
		}
	}
}
