package especial;

import java.awt.GraphicsEnvironment;

import lamina.LaminaTexto;
import modelo.Especial;

public class Fuente extends Especial<String> {

	public Fuente(LaminaTexto laminaTexto, String nombreProperty, int numeroElementosMenu, String[] elementos) {
		super(laminaTexto, nombreProperty, numeroElementosMenu, elementos);
	}

	public Fuente(LaminaTexto laminaTexto, String nombreProperty, int numeroElementosMenu) {
		this(laminaTexto, nombreProperty, numeroElementosMenu,
				GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
	}

}
