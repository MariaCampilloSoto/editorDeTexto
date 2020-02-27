/**
 * @author: María Inmaculada Campillo Soto
 */
package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

/**
 * El escuchador que recibe eventos de la clase "Derecha" e interactua con el texto
 * alineandolo a la derecha.
 *
 * @see componente.Derecha
 */
public class DchaListener implements ActionListener {

	/**
	 * Método de acción realizada.
	 *
	 * @param e El evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		new StyledEditorKit.AlignmentAction(
				ResourceBundle.getBundle("property/Etiquetas").getString("cambioAlineacion"),
				StyleConstants.ALIGN_RIGHT).actionPerformed(e);
	}

}
