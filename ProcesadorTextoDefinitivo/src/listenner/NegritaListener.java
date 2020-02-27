/**
 * @author: María Inmaculada Campillo Soto
 */
package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.StyledEditorKit;

/**
 * El escuchador que recibe eventos de la clase "Negrita" e interactua con el texto para
 * ponerlo en negrita o no dependiendo del caso.
 *
 * @see componente.Negrita
 */
public class NegritaListener implements ActionListener {

	/**
	 * Método de acción realizada.
	 *
	 * @param e El evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		new StyledEditorKit.BoldAction().actionPerformed(e);
	}

}
