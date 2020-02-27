/**
 * @author: María Inmaculada Campillo Soto
 */
package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import lamina.LaminaTexto;
import modelo.Componente;

/**
 * El escuchador que recibe eventos de la clase "AbrirArchivo" e inteactua con el editor de texto para abrir un archivo.
 *
 * @see componente.AbrirArchivo
 */
public class AbrirArchivoListener implements ActionListener {
	
	// Variables para el menu emergente
	/** La lámina de texto. */
	private LaminaTexto laminaTexto;

	/** La localidad. */
	private Locale locale;

	/**
	 * El texto de la ventana emergente que sale si no se selecciona un archivo correctamente.
	 */
	private String texto;

	/**
	 * El título de la ventana emergente que sale si no se selecciona un archivo correctamente.
	 */
	private String titulo;

	/**
	 * Poner el texto correspondiente en la ventana emergente según la localidad.
	 *
	 * @param locale La localidad.
	 */
	// Para el idioma
	public void ponerTextoTitulo(Locale locale) {
		texto = Componente.getRecurso("errorAbrirArchivo", locale);
		titulo = Componente.getRecurso("tituloError", locale);
	}

	/**
	 * Instancia un nuevo escuchador.
	 *
	 * @param laminaTexto La lámina de texto
	 * @param locale      La localidad
	 */
	public AbrirArchivoListener(LaminaTexto laminaTexto, Locale locale) {
		this.laminaTexto = laminaTexto;
		this.locale = locale;
		ponerTextoTitulo(locale);
	}

	/**
	 * Método que abre una ventana emergente que facilita la búsqueda de un archivo.
	 *
	 * @param e El evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Panel para elegir el archivo
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setLocale(locale);
		// Podemos seleccionar archivos, en otro caso dará error
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		// Añadimos un filtro para que solo se pueda abrir certos archivos
		FileNameExtensionFilter filtro = new FileNameExtensionFilter(".mcs", "mcs");
		fileChooser.setFileFilter(filtro);
		int seleccion = fileChooser.showOpenDialog(laminaTexto.getTextPane());

		if (JFileChooser.APPROVE_OPTION == seleccion) {
			try {
				// Ponemos el contenido del archivo en el JTextPane
				File archivo = fileChooser.getSelectedFile();
				Path path = Paths.get(archivo.getAbsolutePath());
				String texto = new String(Files.readAllBytes(path));
				laminaTexto.getTextPane().setText(texto);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, texto + ex.getMessage(), titulo, JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
