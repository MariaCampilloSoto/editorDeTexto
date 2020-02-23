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

public class GuardarArchivoListener implements ActionListener {
	private LaminaTexto laminaTexto;
	
	private Locale locale;
	private String texto;
	private String titulo;

	public void ponerTextoTitulo(Locale locale) {
		texto = Componente.getRecurso("errorGuardarArchivo", locale);
		titulo = Componente.getRecurso("tituloError", locale);
	}

	public GuardarArchivoListener(LaminaTexto laminaTexto, Locale locale) {
		this.laminaTexto = laminaTexto;
		this.locale = locale;
		ponerTextoTitulo(locale);
	}

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
