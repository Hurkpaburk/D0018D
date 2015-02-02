import java.math.*;
import java.util.*;

public class SavingsAccount {
	//****************************************************************** 
	// Programmerare: Johan Bergström, johbef-4@student.ltu.se
	// Datum: 2015-01-29
	// Senast uppdaterad: 2015-01-29, Johan Bergström 
	// Beskrivning: Handle Savings Account Information 
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	private int  accountNumber;
	private double balance;
	private String accountType;
	private static final double interestRate = 2;
	
	// Constructor
	public SavingsAccount(int theAccountNumber, String theAccountType, int theTransaction) {
		  accountNumber = theAccountNumber;
		  accountType = theAccountType;
		  balance = balance + theTransaction;
	}	
	
	// Default Constructor
	public SavingsAccount() {
		  accountNumber = 0000;
		  accountType = "Sparkonto";
		  balance = 0;
	}
	
	
	//------------------------------------------------------
	// Beskrivning: Calculates a new account balance 
	// Inparametrar: theTransaction - Amount to change the account balance with
	// Returvärde: None
	//------------------------------------------------------
	public void setBalance(double theTransaction) {
		balance = balance + theTransaction;
	}
	
	//------------------------------------------------------
	// Beskrivning: get the account balance
	// Inparametrar: None
	// Returvärde: balance - Account balance
	//------------------------------------------------------
	public double getBalance() {
		return balance;
	}
	
	//------------------------------------------------------
	// Beskrivning: get the account number
	// Inparametrar: None
	// Returvärde: accountNumber - Account number
	//------------------------------------------------------
	public int getAccountNumber() {
		return accountNumber;
	}
	
	//------------------------------------------------------
	// Beskrivning: get the account interest
	// Inparametrar: None
	// Returvärde: Interest - balance with interest
	//------------------------------------------------------
	public double getInterest() {
		return balance*(interestRate/100);
	}
	
	//------------------------------------------------------
	// Beskrivning: get the account information
	// Inparametrar: None
	// Returvärde: info - Account information
	//------------------------------------------------------
	public String getAccountInfo(){
		
		String temp = new String(accountNumber + ", " + balance + ", " + accountType + ", " + interestRate);
		StringBuilder info = new StringBuilder(temp);
		
	return info.toString();
	}
}
	