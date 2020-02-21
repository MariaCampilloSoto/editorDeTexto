package componente;

import java.awt.event.ActionListener;
import java.util.Locale;

import modelo.Componente;

public class ColorComponente extends Componente {

	public ColorComponente(String imageIconString, String nombreProperty, String nombreDescripcionProperty,
			Locale locale, ActionListener actionListener) {
		super(imageIconString, nombreProperty, nombreDescripcionProperty, locale, actionListener);
	}
}
