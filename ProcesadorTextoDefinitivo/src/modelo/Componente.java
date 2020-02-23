package modelo;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;

public class Componente {
	// Constantes
	public static final String PROPERTY_FILE = "property/Etiquetas";
	public static final int ANCHO_IMAGEN = 20;
	public static final int ALTO_IMAGEN = 20;

	// Variables propias de cada componente
	private String imageIconString;
	private ImageIcon imageIcon;
	private String nombre;
	private final String nombreProperty;
	private String descripcion;
	private final String nombreDescripcionProperty;
	private Locale locale;
	private ActionListener actionListener;
	private JMenuItem item;
	private JToggleButton button;

	// Obtenemos un objeto JToggleButton para la laminaMenuSuperior
	public JToggleButton getComponenteToggleButton() {
		button = new JToggleButton(imageIcon);
		button.addActionListener(actionListener);
		button.setName(nombre);
		if (descripcion == null) {
			button.setToolTipText(nombre);
		} else {
			button.setToolTipText(descripcion);
		}

		return button;
	}

	// Obtenemos un objeto JMenuItem apara la barra de menús de la ventana
	public JMenuItem getComponenteMenuItem(Integer keyEvent, Integer inputEvent) {
		item = new JMenuItem(nombre, imageIcon);
		item.addActionListener(actionListener);
		if (keyEvent != null || inputEvent != null) {
			item.setAccelerator(KeyStroke.getKeyStroke(keyEvent, inputEvent));
		}

		return item;
	}

	// Método para facilitar el cambio de idioma
	public void actualizarIdioma(String imageIconString, Locale locale, ActionListener actionListener) {
		// Si no se cambia y se llama a este método, no hace nada
		if (!this.locale.equals(locale)) {
			inicializarVariables(imageIconString, nombreProperty, nombreDescripcionProperty, locale, actionListener);
			// Puede que no queramos tener el JToggleButton de un componente
			if (button != null) {
				button.setName(getRecurso(nombreProperty));
				// Añadimos una descripcion al botón cuando mantenemos el ratón encima
				if (descripcion == null) {
					button.setToolTipText(getRecurso(nombreProperty));
				} else {
					button.setToolTipText(getRecurso(nombreDescripcionProperty));
				}
			}
			// Puede que no queramos tener el JMenuItem de un componente
			if (item != null) {
				item.setText(getRecurso(nombreProperty));
			}
		}
	}

	// Obtemos el nombre del recurso
	public String getRecurso(String nombreRecurso) {
		return ResourceBundle.getBundle(PROPERTY_FILE, locale).getString(nombreRecurso);
	}

	// Obtenemos el nombre del recurso, método que se puede usar para cualquier objeto
	public static String getRecurso(String nombreRecurso, Locale locale) {
		return ResourceBundle.getBundle(PROPERTY_FILE, locale).getString(nombreRecurso);
	}

	public static Image redimensionar(String imageIconString, Locale locale) {
		// Estas lineas nos facilitan el creado y redimensionado de la imagen para el JMenuItem y
		// JToggleButton
		ImageIcon imagenIcon = new ImageIcon(getRecurso(imageIconString, locale));
		Image image = imagenIcon.getImage().getScaledInstance(ANCHO_IMAGEN, ALTO_IMAGEN, Image.SCALE_DEFAULT);
		return image;
	}

	// Está fuera del constructor porque es más fácil a la hora de traducir e cambiar los
	// valores
	public void inicializarVariables(String imageIconString, String nombreProperty, String nombreDescripcionProperty,
			Locale locale, ActionListener actionListener) {
		this.locale = locale;
		this.imageIconString = imageIconString;
		this.actionListener = actionListener;
		this.imageIcon = new ImageIcon(redimensionar(imageIconString, locale));
		this.nombre = getRecurso(nombreProperty);
		if (descripcion != null) {
			this.descripcion = getRecurso(nombreDescripcionProperty);
		}
	}

	// El constructor
	public Componente(String imageIconString, String nombreProperty, String nombreDescripcionProperty, Locale locale,
			ActionListener actionListener) {
		this.nombreProperty = nombreProperty;
		this.nombreDescripcionProperty = nombreDescripcionProperty;
		inicializarVariables(imageIconString, nombreProperty, nombreDescripcionProperty, locale, actionListener);
	}

	// Getters
	public String getImageIconString() {
		return imageIconString;
	}

	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Locale getLocale() {
		return locale;
	}

	public ActionListener getActionListener() {
		return actionListener;
	}

	public JMenuItem getItem() {
		return item;
	}

	public JToggleButton getButton() {
		return button;
	}

	public String getNombreDescripcionProperty() {
		return nombreDescripcionProperty;
	}

	public String getNombreProperty() {
		return nombreProperty;
	}

}
