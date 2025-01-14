package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import model.Continent;
import model.Country;

/**
 * This class create the map
 *  
 * @author greeshma
 * @version 1.0
 */
public class CreateMap {

	private JPanel assign_neighbours_panel;
	private JPanel assign_countries_panel;
	private JFrame get_number_frame;
	private JFrame assign_neighbours_frame;
	private JFrame assign_countries_frame;
	private JTextField no_of_countries_text_field;
	private JTextField no_of_continents_text_field;
	private JTextField control_value_text_field;
	private JButton generate_map_button;
	private JButton add_to_country_button;
	private JButton add_to_continent_button;
	private JButton next_button;
	private JButton done_button;
	private JComboBox continents_combo;
	private JComboBox countries_combo;
	public static int NoOfCountries;
	public static int NoOfContinents;
	private JCheckBox[] check_boxes = new JCheckBox[150];
	private JCheckBox[] check_boxes1 = new JCheckBox[150];
	DefaultListModel<String> countries_to_continent_list;
	public static List<Continent> ContinentsObjectList = new ArrayList<>();
	public static List<Country> CountriesObjectList = new ArrayList<>();

	private static JButton EditButton;

	public CreateMap() {
		getnumbers();
		startframe();

	}

	/**
	 * This method creates map for the user interface
	 */
	public void getnumbers() {
		get_number_frame = new JFrame("Create Map");
		get_number_frame.setSize(500, 500);
		JLabel no_of_countries_label = new JLabel("No. of Countries");
		no_of_countries_label.setBounds(200, 27, 150, 50);
		JLabel no_of_continents_label = new JLabel("No of continents");
		no_of_continents_label.setBounds(10, 27, 150, 50);
		no_of_countries_text_field = new JTextField("3");
		no_of_countries_text_field.setBounds(300, 43, 50, 20);
		no_of_continents_text_field = new JTextField("2");
		no_of_continents_text_field.setBounds(110, 43, 50, 20);
		generate_map_button = new JButton("Generate Map");
		generate_map_button.setBounds(200, 90, 150, 30);
		get_number_frame.add(no_of_continents_label);
		get_number_frame.add(no_of_countries_label);
		get_number_frame.add(no_of_countries_text_field);
		get_number_frame.add(no_of_continents_text_field);
		get_number_frame.add(generate_map_button);
		get_number_frame.setLayout(null);
		get_number_frame.setVisible(true);
	}

	/**
	 * This method assigning countries to continents
	 */
	public void assigncountriesframe() {
		assign_countries_frame = new JFrame("Assign Countries To continents");
		assign_countries_panel = new JPanel();
		assign_countries_panel.setBounds(440, 80, 200, 200);
		assign_countries_panel.setBackground(Color.gray);
		assign_countries_panel.setSize(100, 800);
		assign_countries_frame.setSize(1000, 1000);

		JLabel continent_contol_value_label = new JLabel("Continent Control Value");
		continent_contol_value_label.setBounds(10, 200, 150, 50);
		add_to_continent_button = new JButton("Add Countries");
		add_to_continent_button.setBounds(575, 500, 150, 30);

		next_button = new JButton("Next");
		next_button.setBounds(700, 700, 150, 30);
		continents_combo = new JComboBox();
		continents_combo.setBounds(10, 150, 200, 20);
		control_value_text_field = new JTextField("0");
		control_value_text_field.setBounds(10, 250, 50, 20);
		countries_to_continent_list = new DefaultListModel<>();

		assign_countries_frame.add(assign_countries_panel);
		assign_countries_frame.add(next_button);
		assign_countries_frame.add(continent_contol_value_label);
		assign_countries_frame.add(control_value_text_field);
		assign_countries_frame.add(add_to_continent_button);
		assign_countries_frame.add(continents_combo);

		assign_countries_frame.setLayout(null);
		assign_countries_frame.setVisible(true);
	}

	/**
	 * This method add neighbors to the countries
	 */
	public void assignneighboursframe() {

		assign_neighbours_frame = new JFrame("Add Neighbours");
		assign_neighbours_panel = new JPanel();
		assign_neighbours_panel.setBounds(440, 80, 200, 200);
		assign_neighbours_panel.setBackground(Color.gray);
		assign_neighbours_panel.setSize(100, 800);
		assign_neighbours_frame.setSize(1000, 1000);

		add_to_country_button = new JButton("Add Countries");
		add_to_country_button.setBounds(575, 300, 150, 30);
		done_button = new JButton("done");
		done_button.setBounds(700, 700, 150, 30);

		countries_combo = new JComboBox();
		countries_combo.setBounds(10, 150, 200, 20);

		EditButton = new JButton("EDIT");
		EditButton.setBounds(275, 200, 90, 20);

		EditButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (countries_combo.getSelectedItem() != null) {
					JOptionPane.showMessageDialog(null, "Assign neighbours to all Countries");
				} else {
					JOptionPane.showMessageDialog(null, "Map successfully Created");
					assign_countries_frame.dispose();
					assign_countries_frame.dispose();
					SelectMapType.MapType = 6;
				}
			}
		});

		assign_neighbours_frame.add(EditButton);

		assign_neighbours_frame.add(assign_neighbours_panel);
		assign_neighbours_frame.add(done_button);
		assign_neighbours_frame.add(add_to_country_button);
		assign_neighbours_frame.add(countries_combo);

		assign_neighbours_frame.setLayout(null);
		assign_neighbours_frame.setVisible(true);
	}

	/**
	 * This method checks validations of the map
	 */
	public void startframe() {

		generate_map_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				NoOfCountries = Integer.parseInt(no_of_countries_text_field.getText());
				NoOfContinents = Integer.parseInt(no_of_continents_text_field.getText());
				if (NoOfCountries <= 2 || NoOfContinents <= 1) {
					JOptionPane.showMessageDialog(null, "Values should be greater than 2");
				} else if (NoOfCountries < NoOfContinents) {
					JOptionPane.showMessageDialog(null, "NO of Countries shuld be greater than continents");
				} else {
					get_number_frame.dispose();
					assigncountriesframe();
					for (int i = 1; i <= NoOfContinents; i++) {
						continents_combo.addItem("Continent" + i);
					}
					for (int i = 0, j = 150; i < NoOfCountries; i++, j = j + 30) {
						check_boxes[i] = new JCheckBox("Country" + (i + 1));
						assign_countries_panel.add(check_boxes[i]);
						check_boxes[i].setBounds(300, j, 150, 50);
						check_boxes[i].setVisible(true);
					}
					actionaddcontinent();
					actionnextbuttonframe();
				}

			}
		});

	}

	/**
	 * UI for assigning continents and adding countries to the continent
	 */
	public void actionaddcontinent() {
		add_to_continent_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<Country> TempCountriesObject = new ArrayList<Country>();

				for (int i = 0; i < NoOfCountries; i++) {
					if (check_boxes[i].isSelected()) {
						Country temp = new Country(check_boxes[i].getText());
						TempCountriesObject.add(temp);
						check_boxes[i].setVisible(false);
						assign_countries_panel.updateUI();
						check_boxes[i].setSelected(false);
					}
				}
				Continent tempc = new Continent(Integer.parseInt(control_value_text_field.getText()),
						(String) continents_combo.getSelectedItem());
				tempc.setCountries(TempCountriesObject);
				if (tempc.getName() != null) {
					ContinentsObjectList.add(tempc);
				}
				continents_combo.removeItem((String) continents_combo.getSelectedItem());
			}
		});
	}

	/**
	 * UI for assigning countries to the continents
	 */
	public void actionnextbuttonframe() {
		next_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int check = 0;
				for (int i = 0; i < NoOfCountries; i++) {
					if (check_boxes[i].isVisible()) {
						check = 1;
					}
				}

				if (continents_combo.getSelectedItem() != null) {
					JOptionPane.showMessageDialog(null, "Assign all continents");
				} else if (check == 1) {
					JOptionPane.showMessageDialog(null, "Assign all Countries");
					assign_countries_frame.dispose();
					getnumbers();
					startframe();
				} else {
					assign_countries_frame.dispose();
					assignneighboursframe();

					for (int i = 1; i <= NoOfCountries; i++) {
						countries_combo.addItem("Country" + i);
					}
					for (int i = 0, j = 150; i < NoOfCountries; i++, j = j + 30) {
						check_boxes1[i] = new JCheckBox("Country" + (i + 1));
						assign_neighbours_panel.add(check_boxes1[i]);
						check_boxes1[i].setBounds(300, j, 150, 50);
						check_boxes1[i].setVisible(true);
					}
					actionassignneighbours();
				}
			}
		});

	}

	/**
	 * UI for assigning neighbors to the countries
	 */
	public void actionassignneighbours() {
		add_to_country_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				List<Country> TempCountriesObject2 = new ArrayList<Country>();

				for (int i = 0; i < NoOfCountries; i++) {
					if (check_boxes1[i].isSelected()) {
						Country temp = new Country(check_boxes1[i].getText());
						TempCountriesObject2.add(temp);
						check_boxes1[i].setSelected(false);
					}
				}
				Country tempct = new Country((String) countries_combo.getSelectedItem());
				tempct.setNeighbors(TempCountriesObject2);
				CountriesObjectList.add(tempct);
				countries_combo.removeItem((String) countries_combo.getSelectedItem());
				if ((String) countries_combo.getSelectedItem() == null) {
					for (int j = 0; j < NoOfCountries; j++) {
						check_boxes1[j].setVisible(false);
						assign_neighbours_panel.updateUI();
					}
				}
			}
		});
		done_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (countries_combo.getSelectedItem() != null) {
					JOptionPane.showMessageDialog(null, "Assign neighbours to all Countries");
				} else {
					JOptionPane.showMessageDialog(null, "Map successfully Created");
					assign_neighbours_frame.dispose();
					SelectNoOfPlayers.assignCountries();
				}
			}
		});

	}
}
