/**
 * @author: María Inmaculada Campillo Soto
 */
package lamina;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * La clase "LaminaPrincipal" que contiene el resto de láminas del paquete y las organiza.
 * 
 * @see lamina.LaminaMenuSuperiorAbajo
 * @see lamina.LaminaMenuSuperiorArriba
 * @see lamina.LaminaTexto
 */
public class LaminaPrincipal extends JPanel {

	/** La constate serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** La lámina del menú superior de abajo. */
	// Contiene la barra de herramientas que son dos laminas y donde se escribe el texto
	private LaminaMenuSuperiorAbajo laminaMenuSuperiorAbajo;

	/** La lámina menú del superior de arriba. */
	private LaminaMenuSuperiorArriba laminaMenuSuperiorArriba;

	/** La lámina de texto. */
	private LaminaTexto laminaTexto;

	/**
	 * Instancia una nueva lámina principal.
	 */
	public LaminaPrincipal() {
		// Ponemos un layout para poner poder poner las laminas de forma adecuada
		setLayout(new BorderLayout());

		laminaTexto = new LaminaTexto();

		laminaMenuSuperiorAbajo = new LaminaMenuSuperiorAbajo(laminaTexto);
		laminaMenuSuperiorArriba = new LaminaMenuSuperiorArriba(laminaTexto);

		// Se ponen ciertas laminas para que se ponga la barra de herramientas
		// (LaminaMenuSuperior) en la parte izquieda
		JPanel laminaMenuGeneral = new JPanel(new BorderLayout());
		JPanel laminaM1 = new JPanel();
		laminaM1.setLayout(new BorderLayout());
		laminaM1.add(laminaMenuSuperiorArriba, BorderLayout.LINE_START);
		JPanel laminaM2 = new JPanel();
		laminaM2.setLayout(new BorderLayout());
		laminaM2.add(laminaMenuSuperiorAbajo, BorderLayout.LINE_START);
		laminaMenuGeneral.add(laminaM1, BorderLayout.NORTH);
		laminaMenuGeneral.add(laminaM2, BorderLayout.SOUTH);

		add(laminaMenuGeneral, BorderLayout.NORTH);
		add(laminaTexto, BorderLayout.CENTER);
	}

	/**
	 * Obtiene la lámina del menú superior de abajo.
	 *
	 * @return La lámina del menú superior de abajo
	 */
	public LaminaMenuSuperiorAbajo getLaminaMenuSuperiorAbajo() {
		return laminaMenuSuperiorAbajo;
	}

	/**
	 * Obtiene la lámina del menú superior de arriba.
	 *
	 * @return La lámina del menú superior de arriba
	 */
	public LaminaMenuSuperiorArriba getLaminaMenuSuperiorArriba() {
		return laminaMenuSuperiorArriba;
	}

	/**
	 * Obtiene la lámina de texto.
	 *
	 * @return la lámina de texto
	 */
	public LaminaTexto getLaminaTexto() {
		return laminaTexto;
	}

}
