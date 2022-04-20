package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * First Paga of Start up phase Start here
 *
 *
 */
public class SelectMapType {

	private JFrame window;
	public static int MapType = 0;
	

	public SelectMapType() {
		setup();
	}

	public static void main(String[] args) {
//		StartUpWindow temp = new StartUpWindow();
//		temp.setup();
	}

	public void setup() {
		window = new JFrame("Start-up phase");
		window.setSize(500, 700);

		JLabel headerLabel = new JLabel("Choose the map");
		headerLabel.setBounds(120, 100, 150, 50);

		JButton select1 = new JButton("Select from List");
		select1.setBounds(100, 200, 200, 50);

		JButton select2 = new JButton("Load Map");
		select2.setBounds(100, 300, 200, 50);

		JButton select3 = new JButton("Create New Map");
		select3.setBounds(100, 400, 200, 50);

		window.add(headerLabel);
		window.add(select1);
		window.add(select2);
		window.add(select3);

		headerLabel.setVisible(true);

		select1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.dispose();
				MapType = 1;
//				System.out.print("Select fromlist");
			}
		});
		select2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MapType = 2;
				window.dispose();
			}
		});

		select3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				MapType = 3;
				window.dispose();
			}
		});

		select1.setVisible(true);
		select2.setVisible(true);
		select3.setVisible(true);

		window.setLocationRelativeTo(null);

		window.setLayout(null);
		window.setVisible(true);
	}

}
