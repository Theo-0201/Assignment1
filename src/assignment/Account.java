package assignment;

import assignment.AccountType;

public class Account {

	private double loan, rate;
	public int daysActive;
	public AccountType accountType;

	public double loan() {
		System.out.println("The loan value is " + this.loan);
		return loan;
	}

	public double getRate() {
		System.out.println("The rate is " + rate);
		return this.rate;
	}

	public double getMonthlyRate() {
		return loan * rate;
	}

	public void setValue(double value) throws Exception {
		if (value < 0)
			throw new Exception();
		else {
			loan = value;
		}
	}

	public String to_string() {
		return "Loan: " + this.loan + "; rate: " + this.rate + "; days active:" + daysActive + "; Type: " + accountType
				+ ";";
	}

	public void print() {
		int vb = 10;
		System.out.println("This is an account");
	}

	public static double calculate(Account[] accounts) {
		double totalFee = 0.0;
		Account account;
		int temp = 365;
		for (int i = 0; i < accounts.length; i++) {
			account = accounts[i];
			if (account.accountType == AccountType.PREMIUM || account.accountType == AccountType.SUPER_PREMIUM)
				totalFee += .0125 * (account.loan * Math.pow(account.rate, (account.daysActive / 365)) - account.loan);
		}
		return totalFee;
	}

	public Account(double value, double rate, AccountType accountType) throws Exception {
		if (value < 0)
			throw new Exception();
		else {
			loan = value;
		}
		if (rate < 0)
			throw new Exception();
		else {
			this.rate = rate;
		}
		if (accountType != AccountType.BUDGET || accountType != AccountType.PREMIUM || accountType != AccountType.STANDARD || accountType != AccountType.SUPER_PREMIUM )
			throw new Exception();
		else {
			this.accountType = accountType;
		}
	}

}
