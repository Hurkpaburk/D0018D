import java.math.*;
import java.util.*;

public class SavingsAccount {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2015-01-29
	// Senast uppdaterad: 2015-01-29, Johan Bergström 
	// Beskrivning: Present Account information 
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	private int accountNumber;
	private double balance;
	private String accountType;
	private static final double interestRate = 2;
	
	// Constructor
	public SavingsAccount(int theAccountNumber, String theAccountType, int theTransaction) {
		  accountNumber = theAccountNumber;
		  accountType = theAccountType;
		  balance = balance + theTransaction;
	}	
	
	public SavingsAccount() {
		  accountNumber = 0000;
		  accountType = "Sparkonto";
		  balance = 0;
	}
	
	
	//------------------------------------------------------
	// Beskrivning: Main function will take user input and decide 
	// if calculate string (menu function) or exit program shall be done.
	// Inparametrar: None 
	// Returvärde: None
	//------------------------------------------------------
	public void setBalance(double theTransaction) {
		balance = balance + theTransaction;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getInterest() {
		return balance*(interestRate/100);
	}
	
	public StringBuilder getAccountInfo(){
		
		String temp = new String(accountNumber + ", " + balance + ", " + accountType + ", " + interestRate);
		StringBuilder info = new StringBuilder(temp);
		
	return info;
	
	}
}
	