/**
 * @author: María Inmaculada Campillo Soto
 */
package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.StyledEditorKit;

/**
 * El escuchador que recibe eventos de la clase "Cursiva" e interactura con el texto
 * poniendo su estilo en cursiva.
 *
 * @see componente.Cursiva
 */
public class CursivaListener implements ActionListener {

	/**
	 * Método de acción realizada.
	 *
	 * @param e El evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		new StyledEditorKit.ItalicAction().actionPerformed(e);
	}

}
