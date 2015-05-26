import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The driver class creates the gui that the user will be interacting with in order to enter shipping information
 * @author Juan Lopez
 *
 */
public class Driver extends JFrame {
	private final int WIDTH = 500;
	private final int HEIGHT = 520;
	private JPanel topPanel = new JPanel();
	private JLabel lastName;
	private JTextField lastNameBox;
	private JLabel firstName;
	private JTextField firstNameBox;
	private JLabel street;
	private JTextField streetBox;
	private JLabel city;
	private JTextField cityBox;
	private JLabel state;
	private JTextField stateBox;
	private JLabel zip;
	private JTextField zipBox;
	private JLabel lastName2;
	private JTextField lastNameBox2;
	private JLabel firstName2;
	private JTextField firstNameBox2;
	private JLabel street2;
	private JTextField streetBox2;
	private JLabel city2;
	private JTextField cityBox2;
	private JLabel state2;
	private JTextField stateBox2;
	private JLabel zip2;
	private JTextField zipBox2;
	
	private JLabel weight;	
	private JTextField weightBox;
	private JLabel zone;
	private JTextField zoneBox;
	private JLabel shipCost;
	private JTextField shipCostBox;

	private JRadioButton firstClass;
	private JRadioButton express;
	private JRadioButton overnight;
	private JPanel midPanel = new JPanel();
	private JPanel midPanelLeft = new JPanel();
	private JPanel midPanelRight = new JPanel();
	private JPanel bottomPanel1 = new JPanel();
	private JPanel bottomPanel2 = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private Container contentPane;
	private JButton addPackage;
	private JButton printLabel;
	private JButton deliveryReport;
	private JButton clear;
	private JButton exit;

	private Packages packs = new Packages();
	private double packCost;
	private String setType = "";
	
	/**
	 * This is the constructor for the class.  It sets the GUI's layout and adds the panels and buttons onto the content pane.
	 * The constructor also calls the Button Listener classes in order to handle user interaction of buttons and radio buttons.
	 */
	public Driver() throws IOException {
		setTitle("Shipping Manager");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		buildTopPanel();
		add(topPanel, BorderLayout.NORTH);
		buildBottomPanel();
		add(bottomPanel, BorderLayout.SOUTH);
		buildMidPanel();
		add(midPanel, BorderLayout.CENTER);
		addPackage.addActionListener(new AddPackageListener());
		printLabel.addActionListener(new PrintLabelListener());
		deliveryReport.addActionListener(new DeliveryReportListener());
		clear.addActionListener(new ClearListener());
		exit.addActionListener(new ExitButtonListener());
		overnight.addActionListener(new RadioButtonListener());
		express.addActionListener(new RadioButtonListener());
		firstClass.addActionListener(new RadioButtonListener());
	}
	
	/**
	 * The method buildTopPanel initializes the top panel with the shipping options radio buttons.
	 */
	private void buildTopPanel() throws IOException {
		topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 12));
		topPanel.setBorder(BorderFactory.createTitledBorder("Shipping Options"));
		topPanel.setPreferredSize(new Dimension(0, 70));
		
		firstClass = new JRadioButton ("First Class");
		express = new JRadioButton ("Express");
		overnight = new JRadioButton ("Overnight");

		topPanel.add(firstClass);
		topPanel.add(express);
		topPanel.add(overnight);
	}
	
	/**
	 * The method buildMidPanel initializes the middle panel labels and text fieds.
	 */
	private void buildMidPanel() {
		midPanel.setLayout(new GridLayout(1,2));
		
		midPanelLeft.setBorder(BorderFactory.createTitledBorder("To"));
		midPanelLeft.setLayout(new FlowLayout());
		midPanel.add(BorderLayout.WEST, midPanelLeft);
		
		lastName = new JLabel("      Last Name  ");
		firstName = new JLabel("      First Name  ");
		street = new JLabel("               Street  ");
		city = new JLabel("                   City  ");
		state = new JLabel("                State  ");
		zip = new JLabel("                    ZIP  ");
		lastNameBox = new JTextField(8);
		firstNameBox = new JTextField(8);
		streetBox = new JTextField(8);
		cityBox = new JTextField(8);
		stateBox = new JTextField(8);
		zipBox = new JTextField(8);

		midPanelLeft.add(lastName);
		midPanelLeft.add(lastNameBox);
		midPanelLeft.add(firstName);
		midPanelLeft.add(firstNameBox);
		midPanelLeft.add(street);
		midPanelLeft.add(streetBox);
		midPanelLeft.add(city);
		midPanelLeft.add(cityBox);
		midPanelLeft.add(state);
		midPanelLeft.add(stateBox);
		midPanelLeft.add(zip);
		midPanelLeft.add(zipBox);
		
		midPanelRight.setLayout(new BorderLayout());
		midPanelRight.setBorder(BorderFactory.createTitledBorder("From"));
		midPanelRight.setLayout(new FlowLayout());
		midPanel.add(BorderLayout.EAST, midPanelRight);
		
		lastName2 = new JLabel("      Last Name  ");
		firstName2 = new JLabel("      First Name  ");
		street2 = new JLabel("               Street  ");
		city2 = new JLabel("                   City  ");
		state2 = new JLabel("                State  ");
		zip2 = new JLabel("                    ZIP  ");
		lastNameBox2 = new JTextField(8);
		firstNameBox2 = new JTextField(8);
		streetBox2 = new JTextField(8);
		cityBox2 = new JTextField(8);
		stateBox2 = new JTextField(8);
		zipBox2 = new JTextField(8);

		midPanelRight.add(lastName2);
		midPanelRight.add(lastNameBox2);
		midPanelRight.add(firstName2);
		midPanelRight.add(firstNameBox2);
		midPanelRight.add(street2);
		midPanelRight.add(streetBox2);
		midPanelRight.add(city2);
		midPanelRight.add(cityBox2);
		midPanelRight.add(state2);
		midPanelRight.add(stateBox2);
		midPanelRight.add(zip2);
		midPanelRight.add(zipBox2);
	}
	
	/**
	 * The method buildBottomPanel initializes the 5 buttons needed for the bottom panel and sets the panel on the southern part of the content pane.
	 */
	private void buildBottomPanel() {
		bottomPanel.setLayout(new GridLayout(2,1));
		bottomPanel1.setBorder(BorderFactory.createTitledBorder("Package Details"));
		bottomPanel1.setPreferredSize(new Dimension(0, 110));
		bottomPanel2.setLayout(new FlowLayout());
		bottomPanel2.setPreferredSize(new Dimension(0, 50));
		
		weight = new JLabel("                               weight (ounces)              ");
		JLabel placer = new JLabel("                            ");
		zone = new JLabel("                Zone                                   ");
		JLabel placer2 = new JLabel("             ");
		shipCost = new JLabel(" Shipping Costs                ");
		weightBox = new JTextField(10); 
		zoneBox = new JTextField(10);
		shipCostBox = new JTextField(10);
		shipCostBox.setEditable(false);

		addPackage = new JButton("Add Package");
		printLabel = new JButton("Print Labels");
		deliveryReport = new JButton("Delivery Report");
		clear = new JButton("Clear");
		exit = new JButton("Exit");
		
		bottomPanel.add(BorderLayout.NORTH, bottomPanel1);
		bottomPanel.add(BorderLayout.SOUTH, bottomPanel2);
		
		bottomPanel1.add(BorderLayout.WEST, weight);
		bottomPanel1.add(weightBox);
		bottomPanel1.add(BorderLayout.WEST, placer);
		bottomPanel1.add(BorderLayout.WEST, zone);
		bottomPanel1.add(zoneBox);
		bottomPanel1.add(BorderLayout.WEST, placer2);
		bottomPanel1.add(BorderLayout.WEST, shipCost);
		bottomPanel1.add(shipCostBox);

		
		bottomPanel2.add(addPackage);
		bottomPanel2.add(printLabel);
		bottomPanel2.add(deliveryReport);
		bottomPanel2.add(clear);
		bottomPanel2.add(exit);
		
	}
	
	/**
	 * The purpose of the class AddPackageListener is to handle the interaction of the user with the Add Package button.
	 */
	private class AddPackageListener implements ActionListener {
		
		/**
		 * actionPerformed handles the logic and action of the Add Package button.  Uses data entered in text boxes and adds the new package.
		 */
		public void actionPerformed(ActionEvent e) {
			
			if(setType.equals("firstClass")) {
				packCost = packs.addPackage(setType, lastNameBox.getText(), firstNameBox.getText(), streetBox.getText(), cityBox.getText(), stateBox.getText(), Integer.parseInt(zipBox.getText()), 
		                                  lastNameBox2.getText(), firstNameBox2.getText(), streetBox2.getText(), cityBox2.getText(), stateBox2.getText(), Integer.parseInt(zipBox2.getText()), Double.parseDouble(weightBox.getText()), 0);
				shipCostBox.setText("$" + packCost);
			} else {
				packCost = packs.addPackage(setType, lastNameBox.getText(), firstNameBox.getText(), streetBox.getText(), cityBox.getText(), stateBox.getText(), Integer.parseInt(zipBox.getText()), 
						                  lastNameBox2.getText(), firstNameBox2.getText(), streetBox2.getText(), cityBox2.getText(), stateBox2.getText(), Integer.parseInt(zipBox2.getText()), Double.parseDouble(weightBox.getText()), Integer.parseInt(zoneBox.getText()));
				shipCostBox.setText("$" + packCost);	
			}
		}
	}
		
		/**
		 * The purpose of the class PrintLabelListener is to handle the interaction of the user with the print label button.
		 */
		private class PrintLabelListener implements ActionListener {
			
			/**
			 * actionPerformed handles the logic and action of the print label button.  Allows the user to select a destination to save the mailing labels
			 */
			public void actionPerformed(ActionEvent e) {
				String fullPrint = packs.printMailingLabels();
				fullPrint = fullPrint.replaceAll("\n", System.getProperty("line.separator"));
				
				JFileChooser fchooser = new JFileChooser();
				 
				if (fchooser.showSaveDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
				    boolean doExport = true;
				 
				    boolean overrideExistingFile = false;
				 
				    File destinationFile = new File(fchooser.getSelectedFile().getAbsolutePath());
				 
				    while (doExport && destinationFile.exists() && !overrideExistingFile) {
				        overrideExistingFile = (JOptionPane.showConfirmDialog(contentPane, "Replace file?", "Export Settings", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
				 
				        if (!overrideExistingFile) {
				            if (fchooser.showSaveDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
				                destinationFile = new File(fchooser.getSelectedFile().getAbsolutePath());
				            } else {
				                doExport = false;
				            }
				        }
				    }
				    if (doExport) {			
				    	try {
				    						 
							FileWriter fw = new FileWriter(destinationFile.getAbsoluteFile() + ".txt");
							BufferedWriter bw = new BufferedWriter(fw);
							
							bw.write(fullPrint);
							bw.close();
				 
							System.out.println(fullPrint);
				    	} catch (IOException o) {
				    		o.printStackTrace();
				    	}
				    }
				}
			}
		}
		
		/**
		 * The purpose of the class DeliveryReportListener is to handle the interaction of the user with the Delivery report button.
		 */
		private class DeliveryReportListener implements ActionListener {
			
			/**
			 * actionPerformed handles the logic and action of the Delivery Report button.  Allows the user to select a destination to save the sorted delivery list
			 */
			public void actionPerformed(ActionEvent e) {
				String fullPrint = packs.printDeliverySchedule();
				fullPrint = fullPrint.replaceAll("\n", System.getProperty("line.separator"));
				
				JFileChooser fChooser = new JFileChooser();
				 
				if (fChooser.showSaveDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
				    boolean doExport = true;
				 
				    boolean overrideExistingFile = false;
				 
				    File destinationFile = new File(fChooser.getSelectedFile().getAbsolutePath());
				 
				    while (doExport && destinationFile.exists() && !overrideExistingFile) {
				        overrideExistingFile = (JOptionPane.showConfirmDialog(contentPane, "Replace file?", "Export Settings", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
				 
				        if (!overrideExistingFile) {
				            if (fChooser.showSaveDialog(contentPane) == JFileChooser.APPROVE_OPTION) {
				                destinationFile = new File(fChooser.getSelectedFile().getAbsolutePath());
				            } else {
				                doExport = false;
				            }
				        }
				    }				 
				    if (doExport) {			
				    	try {
				    						 
							FileWriter fw = new FileWriter(destinationFile.getAbsoluteFile() + ".txt");
							BufferedWriter bw = new BufferedWriter(fw);
							
							bw.write(fullPrint);
							bw.close();
				 
							System.out.println(fullPrint);
				    	} catch (IOException o) {
				    		o.printStackTrace();
				    	}
				    }
				}
			}
		}
		
		/**
		 * The purpose of the class ClearListener is to handle the interaction of the user with the Clear button.
		 */
		private class ClearListener implements ActionListener {
			
			/**
			 * actionPerformed handles the logic and action of the clear button.  Clears all fields and resets radio buttons
			 */
			public void actionPerformed(ActionEvent e) {
				firstClass.setSelected(false);
				express.setSelected(false);
				overnight.setSelected(false);
				lastNameBox.setText("");
				firstNameBox.setText("");
				streetBox.setText("");
				cityBox.setText("");
				stateBox.setText("");
				zipBox.setText("");
				lastNameBox2.setText("");
				firstNameBox2.setText("");
				streetBox2.setText("");
				cityBox2.setText("");
				stateBox2.setText("");
				zipBox2.setText("");
				weightBox.setText("");
				zoneBox.setText("");
				shipCostBox.setText("");
			}
		}
		
		/**
		 * The purpose of the class ExitButtonListener is to handle the interaction of the user with the exit button.
		 */
		private class ExitButtonListener implements ActionListener {
			
			/**
			 * actionPerformed handles the logic and action of the users interaction with the exit button.  Terminates the application
			 */
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		}
		
		/**
		 * The purpose of the class RadioButtonListener is to handle the interaction of the user with the GUI's Account type radio buttons.
		 */
		private class RadioButtonListener implements ActionListener {
			
			/**
			 * actionPerformed handles the logic and action of the users interaction with the radio buttons.  It allows only one of the radio buttons to be selected at a time 
			 * and assigns package type.
			 */
			public void actionPerformed(ActionEvent e) {
				
				String radioAction = e.getActionCommand();
				
				if (radioAction.equals("First Class")) {
					express.setSelected(false);
					overnight.setSelected(false);
					weight.setText("                               weight (ounces)              ");
					zone.setText("                                                                                                     ");
					zoneBox.setVisible(false);
					setType = "firstClass";
				} else if (radioAction.equals("Express")) {
					firstClass.setSelected(false);
					overnight.setSelected(false);
					weight.setText("                               weight (ounces)              ");
					zone.setText("                Zone                                   ");
					zoneBox.setVisible(true);
					setType = "express";
				} else if (radioAction.equals("Overnight")) {
					firstClass.setSelected(false);
					express.setSelected(false);
					weight.setText("                               weight (pounds)              ");
					zone.setText("                Zone                                   ");
					zoneBox.setVisible(true);
					setType = "overnight";
				}
			}
		}

	public static void main(String[] args) throws IOException {
		Driver gui = new Driver();
		gui.setVisible(true);
	}
}
