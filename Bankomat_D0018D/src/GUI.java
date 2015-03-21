import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {

		private BankLogic bank;
		private JList customers;
		private JTextField name, pNr;
		
		public static void main(String[] args)
		{
			GUI frame = new GUI();
			frame.setVisible(true);
		}
		
		public GUI()
		{
			initiateInstanceVariables();
			buildFrame();
		}
		
		private void initiateInstanceVariables()
		{
			bank = new BankLogic();

			name = new JTextField();
			name.setBorder(BorderFactory.createTitledBorder("Name"));
			pNr = new JTextField();
			pNr.setBorder(BorderFactory.createTitledBorder("Person Nummer"));
			customers = new JList();
			customers.setBorder(BorderFactory.createTitledBorder("Customer List"));
		}
		
		private void buildFrame()
		{
			setTitle("BANK");
			setSize(300,250);
			setLayout(new GridLayout(1,2));
			
			JPanel leftPanel = new JPanel(new GridLayout(5,1));
			leftPanel.add(name);
			leftPanel.add(pNr);
			JButton newButton = new JButton("New Customer");
			newButton.addActionListener(this);
			leftPanel.add(newButton);
			JButton customerButton = new JButton("Show Customer");
			customerButton.addActionListener(this);
			leftPanel.add(customerButton);
			JButton clearButton = new JButton("Clear");
			clearButton.addActionListener(this);
			leftPanel.add(clearButton);
			add(leftPanel);
			
			add(customers);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
		
		public void actionPerformed(ActionEvent event)
		{
			String buttonText = event.getActionCommand();
			if(buttonText.equals("New Customer"))
			{
				add();
			}
			if(buttonText.equals("Show Customer"))
			{
				showSelected();
			}
			if(buttonText.equals("Clear"))
			{
				clear();
			}
		}
		
		private void add()
		{
			bank.addCustomer(name.getText(), Long.parseLong(pNr.getText()));
			customers.setListData(bank.getCustomers().toArray());
			clear();
		}
		
		private void showSelected()
		{/*
			int position = personList.getSelectedIndex();
			if(position > -1)
			{
				nameField.setText(logic.getNameForPersonAt(position));
				phoneNrField.setText(logic.getPhoneNrForPersonAt(position));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Du må‚ste markera en person i listan!");
			}*/
		}
		
		private void clear()
		{
			name.setText("");
		}
	}