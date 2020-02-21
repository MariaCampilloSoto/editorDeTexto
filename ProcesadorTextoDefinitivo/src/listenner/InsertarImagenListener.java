package listenner;

import java.awt.Color;
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

public class InsertarImagenListener implements ActionListener {
	private LaminaTexto laminaTexto;
	
	private Locale locale;
	private String texto;
	private String titulo;

	public void ponerTextoTitulo(Locale locale) {
		texto = Componente.getRecurso("errorInsertarImagen", locale);
		titulo = Componente.getRecurso("tituloError", locale);
	}

	public InsertarImagenListener(LaminaTexto laminaTexto, Locale locale) {
		this.locale = locale;
		this.laminaTexto = laminaTexto;
		ponerTextoTitulo(locale);
	}

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
				label.setBackground(Color.RED);
				label.setIcon(imagen);
				label.setBackground(Color.RED);
				laminaTexto.getTextPane().insertComponent(label);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, texto + e1.getMessage(), titulo, JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
