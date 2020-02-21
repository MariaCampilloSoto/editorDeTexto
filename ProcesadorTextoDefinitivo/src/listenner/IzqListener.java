package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class IzqListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		new StyledEditorKit.AlignmentAction(
				ResourceBundle.getBundle("property/Etiquetas").getString("cambioAlineacion"), StyleConstants.ALIGN_LEFT)
						.actionPerformed(e);
	}

}
