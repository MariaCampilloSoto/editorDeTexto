/**
 * @author: María Inmaculada Campillo Soto
 */
package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.text.StyledEditorKit;

/**
 * El escuchador que recive eventos de la clase "FuenteListener" e interactua con el texto
 * del editor para cambiar la cuente de este.
 *
 * @see especial.Fuente
 */
public class FuenteListener implements ActionListener {

	/** Nombre de la fuente. */
	private String fuente;

	/**
	 * Instancia un nuevo escuchador.
	 *
	 * @param fuente El nombre de la fuente
	 */
	public FuenteListener(String fuente) {
		this.fuente = fuente;
	}

	/**
	 * Método de la acción realizada que cambia la fuente al texto.
	 *
	 * @param e El evento
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		new StyledEditorKit.FontFamilyAction(ResourceBundle.getBundle("property/Etiquetas").getString("cambioLetra"),
				fuente).actionPerformed(e);
	}

}
