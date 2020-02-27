/**
 * @author: María Inmaculada Campillo Soto
 */
package lamina;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;

import componente.AbrirArchivo;
import componente.GuardarArchivo;
import componente.InsertarImagen;
import componente.Ortografia;
import componente.Salir;
import listenner.AbrirArchivoListener;
import listenner.GuardarArchivoListener;
import listenner.InsertarImagenListener;
import listenner.SalirListener;
import modelo.Lamina;

/**
 * La clase "LaminaMenuSuperiorArriba" contine los JToggleButton de las clases heredadas
 * de "Componente", esta clase se situará en la parte superior del editor pero en el
 * primer novel.
 * 
 * @see modelo.Lamina
 * @see modelo.Componente
 * @see lamina.LaminaMenuSuperiorAbajo
 */
public class LaminaMenuSuperiorArriba extends Lamina {

	/** La constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** La ortografía es seleccionada o no. */
	// Variables que usaremos y pondremos en una parte del menu de herramientas
	private boolean ortografiaSelected;

	/** El menú de herramientas. */
	private JToolBar menuHerramientas;

	/** Objeto para abrir un archivo. */
	private AbrirArchivo abrirArchivo;

	/** Objeto para guardar un archivo. */
	private GuardarArchivo guardarArchivo;

	/** Objeto de insertar imagen. */
	private InsertarImagen insertarImagen;

	/** La ortografía. */
	private Ortografia ortografia;

	/** El objeto para salir. */
	private Salir salir;

	/**
	 * Inicialización de variables.
	 *
	 * @param laminaTexto La lámina que contiene el texto.
	 * @param locale      La localidad.
	 */
	public void inicializacionVariables(LaminaTexto laminaTexto, Locale locale) {
		// Inicializacion de la varibles
		abrirArchivo = new AbrirArchivo("imagenAbrirArchivo", "textAbrirArchivo", null, locale,
				new AbrirArchivoListener(laminaTexto, locale));
		anyadirComponente(abrirArchivo);

		guardarArchivo = new GuardarArchivo("imagenGuardarArchivo", "textGuardarArchivo", null, locale,
				new GuardarArchivoListener(laminaTexto, locale));
		anyadirComponente(guardarArchivo);

		insertarImagen = new InsertarImagen("imagenInsertarImagen", "textInsertarImagen",
				"textInsertarImagenDescripcion", locale, new InsertarImagenListener(laminaTexto, locale));
		anyadirComponente(insertarImagen);

		ortografia = new Ortografia("imagenOrtografia", "textCorregirOrtografia", null, locale, new ActionListener() {

			// Para ortografia, altener su propio popup hay que quietar uno y poner otro
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!ortografiaSelected) {
					laminaTexto.getTextPane().remove(laminaTexto.getTextPane().getComponentPopupMenu());
					laminaTexto.getTextPane().setComponentPopupMenu(null);
					// Poner los diccionarios que tenga el usuario
					SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
					// Si los tenemos fuera de la aplicacion hay que enlazarlos
					SpellChecker.registerDictionaries(null, null);
					// Registar la lamina donde se escribe
					SpellChecker.register(laminaTexto.getTextPane());
				} else {
					// Quitar el popup y poner el que hemos creado
					SpellChecker.unregister(laminaTexto.getTextPane());
					laminaTexto.getTextPane().setComponentPopupMenu(laminaTexto.getPopupMenu());
				}
				ortografiaSelected = !ortografiaSelected;
			}
		});

		anyadirComponente(ortografia);

		salir = new Salir("imagenSalir", "nombreSalir", "textSalirDescripcion", locale, new SalirListener(locale));
		anyadirComponente(salir);
	}

	/**
	 * Configurar el menú de herramientas, añadiendole los elementos a este.
	 */
	private void configurarBox() {
		// Poner elementos en el menú de herramientas
		menuHerramientas = new JToolBar();
		menuHerramientas.setFloatable(false);

		menuHerramientas.add(abrirArchivo.getComponenteToggleButton());
		menuHerramientas.add(guardarArchivo.getComponenteToggleButton());

		menuHerramientas.add(insertarImagen.getComponenteToggleButton());

		menuHerramientas.add(ortografia.getComponenteToggleButton());

		add(menuHerramientas);
	}

	/**
	 * Añade un componente, que son JToggleButton, al menú de herramientas.
	 *
	 * @param button El botón a añadir.
	 */
	// AÃ±adir futuros componentes al final de la barra de herramientas
	public void anyadirComponenteMenuHerramientas(JToggleButton button) {
		menuHerramientas.add(button);
	}

	/**
	 * Instancia un nuevo objeto que es una lámina de menú en la parte superior del editor de
	 * texto arriba.
	 *
	 * @param laminaTexto La lámina de texto.
	 */
	public LaminaMenuSuperiorArriba(LaminaTexto laminaTexto) {
		Locale locale = getLocale();
		setLayout(new FlowLayout());

		ortografiaSelected = false;

		inicializacionVariables(laminaTexto, locale);

		configurarBox();
	}

	/**
	 * Obtiene el objeto de abrir archivo.
	 *
	 * @return el objeto de abrir archivo
	 */
	public AbrirArchivo getAbrirArchivo() {
		return abrirArchivo;
	}

	/**
	 * Obtiene el objeto de guardar archivo.
	 *
	 * @return el objeto de guardar archivo
	 */
	public GuardarArchivo getGuardarArchivo() {
		return guardarArchivo;
	}

	/**
	 * Obtiene el objeto de insertar imagen.
	 *
	 * @return the insertar imagen
	 */
	public InsertarImagen getInsertarImagen() {
		return insertarImagen;
	}

	/**
	 * Obtiene el objeto de la ortografía.
	 *
	 * @return el objeto de la ortografía
	 */
	public Ortografia getOrtografia() {
		return ortografia;
	}

	/**
	 * Obtiene el objeto de salir.
	 *
	 * @return el objeto de salir
	 */
	public Salir getSalir() {
		return salir;
	}

}
