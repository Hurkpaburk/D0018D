import java.util.*;

public class BankLogic {
	//****************************************************************** 
	// Programmerare: Johan Bergstr√∂m, johbef-4@student.ltu.se
	// Datum: 2015-01-29
	// Senast uppdaterad: 2015-01-29, Johan Bergstr√∂m 
	// Beskrivning: Handle bank logic  
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	private ArrayList<Customer> customer;
	private static final int startAccount =  1001;
	private static int nextAccount;

	// Constructor
	
	// Default Constructor
	public BankLogic() {
		nextAccount = startAccount;
		customer = new ArrayList<Customer>();
	}
	
	// Metohds
	// Public Methods

	public String infoBank() {
		String the = new String("All Customers:");
		StringBuilder info = new StringBuilder(the);
		for(Customer i: customer) {
			info.append("\n" + i.getCustomerName() + ";");
		}
		System.out.println(info.toString());
		return info.toString();
	}


	public boolean addCustomer(String name, long pNr) {
		if(existCustomerPn(pNr) != null) {
			// No New Customer Created due to existing pNr
			return false;
		}
		else {
			customer.add(new Customer(name, pNr));
			return true;
		}
	}

	public String infoCustomer(long pNr) {
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) {
			return thePerson.toString();
		}
		else {
			return null;
		}
	}

	public boolean changeCustomerName(String name, long pNr) {
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) {
			thePerson.setCustomerName(name);
			return true; 
		}
		else {
			return false;
		}
	}


	public String removeCustomer(long pNr) {
		
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) {
			String customerName = new String(thePerson.getCustomerName() +"\n");
			StringBuilder removedCustomer = new StringBuilder(customerName);
			for (int i = startAccount; i<nextAccount; i++) {
				SavingsAccount theAccount = thePerson.getAccount(i);
				if(theAccount != null) {
					removedCustomer.append("Closed Account: " + closeAccount(pNr,i) + ", Saldo: " + theAccount.getBalance() + ", R‰nta: " + theAccount.getInterest() + "\n");
					thePerson.removeAccount(theAccount);
				}
			}
			customer.remove(thePerson);
			return removedCustomer.toString();
		}
		return null;
	}
	

	public int addSavingsAccount(long pNr, int accountId) {
		int accountAdded = -1;
		System.out.println("Next Account: "  + nextAccount);
		if ((accountId >= nextAccount) && (accountId >= startAccount)) {
			Customer thePerson = existCustomerPn(pNr);
			if(thePerson != null) {
				accountAdded = thePerson.addAccount(accountId, "Sparkonto", 0);
				nextAccount = accountAdded + 1;
				System.out.println(accountAdded);
			}
		}
		return accountAdded;
	}

	public String infoAccount(long pNr, int accountId) {
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) {
			return thePerson.getAccountInfo(accountId);
		}
		else {
			return null;
		}
	}

	public boolean deposit(long pNr, int accountId, double amount) {
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) {
			SavingsAccount theAccount = thePerson.getAccount(accountId);
			if (theAccount != null) {
				theAccount.deposit(amount);
				return true;
			}
		}
		return false;
	}

	public boolean withdraw(long pNr, int accountId, double amount) {
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) {
			SavingsAccount theAccount = thePerson.getAccount(accountId);
			if (theAccount != null) {
				theAccount.withdraw(amount);
				return true;
			}
		}
		return false;
	}

	public String closeAccount(long pNr, int accountId) {
		Customer thePerson = existCustomerPn(pNr);
		if(thePerson != null) {
			SavingsAccount theAccount = thePerson.getAccount(accountId);
			if (theAccount != null) {
				String theBalance = new String("Saldo: " + theAccount.getBalance() + ", R‰nta: " + theAccount.getInterest()); 
				thePerson.removeAccount(theAccount);
				return theBalance;
			}
		}
		return null;
	}


	// Private Methods

	private Customer existCustomerPn(long theCustomer) {
		for(Customer i: customer) {
			if(theCustomer == i.getCustomerPn()) {
				return i;
			}
		}
		return null;
	}
}

