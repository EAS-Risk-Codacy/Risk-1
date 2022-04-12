package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class TournamentResults {

	private JFrame window;
	private JPanel panel;

	public void setup(int a) {
		JLabel HeaderLabel; //cambio de atributo a variable local
		window = new JFrame("Tournament Results");
		window.setSize(500, 700);
		panel= new JPanel(new GridLayout(0,a));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));

		HeaderLabel = new JLabel("Results");
		HeaderLabel.setBounds(120, 100, 150, 50);

//		panel.add(HeaderLabel);
	//	panel.add(field);
		
		HeaderLabel.setVisible(true);
//		field.setVisible(true);
		
		
	//	window.setLocationRelativeTo(null);
	//	window.setLayout(null);
	}
	public void adding(String aaa) {
		JLabel jLabel=new JLabel(aaa);
		
		jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK) );
		panel.add(jLabel);
	}
	public void show() {
		window.add(panel);
		window.setVisible(true);
	}

}
