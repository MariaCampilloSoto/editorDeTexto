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
	public static final String PROPERTY_FILE = "property/Etiquetas";
	public static final int ANCHO_IMAGEN = 20;
	public static final int ALTO_IMAGEN = 20;
	
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
	
	public JToggleButton getComponenteToggleButton() {
		button = new JToggleButton(imageIcon);
		button.addActionListener(actionListener);
		button.setName(nombre);
		if(descripcion == null) {
			button.setToolTipText(nombre);
		} else {
			button.setToolTipText(descripcion);
		}
		
		return button;
	}
	
	public JMenuItem getComponenteMenuItem(Integer keyEvent, Integer inputEvent) {
		item = new JMenuItem(nombre, imageIcon);
		item.addActionListener(actionListener);
		if(keyEvent != null || inputEvent != null) {
			item.setAccelerator(KeyStroke.getKeyStroke(keyEvent, inputEvent));
		}
		
		return item;
	}
	
	public void actualizarIdioma(String imageIconString, Locale locale, ActionListener actionListener) {
		if(!this.locale.equals(locale)) {
			inicializarVariables(imageIconString, nombreProperty, nombreDescripcionProperty, locale, actionListener);
			if(button != null) {
				button.setName(getRecurso(nombreProperty));
				if(descripcion == null) {
					button.setToolTipText(getRecurso(nombreProperty));
				} else {
					button.setToolTipText(getRecurso(nombreDescripcionProperty));
				}
			}
			
			if(item != null) {
				item.setText(getRecurso(nombreProperty));
			}
		}
	}
	
	public String getRecurso(String nombreRecurso) {
		return ResourceBundle.getBundle(PROPERTY_FILE, locale).getString(nombreRecurso);
	}
	
	public static String getRecurso(String nombreRecurso, Locale locale) {
		return ResourceBundle.getBundle(PROPERTY_FILE, locale).getString(nombreRecurso);
	}

	public static Image redimensionar(String imageIconString, Locale locale) {
		ImageIcon imagenIcon = new ImageIcon(getRecurso(imageIconString, locale));
		Image image = imagenIcon.getImage().getScaledInstance(ANCHO_IMAGEN, ALTO_IMAGEN, Image.SCALE_DEFAULT);
		return image;
	}
	
	public void inicializarVariables(String imageIconString, String nombreProperty, String nombreDescripcionProperty, Locale locale, ActionListener actionListener) {
		this.locale = locale;
		this.imageIconString = imageIconString;
		this.actionListener = actionListener;
		this.imageIcon = new ImageIcon(redimensionar(imageIconString, locale));
		this.nombre = getRecurso(nombreProperty);
		if(descripcion != null) {
			this.descripcion = getRecurso(nombreDescripcionProperty);
		}
	}
	
	public Componente(String imageIconString, String nombreProperty, String nombreDescripcionProperty, Locale locale, ActionListener actionListener) {
		this.nombreProperty = nombreProperty;
		this.nombreDescripcionProperty = nombreDescripcionProperty;
		inicializarVariables(imageIconString, nombreProperty, nombreDescripcionProperty, locale, actionListener);
	}

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
