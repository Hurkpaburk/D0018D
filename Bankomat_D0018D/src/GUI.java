import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
	//****************************************************************** 
		// Programmerare: Johan Bergstr�m, johbef-4@student.ltu.se
		// Datum: 2015-03-27
		// Senast uppdaterad: 2015-03-27, Johan Bergström 
		// Beskrivning: Handle Account information class 
		// Version: 1, First Release 
		//****************************************************************** 
	
		// Instance Variables
		private BankLogic bank;
		private JList customers, accounts;
		private JButton buttonCustInfo, buttonAccInfo, buttonWithdraw, buttonDeposit;
		private JTextArea infoCust, infoAcc;
		private JPanel leftPanel, rightPanel, rightButtonPanel;
		private File fileName;
		public final static String custDiv = "---CUSTOMER---";
		public final static String custEndDiv = "---END CUSTOMER---";
		public final static String AccDiv = "---ACCOUNT---";
		public final static String AccEndDiv = "---END ACCOUNT---";
		
		// Public Methods
		
		//------------------------------------------------------
		// Beskrivning: main
		// Inparametrar: String[]
		// Returvärde: None
		//------------------------------------------------------
		public static void main(String[] args) {
			GUI bankFrame = new GUI();
			bankFrame.setVisible(true);
		}
		
		
		//------------------------------------------------------
		// Beskrivning: function to create gui
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------
		public GUI() {
			initMain();
			buildMenu();
			buildMainFrame();		
		}
		
		// Private Methods
		
		//------------------------------------------------------
		// Beskrivning: construct new bank, panels, button etc.
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------
		private void initMain() {
			bank = new BankLogic();

			leftPanel = new JPanel(new GridLayout(3,1));
			rightPanel = new JPanel(new GridLayout(3,1));
			rightButtonPanel = new JPanel(new GridLayout(1,3));
			
			buttonCustInfo = new JButton("Show Customer");
			buttonCustInfo.addActionListener(this);
			buttonAccInfo = new JButton("Show Account History");
		    buttonAccInfo.addActionListener(this);
		    buttonWithdraw = new JButton("Withdraw");
			buttonWithdraw.addActionListener(this);
			buttonDeposit = new JButton("Deposit");
			buttonDeposit.addActionListener(this);
			
			infoCust = new JTextArea();
			infoCust.setBorder(BorderFactory.createTitledBorder("Customer Information"));
			infoAcc = new JTextArea();
			infoAcc.setBorder(BorderFactory.createTitledBorder("Account Information"));
			
			accounts = new JList();
			accounts.setBorder(BorderFactory.createTitledBorder("Customer Account List"));
			customers = new JList();
			customers.setBorder(BorderFactory.createTitledBorder("Customer List"));
		}
		
		//------------------------------------------------------
		// Beskrivning: Build main frame gui for ban
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------
		private void buildMainFrame() {
			setTitle("BANK");
			setExtendedState(JFrame.MAXIMIZED_BOTH); 
			setLayout(new GridLayout(1,2));
			
			leftPanel.add(customers,0);
			leftPanel.add(buttonCustInfo,1);
			leftPanel.add(infoCust, 2);
			add(leftPanel);
			
			rightButtonPanel.add(buttonAccInfo,0);
			rightButtonPanel.add(buttonDeposit,1);
			rightButtonPanel.add(buttonWithdraw,2);
			
			rightPanel.add(accounts,0);
			rightPanel.add(rightButtonPanel,1);
			rightPanel.add(infoAcc, 2);
			add(rightPanel);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
		//------------------------------------------------------
		// Beskrivning: Build JMenu for bank to be added in to main gui
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------
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
		    JMenuItem remCust = new JMenuItem("Remove Customer");
		    remCust.addActionListener(this);
		    customerMenu.add(remCust);
		    
		    JMenu accountMenu = new JMenu("Account");
		    menuBar.add(accountMenu);
		    JMenuItem newAcc = new JMenuItem("New Account");
		    newAcc.addActionListener(this);
		    accountMenu.add(newAcc);
		    JMenuItem remAcc = new JMenuItem("Remove Account");
		    remAcc.addActionListener(this);
		    accountMenu.add(remAcc);
		    
		    JMenu importExportMenu = new JMenu("Import Export");
		    menuBar.add(importExportMenu);
		    JMenuItem exportCust = new JMenuItem("Export Customers");
		    exportCust.addActionListener(this);
		    importExportMenu.add(exportCust);
		    JMenuItem importCust = new JMenuItem("Import Customers");
		    importCust.addActionListener(this);
		    importExportMenu.add(importCust);
		    
			setJMenuBar(menuBar);
		}

		//------------------------------------------------------
		// Beskrivning: action performed, perform action based on text compare
		// Inparametrar: Action event
		// Returvärde: None
		//------------------------------------------------------
		public void actionPerformed(ActionEvent event) {

			String text = event.getActionCommand();

			if(text.equals("Exit")) { // Exit program
				setVisible(false); 
				dispose();
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
			else if(text.equals("New Account")) {
				addAccount();
			}
			else if(text.equals("Show Account History")) {
				showAccount();
			}
			else if(text.equals("Remove Account")) {
				remAccount();
			}
			else if(text.equals("Withdraw")) {
				withdrawAccount();
			}
			else if(text.equals("Deposit")) {
				depositAccount();
			}
			else if(text.equals("Export Customers")) {
				exportCust();
			}
			else if(text.equals("Import Customers")) {
				importCust();
			}
		}

		//------------------------------------------------------
		// Beskrivning: Add customer to bank and update gui
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------
		private void addCustomer() {
			// Create new panel to use in dialog
			JPanel panel = new JPanel();
			JTextField nameInput = new JTextField(20);
			nameInput.setBorder(BorderFactory.createTitledBorder("Customer Name"));
			panel.add(nameInput);
			JTextField pNrInput = new JTextField(20);
			pNrInput.setBorder(BorderFactory.createTitledBorder("Customer Personnummer"));
			panel.add(pNrInput);
			
			// Dialog to input customer information
			int value = JOptionPane.showConfirmDialog(null, panel, "New Customer", JOptionPane.OK_CANCEL_OPTION);
			if (value == JOptionPane.OK_OPTION)
			{
				bank.addCustomer(nameInput.getText(), Long.parseLong(pNrInput.getText()));
				customers.setListData(bank.getCustomersName().toArray());
			}
		}

		//------------------------------------------------------
		// Beskrivning: Remove customer to bank and update gui
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------
		private void removeCustomer() {
			int position = customers.getSelectedIndex();
			if(position >= 0) { // Customer selected in JList
				String remCustomer = bank.removeCustomer((bank.getCustomers().get(position).getCustomerPn()));
				customers.setListData(bank.getCustomersName().toArray());
				JOptionPane.showMessageDialog(null, "Following Customer is removed from Bank:\n" + remCustomer);
			}
			else {
				JOptionPane.showMessageDialog(null, "Select a Customer in the list");
			}
		}

		//------------------------------------------------------
		// Beskrivning: Show customer information in gui
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------
		private void showCustomer() {
			int position = customers.getSelectedIndex();
			if(position >= 0) { // Customer selected in JList
				infoCust.setText(null);
				infoCust.setText(bank.getCustomers().get(position).toString());
				accounts.setListData(bank.getCustomers().get(position).getAccounts().toArray());
				infoAcc.setText(null);
			}
			else {
				JOptionPane.showMessageDialog(null, "Select a Customer in the list");
			}
		}
		
		//------------------------------------------------------
		// Beskrivning: Add Account to bank and update gui
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------
		private void addAccount() {
			String savAcc = "Saving Account";
			String creAcc = "Credit Account";
			int position = customers.getSelectedIndex();
			if(position >= 0) { // Customer selected in JList
				
				// Create dialogbox to select account type
				Object[] accountList = {savAcc, creAcc};
				String accType = (String)JOptionPane.showInputDialog(null, "Which account shall be created?",
						"Account Creation",JOptionPane.PLAIN_MESSAGE,null,accountList,savAcc);

				if(accType != null && accType == savAcc) { // Saving account 
					bank.addSavingsAccount(bank.getCustomers().get(position).getCustomerPn());
				}
				else if(accType != null && accType == creAcc) { // Credit account
					bank.addCreditAccount(bank.getCustomers().get(position).getCustomerPn());
				}
				else {
					JOptionPane.showMessageDialog(null, "Something went wrong creating account");
				}
				accounts.setListData(bank.getCustomers().get(position).getAccounts().toArray());
			}
			else {
				JOptionPane.showMessageDialog(null, "Select a Customer in the list");
			}
		}
		
		//------------------------------------------------------
		// Beskrivning: Show account information in gui
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------
		private void showAccount() {
			int accPost = accounts.getSelectedIndex();
			int cusPost = customers.getSelectedIndex();
			if(accPost >= 0 && cusPost >= 0) { // Customer and account selected in JList
				int accNum = bank.getCustomers().get(cusPost).getAccounts().get(accPost).getAccountNumber();
				String info = bank.infoTransactions(bank.getCustomers().get(cusPost).getCustomerPn(),accNum);
				infoAcc.setText(info);
			}
			else {
				JOptionPane.showMessageDialog(null, "Select a Customer and Account in the lists");
			}	
		}
		
		//------------------------------------------------------
		// Beskrivning: remove account from bank and update gui
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------
		private void remAccount() {
			int accPost = accounts.getSelectedIndex();
			int cusPost = customers.getSelectedIndex();
			if(accPost >= 0 && cusPost >= 0) { // Customer and account selected in JList
				//String accInfo = bank.getCustomers().get(cusPost).getAccounts().get(accPost).toString();
				int accNum = bank.getCustomers().get(cusPost).getAccounts().get(accPost).getAccountNumber();
				String closedAcc = bank.closeAccount(bank.getCustomers().get(cusPost).getCustomerPn(),accNum);
				accounts.setListData(bank.getCustomers().get(cusPost).getAccounts().toArray());
				if(closedAcc == null) { // account does not exist in bank
					JOptionPane.showMessageDialog(null, "No Account Closed");
				}
				else {
					JOptionPane.showMessageDialog(null, "Closed Account:\n" + closedAcc);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Select a Customer and Account in the lists");
			}
		}

		//------------------------------------------------------
		// Beskrivning: Withdraw from account and update gui
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------
		private void withdrawAccount() {
			int accPost = accounts.getSelectedIndex();
			int cusPost = customers.getSelectedIndex();
			if(accPost >= 0 && cusPost >= 0) { // Customer and account selected in JList
				int accNum = bank.getCustomers().get(cusPost).getAccounts().get(accPost).getAccountNumber();
				Long pNr = bank.getCustomers().get(cusPost).getCustomerPn();
				// Dialog to input how much to withdraw
				String amount = JOptionPane.showInputDialog(null, "Amount to withdraw","0");
				boolean withdrawOk = bank.withdraw(pNr, accNum, Long.parseLong(amount));
				if(withdrawOk) { // Amount is withdrawn from bank and gui updated
					accounts.setListData(bank.getCustomers().get(cusPost).getAccounts().toArray());
					String info = bank.infoTransactions(pNr,accNum);
					infoAcc.setText(null);
					infoAcc.setText(info);	
				}
				else {
					JOptionPane.showMessageDialog(null, "Not able to withdraw:\n" + amount);
				}
				}
			else {
				JOptionPane.showMessageDialog(null, "Select a Customer and Account in the lists");
			}
		}
		
		//------------------------------------------------------
		// Beskrivning: Deposit to account and update gui
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------		
		private void depositAccount() {
			int accPost = accounts.getSelectedIndex();
			int cusPost = customers.getSelectedIndex();
			if(accPost >= 0 && cusPost >= 0) { // Customer and account selected in JList
				int accNum = bank.getCustomers().get(cusPost).getAccounts().get(accPost).getAccountNumber();
				Long pNr = bank.getCustomers().get(cusPost).getCustomerPn();
				// dialog to input how much to deposit
				String amount = JOptionPane.showInputDialog(null, "Amount to deposit","0");
				boolean depositOk = bank.deposit(pNr, accNum, Long.parseLong(amount));
				if(depositOk) {// Amount is deposit from bank and gui updated
					accounts.setListData(bank.getCustomers().get(cusPost).getAccounts().toArray());
					String info = bank.infoTransactions(pNr,accNum);
					infoAcc.setText(null);
					infoAcc.setText(info);
				}
				else {
					JOptionPane.showMessageDialog(null, "Now able to deposit:\n" + amount);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Select a Customer and Account in the lists");
			}
		}

		//------------------------------------------------------
		// Beskrivning: Export Customers and the customer information to txt file
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------		
		private void exportCust() {
			JFileChooser chooser = new JFileChooser();
			int val = chooser.showSaveDialog(null);
			if(val == JFileChooser.APPROVE_OPTION) {
				fileName = chooser.getSelectedFile(); 
			}
			
			try {
				if(fileName.exists() == false) {
					fileName.createNewFile();
				}

				//String fileName = JOptionPane.showInputDialog(null, "Save to file:","Customers.txt");		

				PrintWriter out = new PrintWriter(new FileWriter(fileName));

				for(int i = 0; i < bank.getCustomers().size(); i++) {
					bank.getCustomers().get(i).save(out);
				}
				out.close();
			}
			catch(IOException e) {
				JOptionPane.showMessageDialog(null, "Could not save data to file: " + fileName);
			}
		}
		
		//------------------------------------------------------
		// Beskrivning: Import Customers and the customer information to txt file
		// Inparametrar: None
		// Returvärde: None
		//------------------------------------------------------		
		private void importCust() {
			JFileChooser chooser = new JFileChooser();
			int val = chooser.showOpenDialog(null);
			boolean newCust = false;
			boolean newAcc = false;
			
			if(val == JFileChooser.APPROVE_OPTION) {
				fileName = chooser.getSelectedFile(); 
			}
			
			try {
				BufferedReader in = new BufferedReader(new FileReader(fileName));
				
		        if(in.readLine().equals(custDiv)) { // New Customer to import
		        	newCust = true; 
		        	
		        }
		        else if(in.readLine().equals(custEndDiv)) { // End of Customer to import
		        	newCust = false; 
		        }
		        else if(in.readLine().equals(AccDiv)) { // End of Customer to import
		        	newAcc = true; 
		        }
		        else if(in.readLine().equals(AccEndDiv)) { // End of Customer to import
		        	newAcc = false; 
		        }
		        else {
		        	if(newCust == true) {
		        		bank.addCustomer(in.readLine(), Long.parseLong(in.readLine()));
		        		if(newAcc == true) {
		        			bank.a
		        		}
		        	}
		        	
		        }
				
				/*String line;
				
			    while ((line = in.readLine()) != null) {
			        if(line.equals(custDiv)) { // New Customer to import
			        	newCust = true; 
			        	continue;
			        }
			        else if(line.equals(custEndDiv)) { // End of Customer to import
			        	newCust = false; 
			        	continue;
			        }
			        else {
			        	if(newCust == true) {
			        		custName = line;
			        		continue;
			        		
			        	}
			        	
			        }
			    }*/
				   
			    in.close();
			}	
			catch(IOException e) {
				JOptionPane.showMessageDialog(null, "Could not read data from file: " + fileName);
			} 
		}
	}