package componente;

import java.awt.event.ActionListener;
import java.util.Locale;

import modelo.Componente;

public class InsertarImagen extends Componente {

	public InsertarImagen(String imageIconString, String nombreProperty, String nombreDescripcionProperties,
			Locale locale, ActionListener actionListener) {
		super(imageIconString, nombreProperty, nombreDescripcionProperties, locale, actionListener);
	}
}