package especial;

import java.awt.GraphicsEnvironment;
import java.util.Locale;

import lamina.LaminaTexto;
import modelo.Especial;

public class Fuente extends Especial<String> {

	public Fuente(Locale locale, LaminaTexto laminaTexto, String nombreProperty, int numeroElementosMenu, String[] elementos) {
		super(locale, laminaTexto, nombreProperty, numeroElementosMenu, elementos);
	}

	// Este es diferente al su clase hermana porque se puede sacar las fuentes desde aqui
	public Fuente(Locale locale, LaminaTexto laminaTexto, String nombreProperty, int numeroElementosMenu) {
		this(locale, laminaTexto, nombreProperty, numeroElementosMenu,
				GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
	}

}
