/**
 * @author: María Inmaculada Campillo Soto
 */

package ventana;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import componente.MenuEditor;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Locale;

import lamina.LaminaMenuSuperiorArriba;
import lamina.LaminaMenuSuperiorAbajo;
import lamina.LaminaPrincipal;
import lamina.LaminaTexto;
import listenner.AbrirArchivoListener;
import listenner.AcercaDeListener;
import listenner.GuardarArchivoListener;
import listenner.InsertarImagenListener;
import listenner.SalirListener;
import listenner.VentanaListener;
import modelo.Componente;

/**
 * La clase "Ventana" que contiene una barra en la parte superior (JMenuBar), cambia el
 * idioma del programa y el aspecto y la lámina principal.
 * 
 * @see lamina.LaminaPrincipal
 */
public class Ventana extends JFrame {

	/** La constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** La constante ANCHO_VENTANA. */
	public static final int ANCHO_VENTANA = 800;

	/** La constante ALTO_VENTANA. */
	public static final int ALTO_VENTANA = 500;

	/** La constante MAXIMO_TAMANYO, número máximo que puede aumenta el tamaño. */
	public static final int MAXIMO_TAMANYO = 84;

	/** La constante NUMERO_SKINS. */
	public static final int NUMERO_SKINS = 13;

	/** La localidad. */
	private Locale locale;

	/** El nombre del botón de español. */
	public static String ESPANYOL;

	/** El nombre del botón de inglés. */
	public static String INGLES;

	/** El nombre del botón de francés. */
	public static String FRANCES;

	/** El nombre del botón de alemán. */
	public static String ALEMAN;

	/** La lámina principal. */
	private LaminaPrincipal laminaPrincipal;

	/** La lámina del menú superior abajo. */
	private LaminaMenuSuperiorAbajo laminaMenuSuperiorAbajo;

	/** La lámina del menú superior arriba. */
	private LaminaMenuSuperiorArriba laminaMenuSuperiorArriba;

	/** La lámina de texto. */
	private LaminaTexto laminaTexto;

	/** El JMenu de archivo. */
	private JMenu archivoMenu;

	/** El JMenu de insertar. */
	private JMenu insertarMenu;

	/** El JMenu de formato. */
	private JMenu formatoMenu;

	/** El JMenu de texto. */
	private JMenu textoMenu;

	/** El JMenu de alinear . */
	private JMenu alinearMenu;

	/** El JMenu de color. */
	private JMenu colorMenu;

	/** El JMenu de herramientas. */
	private JMenu herramientasMenu;

	/** El JMenu de ayuda. */
	private JMenu ayuda;

	/** El JMenuItem de "acerca de". */
	private JMenuItem acercaDeItem;

	/** El JMenuItem de abrir archivo. */
	private JMenuItem abrirArchivo;

	/** El JMenuItem de guardar archivo. */
	private JMenuItem guardarArchivo;

	/** El JMenuItem de salir. */
	private JMenuItem salir;

	/** El menú editor . */
	private MenuEditor editorMenu;

	/** El JMenuItem de negrita. */
	private JMenuItem negrita;

	/** El JMenuItem de cursiva. */
	private JMenuItem cursiva;

	/** El JMenuItem de subrayado. */
	private JMenuItem subrayado;

	/** El JMenuItem de ortografia. */
	private JMenuItem ortografia;

	/** El JMenu de skin. */
	private JMenu skinMenu;

	/** Un array con el nombre de los temas para el cambio de aspecto. */
	private String[] nombreTemas;

	/** El JMenuItem de insertar imagen. */
	private JMenuItem insertarImagen;

	/** El JMenuItem de izquierda. */
	private JMenuItem izquierda;

	/** El JMenuItem de centrado. */
	private JMenuItem centrado;

	/** El JMenuItem de derecha. */
	private JMenuItem derecha;

	/** El JMenuItem de justificado. */
	private JMenuItem justificado;

	/** El JMenuItem de negrita del menú emergente o popup. */
	private JMenuItem negritaEmergente;

	/** El JMenuItem de cursiva del menú emergente o popup. */
	private JMenuItem cursivaEmergente;

	/** El JMenuItem de subrayado del menú emergente o popup. */
	private JMenuItem subrayadoEmergente;

	/** El JMenuItem de izquierda del menú emergente o popup. */
	private JMenuItem izquierdaEmergente;

	/** El JMenuItem de centrado del menú emergente o popup. */
	private JMenuItem centradoEmergente;

	/** El JMenuItem de derecha del menú emergente o popup. */
	private JMenuItem derechaEmergente;

	/** El JMenuItem de justificado del menú emergente o popup. */
	private JMenuItem justificadoEmergente;

	/** El JMenu de fuente. */
	private JMenu fuente;

	/** El JMenu de tamaño. */
	private JMenu tamanyo;

	/** El JMenuItem del color. */
	private JMenuItem colorPanel;

	/** El popup o menú emergente. */
	private JPopupMenu popUpMenu;

	/** El JToggleButton del idioma "español". */
	private JToggleButton espanyol;

	/** El JToggleButton del idioma "inglés". */
	private JToggleButton ingles;

	/** El JToggleButton del idioma "francés". */
	private JToggleButton frances;

	/** El JToggleButton del idioma "alemán". */
	private JToggleButton aleman;

	/**
	 * Configuración inicial de la ventana.
	 */
	private void configuracionInicial() {
		// Ponemos la localidad por defecto
		locale = new Locale("es");

		// Inicializamos unas varibles importantes, las del idioma
		ESPANYOL = Componente.getRecurso("textEspanyol", locale);
		INGLES = Componente.getRecurso("textIngles", locale);
		FRANCES = Componente.getRecurso("textFrances", locale);
		ALEMAN = Componente.getRecurso("textAleman", locale);

		// Configuramos el tamaÃ±o de la ventana.
		setSize(ANCHO_VENTANA, ALTO_VENTANA);
		// Ponemos titulo
		setTitle(Componente.getRecurso("tituloVentana", locale));
		// Para que se puede agrandar o empequeÃ±ecer
		setResizable(true);

		// Ponemos icono
		setIconImage(Componente.redimensionar("imagenIconoEditor", locale));
		// Para que nos pregunte antes de cerrar y aÃ±adimos un listener que hemos creado
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new VentanaListener(locale));

		// Ponemos la ventana en medio de la pantalla
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();

		int x = (int) dimension.getWidth() / 2;
		int y = (int) dimension.getHeight() / 2;

		int centroX = x - ANCHO_VENTANA / 2;
		int centroY = y - ALTO_VENTANA / 2;

		setLocation(centroX, centroY);
	}

	/**
	 * Inicialización de variables.
	 */
	public void inicializacionVariables() {
		nombreTemas = new String[NUMERO_SKINS];

		nombreTemas[0] = "Texture";
		nombreTemas[1] = "Smart";
		nombreTemas[2] = "Noire";
		nombreTemas[3] = "Acryl";
		nombreTemas[4] = "Aero";
		nombreTemas[5] = "Aluminium";
		nombreTemas[6] = "Bernstein";
		nombreTemas[7] = "Fast";
		nombreTemas[8] = "Graphite";
		nombreTemas[9] = "HiFi";
		nombreTemas[10] = "Luna";
		nombreTemas[11] = "McWin";
		nombreTemas[12] = "Mint";

		laminaPrincipal = new LaminaPrincipal();
		laminaMenuSuperiorAbajo = laminaPrincipal.getLaminaMenuSuperiorAbajo();
		laminaMenuSuperiorArriba = laminaPrincipal.getLaminaMenuSuperiorArriba();
		laminaTexto = laminaPrincipal.getLaminaTexto();

		abrirArchivo = laminaMenuSuperiorArriba.getAbrirArchivo().getComponenteMenuItem(KeyEvent.VK_O,
				InputEvent.CTRL_DOWN_MASK);
		guardarArchivo = laminaMenuSuperiorArriba.getGuardarArchivo().getComponenteMenuItem(KeyEvent.VK_S,
				InputEvent.CTRL_DOWN_MASK);
		salir = laminaMenuSuperiorArriba.getSalir().getComponenteMenuItem(KeyEvent.VK_F4, InputEvent.ALT_DOWN_MASK);

		editorMenu = new MenuEditor(Componente.getRecurso("tituloEditorMenu", locale), laminaTexto);

		fuente = laminaMenuSuperiorAbajo.getFuente().getNewMenu();

		tamanyo = laminaMenuSuperiorAbajo.getTamanyo().getNewMenu();

		ortografia = laminaMenuSuperiorArriba.getOrtografia().getComponenteMenuItem(null, null);
		skinMenu = new JMenu(Componente.getRecurso("cambioFuenteSkin", locale));

		insertarImagen = laminaMenuSuperiorArriba.getInsertarImagen().getComponenteMenuItem(null, null);

		// InicializaciÃ³n de variables para el JMenuBar
		negrita = laminaMenuSuperiorAbajo.getNegrita().getComponenteMenuItem(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK);
		cursiva = laminaMenuSuperiorAbajo.getCursiva().getComponenteMenuItem(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK);
		subrayado = laminaMenuSuperiorAbajo.getSubrayado().getComponenteMenuItem(KeyEvent.VK_U,
				InputEvent.CTRL_DOWN_MASK);

		izquierda = laminaMenuSuperiorAbajo.getIzquierda().getComponenteMenuItem(KeyEvent.VK_L,
				InputEvent.CTRL_DOWN_MASK);
		centrado = laminaMenuSuperiorAbajo.getCentrado().getComponenteMenuItem(KeyEvent.VK_T,
				InputEvent.CTRL_DOWN_MASK);
		derecha = laminaMenuSuperiorAbajo.getDerecha().getComponenteMenuItem(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK);
		justificado = laminaMenuSuperiorAbajo.getJustificado().getComponenteMenuItem(KeyEvent.VK_J,
				InputEvent.CTRL_DOWN_MASK);

		colorPanel = laminaMenuSuperiorAbajo.getColorPanel().getComponenteMenuItem(null, null);

		// Inilizacion de variables para el PopupMenu porque no se puede aÃ±adir dos
		// veces a dos sitios distintos
		negritaEmergente = laminaMenuSuperiorAbajo.getNegrita().getComponenteMenuItem(KeyEvent.VK_B,
				InputEvent.CTRL_DOWN_MASK);
		cursivaEmergente = laminaMenuSuperiorAbajo.getCursiva().getComponenteMenuItem(KeyEvent.VK_I,
				InputEvent.CTRL_DOWN_MASK);
		subrayadoEmergente = laminaMenuSuperiorAbajo.getSubrayado().getComponenteMenuItem(KeyEvent.VK_U,
				InputEvent.CTRL_DOWN_MASK);

		izquierdaEmergente = laminaMenuSuperiorAbajo.getIzquierda().getComponenteMenuItem(KeyEvent.VK_L,
				InputEvent.CTRL_DOWN_MASK);
		centradoEmergente = laminaMenuSuperiorAbajo.getCentrado().getComponenteMenuItem(KeyEvent.VK_T,
				InputEvent.CTRL_DOWN_MASK);
		derechaEmergente = laminaMenuSuperiorAbajo.getDerecha().getComponenteMenuItem(KeyEvent.VK_R,
				InputEvent.CTRL_DOWN_MASK);
		justificadoEmergente = laminaMenuSuperiorAbajo.getJustificado().getComponenteMenuItem(KeyEvent.VK_J,
				InputEvent.CTRL_DOWN_MASK);

		popUpMenu = laminaTexto.getPopupMenu();
	}

	/**
	 * Inialización de variables relacionado con el idioma del editor de texto.
	 */
	public void inializacionVariablesIdioma() {
		espanyol = new JToggleButton(new ImageIcon(Componente.redimensionar("imagenEspanyol", locale)));
		espanyol.setName(Componente.getRecurso("textEspanyol", locale));
		espanyol.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				configuracionIdioma(e);
			}
		});
		ingles = new JToggleButton(new ImageIcon(Componente.redimensionar("imagenIngles", locale)));
		ingles.setName(Componente.getRecurso("textIngles", locale));
		ingles.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				configuracionIdioma(e);
			}
		});
		frances = new JToggleButton(new ImageIcon(Componente.redimensionar("imagenFrances", locale)));
		frances.setName(Componente.getRecurso("textFrances", locale));
		frances.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				configuracionIdioma(e);
			}
		});
		aleman = new JToggleButton(new ImageIcon(Componente.redimensionar("imagenAleman", locale)));
		aleman.setName(Componente.getRecurso("textAleman", locale));
		aleman.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				configuracionIdioma(e);
			}
		});
	}

	/**
	 * Configuración lámina del menú superior del primero nivel, en este método se añade los
	 * idiomas y el boton de salir.
	 */
	public void configuracionLaminaMenuSuperiorArriba() {
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(espanyol);
		grupo.add(ingles);
		grupo.add(frances);
		grupo.add(aleman);
		laminaMenuSuperiorArriba.anyadirComponenteMenuHerramientas(espanyol);
		laminaMenuSuperiorArriba.anyadirComponenteMenuHerramientas(ingles);
		laminaMenuSuperiorArriba.anyadirComponenteMenuHerramientas(frances);
		laminaMenuSuperiorArriba.anyadirComponenteMenuHerramientas(aleman);

		laminaMenuSuperiorArriba
				.anyadirComponenteMenuHerramientas(laminaMenuSuperiorArriba.getSalir().getComponenteToggleButton());
	}

	/**
	 * Configuración del JMenuBar, este método añade elementos al menú de la ventana.
	 */
	private void configuracionJMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		archivoMenu = new JMenu();
		archivoMenu.add(abrirArchivo);
		archivoMenu.add(guardarArchivo);
		archivoMenu.add(new JSeparator());
		archivoMenu.add(salir);
		menuBar.add(archivoMenu);

		editorMenu.add(new JSeparator());
		editorMenu.add(laminaTexto.getUndoAction());
		editorMenu.add(laminaTexto.getRedoAction());
		menuBar.add(editorMenu);

		insertarMenu = new JMenu();
		insertarMenu.add(insertarImagen);
		menuBar.add(insertarMenu);

		menuBar.add(fuente);
		menuBar.add(tamanyo);

		formatoMenu = new JMenu();

		textoMenu = new JMenu();
		textoMenu.add(negrita);
		textoMenu.add(cursiva);
		textoMenu.add(subrayado);
		formatoMenu.add(textoMenu);

		alinearMenu = new JMenu();
		alinearMenu.add(izquierda);
		alinearMenu.add(centrado);
		alinearMenu.add(derecha);
		alinearMenu.add(justificado);
		formatoMenu.add(alinearMenu);

		menuBar.add(formatoMenu);

		colorMenu = new JMenu();
		colorMenu.add(colorPanel);
		menuBar.add(colorMenu);

		herramientasMenu = new JMenu();
		herramientasMenu.add(ortografia);

		for (String nombre : nombreTemas) {
			JMenuItem item = new JMenuItem(nombre);
			item.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String n = ((JMenuItem) e.getSource()).getText();
					cambioSkin("com.jtattoo.plaf." + n.toLowerCase() + "." + n + "LookAndFeel");
				}
			});

			skinMenu.add(item);
		}
		herramientasMenu.add(skinMenu);
		menuBar.add(herramientasMenu);

		ayuda = new JMenu();
		acercaDeItem = new JMenuItem();
		acercaDeItem.addActionListener(new AcercaDeListener(locale));
		ayuda.add(acercaDeItem);
		menuBar.add(ayuda);

		ponerNombreMenu();
		setJMenuBar(menuBar);
	}

	/**
	 * Configuración del menú emergente o popup.
	 */
	public void configuracionMenuEmergente() {
		popUpMenu.add(negritaEmergente);
		popUpMenu.add(cursivaEmergente);
		popUpMenu.add(subrayadoEmergente);
		popUpMenu.add(new JSeparator());
		popUpMenu.add(izquierdaEmergente);
		popUpMenu.add(centradoEmergente);
		popUpMenu.add(derechaEmergente);
		popUpMenu.add(justificadoEmergente);
	}

	/**
	 * Configuración final de la ventana.
	 */
	public void configuracionFinal() {
		setContentPane(laminaPrincipal);
		setVisible(true);
	}

	/**
	 * Poner nombre a los menús del JMenuBar.
	 */
	public void ponerNombreMenu() {
		archivoMenu.setText(Componente.getRecurso("tituloArchivo", locale));
		insertarMenu.setText(Componente.getRecurso("tituloInsertar", locale));
		formatoMenu.setText(Componente.getRecurso("tituloFormato", locale));
		textoMenu.setText(Componente.getRecurso("tituloTexto", locale));
		alinearMenu.setText(Componente.getRecurso("tituloAlinear", locale));
		colorMenu.setText(Componente.getRecurso("tituloColor", locale));
		herramientasMenu.setText(Componente.getRecurso("tituloHerramientas", locale));
		ayuda.setText(Componente.getRecurso("tituloAyuda", locale));
		acercaDeItem.setText(Componente.getRecurso("tituloAcercaDeItem", locale));
	}

	/**
	 * Configuración del idioma donde se cambia el idioma según el botón seleccionado.
	 *
	 * @param e El evento de los botones de cambiar el idioma
	 */
	public void configuracionIdioma(ActionEvent e) {
		String nombre = ((JToggleButton) e.getSource()).getName();
		if (INGLES.equals(nombre)) {
			locale = new Locale("en");
			List<Componente> componentesIngles = laminaMenuSuperiorAbajo.getComponentes();
			for (Componente componente : componentesIngles) {
				componente.actualizarIdioma(componente.getImageIconString(), locale, componente.getActionListener());
			}

			componentesIngles = laminaMenuSuperiorArriba.getComponentes();
			for (Componente componente : componentesIngles) {
				componente.actualizarIdioma(componente.getImageIconString(), locale, componente.getActionListener());
				if (componente.getActionListener() instanceof SalirListener) {
					((SalirListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}
				if (componente.getActionListener() instanceof AbrirArchivoListener) {
					((AbrirArchivoListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}

				if (componente.getActionListener() instanceof GuardarArchivoListener) {
					((GuardarArchivoListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}

				if (componente.getActionListener() instanceof InsertarImagenListener) {
					((InsertarImagenListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}
			}
			((AcercaDeListener) acercaDeItem.getActionListeners()[0]).ponerTextoTitulo(locale);
			((VentanaListener) getWindowListeners()[0]).ponerTextoTitulo(locale);
			ponerNombreMenu();
			laminaTexto.cambiarIdiomaUndoRedo(locale);
			skinMenu.setText(Componente.getRecurso("cambioFuenteSkin", locale));
			editorMenu.ponerNombreAcciones(locale);
			editorMenu.setText(Componente.getRecurso("tituloEditorMenu", locale));
			this.setTitle(Componente.getRecurso("tituloVentana", locale));
			laminaMenuSuperiorAbajo.getFuente().cambiarIdioma(locale);
			laminaMenuSuperiorAbajo.getTamanyo().cambiarIdioma(locale);

		} else if (FRANCES.equals(nombre)) {
			locale = new Locale("fr");
			List<Componente> componentesFrances = laminaMenuSuperiorAbajo.getComponentes();
			for (Componente componente : componentesFrances) {
				componente.actualizarIdioma(componente.getImageIconString(), locale, componente.getActionListener());
			}

			componentesFrances = laminaMenuSuperiorArriba.getComponentes();
			for (Componente componente : componentesFrances) {
				componente.actualizarIdioma(componente.getImageIconString(), locale, componente.getActionListener());
				if (componente.getActionListener() instanceof SalirListener) {
					((SalirListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}

				if (componente.getActionListener() instanceof AbrirArchivoListener) {
					((AbrirArchivoListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}

				if (componente.getActionListener() instanceof GuardarArchivoListener) {
					((GuardarArchivoListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}

				if (componente.getActionListener() instanceof InsertarImagenListener) {
					((InsertarImagenListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}
			}

			((AcercaDeListener) acercaDeItem.getActionListeners()[0]).ponerTextoTitulo(locale);
			((VentanaListener) getWindowListeners()[0]).ponerTextoTitulo(locale);
			ponerNombreMenu();
			laminaTexto.cambiarIdiomaUndoRedo(locale);
			editorMenu.ponerNombreAcciones(locale);
			this.setTitle(Componente.getRecurso("tituloVentana", locale));
			skinMenu.setText(Componente.getRecurso("cambioFuenteSkin", locale));
			editorMenu.setText(Componente.getRecurso("tituloEditorMenu", locale));
			laminaMenuSuperiorAbajo.getFuente().cambiarIdioma(locale);
			laminaMenuSuperiorAbajo.getTamanyo().cambiarIdioma(locale);

		} else if (ALEMAN.equals(nombre)) {
			locale = new Locale("de");
			List<Componente> componentesAleman = laminaMenuSuperiorAbajo.getComponentes();
			for (Componente componente : componentesAleman) {
				componente.actualizarIdioma(componente.getImageIconString(), locale, componente.getActionListener());
			}

			componentesAleman = laminaMenuSuperiorArriba.getComponentes();
			for (Componente componente : componentesAleman) {
				componente.actualizarIdioma(componente.getImageIconString(), locale, componente.getActionListener());
				if (componente.getActionListener() instanceof SalirListener) {
					((SalirListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}

				if (componente.getActionListener() instanceof AbrirArchivoListener) {
					((AbrirArchivoListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}

				if (componente.getActionListener() instanceof GuardarArchivoListener) {
					((GuardarArchivoListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}

				if (componente.getActionListener() instanceof InsertarImagenListener) {
					((InsertarImagenListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}
			}

			((AcercaDeListener) acercaDeItem.getActionListeners()[0]).ponerTextoTitulo(locale);
			((VentanaListener) getWindowListeners()[0]).ponerTextoTitulo(locale);
			ponerNombreMenu();
			editorMenu.ponerNombreAcciones(locale);
			laminaTexto.cambiarIdiomaUndoRedo(locale);
			this.setTitle(Componente.getRecurso("tituloVentana", locale));
			skinMenu.setText(Componente.getRecurso("cambioFuenteSkin", locale));
			editorMenu.setText(Componente.getRecurso("tituloEditorMenu", locale));
			laminaMenuSuperiorAbajo.getFuente().cambiarIdioma(locale);
			laminaMenuSuperiorAbajo.getTamanyo().cambiarIdioma(locale);

		} else {
			locale = new Locale("es");
			List<Componente> componentesEspanyol = laminaMenuSuperiorAbajo.getComponentes();
			for (Componente componente : componentesEspanyol) {
				componente.actualizarIdioma(componente.getImageIconString(), locale, componente.getActionListener());
			}

			ponerNombreMenu();
			componentesEspanyol = laminaMenuSuperiorArriba.getComponentes();
			for (Componente componente : componentesEspanyol) {
				componente.actualizarIdioma(componente.getImageIconString(), locale, componente.getActionListener());
				if (componente.getActionListener() instanceof SalirListener) {
					((SalirListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}

				if (componente.getActionListener() instanceof AbrirArchivoListener) {
					((AbrirArchivoListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}

				if (componente.getActionListener() instanceof GuardarArchivoListener) {
					((GuardarArchivoListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}

				if (componente.getActionListener() instanceof InsertarImagenListener) {
					((InsertarImagenListener) componente.getActionListener()).ponerTextoTitulo(locale);
				}
			}

			((AcercaDeListener) acercaDeItem.getActionListeners()[0]).ponerTextoTitulo(locale);
			((VentanaListener) getWindowListeners()[0]).ponerTextoTitulo(locale);
			editorMenu.ponerNombreAcciones(locale);
			laminaTexto.cambiarIdiomaUndoRedo(locale);
			this.setTitle(Componente.getRecurso("tituloVentana", locale));
			skinMenu.setText(Componente.getRecurso("cambioFuenteSkin", locale));
			editorMenu.setText(Componente.getRecurso("tituloEditorMenu", locale));
			laminaMenuSuperiorAbajo.getFuente().cambiarIdioma(locale);
			laminaMenuSuperiorAbajo.getTamanyo().cambiarIdioma(locale);

		}
	}

	/**
	 * Cambia el aspecto del editor de texto.
	 *
	 * @param nombreSkin el nombre del aspecto o skin a cambiar
	 */
	public void cambioSkin(String nombreSkin) {
		try {
			UIManager.setLookAndFeel(nombreSkin);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Instancia una nueva ventana.
	 */
	public Ventana() {
		configuracionInicial();

		inicializacionVariables();

		inializacionVariablesIdioma();

		configuracionLaminaMenuSuperiorArriba();

		configuracionJMenuBar();

		configuracionMenuEmergente();

		configuracionFinal();
	}

	/**
	 * Estable la localidad.
	 *
	 * @param locale la localidad
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
