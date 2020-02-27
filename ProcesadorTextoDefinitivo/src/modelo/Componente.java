/**
 * @author: María Inmaculada Campillo Soto
 */
package modelo;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;

/**
 * La clase "Componente" es la clase padre de algunos de las clases en el paquete
 * "componente", se puede obtener un JToggleButton o un JMenuItem.
 */
public class Componente {

	/** La constante PROPERTY_FILE donde se encuentra el archivo de property. */
	// Constantes
	public static final String PROPERTY_FILE = "property/Etiquetas";

	/** La constante ANCHO_IMAGEN que define el ancho de la imagen. */
	public static final int ANCHO_IMAGEN = 20;

	/** La constante ALTO_IMAGEN que define el ancho de la imagen. */
	public static final int ALTO_IMAGEN = 20;

	/**
	 * El nombre de la eitqueta del archivo de properties que hace referencia al enlace de la
	 * imagen del componente.
	 */
	// Variables propias de cada componente
	private String imageIconString;

	/** La imagen del componente. */
	private ImageIcon imageIcon;

	/** El nombre o texto del componente. */
	private String nombre;

	/**
	 * El nombre de la etiqueta del archivo de properties que hace referencia al nombre del
	 * componente.
	 */
	private final String nombreProperty;

	/**
	 * La descripcion del componente que aparecerá cuando situamos el ratón encima del
	 * JToggleButton.
	 */
	private String descripcion;

	/**
	 * El nombre de la etiqueta del archivo de properties que hace refenrecia a la descripción
	 * de componente.
	 */
	private final String nombreDescripcionProperty;

	/** La localidad. */
	private Locale locale;

	/** El escuchador. */
	private ActionListener actionListener;

	/** El JMenuItem. */
	private JMenuItem item;

	/** El JToggleButton. */
	private JToggleButton button;

	/**
	 * Obtiene un nuevo objeto referente al componente en forma de JToggleButton.
	 *
	 * @return El nuevo componente en forma de JToggleButton
	 * @see #getButton()
	 */
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

	/**
	 * Obtiene un nuevo objeto de componente en forma de JMenuItem.
	 *
	 * @param keyEvent   El evento de la tecla
	 * @param inputEvent El evento de entrada
	 * @return El JMenuItem del componente
	 */
	// Obtenemos un objeto JMenuItem apara la barra de menÃºs de la ventana
	public JMenuItem getComponenteMenuItem(Integer keyEvent, Integer inputEvent) {
		item = new JMenuItem(nombre, imageIcon);
		item.addActionListener(actionListener);
		if (keyEvent != null || inputEvent != null) {
			item.setAccelerator(KeyStroke.getKeyStroke(keyEvent, inputEvent));
		}

		return item;
	}

	/**
	 * Actualiza el idioma del componente poniendo el su nombre según la localidad.
	 *
	 * @param imageIconString El nombre de la etiqueta del archivo properties que referencia
	 *                        al enlace de la imagen del componente.
	 * @param locale          La localidad
	 * @param actionListener  El escuchador
	 */
	// MÃ©todo para facilitar el cambio de idioma
	public void actualizarIdioma(String imageIconString, Locale locale, ActionListener actionListener) {
		// Si no se cambia y se llama a este mÃ©todo, no hace nada
		if (!this.locale.equals(locale)) {
			inicializarVariables(imageIconString, nombreProperty, nombreDescripcionProperty, locale, actionListener);
			// Puede que no queramos tener el JToggleButton de un componente
			if (button != null) {
				button.setName(getRecurso(nombreProperty));
				// AÃ±adimos una descripcion al botÃ³n cuando mantenemos el ratÃ³n encima
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

	/**
	 * Obtiene el recurso que tiene la referencia según la etiqueta del archivo de propertiy.
	 *
	 * @param nombreRecurso El nombre de la etiqueta del recurso
	 * @return El recurso
	 * @see #getRecurso(String, Locale)
	 */
	// Obtemos el nombre del recurso
	public String getRecurso(String nombreRecurso) {
		return ResourceBundle.getBundle(PROPERTY_FILE, locale).getString(nombreRecurso);
	}

	/**
	 * Obtiene el recurso que contiene la referencia según la etiqueta del archivo de property
	 * y la localidad.
	 *
	 * @param nombreRecurso El nombre de la etiqueta del recurso
	 * @param locale        La localidad
	 * @return El recurso
	 * @see #getRecurso(String)
	 */
	// Obtenemos el nombre del recurso, mÃ©todo que se puede usar para cualquier objeto
	public static String getRecurso(String nombreRecurso, Locale locale) {
		return ResourceBundle.getBundle(PROPERTY_FILE, locale).getString(nombreRecurso);
	}

	/**
	 * Método para redimensionar una imagen.
	 *
	 * @param imageIconString El nombre de la etiqueta del archivo de properties que
	 *                        referencia al enlace de la imagen del componente.
	 * @param locale          La localidad
	 * @return La imagen redimensionada
	 */
	public static Image redimensionar(String imageIconString, Locale locale) {
		// Estas lineas nos facilitan el creado y redimensionado de la imagen para el JMenuItem y
		// JToggleButton
		ImageIcon imagenIcon = new ImageIcon(getRecurso(imageIconString, locale));
		Image image = imagenIcon.getImage().getScaledInstance(ANCHO_IMAGEN, ALTO_IMAGEN, Image.SCALE_DEFAULT);
		return image;
	}

	// Está fuera del constructor porque es mÃ¡s fÃ¡cil a la hora de traducir e cambiar los
	/**
	 * Inicializa las variables.
	 *
	 * @param imageIconString           El nombre de la etiqueta del archivo properties que
	 *                                  referencia al enlace de la imagen del componente.
	 * @param nombreProperty            El nombre de la etiqueta del archivo properties que
	 *                                  referencia al nombre del componente.
	 * @param nombreDescripcionProperty El nombre de la etiqueta del archivo properties que
	 *                                  referencia a la descripción del componente.
	 * @param locale                    La localización.
	 * @param actionListener            El escuchador que tendrá el componente.
	 */
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

	/**
	 * Instancia un nuevo componente.
	 *
	 * @param imageIconString           El nombre de la etiqueta del archivo properties que
	 *                                  referencia al enlace de la imagen del componente.
	 * @param nombreProperty            El nombre de la etiqueta del archivo properties que
	 *                                  referencia al nombre del componente.
	 * @param nombreDescripcionProperty El nombre de la etiqueta del archivo properties que
	 *                                  referencia a la descripción del componente.
	 * @param locale                    La localización.
	 * @param actionListener            El escuchador que tendrá el componente.
	 */
	// El constructor
	public Componente(String imageIconString, String nombreProperty, String nombreDescripcionProperty, Locale locale,
			ActionListener actionListener) {
		this.nombreProperty = nombreProperty;
		this.nombreDescripcionProperty = nombreDescripcionProperty;
		inicializarVariables(imageIconString, nombreProperty, nombreDescripcionProperty, locale, actionListener);
	}

	/**
	 * Obtiene el nombre de la etiqueta del archivo properties que referencia al enlace de la
	 * imagen del componente.
	 *
	 * @return el nombre de la etiquta
	 */
	// Getters
	public String getImageIconString() {
		return imageIconString;
	}

	/**
	 * Obtiene la imagen del componente.
	 *
	 * @return la imagen
	 */
	public ImageIcon getImageIcon() {
		return imageIcon;
	}

	/**
	 * Obtiene el nombre o texto del componente.
	 *
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene la descripción del componente.
	 *
	 * @return la descripción
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Obtiene la localidad del componente.
	 *
	 * @return la localidad
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Obtiene el escuchador del componente.
	 *
	 * @return el escuchador
	 */
	public ActionListener getActionListener() {
		return actionListener;
	}

	/**
	 * Obtiene el JMenuItem del componente sin crear un nuevo objeto.
	 *
	 * @return el JMenuItem
	 * @see #getComponenteMenuItem(Integer, Integer)
	 */
	public JMenuItem getItem() {
		return item;
	}

	/**
	 * Obtiene el JToggleButton del componente sin crear un nuevo objeto.
	 *
	 * @return el JToggleButton
	 * @see #getComponenteToggleButton()
	 */
	public JToggleButton getButton() {
		return button;
	}

	/**
	 * Obtiene el nombre de la etiqueta del archivo properties que referencia a la descripción
	 * del componente..
	 *
	 * @return el nombre de la etiqueta de la descripcion del componente
	 */
	public String getNombreDescripcionProperty() {
		return nombreDescripcionProperty;
	}

	/**
	 * Obtiene el nombre de la etiqueta del archivo properties que referencia al nombre del
	 * componente.
	 *
	 * @return El nombre de la etiqueta del nombre del componente
	 */
	public String getNombreProperty() {
		return nombreProperty;
	}

}
