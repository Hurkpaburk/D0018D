import java.util.*;

public class TestSavingsAccount {
	
	public static void main(String []args){
		
		System.out.println("START OF ACCOUNT TEST!");
		int theAccountNumber = 1234;		
		String theAccountType = "Sparkonto";
		int theTransaction = 10;
		
		SavingsAccount testAccount = new SavingsAccount(theAccountNumber, theAccountType, theTransaction);
		SavingsAccount testAccountTwo = new SavingsAccount();
		SavingsAccount testAccountThree = new SavingsAccount(theAccountNumber, theAccountType, theTransaction);

		System.out.println(testAccount.getBalance());
		System.out.println(testAccount.getAccountInfo());
		System.out.println(testAccount.getInterest());
		System.out.println(testAccount.getAccountNumber());
		
		double deposit = 15;
		
		testAccount.setBalance(deposit);
		System.out.println(testAccount.getBalance());
		
		double withdraw = -15;
		testAccount.setBalance(withdraw);
		System.out.println(testAccount.getBalance());
		
		System.out.println(testAccountTwo.getBalance());
		System.out.println(testAccountTwo.getAccountInfo());
		System.out.println(testAccountTwo.getInterest());
		System.out.println(testAccountTwo.getAccountNumber());
		

		System.out.println(testAccountThree.getBalance());
		System.out.println(testAccountThree.getAccountInfo());
		System.out.println(testAccountThree.getInterest());
		System.out.println(testAccountThree.getAccountNumber());
		System.out.println("END OF ACCOUNT TEST!");
		
		System.out.println("START OF CUSTOMER TEST!");
		Customer customer1 = new Customer("Pelle Persson", "461220-4321");
		Customer customer2 = new Customer();
		Customer customer3 = new Customer("Eva Dahlgren", "600609-1234");
		
		System.out.println(customer1.getCustomerInfo());
		System.out.println(customer2.getCustomerInfo());
		System.out.println(customer3.getCustomerInfo());
		
		customer1.addAccount(1, "Test", 20);
		customer1.addAccount(3, "Test", 0);
		customer2.addAccount(12, "Test2", 10);
		customer3.addAccount(12, "Test3", 1);
		
		System.out.println(customer1.getCustomerInfo());
		System.out.println(customer2.getCustomerInfo());
		System.out.println(customer3.getCustomerInfo());
		
		

		
	}
}