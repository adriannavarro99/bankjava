package banck;

public class BankAccount {
	
		public static int Accounts = 0;
		public static double total = 0;
		

	
		
		private double checkingBalance;
		private double savingsBalance;

		public BankAccount() {
			BankAccount.Accounts += 1;
			this.checkingBalance = 0;
			this.savingsBalance = 0;
			
		}
		
		public double getCheckingBalance() {
			return this.checkingBalance;
		}

		public double getSavingsBalance() {
			return this.savingsBalance;
		}

		public void depositMoney(double amount, String account) {
			if(account.equals("savings"))
				this.savingsBalance += amount;
			else if(account.equals("checking"))
				this.checkingBalance += amount;
			BankAccount.total += amount;
		}

		public void withdrawMoney(double amount, String account) {
			boolean successful = false;
			if(account.equals("savings")) {
				// check if enough in account
				if(this.savingsBalance - amount >= 0) {
					successful = true;
					this.savingsBalance -= amount;
				}
			}
			else if(account.equals("checking")) {
				if(this.checkingBalance - amount >= 0) {
					successful = true;
					this.checkingBalance -= amount;
				}
			}
			if(successful) {
				BankAccount.total -= amount;
			}
		}

		public void displayAccountBalance() {
			
			System.out.println(String.format("Savings: %.2f, Checking: %.2f", this.savingsBalance, this.checkingBalance));
		}

		public static void main(String[] args) {
			BankAccount ba = new BankAccount();
			ba.depositMoney(100.49, "checking");
			ba.depositMoney(3.00, "savings");
			ba.displayAccountBalance();

			System.out.println(BankAccount.total);

			ba.withdrawMoney(50, "checking");
			ba.withdrawMoney(50, "savings");
			ba.displayAccountBalance();

			System.out.println(BankAccount.total);
		}

}
