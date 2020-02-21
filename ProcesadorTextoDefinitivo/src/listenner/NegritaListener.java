package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.StyledEditorKit;

public class NegritaListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		new StyledEditorKit.BoldAction().actionPerformed(e);
	}

}
