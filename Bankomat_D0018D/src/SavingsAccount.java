import java.math.*;
import java.util.*;

public class SavingsAccount {
	//****************************************************************** 
	// Programmerare: Johan Bergstr�m, johbef-4@student.ltu.se
	// Datum: 2015-01-29
	// Senast uppdaterad: 2015-01-29, Johan Bergstr�m 
	// Beskrivning: Present Account information 
	// Version: 1, First Release 
	//****************************************************************** 

	// Instance Variables
	private int accountNumber;
	private double balance;
	private String accountType;
	private static final double interestRate = 0.02;
	
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
	// Returv�rde: None
	//------------------------------------------------------
	public double getBalance() {
		return balance;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double getInterest() {
		return balance*0.02;
	}
	
	public String getAccountInfo(){
		String info = "(" + accountNumber + ", " + balance + "," + accountType + "," + interestRate + ")";
		return info;
	}
}
	