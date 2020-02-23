package lamina;

import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import componente.Centrado;
import componente.ColorComponente;
import componente.Cursiva;
import componente.Derecha;
import componente.Izquierda;
import componente.Justificado;
import componente.Negrita;
import componente.Subrayado;
import especial.Fuente;
import especial.Tamanyo;
import listenner.CentradoListener;
import listenner.ColorListener;
import listenner.CursivaListener;
import listenner.DchaListener;
import listenner.IzqListener;
import listenner.JustificadoListener;
import listenner.NegritaListener;
import listenner.SubrayadoListener;
import modelo.Lamina;

public class LaminaMenuSuperiorAbajo extends Lamina {
	private static final long serialVersionUID = 1L;
	// Variables que vamos a usar
	public static final int MAXIMO_TAMANYO = 84;

	private Fuente fuente;

	private Tamanyo tamanyo;

	private Negrita negrita;
	private Cursiva cursiva;
	private Subrayado subrayado;

	private Izquierda izquierda;
	private Centrado centrado;
	private Derecha derecha;
	private Justificado justificado;

	private ColorComponente colorPanel;

	private void inicializacionVariables(LaminaTexto laminaTexto, Locale locale) {
		// Inicializacion variables
		fuente = new Fuente(locale, laminaTexto, "textFuente", 25);

		// Creamos una lista de numeros para ponerlos en el JToolBar
		Integer[] listaNumeros = ponerNumerosArray();
		tamanyo = new Tamanyo(locale, laminaTexto, "textTamanyo", 11, listaNumeros);

		negrita = new Negrita("imagenNegrita", "textNegrita", "textNegritaDescripcion", locale, new NegritaListener());
		anyadirComponente(negrita);

		cursiva = new Cursiva("imagenCursiva", "textCursiva", "textCursivaDescripcion", locale, new CursivaListener());
		anyadirComponente(cursiva);

		subrayado = new Subrayado("imagenSubrayado", "textSubrayado", "textSubrayadoDescripcion", locale,
				new SubrayadoListener());
		anyadirComponente(subrayado);

		izquierda = new Izquierda("imagenIzquierda", "textIzquierda", "textIzquierdaDescripcion", locale,
				new IzqListener());
		anyadirComponente(izquierda);

		centrado = new Centrado("imagenCentrado", "textCentrado", "textCentradoDescripcion", locale,
				new CentradoListener());
		anyadirComponente(centrado);

		derecha = new Derecha("imagenDerecha", "textDerecha", "textDerechaDescripcion", locale, new DchaListener());
		anyadirComponente(derecha);

		justificado = new Justificado("imagenJustificado", "textJustificado", "textJustificadoDescripcion", locale,
				new JustificadoListener());
		anyadirComponente(justificado);

		colorPanel = new ColorComponente("imagenColor", "textColor", null, locale, new ColorListener(laminaTexto));
		anyadirComponente(colorPanel);
	}

	private void configuracionBox() {
		// Creamos el toolbar
		JToolBar menuHerramientas = new JToolBar();
		menuHerramientas.setFloatable(false);

		// Añadimos los botones
		menuHerramientas.add(fuente.getComboBox());
		menuHerramientas.add(tamanyo.getComboBox());
		menuHerramientas.add(negrita.getComponenteToggleButton());
		menuHerramientas.add(cursiva.getComponenteToggleButton());
		menuHerramientas.add(subrayado.getComponenteToggleButton());

		// En concreto hacemos un grupo con la alineacion
		ButtonGroup grupoAlineacion = new ButtonGroup();
		JToggleButton izquierda = this.izquierda.getComponenteToggleButton();
		JToggleButton centrado = this.centrado.getComponenteToggleButton();
		JToggleButton derecha = this.derecha.getComponenteToggleButton();
		JToggleButton justificado = this.justificado.getComponenteToggleButton();

		grupoAlineacion.add(izquierda);
		grupoAlineacion.add(centrado);
		grupoAlineacion.add(derecha);
		grupoAlineacion.add(justificado);

		menuHerramientas.add(izquierda);
		menuHerramientas.add(centrado);
		menuHerramientas.add(derecha);
		menuHerramientas.add(justificado);

		menuHerramientas.add(colorPanel.getComponenteToggleButton());

		add(menuHerramientas);
	}

	private Integer[] ponerNumerosArray() {
		// Para poner ciertos nuemos en el toolbar, de lo contraio serían muchos y el usuario se
		// estresaría
		int i = 0;
		int numeroTamanyo = 1;
		// Cogemos el numero de elementos
		while (numeroTamanyo < MAXIMO_TAMANYO) {
			if (numeroTamanyo < 10) {
				numeroTamanyo += 3;
			}

			if (numeroTamanyo >= 10 && numeroTamanyo < 40) {
				numeroTamanyo += 2;
			}

			if (numeroTamanyo >= 40) {
				numeroTamanyo += 5;
			}
			i++;

		}

		// Teniendo el numero de elementos que vamos a poner, creamos un array
		Integer[] listaNumeros = new Integer[i];
		i = 0;
		numeroTamanyo = 1;
		while (numeroTamanyo < 84) {
			if (numeroTamanyo < 10) {
				listaNumeros[i] = numeroTamanyo;
				numeroTamanyo += 3;
			}

			if (numeroTamanyo >= 10 && numeroTamanyo < 40) {
				listaNumeros[i] = numeroTamanyo;
				numeroTamanyo += 2;
			}

			if (numeroTamanyo >= 40) {
				listaNumeros[i] = numeroTamanyo;
				numeroTamanyo += 5;
			}

			i++;

		}

		return listaNumeros;
	}

	public LaminaMenuSuperiorAbajo(LaminaTexto laminaTexto) {
		// Cogemos el locale que le pasaremos a las variables
		Locale locale = getLocale();

		inicializacionVariables(laminaTexto, locale);

		configuracionBox();
	}

	public Fuente getFuente() {
		return fuente;
	}

	public Tamanyo getTamanyo() {
		return tamanyo;
	}

	public Negrita getNegrita() {
		return negrita;
	}

	public Cursiva getCursiva() {
		return cursiva;
	}

	public Subrayado getSubrayado() {
		return subrayado;
	}

	public Izquierda getIzquierda() {
		return izquierda;
	}

	public Centrado getCentrado() {
		return centrado;
	}

	public Derecha getDerecha() {
		return derecha;
	}

	public Justificado getJustificado() {
		return justificado;
	}

	public ColorComponente getColorPanel() {
		return colorPanel;
	}

}
