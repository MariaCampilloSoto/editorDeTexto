package lamina;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class LaminaPrincipal extends JPanel {
	private static final long serialVersionUID = 1L;

	// Contiene la barra de herramientas que son dos laminas y donde se escribe el texto
	private LaminaMenuSuperiorAbajo laminaMenuSuperiorAbajo;
	private LaminaMenuSuperiorArriba laminaMenuSuperiorArriba;
	private LaminaTexto laminaTexto;

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

	public LaminaMenuSuperiorAbajo getLaminaMenuSuperiorAbajo() {
		return laminaMenuSuperiorAbajo;
	}

	public LaminaMenuSuperiorArriba getLaminaMenuSuperiorArriba() {
		return laminaMenuSuperiorArriba;
	}

	public LaminaTexto getLaminaTexto() {
		return laminaTexto;
	}

}
