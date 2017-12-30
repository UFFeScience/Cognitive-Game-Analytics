package academia_cerebro;

import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

public class Inicio {
	public void inicio() throws UnsupportedLookAndFeelException {
	    JFrame frame = new JFrame();
	    System.setProperty("apple.awt.fileDialogForDirectories", "true");
	    FileDialog d = new FileDialog(frame);
	    d.setVisible(true);
	}
}
