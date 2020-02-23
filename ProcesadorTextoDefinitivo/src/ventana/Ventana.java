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

public class Ventana extends JFrame {
	private static final long serialVersionUID = 1L;

	public static final int ANCHO_VENTANA = 800;
	public static final int ALTO_VENTANA = 500;
	public static final int MAXIMO_TAMANYO = 84;
	public static final int NUMERO_SKINS = 13;

	private Locale locale;

	public static String ESPANYOL;
	public static String INGLES;
	public static String FRANCES;
	public static String ALEMAN;

	private LaminaPrincipal laminaPrincipal;
	private LaminaMenuSuperiorAbajo laminaMenuSuperiorAbajo;
	private LaminaMenuSuperiorArriba laminaMenuSuperiorArriba;
	private LaminaTexto laminaTexto;

	private JMenu archivoMenu;
	private JMenu insertarMenu;
	private JMenu formatoMenu;
	private JMenu textoMenu;
	private JMenu alinearMenu;
	private JMenu colorMenu;
	private JMenu herramientasMenu;
	private JMenu ayuda;
	private JMenuItem acercaDeItem;

	private JMenuItem abrirArchivo;
	private JMenuItem guardarArchivo;
	private JMenuItem salir;

	private MenuEditor editorMenu;

	private JMenuItem negrita;
	private JMenuItem cursiva;
	private JMenuItem subrayado;

	private JMenuItem ortografia;
	private JMenu skinMenu;
	private String[] nombreTemas;

	private JMenuItem insertarImagen;

	private JMenuItem izquierda;
	private JMenuItem centrado;
	private JMenuItem derecha;
	private JMenuItem justificado;

	private JMenuItem negritaEmergente;
	private JMenuItem cursivaEmergente;
	private JMenuItem subrayadoEmergente;

	private JMenuItem izquierdaEmergente;
	private JMenuItem centradoEmergente;
	private JMenuItem derechaEmergente;
	private JMenuItem justificadoEmergente;

	private JMenu fuente;
	private JMenu tamanyo;

	private JMenuItem colorPanel;

	private JPopupMenu popUpMenu;

	private JToggleButton espanyol;
	private JToggleButton ingles;
	private JToggleButton frances;
	private JToggleButton aleman;

	private void configuracionInicial() {

		locale = new Locale("es");

		ESPANYOL = Componente.getRecurso("textEspanyol", locale);
		INGLES = Componente.getRecurso("textIngles", locale);
		FRANCES = Componente.getRecurso("textFrances", locale);
		ALEMAN = Componente.getRecurso("textAleman", locale);

		setSize(ANCHO_VENTANA, ALTO_VENTANA);
		setTitle(Componente.getRecurso("tituloVentana", locale));

		setResizable(true);

		setIconImage(Componente.redimensionar("imagenIconoEditor", locale));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new VentanaListener(locale));

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();

		int x = (int) dimension.getWidth() / 2;
		int y = (int) dimension.getHeight() / 2;

		int centroX = x - ANCHO_VENTANA / 2;
		int centroY = y - ALTO_VENTANA / 2;

		setLocation(centroX, centroY);
	}

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

		// Inicialización de variables para el JMenuBar
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

		// Inilizacion de variables para el PopupMenu porque no se puede añadir dos
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

	public void configuracionFinal() {
		setContentPane(laminaPrincipal);
		setVisible(true);
	}

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

	public void cambioSkin(String nombreSkin) {
		try {
			UIManager.setLookAndFeel(nombreSkin);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	public Ventana() {
		configuracionInicial();

		inicializacionVariables();

		inializacionVariablesIdioma();

		configuracionLaminaMenuSuperiorArriba();

		configuracionJMenuBar();

		configuracionMenuEmergente();

		configuracionFinal();
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
