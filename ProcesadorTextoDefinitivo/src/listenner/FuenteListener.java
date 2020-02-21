package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.text.StyledEditorKit;

public class FuenteListener implements ActionListener {
	private String fuente;
	
	public FuenteListener(String fuente) {
		this.fuente = fuente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new StyledEditorKit.FontFamilyAction(ResourceBundle.getBundle("property/Etiquetas").getString("cambioLetra"),
				fuente).actionPerformed(e);;
	}

}
