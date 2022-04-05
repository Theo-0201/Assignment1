package assignment;

import assignment.AccountType;

public class Account {

	private double loan, rate;
	private int daysActive;
	private AccountType accountType;
	
	private static final int DAYS = 365;
	private static final float BROKER_FEE = 0.0125f;

	public double getLoan() {
		return loan;
	}

	public double getRate() {
		return rate;
	}
	
	public int getDaysActive() {
		return daysActive;
	}
	
	public AccountType getAccountType() {
		return accountType;
	}
	
	public void setLoan(double value) throws Exception {
		if (value < 0)
			throw new Exception();
		else {
			loan = value;
		}
	}

	public void setRate(double value) throws Exception {
		if (value < 0)
			throw new Exception();
		else {
			rate = value;
		}
	}
	
	public void setDaysActive(int value) throws Exception {
		if (value < 0)
			throw new Exception();
		else {
			daysActive = value;
		}
	}
	
	public void setAccountType(AccountType accountType) throws Exception {
		if (accountType != AccountType.BUDGET || accountType != AccountType.PREMIUM || accountType != AccountType.STANDARD || accountType != AccountType.SUPER_PREMIUM)
			throw new Exception();
		else {
			this.accountType = accountType;
		}
	}
	
	public double getMonthlyRate() {
		return loan * rate;
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
