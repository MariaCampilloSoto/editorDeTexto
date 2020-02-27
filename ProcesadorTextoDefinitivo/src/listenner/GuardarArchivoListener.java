/**
 * @author: María Inmaculada Campillo Soto
 */
package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import lamina.LaminaTexto;
import modelo.Componente;

/**
 * El escuchador que recive eventos de la clase "GuardarArchivo" e interactua con el
 * editor de texto, guardando el contenido en un archivo.
 *
 * @see componente.GuardarArchivo
 */
public class GuardarArchivoListener implements ActionListener {

	/** La lámina de texto. */
	private LaminaTexto laminaTexto;

	/** La localidad. */
	private Locale locale;

	/**
	 * El texto de la ventana emergente que sale si no se selecciona un archivo corectamente.
	 */
	private String texto;

	/**
	 * El título de la ventana emergente que sale si no se selecciona un archivo corectamente.
	 */
	private String titulo;

	/**
	 * Poner el texto correspondiente en la ventana emergente según la localidad.
	 *
	 * @param locale La localidad.
	 */
	public void ponerTextoTitulo(Locale locale) {
		texto = Componente.getRecurso("errorGuardarArchivo", locale);
		titulo = Componente.getRecurso("tituloError", locale);
	}

	/**
	 * Instancia un nuevo escuchador.
	 *
	 * @param laminaTexto La lámina de texto
	 * @param locale      La localidad
	 */
	public GuardarArchivoListener(LaminaTexto laminaTexto, Locale locale) {
		this.laminaTexto = laminaTexto;
		this.locale = locale;
		ponerTextoTitulo(locale);
	}

	/**
	 * Método que abre una ventana emergente que facilita la búsqueda de un archivo a guardar
	 * o se creará uno nuevo.
	 *
	 * @param e El evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setLocale(locale);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter filtro = new FileNameExtensionFilter(".mcs", "mcs");
		fileChooser.setFileFilter(filtro);
		int seleccion = fileChooser.showSaveDialog(laminaTexto.getTextPane());

		if (JFileChooser.APPROVE_OPTION == seleccion) {
			try {
				File archivo = fileChooser.getSelectedFile();
				if (!archivo.exists()) {
					try {
						archivo.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}

				PrintStream salida = new PrintStream(archivo + ".mcs");
				salida.print(laminaTexto.getTextPane().getText());
				salida.close();

			} catch (FileNotFoundException ex) {
				JOptionPane.showMessageDialog(null, texto + ex.getMessage(), titulo, JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
