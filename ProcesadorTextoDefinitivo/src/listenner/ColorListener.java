/**
 * @author: María Inmaculada Campillo Soto
 */
package listenner;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JColorChooser;
import javax.swing.text.StyledEditorKit;

import lamina.LaminaTexto;
import modelo.Componente;

/**
 * El escuchador que recibe eventos de la clase "ColorComponente" e interactua con el
 * texto poniendo este de direfentes colores.
 *
 * @see componente.ColorComponente
 */
public class ColorListener implements ActionListener {

	/** La lámina de texto. */
	private LaminaTexto laminaTexto;

	/**
	 * Instancia un nuevo escuchador.
	 *
	 * @param laminaTexto La lámina de texto
	 */
	public ColorListener(LaminaTexto laminaTexto) {
		this.laminaTexto = laminaTexto;
	}

	/**
	 * Instancia un nuevo escuchador.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Color nuevoColor = JColorChooser.showDialog(laminaTexto.getTextPane(),
				ResourceBundle.getBundle(Componente.PROPERTY_FILE).getString("tituloColorPanel"), Color.BLACK);
		new StyledEditorKit.ForegroundAction(
				ResourceBundle.getBundle(Componente.PROPERTY_FILE).getString("cambioColor"), nuevoColor)
						.actionPerformed(e);
	}

}
