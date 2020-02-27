/**
 * @author: María Inmaculada Campillo Soto
 */
package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.StyledEditorKit;

/**
 * El escuchador que recibe eventos de la clase "Subrayado" e interactua con el texto para
 * subrayarlo o no dependiendo del caso.
 *
 * @see componente.Subrayado
 */
public class SubrayadoListener implements ActionListener {

	/**
	 * Método de acción realizada.
	 *
	 * @param e El evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		new StyledEditorKit.UnderlineAction().actionPerformed(e);
	}

}
