package lamina;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class LaminaTexto extends JScrollPane {
	private static final long serialVersionUID = 1L;

	private UndoManager undoManager;
	private UndoAction undoAction;
	private RedoAction redoAction;

	private JTextPane textPane;

	public LaminaTexto() {
		undoManager = new UndoManager();
		undoAction = new UndoAction();
		redoAction = new RedoAction();

		textPane = new JTextPane();
		textPane.setAutoscrolls(false);
		textPane.getDocument().addUndoableEditListener(new UndoListener());
		crearPopup();

		setViewportView(textPane);
	}

	public void crearPopup() {
		JPopupMenu popupMenu = new JPopupMenu();
		textPane.setComponentPopupMenu(popupMenu);
	}

	public JPopupMenu getPopupMenu() {
		JPopupMenu p = textPane.getComponentPopupMenu();
		return p;
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

	private class UndoListener implements UndoableEditListener {

		@Override
		public void undoableEditHappened(UndoableEditEvent e) {
			undoManager.addEdit(e.getEdit());
			undoAction.update();
			redoAction.update();
		}

	}

	private class UndoAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public UndoAction() {
			this.putValue(Action.NAME, undoManager.getUndoPresentationName());
			this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
			this.setEnabled(false);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (this.isEnabled()) {
				undoManager.undo();
				undoAction.update();
				redoAction.update();
			}
		}

		public void update() {
			this.putValue(Action.NAME, undoManager.getUndoPresentationName());
			this.setEnabled(undoManager.canUndo());
		}

	}

	class RedoAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public RedoAction() {
			this.putValue(Action.NAME, undoManager.getRedoPresentationName());
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
			this.putValue(Action.NAME, undoManager.getRedoPresentationName());
			this.setEnabled(undoManager.canRedo());
		}
	}
}
