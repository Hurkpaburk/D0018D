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
			GUI frame = new GUI();
			frame.setVisible(true);
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
			pNr.setBorder(BorderFactory.createTitledBorder("Person Nummer"));
			accountInfo = new JTextField();
			accountInfo.setBorder(BorderFactory.createTitledBorder("Account Information"));
			customers = new JList();
			customers.setBorder(BorderFactory.createTitledBorder("Customer List"));
			accounts = new JList();
			accounts.setBorder(BorderFactory.createTitledBorder("Account List for Customer"));
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
		    JMenu menu = new JMenu("File");
		    menuBar.add(menu);
			setJMenuBar(menuBar);
		}
		
		private void buildCustomerFrame() {
			
			setLayout(new GridLayout(1,2));
			
			//JPanel leftPanel = new JPanel(new GridLayout(6,1));
			leftPanel.removeAll();
			leftPanel.add(name,0);
			leftPanel.add(pNr,1);
			JButton addAccButton = new JButton("Add Account");
			addAccButton.addActionListener(this);
			leftPanel.add(addAccButton,2);
			JButton infoAccButton = new JButton("Info Account");
			infoAccButton.addActionListener(this);
			leftPanel.add(infoAccButton,3);
			JButton remAccButton = new JButton("Remove Account");
			remAccButton.addActionListener(this);
			leftPanel.add(remAccButton,4);
			JButton backButton = new JButton("Back to Bank");
			backButton.addActionListener(this);
			leftPanel.add(backButton,5);
			add(leftPanel);
			
			//JPanel rightPanel = new JPanel(new GridLayout(2,1));
			rightPanel.removeAll();
			rightPanel.add(accounts,0);
			rightPanel.add(accounts,1);
			add(rightPanel);
			
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
		public void actionPerformed(ActionEvent event) {
			String buttonText = event.getActionCommand();
			
			if(buttonText.equals("New Customer")) {
				addCustomer();
			}
			else if(buttonText.equals("Show Customer")) {
				showSelected();
			}
			else if(buttonText.equals("Clear")) {
				clear();
			}
			else if(buttonText.equalsIgnoreCase("Remove Customer")) {
				removeCustomer();
			}
		}
		
		private void addCustomer() {
			bank.addCustomer(name.getText(), Long.parseLong(pNr.getText()));
			customers.setListData(bank.getCustomers().toArray());
			clear();
		}
		
		private void removeCustomer() {
			bank.removeCustomer(Long.parseLong(pNr.getText()));
			customers.setListData(bank.getCustomers().toArray());
		}
		
		private void showSelected() {
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
		
		private void clear() {
			name.setText("");
			pNr.setText("");
		}
	}