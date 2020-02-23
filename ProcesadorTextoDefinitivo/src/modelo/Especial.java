package modelo;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.text.StyledEditorKit;

import lamina.LaminaTexto;

public class Especial<E> {
	// Para los JMenu, sus valores si cambian
	public final static String FUENTE = ResourceBundle.getBundle(Componente.PROPERTY_FILE).getString("textFuente");
	public final static String TAMANYO = ResourceBundle.getBundle(Componente.PROPERTY_FILE).getString("textTamanyo");

	private String nombre;
	private final String nombreProperty;
	private final int numeroElementosMenu;
	private JMenu menu;
	private JComboBox<E> combo;
	private E[] elementos;
	private LaminaTexto laminaTexto;

	public JComboBox<E> getComboBox() {
		combo = new JComboBox<E>(elementos);
		combo.setName(nombre);

		// Ponermos una fuente predeterminada con unos valores
		if (FUENTE.equals(combo.getName())) {
			combo.setSelectedIndex(30);
			laminaTexto.getTextPane().setFont(new Font(combo.getSelectedItem().toString(),
					laminaTexto.getTextPane().getFont().getStyle(), laminaTexto.getTextPane().getFont().getSize()));
		}

		if (TAMANYO.equals(combo.getName())) {
			combo.setSelectedIndex(12);
			combo.setPreferredSize(new Dimension(3 * Componente.ANCHO_IMAGEN, Componente.ALTO_IMAGEN));
			laminaTexto.getTextPane()
					.setFont(new Font(laminaTexto.getTextPane().getFont().getFontName(),
							laminaTexto.getTextPane().getFont().getStyle(),
							Integer.parseInt(combo.getSelectedItem().toString())));
		}

		// Tenemos un array de acciones para que cada elmento del JComboBox tenga su accion
		Action[] acciones = new Action[elementos.length];
		for (int i = 0; i < elementos.length; i++) {
			if (FUENTE.equals(combo.getName())) {
				acciones[i] = new StyledEditorKit.FontFamilyAction(
						ResourceBundle.getBundle(Componente.PROPERTY_FILE).getString("cambioLetra"),
						elementos[i].toString());
			}

			if (TAMANYO.equals(combo.getName())) {
				acciones[i] = new StyledEditorKit.FontSizeAction(
						ResourceBundle.getBundle(Componente.PROPERTY_FILE).getString("cambioTam"),
						Integer.parseInt(elementos[i].toString()));
			}
		}
		combo.addActionListener(new ActionListener() {
			// Buscamos si es igual y cambiamos la fuente o el tamaño dependiendo de lo que
			// seleccionemos
			@Override
			public void actionPerformed(ActionEvent e) {
				if (FUENTE.equals(combo.getName())) {
					for (int i = 0; i < elementos.length; i++) {
						if ((elementos[i].toString()).equals((String) combo.getSelectedItem())) {
							acciones[i].actionPerformed(e);
							break;
						}
					}
				}

				if (TAMANYO.equals(combo.getName())) {
					for (int i = 0; i < elementos.length; i++) {
						if (elementos[i] == combo.getSelectedItem()) {
							acciones[i].actionPerformed(e);
							break;
						}
					}
				}

			}
		});

		return combo;
	}

	public JMenu getNewMenu() {
		// Solamente crearemos ciertos JMenuItem
		menu = new JMenu(nombre);
		// Si se pasa de 15, el usuario agradecerá que pongamos un menu auxiliar
		JMenu otros = new JMenu(ResourceBundle.getBundle(Componente.PROPERTY_FILE).getString("textOtros"));
		int contadorE = 0;
		while (contadorE < numeroElementosMenu && contadorE < elementos.length) {
			JMenuItem item = null;
			Action accion = null;

			if (FUENTE.equals(menu.getText())) {
				item = new JMenuItem(elementos[contadorE].toString());
				accion = new StyledEditorKit.FontFamilyAction(elementos[contadorE].toString(),
						elementos[contadorE].toString());
			}

			if (TAMANYO.equals(menu.getText())) {
				item = new JMenuItem(elementos[contadorE * 2].toString());
				accion = new StyledEditorKit.FontSizeAction(elementos[contadorE * 2].toString(),
						Integer.parseInt(elementos[contadorE * 2].toString()));
			}

			if (accion != null) {
				item.setAction(accion);
			}

			if (contadorE < 15) {
				menu.add(item);
			}

			if (contadorE == 15) {
				menu.add(otros);
			}

			if (contadorE >= 15) {
				otros.add(item);
			}

			contadorE++;
		}
		return menu;
	}

	public void cambiarIdioma(Locale locale) {
		menu.setText(Componente.getRecurso(nombreProperty, locale));
		combo.setName(Componente.getRecurso(nombreProperty, locale));
	}

	@SafeVarargs
	public Especial(Locale locale, LaminaTexto laminaTexto, String nombreProperty, int numeroElementosMenu,
			E... elementos) {
		this.laminaTexto = laminaTexto;
		this.nombreProperty = nombreProperty;
		this.numeroElementosMenu = numeroElementosMenu;
		this.elementos = elementos;
		this.nombre = Componente.getRecurso(nombreProperty, locale);
	}

	public String getNombre() {
		return nombre;
	}

	public JComboBox<E> getCombo() {
		return combo;
	}

	public String getNombreProperty() {
		return nombreProperty;
	}

	public E[] getElementos() {
		return elementos;
	}

	public int getNumeroElementosMenu() {
		return numeroElementosMenu;
	}

	public JMenu getMenu() {
		return menu;
	}

}
