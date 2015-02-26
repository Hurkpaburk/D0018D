import java.util.*;

public class BankLogic {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2015-02-05
	// Senast uppdaterad: 2015-02-05, Johan Bergström 
	// Beskrivning: Handle bank logic class
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	private ArrayList<Customer> customer; // Bank customer list
	private ArrayList<Object> accountList; // Bank account list. Accounts will not be removed from this list if they are closed. 
	private static final int startAccount =  1001;
	private static int nextAccount;
	
	// Default Constructor
	public BankLogic() {
		nextAccount = startAccount;
		customer = new ArrayList<Customer>();
		accountList = new ArrayList<Object>();
	}
	
	// Metohds
	// Public Methods

	//------------------------------------------------------
	// Beskrivning: Get information about bank
	// Inparametrar: None
	// Returvärde: Customer Names 
	//------------------------------------------------------
	public String infoBank() {
		StringBuilder info = new StringBuilder(new String()); // stringbuilder to append
		for(Customer i: customer) { // loop over customers
			info.append("\n" + i.getCustomerName() + ";"); 
		}
		System.out.println(info.toString());
		return info.toString();
	}

	//------------------------------------------------------
	// Beskrivning: Add new customer to bank
	// Inparametrar: name - Customer Name, pNr - personnummer
	// Returvärde: true/false if created or not
	//------------------------------------------------------
	public boolean addCustomer(String name, long pNr) {
		boolean temp = false;
		if(existCustomerPn(pNr) != null) { // check if customer exists
			// No New Customer Created due to existing pNr
			temp = false;
		}
		else { // add new customer
			customer.add(new Customer(name, pNr));
			temp = true;
		}
		return temp;
	}
	
	//------------------------------------------------------
	// Beskrivning: Get information about customer
	// Inparametrar: pNr - personnummer
	// Returvärde: customer information 
	//------------------------------------------------------
	public String infoCustomer(long pNr) {
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) { // check if customer exists
			return thePerson.toString();
		}
		else {
			return new String("Can not find information about Customer");
		}
	}
	
	//------------------------------------------------------
	// Beskrivning: Change customer name
	// Inparametrar: name - New customer name, pNr - personnummer
	// Returvärde: true/ false if changed or not 
	//------------------------------------------------------
	public boolean changeCustomerName(String name, long pNr) {
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) { // check if customer exists
			thePerson.setCustomerName(name); // Set customer name
			return true; 
		}
		else {
			return false;
		}
	}

	//------------------------------------------------------
	// Beskrivning: remove customer from bank
	// Inparametrar: pNr - personnummer
	// Returvärde: Information about customers account when removed from bank 
	//------------------------------------------------------
	public String removeCustomer(long pNr) {
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) { // Check if customer exists
			String customerName = new String(thePerson.getCustomerName() +"\n");
			StringBuilder removedCustomer = new StringBuilder(customerName); // stringbuilder to append customer information
			for (int i = startAccount; i<nextAccount; i++) { // go over all created bank account numbers
				BankAccount theAccount = thePerson.getAccount(i); 
				if(theAccount != null) { // if customer owns bank account
					removedCustomer.append("Closed Account: " + closeAccount(pNr,i) + "\n"); // Append account information
					thePerson.removeAccount(theAccount); // Remove account from customer list but not bank list
				}
			}
			customer.remove(thePerson); // remove customer from list
			return removedCustomer.toString(); 
		}
		return null;
	}
	
	//------------------------------------------------------
	// Beskrivning: Add savings account for customer
	// Inparametrar: pNr - personnummer
	// Returvärde: Account number if created, otherwise -1 
	//------------------------------------------------------
	public int addSavingsAccount(long pNr) {
		int accountAdded = -1;
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) { // If customer exists
			accountAdded = thePerson.addAccount(nextAccount, "Sparkonto", 0); // create account with 0 deposit
			nextAccount++; // Increase the number for next available bank account
			accountList.add(thePerson.getAccount(nextAccount)); // Add account to Bank account List
		}
		return accountAdded;
	}
	
	//------------------------------------------------------
	// Beskrivning: Add credit account for customer
	// Inparametrar: pNr - personnummer
	// Returvärde: Account number if created, otherwise -1 
	//------------------------------------------------------
	public int addCreditAccount(long pNr) {
		int accountAdded = -1;
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) { // If customer exists
			accountAdded = thePerson.addAccount(nextAccount, "Kreditkonto", 0); // create account with 0 deposit
			nextAccount++; // Increase the number for next available bank account
			accountList.add(thePerson.getAccount(nextAccount)); // Add account to Bank account List
		}
		return accountAdded;
	}
	
	//------------------------------------------------------
	// Beskrivning: Information about a account
	// Inparametrar: pNr - personnummer, accountId - Account number
	// Returvärde: Information about a customers specific account 
	//------------------------------------------------------
	public String infoAccount(long pNr, int accountId) {
		Customer thePerson = existCustomerPn(pNr); 
		if(thePerson != null) { // Does customer exist
			return thePerson.getAccountInfo(accountId); // return account information
		}
		else {
			return new String("No matching Customer for Bank!");
		}
	}
	
	//------------------------------------------------------
	// Beskrivning: Information about an accounts transactions
	// Inparametrar: pNr - personnummer, accountId - Account number
	// Returvärde: Information transcation for a customers specific account 
	//------------------------------------------------------
	public String infoTransactions(long pNr, int accountId) {
	Customer thePerson = existCustomerPn(pNr); 
	if(thePerson != null) { // Does customer exist
		return thePerson.getAccount(accountId).getTransactions(); // return account information
	}
	else {
		return new String("No matching Customer for Bank!");
	}
}
	//------------------------------------------------------
	// Beskrivning: Deposit to a account
	// Inparametrar: pNr - personnummer, accountId - Account Number, amount - Amount to deposit
	// Returvärde: True or false depending on success
	//------------------------------------------------------
	public boolean deposit(long pNr, int accountId, double amount) {
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) { // exist customer
			BankAccount theAccount = thePerson.getAccount(accountId);
			if (theAccount != null) { // exist account for customer
				theAccount.deposit(amount); // deposit 
				return true;
			}
		}
		return false;
	}

	//------------------------------------------------------
	// Beskrivning: Withdraw from a account
	// Inparametrar: pNr - personnummer, accountId - Account Number, amount - Amount to withdraw
	// Returvärde: True or false depending on success
	//------------------------------------------------------
	public boolean withdraw(long pNr, int accountId, double amount) {
		boolean temp = false; 
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) { // exist customer
			BankAccount theAccount = thePerson.getAccount(accountId);
			if (theAccount != null) { // exist account for customer
				temp = theAccount.withdraw(amount); // withdraw
				return temp;
			}
		}
		return temp;
	}
	
	//------------------------------------------------------
	// Beskrivning: Close Account for a customer
	// Inparametrar: pNr - personnummer, accountId - Account Number
	// Returvärde: Information about closed account
	//------------------------------------------------------
	public String closeAccount(long pNr, int accountId) {
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) { // exist customer
			BankAccount theAccount = thePerson.getAccount(accountId);
			if (theAccount != null) { // exist account
				String theBalance = new String("Saldo: " + theAccount.getBalance() + ", R�nta: " + theAccount.getInterest()); 
				thePerson.removeAccount(theAccount); // remove account from customer but not from bank list
				return theBalance; 
			}
		}
		return null;
	}

	//	Private Methods

	//------------------------------------------------------
	// Beskrivning: Check if Customer exists in list
	// Inparametrar: theCustomer - personnummer,
	// Returvärde: Customer Object
	//------------------------------------------------------
	private Customer existCustomerPn(long theCustomer) {
		for(Customer i: customer) { // loop over list
			if(theCustomer == i.getCustomerPn()) { // check if personummer exist in any Customer 
				return i;
			}
		}
		return null;
	}
}

