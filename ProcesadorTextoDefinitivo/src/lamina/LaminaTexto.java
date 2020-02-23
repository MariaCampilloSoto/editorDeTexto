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

public class LaminaTexto extends JScrollPane {
	private static final long serialVersionUID = 1L;

	// Variables
	private UndoManager undoManager;
	private UndoAction undoAction;
	private RedoAction redoAction;

	private JPopupMenu popupMenu;

	private JTextPane textPane;
	private Locale locale;

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

		// Creacion del popup pero se añadiran elementos en la ventana
		popupMenu = new JPopupMenu();
		textPane.setComponentPopupMenu(popupMenu);

		setViewportView(textPane);
	}

	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}

	public JTextPane getTextPane() {
		return textPane;
	}

	public UndoAction getUndoAction() {
		return undoAction;
	}

	public RedoAction getRedoAction() {
		return redoAction;
	}

	public void cambiarIdiomaUndoRedo(Locale locale) {
		if (!this.locale.equals(locale)) {
			// Poner los nombres y que luego al cambiar de idioma sea más fácil
			undoAction.putValue(Action.NAME, Componente.getRecurso("textDeshacer", locale));
			redoAction.putValue(Action.NAME, Componente.getRecurso("textRedo", locale));
		}
	}

	// Listener para el deshacer
	private class UndoListener implements UndoableEditListener {

		@Override
		public void undoableEditHappened(UndoableEditEvent e) {
			// Actualizar ambos componentes
			undoManager.addEdit(e.getEdit());
			undoAction.update();
			redoAction.update();
		}

	}

	// Clase deshacer
	private class UndoAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public UndoAction() {
			// Ponemos el nombre y el atajo de teclado
			setLocale(locale);
			this.putValue(Action.NAME, Componente.getRecurso("textDeshacer", locale));
			this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
			this.setEnabled(false);
		}

		// Al ser un AbstractAction es necesario implementarlo
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (this.isEnabled()) {
				undoManager.undo();
				undoAction.update();
				redoAction.update();
			}
		}
		// Método para actualizar los valores que se van a retomar
		public void update() {
			this.putValue(Action.NAME, Componente.getRecurso("textDeshacer", locale));
			this.setEnabled(undoManager.canUndo());
		}

	}

	//Igual que la clase UndoAction
	class RedoAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public RedoAction() {
			setLocale(locale);
			this.putValue(Action.NAME, Componente.getRecurso("textRedo", locale));
			this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_DOWN_MASK));
			this.setEnabled(false);
		}

		public void actionPerformed(ActionEvent e) {
			if (this.isEnabled()) {
				undoManager.redo();
				undoAction.update();
				redoAction.update();
			}
		}

		public void update() {
			this.putValue(Action.NAME, Componente.getRecurso("textRedo", locale));
			this.setEnabled(undoManager.canRedo());
		}
	}
}
