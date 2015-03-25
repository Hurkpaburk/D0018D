import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {

		private BankLogic bank;
		private JList customers, accounts;
//		private JTextField name, pNr, accountInfo;
		
		JPanel leftPanel = new JPanel(new GridLayout(1,1));
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

			accounts = new JList();
			accounts.setBorder(BorderFactory.createTitledBorder("Customer Account List"));
			customers = new JList();
			customers.setBorder(BorderFactory.createTitledBorder("Customer List"));
		}
		
		private void buildMainFrame() {
			setTitle("BANK");
			setSize(300,250);
			setLayout(new GridLayout(1,2));
			
			leftPanel.add(customers);
			add(leftPanel);
			
			rightPanel.add(accounts);
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
		    JMenuItem newAcc = new JMenuItem("New Account");
		    newAcc.addActionListener(this);
		    accountMenu.add(newAcc);
		    JMenuItem showAcc = new JMenuItem("Show Account");
		    showAcc.addActionListener(this);
		    accountMenu.add(showAcc);
		    JMenuItem remAcc = new JMenuItem("Remove Account");
		    remAcc.addActionListener(this);
		    accountMenu.add(remAcc);
		    
			setJMenuBar(menuBar);
		}
		
		private void buildCustomerFrame() {
			
			setLayout(new GridLayout(1,2));
		/*	
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
			*/
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
			else if(text.equals("New Account")) {
				addAccount();
			}
			else if(text.equals("Show Account")) {
				showAccount();
			}
			else if(text.equals("Remove Account")) {
				remAccount();
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
				String remCustomer = bank.removeCustomer((bank.getCustomers().get(position).getCustomerPn()));
				customers.setListData(bank.getCustomers().toArray());
				JOptionPane.showMessageDialog(null, "Following Customer is removed from Bank:\n" + remCustomer);
			}
			else {
				JOptionPane.showMessageDialog(null, "Select a Customer in the list");
			}
		}
		// TODO: Not Done
		private void showCustomer() {
			int position = customers.getSelectedIndex();
			if(position >= 0) {
				accounts.setListData(bank.getCustomers().get(position).getAccounts().toArray());
			}
			else {
				JOptionPane.showMessageDialog(null, "Select a Customer in the list");
			}
		}
		
		private void addAccount() {
			String savAcc = "Saving Account";
			String creAcc = "Credit Account";
			int position = customers.getSelectedIndex();
			if(position >= 0) {
				Object[] accountList = {savAcc, creAcc};
				String accType = (String)JOptionPane.showInputDialog(null, "Which account shall be created?",
						"Account Creation",JOptionPane.PLAIN_MESSAGE,null,accountList,savAcc);

				if(accType != null && accType == savAcc) {
					bank.addSavingsAccount(bank.getCustomers().get(position).getCustomerPn());
				}
				else if(accType != null && accType == creAcc) {
					bank.addCreditAccount(bank.getCustomers().get(position).getCustomerPn());
				}
				else {
					JOptionPane.showMessageDialog(null, "Something went wrong creting account");
				}
				accounts.setListData(bank.getCustomers().get(position).getAccounts().toArray());
			}
			else {
				JOptionPane.showMessageDialog(null, "Select a Customer in the list");
			}
		}
		// TODO: Not Done
		private void showAccount() {
			
		}
		
		private void remAccount() {
			int accPost = accounts.getSelectedIndex();
			int cusPost = customers.getSelectedIndex();
			if(accPost >= 0 && cusPost >= 0) {
				String accInfo = bank.getCustomers().get(cusPost).getAccounts().get(accPost).toString();
				int accNum = bank.getCustomers().get(cusPost).getAccounts().get(accPost).getAccountNumber();
				String closedAcc = bank.closeAccount(bank.getCustomers().get(cusPost).getCustomerPn(),accNum);
				accounts.setListData(bank.getCustomers().get(cusPost).getAccounts().toArray());
				if(closedAcc == null) {
					JOptionPane.showMessageDialog(null, "No Account Closed");
				}
				else {
					JOptionPane.showMessageDialog(null, "Closed Account:\n" + accInfo);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Select a Customer and Account in the lists");
			}
		}
	}