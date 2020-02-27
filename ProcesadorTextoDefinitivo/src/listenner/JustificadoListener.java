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
 * El escuchador que recibe eventos de la clase "Justificado" e interctua con el texto,
 * justificando su contenido.
 *
 * @see componente.Justificado
 */
public class JustificadoListener implements ActionListener {

	/**
	 * Método de acción realizada.
	 *
	 * @param e El evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		new StyledEditorKit.AlignmentAction(
				ResourceBundle.getBundle("property/Etiquetas").getString("cambioAlineacion"),
				StyleConstants.ALIGN_JUSTIFIED).actionPerformed(e);
	}

}
