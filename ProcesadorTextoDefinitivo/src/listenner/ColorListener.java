package listenner;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JColorChooser;
import javax.swing.text.StyledEditorKit;

import lamina.LaminaTexto;
import modelo.Componente;

public class ColorListener implements ActionListener {
	LaminaTexto laminaTexto;

	public ColorListener(LaminaTexto laminaTexto) {
		this.laminaTexto = laminaTexto;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color nuevoColor = JColorChooser.showDialog(laminaTexto.getTextPane(),
				ResourceBundle.getBundle(Componente.PROPERTY_FILE).getString("tituloColorPanel"), Color.BLACK);
		new StyledEditorKit.ForegroundAction(
				ResourceBundle.getBundle(Componente.PROPERTY_FILE).getString("cambioColor"), nuevoColor)
						.actionPerformed(e);
	}

}
