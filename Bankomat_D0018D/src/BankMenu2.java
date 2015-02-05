/**
 * Labb 2 - Testar klasserna Account och Customer via BankLogic
 * Susanne Fahlman, susanne.fahlman@ltu.se
 * Notera att denna klass kan komma att förändras under kursens gång 
 * så du ska alltid kolla så att du har den senaste versionen innan du lämnar in
 * 
 * Senast ändrad: 2014-10-08
 */


//import java.util.Scanner;
public class BankMenu2
{
	private BankLogic bank = new BankLogic();
	
	//-----------------------------------------------------------------------------------
	// Kör igenom ett testscenario
	//-----------------------------------------------------------------------------------
	public void test()
	{
		System.out.println("Här testas all funktionalitet + lab2. Notera att utskriften OK! betyder att testet\n" +
				"gick igenom medan FEL! betyder att testet misslyckades och din kod måste ses över.\n" +
				"Koden i denna testklass ska inte ändras! ");
		// Skriver ut bankinfo
		printBank();

		// Skapar testkund...
		addCustomer("Karl Karlsson", 8505221898L, true);
		addCustomer("Donald Duck"  , 8505221898L, false);
		addCustomer("Pelle Persson", 6911258876L, true);	
		addCustomer("Lotta Larsson", 7505121231L, true);	
		
		// Skriver ut en lista med kunder
		printBank();
		
		
		// Skapa konton
		addSavingsAccount(8505221898L);	// 1001
		addCreditAccount(6911258876L);	// 1002
		addCreditAccount(8505221898L);	// 1003	
		addSavingsAccount(7505121231L); // 1004
		
		// Skriver ut kunderna inklusive konton
		printCustomer(8505221898L);
		printCustomer(6911258876L);
		printCustomer(7505121231L);

		// Sätter in 4000 på sparkontot 1004
		deposit(7505121231L, 1004, 4000, true);			
		withdraw(7505121231L, 1004, 1000, true);
		// Uttaget går inte genomföra eftersom uttagsränta + belopp överstiger saldot
		withdraw(7505121231L, 1004, 2990, false);
		getTransactions(7505121231L, 1004);
		
		// Sätter in 4000 på kreditkontot 1002
		deposit(6911258876L, 1002, 4000, true);		
		
		// Sätter in 700 kr på konto 1002 (ska ej gå pga fel kontoägare)
		deposit(8505221898L, 1002, 700, false);		
		
		// Sätter in 500 kr på konto 1001
		deposit(8505221898L, 1001, 500, true);						
		// Ta ut 500 kr  på konto 1001
		withdraw(8505221898L, 1001, 500, true);						
		// Ta ut 1 kr  på konto 1001 (ska ej gå)
		withdraw(8505221898L, 1001, 1, false);
		// Såtter in 1000 kr  på konto 1001
		deposit(8505221898L, 1001, 1000, true);	
		
		closeAccount(8505221898L, 1001);	
		
		printBank();
		
		// Utför några transaktioner
		deposit(8505221898L, 1003, 5000, true);							
		withdraw(8505221898L, 1003, 10000, true);	
		withdraw(8505221898L, 1003, 10, false);		// Går ej
		deposit(8505221898L, 1003, 4000, true);	
		withdraw(8505221898L, 1003, 3000, true);	
		getTransactions(8505221898L, 1003);

		addSavingsAccount(7505121231L); // 1005
		
		// Sätter in 100 kr
		deposit(7505121231L, 1005, 100, true);	
		
		// Tar ut 7 kr tre gånger
		withdraw(7505121231L, 1005, 7, true);
		withdraw(7505121231L, 1005, 7, true);						
		withdraw(7505121231L, 1005, 7, true);		
		getTransactions(7505121231L, 1005);
		
		// Skriv ut kontoinformation
		printCustomer(7505121231L);
				
		removeCustomer(7505121231L);
		
		printBank();
		
		removeCustomer(6911258876L);
		printBank();
		
		removeCustomer(8505221898L);
		printBank();
	}
	
	/**
	 * Hjälpmetod för att skriva ut kundlistan
	 */
	private void printBank()
	{
		System.out.println("\n## BANKEN INNEHÅLLER ##");
		System.out.println(bank.infoBank());
	}
	
	/**
	 * Hjälpmetod för att skriva ut en kund
	 * @param pNr - Personnummer
	 */
	private void printCustomer(long pNr)
	{
		System.out.println("\n# UTSKRIFT AV KUND\t" + pNr);
		System.out.println(bank.infoCustomer(pNr));
	}
	
	/**
	 * Hjälpmetod för att skriva ut information om ett konto
	 * @param pNr - Personnummer
	 * @param accountId - Kontonummer
	 */
	private void printAccount(long pNr, int accountId)
	{
		System.out.println("\n# UTSKRIFT AV KONTO\t" + pNr + "\t" + accountId);
		System.out.println(bank.infoAccount(pNr, accountId));
	}
	
	/**
	 * Hjälpmetod som skapar upp en kund samt skriver ut om testet blev godkänt
	 * @param name - Kundens namn (för och efternamn)
	 * @param pNr  - Kundens personnummer
	 * @param check - skicka in true om det borde fungera eller false om det inte borde gå skapa kund
	 */
	private void addCustomer(String name, long pNr, boolean check)
	{
		System.out.println("# SKAPA KUND\t" + pNr + "\t" + name);
		if(bank.addCustomer(name, pNr) == check)		
			System.out.println("\t- OK!");
		else
			System.out.println("\t- FEL!");
	}

	/**
	 * Hjälpmetod som byter namn på en kund samt skriver ut om testet blev godkänt
	 * @param name - Kundens namn (för och efternamn)
	 * @param pNr  - Kundens personnummer
	 * @param check - skicka in true om det borde fungera eller false om det inte borde gå skapa kund
	 */
	private void changeName(String name, long pNr, boolean check)
	{
		System.out.println("# ÄNDRA NAMN\t" + pNr + "\t" + name);
		if(bank.changeCustomerName(name, pNr) == check)		
			System.out.println("\t- OK!");
		else
			System.out.println("\t- FEL!");
	}


	/**
	 * Hjälpmetod som skapar upp ett sparkonto samt skriver ut OK! om kontot skapades eller FEL! om kontot inte skapades
	 * Konto kan bara skapas om man valt kund först
	 * @param pNr - kontoägaren
	 */
	private void addSavingsAccount(long pNr)
	{
		int id = bank.addSavingsAccount(pNr);
		System.out.println("# SKAPA KONTO\t" + pNr + "\t" + id);
		if(id == -1)
			System.out.println("\t- FEL!");
		else
			System.out.println("\t- OK!");
	}

	/**
	 * Hjälpmetod som skapar upp ett kreditkonto samt skriver ut OK! om kontot skapades eller FEL! om kontot inte skapades
	 * Konto kan bara skapas om man valt kund först
	 * @param pNr - kontoägaren
	 */
	private void addCreditAccount(long pNr)
	{
		int id = bank.addCreditAccount(pNr);
		System.out.println("# SKAPA KONTO\t" + pNr + "\t" + id);
		if(id == -1)
			System.out.println("\t- FEL!");
		else
			System.out.println("\t- OK!");
	}

		
	/**
	 * Hjälpmetod som sätter in pengar på konto samt skriver ut om testet blev godkänt
	 * Ska bara gå göra om man skickar in personnummer och kontonummer som hör ihop
	 * @param pNr - kontoägaren
	 * @param accountId - kontonummret
	 * @param amount  - belopp
	 * @param check - skicka in true om det borde fungera eller false om det inte borde gå sätta in pengar
	 */
	private void deposit(long pNr, int accountId, int amount, boolean check)
	{
		System.out.println("# INSÄTTNING\t" + pNr + "\t" + accountId + "\t" + amount + " kr");
		if(bank.deposit(pNr, accountId, amount) == check)							
			System.out.println("\t- OK!");
		else
			System.out.println("\t- FEL!");
	}
	
	/**
	 * Hjälpmetod som tar ut pengar från konto samt skriver ut om testet blev godkänt
	 * Ska bara gå göra om man skickar in personnummer och kontonummer som hör ihop samt om belopp finns
	 * @param pNr - kontoägaren
	 * @param accountId - kontonummret
	 * @param amount  - belopp
	 * @param check - skicka in true om det borde fungera eller false om det inte borde gå ta ut pengar
	 */
	private void withdraw(long pNr, int accountId, int amount, boolean check)
	{
		System.out.println("# UTTAG\t" + pNr + "\t" + accountId + "\t-" + amount + " kr");
		if(bank.withdraw(pNr, accountId, amount) == check)							
			System.out.println("\t- OK!");
		else
			System.out.println("\t- FEL!");
	}
	
	/**
	 * Hjälpmetod hämtar information om transaktioner som gjorts på kontot
	 * Ska bara gå göra om man skickar in personnummer och kontonummer som hör ihop
	 * @param pNr - kontoägaren
	 * @param accountId - kontonummret
	 */
	private void getTransactions(long pNr, int accountId)
	{							
		System.out.println(bank.infoTransactions(pNr, accountId));
	}
	
	/**
	 * Hjälpmetod som stänger ett konto samt skriver ut information inklusive ränta man får
	 * Ska bara gå göra om man skickar in personnummer och kontonummer som hör ihop
	 * @param pNr - kundägaren
	 * @param accountId - kontonummret
	 */
	private void closeAccount(long pNr, int accountId)
	{
		System.out.println("# AVSLUTA KONTO\t" + pNr + "\t" + accountId);
		System.out.println(bank.closeAccount(pNr, accountId));							
	}
		
	/**
	 * Hjälpmetod som tar bort en kund inklusive konton från banken
	 * @param pNr - kund
	 */
	private void removeCustomer(long pNr)
	{
		System.out.println("# TA BORT KUND (+ KONTON)\t" + pNr);
		System.out.println(bank.removeCustomer(pNr));				
	}

	/**
	 * Skapar en instans av BankMenu-klassen och kör igång menyn
	 * @param	args	argument används inte
	 */
	public static void main(String[] args)
	{
		
		BankMenu2 bankMenu = new BankMenu2();
		bankMenu.test();
	}
}