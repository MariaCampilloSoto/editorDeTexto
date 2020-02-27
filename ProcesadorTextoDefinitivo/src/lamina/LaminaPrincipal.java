/**
 * @author: Mar�a Inmaculada Campillo Soto
 */
package lamina;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * La clase "LaminaPrincipal" que contiene el resto de l�minas del paquete y las organiza.
 * 
 * @see lamina.LaminaMenuSuperiorAbajo
 * @see lamina.LaminaMenuSuperiorArriba
 * @see lamina.LaminaTexto
 */
public class LaminaPrincipal extends JPanel {

	/** La constate serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** La l�mina del men� superior de abajo. */
	// Contiene la barra de herramientas que son dos laminas y donde se escribe el texto
	private LaminaMenuSuperiorAbajo laminaMenuSuperiorAbajo;

	/** La l�mina men� del superior de arriba. */
	private LaminaMenuSuperiorArriba laminaMenuSuperiorArriba;

	/** La l�mina de texto. */
	private LaminaTexto laminaTexto;

	/**
	 * Instancia una nueva l�mina principal.
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
	 * Obtiene la l�mina del men� superior de abajo.
	 *
	 * @return La l�mina del men� superior de abajo
	 */
	public LaminaMenuSuperiorAbajo getLaminaMenuSuperiorAbajo() {
		return laminaMenuSuperiorAbajo;
	}

	/**
	 * Obtiene la l�mina del men� superior de arriba.
	 *
	 * @return La l�mina del men� superior de arriba
	 */
	public LaminaMenuSuperiorArriba getLaminaMenuSuperiorArriba() {
		return laminaMenuSuperiorArriba;
	}

	/**
	 * Obtiene la l�mina de texto.
	 *
	 * @return la l�mina de texto
	 */
	public LaminaTexto getLaminaTexto() {
		return laminaTexto;
	}

}
