package view;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Class to display errors
 * 
 * @author pazim
 *
 */
public class MFrame2 {

	JFrame frame;
	JLabel jLabel;

	/**
	 * default constructor
	 */
	public MFrame2() {
	}

	/**
	 * throws error and restarts game
	 * 
	 * @param message
	 */
	public void error(String message) {
		JOptionPane.showMessageDialog(null, message);
		String args[] = new String[0];
		GameStartWindow.main(args);

	}
}
