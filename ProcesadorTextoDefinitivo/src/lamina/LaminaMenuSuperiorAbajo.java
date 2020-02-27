/**
 * @author: María Inmaculada Campillo Soto
 */
package lamina;

import java.util.Locale;

import javax.swing.ButtonGroup;
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

/**
 * La clase "LaminaMenuSuperiorAbajo" contiene los JToggleButton de las clases heredadas
 * de "Componente", esta clase se situará en la parte superior del editor pero en segundo
 * nivel.
 * 
 * @see modelo.Lamina
 * @see modelo.Componente
 * @see lamina.LaminaMenuSuperiorArriba
 */
public class LaminaMenuSuperiorAbajo extends Lamina {

	/** La constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** La constante MAXIMO_TAMANYO, número máximo que tendrá el tamaño. */
	// Variables que vamos a usar
	public static final int MAXIMO_TAMANYO = 84;

	/** La fuente. */
	private Fuente fuente;

	/** El tamaño. */
	private Tamanyo tamanyo;

	/** La negrita. */
	private Negrita negrita;

	/** La cursiva. */
	private Cursiva cursiva;

	/** El subrayado. */
	private Subrayado subrayado;

	/** La izquierda. */
	private Izquierda izquierda;

	/** El centrado. */
	private Centrado centrado;

	/** La derecha. */
	private Derecha derecha;

	/** El justificado. */
	private Justificado justificado;

	/** El color del texto del panel. */
	private ColorComponente colorPanel;

	/**
	 * Inicialización de las variables.
	 *
	 * @param laminaTexto La lámina que contiene el texto.
	 * @param locale      La localización.
	 */
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

	/**
	 * Configuración del JToolBar.
	 */
	private void configuracionToolBar() {
		// Creamos el toolbar
		JToolBar menuHerramientas = new JToolBar();
		menuHerramientas.setFloatable(false);

		// AÃ±adimos los botones
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

	/**
	 * Ponemos números en un array con diferentes tamaños que podrá adoptar la letra.
	 *
	 * @return El array de enteros
	 */
	private Integer[] ponerNumerosArray() {
		// Para poner ciertos numeros en el toolbar, de lo contrario serán muchos y el usuario se
		// estresará
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

		// Teniendo el número de elementos que vamos a poner, creamos un array
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

	/**
	 * Inicializa una nueva lámina con el menú de herramientas superior pero en el segundo
	 * nivel.
	 *
	 * @param laminaTexto la lámina detexto
	 */
	public LaminaMenuSuperiorAbajo(LaminaTexto laminaTexto) {
		// Cogemos el locale que le pasaremos a las variables
		Locale locale = getLocale();
		// Inicializamos las variables
		inicializacionVariables(laminaTexto, locale);
		// Ponermos los elementos en el JToolBar
		configuracionToolBar();
	}

	/**
	 * Obtiene la fuente.
	 *
	 * @return la fuente
	 */
	public Fuente getFuente() {
		return fuente;
	}

	/**
	 * Obtiene el tamaño.
	 *
	 * @return el tamaño
	 */
	public Tamanyo getTamanyo() {
		return tamanyo;
	}

	/**
	 * Obtiene la negrita.
	 *
	 * @return la negrita
	 */
	public Negrita getNegrita() {
		return negrita;
	}

	/**
	 * Obtiene la cursiva.
	 *
	 * @return la cursiva
	 */
	public Cursiva getCursiva() {
		return cursiva;
	}

	/**
	 * Obtiene el subrayado.
	 *
	 * @return el subrayado
	 */
	public Subrayado getSubrayado() {
		return subrayado;
	}

	/**
	 * Obtiene la izquierda.
	 *
	 * @return la izquierda
	 */
	public Izquierda getIzquierda() {
		return izquierda;
	}

	/**
	 * Obtiene el centrado.
	 *
	 * @return el centrado
	 */
	public Centrado getCentrado() {
		return centrado;
	}

	/**
	 * Obtiene la derecha.
	 *
	 * @return la derecha
	 */
	public Derecha getDerecha() {
		return derecha;
	}

	/**
	 * Obtiene el justificado.
	 *
	 * @return el justificado
	 */
	public Justificado getJustificado() {
		return justificado;
	}

	/**
	 * Obtiene el objeto que cambia el color del texto.
	 *
	 * @return el objeto color
	 */
	public ColorComponente getColorPanel() {
		return colorPanel;
	}

}
