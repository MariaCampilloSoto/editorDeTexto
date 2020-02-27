/**
 * @author: María Inmaculada Campillo Soto
 */
package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import lamina.LaminaTexto;
import modelo.Componente;

/**
 * El escuchador que recibe eventos de la clase "InsertarImagen" e interactua con el
 * editor de texto insertando imagenes en él.
 *
 * @see componente.InsertarImagen
 */
public class InsertarImagenListener implements ActionListener {

	/** La lámina de texto. */
	private LaminaTexto laminaTexto;

	/** La localidad. */
	private Locale locale;

	/**
	 * El texto de la ventana emergente que sale si no se selecciona la imagen correctamente.
	 */
	private String texto;

	/**
	 * El título de la ventana emergente que sale si no se selecciona la imagen correctamente.
	 */
	private String titulo;

	/**
	 * Poner el texto correspondiente en la ventana emergente según la localidad.
	 *
	 * @param locale La localidad.
	 */
	public void ponerTextoTitulo(Locale locale) {
		texto = Componente.getRecurso("errorInsertarImagen", locale);
		titulo = Componente.getRecurso("tituloError", locale);
	}

	/**
	 * Instancia un nuevo escuchador.
	 *
	 * @param laminaTexto La lámina de texto
	 * @param locale      La localidad
	 */
	public InsertarImagenListener(LaminaTexto laminaTexto, Locale locale) {
		this.locale = locale;
		this.laminaTexto = laminaTexto;
		ponerTextoTitulo(locale);
	}

	/**
	 * Método que abre una ventana emergente que facilita la búsqueda de la imagen a insertar.
	 *
	 * @param e El evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setLocale(locale);
		fileChooser.setMultiSelectionEnabled(true);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		FileNameExtensionFilter filtro = new FileNameExtensionFilter(".jpg, .png", "jpg", "png");
		fileChooser.setFileFilter(filtro);
		int seleccion = fileChooser.showOpenDialog(laminaTexto.getTextPane());

		if (JFileChooser.APPROVE_OPTION == seleccion) {
			File file = fileChooser.getSelectedFile();
			try {
				ImageIcon imagen = new ImageIcon(ImageIO.read(file));

				JLabel label = new JLabel();
				label.setIcon(imagen);
				laminaTexto.getTextPane().insertComponent(label);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, texto + e1.getMessage(), titulo, JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
