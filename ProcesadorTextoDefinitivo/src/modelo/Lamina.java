package modelo;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class Lamina extends JPanel {
	private static final long serialVersionUID = 1L;

	public static final int NUMERO_MAXIMO_TAMANYO = 84;

	private List<Componente> componentes;

	public void anyadirComponente(Componente componente) {
		componentes.add(componente);
	}

	public void anyadirComponente(int index, Componente componente) {
		componentes.add(index, componente);
	}

	public Lamina() {
		componentes = new LinkedList<Componente>();
	}

	public List<Componente> getComponentes() {
		return componentes;
	}
}
