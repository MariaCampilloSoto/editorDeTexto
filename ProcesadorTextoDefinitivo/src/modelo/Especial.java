/**
 * @author: María Inmaculada Campillo Soto
 */
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

/**
 * La clase generica "Especial" en la que se puede prefentar en forma de JMenu o
 * JComboBox.
 *
 * @param <E> El tipo del elemento
 * 
 * @see especial.Tamanyo
 * @see especial.Fuente
 */
public class Especial<E> {

	/** La contante FUENTE con el texto del JMenu de la fuente. */
	// Para los JMenu, sus valores si cambian
	public final static String FUENTE = ResourceBundle.getBundle(Componente.PROPERTY_FILE).getString("textFuente");

	/** La constante TAMANYO con el texto del JMenu del tamaño. */
	public final static String TAMANYO = ResourceBundle.getBundle(Componente.PROPERTY_FILE).getString("textTamanyo");

	/** El nombre del recurso. */
	private String nombre;

	/**
	 * El nombre de la etiqueta del archivo properties que referencia al nombre del
	 * componente.
	 */
	private final String nombreProperty;

	/** El número de elementos en el menú. */
	private final int numeroElementosMenu;

	/** El menú. */
	private JMenu menu;

	/** El comboBox. */
	private JComboBox<E> combo;

	/** Lista de elementos. */
	private E[] elementos;

	/** La lámina del texto. */
	private LaminaTexto laminaTexto;

	/**
	 * Obtiene el combo box con un elemento predefinido, las acciones ya integradas en cada
	 * componente del combo.
	 *
	 * @return el combo box
	 * @see #getCombo()
	 */
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
			// Buscamos si es igual y cambiamos la fuente o el tamaÃ±o dependiendo de lo que
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

	/**
	 * Obtiene el menú con ciertos elementos del comboBox y cada uno de ellos con su acción.
	 *
	 * @return the new menu
	 * @see #getMenu()
	 */
	public JMenu getNewMenu() {
		// Solamente crearemos ciertos JMenuItem
		menu = new JMenu(nombre);
		// Si se pasa de 15, el usuario agradecerÃ¡ que pongamos un menu auxiliar
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

	/**
	 * Cambiar el idioma según la localidad.
	 *
	 * @param locale La localidad
	 */
	public void cambiarIdioma(Locale locale) {
		menu.setText(Componente.getRecurso(nombreProperty, locale));
		combo.setName(Componente.getRecurso(nombreProperty, locale));
	}

	/**
	 * Inicializa un nuevo objeto de la clase "Especial".
	 *
	 * @param locale              La localización.
	 * @param laminaTexto         La lámina del texto.
	 * @param nombreProperty      El nombre de la etiqueta del archivo properties que
	 *                            referencia al nombre del componente.
	 * @param numeroElementosMenu El número de elementos en el menú.
	 * @param elementos           Una array de elementos.
	 */
	@SafeVarargs
	public Especial(Locale locale, LaminaTexto laminaTexto, String nombreProperty, int numeroElementosMenu,
			E... elementos) {
		this.laminaTexto = laminaTexto;
		this.nombreProperty = nombreProperty;
		this.numeroElementosMenu = numeroElementosMenu;
		this.elementos = elementos;
		this.nombre = Componente.getRecurso(nombreProperty, locale);
	}

	/**
	 * Obtiene el nombre del elemento.
	 *
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene el combo pero sin crear un nuevo objeto.
	 *
	 * @return el comboBox
	 * 
	 * @see #getComboBox()
	 */
	public JComboBox<E> getCombo() {
		return combo;
	}

	/**
	 * Obtiene el nombre de la etiqueta del archivo properties.
	 *
	 * @return el nombre en el property
	 */
	public String getNombreProperty() {
		return nombreProperty;
	}

	/**
	 * Obtiene los elementos.
	 *
	 * @return los elementos
	 */
	public E[] getElementos() {
		return elementos;
	}

	/**
	 * Obtiene el número de elementos en el menú.
	 *
	 * @return el número elementos del menú
	 */
	public int getNumeroElementosMenu() {
		return numeroElementosMenu;
	}

	/**
	 * Obtiene el menú pero sin crear un nuevo objeto..
	 *
	 * @return el menú
	 * @see Especial#getNewMenu()
	 */
	public JMenu getMenu() {
		return menu;
	}

}
