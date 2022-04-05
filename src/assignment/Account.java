package assignment;

import assignment.AccountType;

public class Account {

	private double loan, rate;
	public int daysActive; //all attr private! + accessor methods
	public AccountType accountType;
	
	private static final int DAYS = 365;
	private static final float BROKER_FEE = 0.0125f;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [loan=");
		builder.append(loan);
		builder.append(", rate=");
		builder.append(rate);
		builder.append(", daysActive=");
		builder.append(daysActive);
		builder.append(", accountType=");
		builder.append(accountType);
		builder.append("]");
		return builder.toString();
	}

	public static double calculate(Account[] accounts) {
		double totalFee = 0.0;
		Account account;
		//check if accounts is not null
		for (int i = 0; i < accounts.length; i++) {
			account = accounts[i];
			if (account.accountType == AccountType.PREMIUM || account.accountType == AccountType.SUPER_PREMIUM)
				totalFee += BROKER_FEE * (account.loan * Math.pow(account.rate, (account.daysActive / DAYS)) - account.loan);
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
