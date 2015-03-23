import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {

		private BankLogic bank;
		private JList customers, accounts;
		private JTextField name, pNr, accountInfo;
		
		JPanel leftPanel = new JPanel(new GridLayout(6,1));
		JPanel rightPanel = new JPanel(new GridLayout(1,1));
		
		public static void main(String[] args) {
			GUI bankFrame = new GUI();
			bankFrame.setVisible(true);
		}
		
		public GUI() {
			initMain();
			buildMenu();
			buildMainFrame();
			
		}
		
		private void initMain() {
			bank = new BankLogic();

			name = new JTextField();
			name.setBorder(BorderFactory.createTitledBorder("Name"));
			pNr = new JTextField();
			pNr.setBorder(BorderFactory.createTitledBorder("PersonNummer"));
			accountInfo = new JTextField();
			accountInfo.setBorder(BorderFactory.createTitledBorder("Account Information"));
			customers = new JList();
			customers.setBorder(BorderFactory.createTitledBorder("Customer List"));
		}
		
		private void buildMainFrame() {
			setTitle("BANK");
			setSize(300,250);
			setLayout(new GridLayout(1,2));
			
			leftPanel.add(name,0);
			leftPanel.add(pNr,1);
			JButton newButton = new JButton("New Customer");
			newButton.addActionListener(this);
			leftPanel.add(newButton,2);
			JButton customerButton = new JButton("Show Customer");
			customerButton.addActionListener(this);
			leftPanel.add(customerButton,3);
			JButton removeButton = new JButton("Remove Customer");
			removeButton.addActionListener(this);
			leftPanel.add(removeButton,4);
			JButton clearButton = new JButton("Clear");
			clearButton.addActionListener(this);
			leftPanel.add(clearButton,5);
			add(leftPanel);
			
			rightPanel.add(customers);
			add(rightPanel);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
		private void buildMenu() {
			JMenuBar menuBar = new JMenuBar();
		    JMenu fileMenu = new JMenu("File");
		    menuBar.add(fileMenu);
		    JMenuItem exit = new JMenuItem("Exit");
		    exit.addActionListener(this);
		    fileMenu.add(exit);
		    
		    JMenu customerMenu = new JMenu("Customer");
		    menuBar.add(customerMenu);
		    JMenuItem newCust = new JMenuItem("New Customer");
		    newCust.addActionListener(this);
		    customerMenu.add(newCust);
		    JMenuItem showCust = new JMenuItem("Show Customer");
		    showCust.addActionListener(this);
		    customerMenu.add(showCust);
		    JMenuItem remCust = new JMenuItem("Remove Customer");
		    remCust.addActionListener(this);
		    customerMenu.add(remCust);
		    
		    JMenu accountMenu = new JMenu("Account");
		    menuBar.add(accountMenu);		    
			setJMenuBar(menuBar);
		}
		
		private void buildCustomerFrame() {
			
			setLayout(new GridLayout(1,2));
			
			//JPanel leftPanel = new JPanel(new GridLayout(6,1));
			leftPanel.removeAll();
			leftPanel.add(name,0);
			leftPanel.add(pNr,1);
			
			add(leftPanel);
			
			//JPanel rightPanel = new JPanel(new GridLayout(2,1));
			rightPanel.removeAll();
			rightPanel.add(accounts,0);
			rightPanel.add(accounts,1);
			add(rightPanel);
			
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

		public void actionPerformed(ActionEvent event) {

			String text = event.getActionCommand();

			if(text.equals("Exit")) {
				setVisible(false); // Hide 
				dispose(); //Destroy JFrame object
				System.exit(0); 
			}
			else if(text.equals("New Customer")) {
				addCustomer();
			}
			else if(text.equals("Show Customer")) {
				showCustomer();
			}
			else if(text.equals("Remove Customer")) {
				removeCustomer();
			}
		}
		
		private void addCustomer() {
			
			JPanel panel = new JPanel();
			JTextField nameInput = new JTextField(20);
			nameInput.setBorder(BorderFactory.createTitledBorder("Customer Name"));
			panel.add(nameInput);
			JTextField pNrInput = new JTextField(20);
			pNrInput.setBorder(BorderFactory.createTitledBorder("Customer Personnummer"));
			panel.add(pNrInput);

			int value = JOptionPane.showConfirmDialog(null, panel, "New Customer", JOptionPane.OK_CANCEL_OPTION);
			if (value == JOptionPane.OK_OPTION)
			{
				bank.addCustomer(nameInput.getText(), Long.parseLong(pNrInput.getText()));
				customers.setListData(bank.getCustomers().toArray());
			}
		}

		private void removeCustomer() {
			int position = customers.getSelectedIndex();
			if(position >= 0) {
				bank.removeCustomer(customers.getSelectedValue()toString());
				customers.setListData(bank.getCustomers().toArray());
			}
			else {
				JOptionPane.showMessageDialog(null, "Select a Customer in the list");
			}
		}

			private void showCustomer() {
				int position = customers.getSelectedIndex();
			if(position >= 0) {
				buildCustomerFrame();
				name.setText(bank.getCustomers().get(position).getCustomerName());
				pNr.setText((Long.toString(bank.getCustomers().get(position).getCustomerPn())));
					
			}
			else {
				JOptionPane.showMessageDialog(null, "Select a Customer in the list");
			}
		}
	}