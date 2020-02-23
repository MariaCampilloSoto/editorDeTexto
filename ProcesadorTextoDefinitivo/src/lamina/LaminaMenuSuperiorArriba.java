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

public class LaminaMenuSuperiorArriba extends Lamina {
	private static final long serialVersionUID = 1L;
	// Variables que usaremos y pondremos en una parte del menu de herramientas
	private boolean ortografiaSelected;

	private JToolBar menuHerramientas;

	private AbrirArchivo abrirArchivo;
	private GuardarArchivo guardarArchivo;

	private InsertarImagen insertarImagen;

	private Ortografia ortografia;

	private Salir salir;

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

	// Añadir futuros componentes al final de la barra de herramientas
	public void anyadirComponenteMenuHerramientas(JToggleButton button) {
		menuHerramientas.add(button);
	}

	public LaminaMenuSuperiorArriba(LaminaTexto laminaTexto) {
		Locale locale = getLocale();
		setLayout(new FlowLayout());

		ortografiaSelected = false;

		inicializacionVariables(laminaTexto, locale);

		configurarBox();
	}

	public AbrirArchivo getAbrirArchivo() {
		return abrirArchivo;
	}

	public GuardarArchivo getGuardarArchivo() {
		return guardarArchivo;
	}

	public InsertarImagen getInsertarImagen() {
		return insertarImagen;
	}

	public Ortografia getOrtografia() {
		return ortografia;
	}

	public Salir getSalir() {
		return salir;
	}

}
