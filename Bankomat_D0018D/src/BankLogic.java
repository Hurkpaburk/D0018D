import java.math.*;
import java.util.*;

public class BankLogic {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2015-01-29
	// Senast uppdaterad: 2015-01-29, Johan Bergström 
	// Beskrivning: Present Account information 
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	private static ArrayList<Customer> customer;
	
	// Constructor
	
	public String infoBank() {
		String temp = new String("All Customers:\n");
		StringBuilder info = new StringBuilder(temp);
		for(Customer i: customer) {
			 info.append("\n" + i.getCustomerName() + ";");
		}
	return info.toString();
	}


	public boolean addCustomer(String name, long pNr) {
		if(existCustomerPn(pNr) == null) {
			// No New Customer Created due to existing pNr
			return false;
		}
		else {
			customer.add(new Customer(name, pNr));
			return true;
		}
	}
	
	public String infoCustomer(long pNr) {
		Customer tempPerson = existCustomerPn(pNr);
		if(tempPerson != null) {
			return tempPerson.getCustomerInfo();
		}
		else {
			return null;
		}
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
/*
	public boolean changeCustomerName(String name, long pNr)
	
	public String removeCustomer(long pNr)
	
	
	public int addSavingsAccount(long pNr)
	
	public String infoAccount(long pNr, int accountId)
	
	public boolean deposit(long pNr, int accountId, double amount)
	
	public boolean withdraw(long pNr, int accountId, double amount)
	
	public String closeAccount(long pNr, int accountId) 
	*/