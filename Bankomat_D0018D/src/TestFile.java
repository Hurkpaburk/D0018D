import java.util.*;

public class TestFile {
	
	public static void main(String []args){
		/*
		System.out.println("START OF ACCOUNT TEST!");
		int theAccountNumber = 1234;		
		int theTransaction = 100;
		
		System.out.println("*** Test bank account ***");

		BankAccount testAccount = new BankAccount(theAccountNumber, theTransaction);
	
		System.out.println(testAccount.getBalance());
		System.out.println(testAccount.toString());
		System.out.println(testAccount.getInterest());
		System.out.println(testAccount.getAccountNumber());
		
		double deposit = 15;
		
		testAccount.deposit(deposit);
		System.out.println(testAccount.getBalance());
		
		double withdraw = 15;
		testAccount.withdraw(withdraw);
		System.out.println(testAccount.getBalance());
		
		double withdraw2 = 15;
		testAccount.withdraw(withdraw2);
		System.out.println("withdraw 2 " + testAccount.getBalance());
		System.out.println(testAccount.getTransactions());
		
		System.out.println("*** Test savings account ***");

		theAccountNumber = 1234;		
		theTransaction = 5000;

		SavingsAccount testAccountTwo = new SavingsAccount(theAccountNumber, theTransaction);
		
		
		System.out.println(testAccountTwo.getBalance());
		System.out.println(testAccountTwo.toString());
		System.out.println(testAccountTwo.getInterest());
		System.out.println(testAccountTwo.getAccountNumber());
		
		deposit = 55;
		
		testAccountTwo.deposit(deposit);
		System.out.println(testAccountTwo.getBalance());
		
		 withdraw = 10;
		 testAccountTwo.withdraw(withdraw);
		System.out.println(testAccountTwo.getBalance());
		
		withdraw2 = 50;
		testAccountTwo.withdraw(withdraw2);
		System.out.println("withdraw 2 " + testAccountTwo.getBalance());
		
		System.out.println(testAccountTwo.getTransactions());

		double withdraw3 = 43.5;
		testAccountTwo.withdraw(withdraw3);
		System.out.println("withdraw 3 " + testAccountTwo.getBalance());
		
		System.out.println(testAccountTwo.getTransactions());
		
		double withdraw4 = 5000;
		testAccountTwo.withdraw(withdraw4);
		System.out.println("withdraw 3 " + testAccountTwo.getBalance());
		
		System.out.println(testAccountTwo.getTransactions());
		
		System.out.println("*** Test Credit account ***");
		
		theAccountNumber = 1234;		
		theTransaction = 5000;

		CreditAccount testAccountThree = new CreditAccount(theAccountNumber, theTransaction);
		
		
		System.out.println(testAccountThree.getBalance());
		System.out.println(testAccountThree.toString());
		System.out.println(testAccountThree.getInterest());
		System.out.println(testAccountThree.getAccountNumber());
		
		deposit = 55;
		
		testAccountThree.deposit(deposit);
		System.out.println(testAccountThree.getBalance());
		
		 withdraw = 10;
		 testAccountThree.withdraw(withdraw);
		System.out.println(testAccountThree.getBalance());
		
		withdraw2 = 50;
		testAccountThree.withdraw(withdraw2);
		System.out.println("withdraw 2 " + testAccountThree.getBalance());
		
		System.out.println(testAccountThree.getTransactions());

		System.out.println(testAccountThree.getInterest());

		
		withdraw3 = 5200;
		testAccountThree.withdraw(withdraw3);
		System.out.println("withdraw 3 " + testAccountThree.getBalance());
		
		System.out.println(testAccountThree.getTransactions());
		
		System.out.println(testAccountThree.getInterest());

		
		withdraw4 = 5000;
		testAccountThree.withdraw(withdraw4);
		System.out.println("withdraw 3 " + testAccountThree.getBalance());
		
		System.out.println(testAccountThree.getTransactions());
		
		System.out.println(testAccountThree.getInterest());

		
		System.out.println("END OF CREDIT TEST!");
		*/
		/*
		System.out.println("START OF CUSTOMER TEST!");
		Customer customer1 = new Customer("Pelle Persson", 4612204321L);
		Customer customer2 = new Customer();
		Customer customer3 = new Customer("Eva Dahlgren", 6006091234L);
		
		System.out.println(customer1.toString());
		System.out.println(customer2.toString());
		System.out.println(customer3.toString());
		
		customer1.addAccount(1, "Test", 20);
		customer1.addAccount(3, "Test", 0);
		customer2.addAccount(12, "Test2", 10);
		customer3.addAccount(12, "Test3", 1);
		
		System.out.println(customer1.toString());
		System.out.println(customer2.toString());
		System.out.println(customer3.toString());
		
		customer2.removeAccount(customer2.getAccount(12));
		customer2.removeAccount(customer2.getAccount(1));
		customer2.removeAccount(customer2.getAccount(3));
		System.out.println(customer2.toString());
		customer2.removeAccount(customer2.getAccount(566));
		
		System.out.println("END OF ACCOUNT TEST!");
		*/
		/*
		System.out.println("START OF BANK TEST!");
		
		BankLogic bank = new BankLogic();
		bank.addCustomer("Pelle Persson", 12345L);
		int addedAccount = bank.addSavingsAccount(12345L);
		System.out.println("Added Account: " + addedAccount);
		System.out.println("Added Customer: " + bank.infoCustomer(12345L));
		System.out.println("Added Bank: " + bank.infoBank());
		addedAccount = bank.addSavingsAccount(12345L);
		System.out.println("Added Account: " + addedAccount);

		addedAccount = bank.addSavingsAccount(12345L);
		System.out.println("Added Account: " + addedAccount);

		addedAccount = bank.addSavingsAccount(12345L);
		System.out.println("Added Account: " + addedAccount);
		addedAccount = bank.addSavingsAccount(12345L);
		System.out.println("Added Account: " + addedAccount);
		System.out.println("Added Bank: " + bank.infoBank());
		
		System.out.println("NEW CUSTOMER");
		bank.addCustomer("Elin Eriksson", 123456L);
		addedAccount = bank.addSavingsAccount(123456L);
		System.out.println("Added Account: " + addedAccount);
		System.out.println("Added Customer: " + bank.infoCustomer(123456L));
		addedAccount = bank.addSavingsAccount(123456L);
		System.out.println("Added Account: " + addedAccount);
		addedAccount = bank.addSavingsAccount(123456L);
		System.out.println("Added Account: " + addedAccount); 
		
		
		System.out.println("Info Customer: \n" + bank.infoCustomer(12345L));
		System.out.println("Info Customer: \n" + bank.infoCustomer(123456L));
		
		String removedAccount =  bank.closeAccount(12345L, 1001);		
		System.out.println("Removed Account: " + removedAccount);
		System.out.println("Info Customer: \n" + bank.infoCustomer(12345L));
		addedAccount = bank.addSavingsAccount(123456L);
		System.out.println("Info Customer: \n" + bank.infoCustomer(123456L));
		
		System.out.println("END OF BANKLOGIC TEST!");
		*/
		
		
		 System.out.println("START OF BANK TEST!");
		BankMenu2 bankTest = new BankMenu2();
		bankTest.test();
		 
		
	}
}