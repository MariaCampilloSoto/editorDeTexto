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

public class AbrirArchivoListener implements ActionListener {
	// Variables para el menú emergente
	private LaminaTexto laminaTexto;
	private Locale locale;
	private String texto;
	private String titulo;

	// Para el idioma
	public void ponerTextoTitulo(Locale locale) {
		texto = Componente.getRecurso("errorAbrirArchivo", locale);
		titulo = Componente.getRecurso("tituloError", locale);
	}

	public AbrirArchivoListener(LaminaTexto laminaTexto, Locale locale) {
		this.laminaTexto = laminaTexto;
		this.locale = locale;
		ponerTextoTitulo(locale);
	}

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
