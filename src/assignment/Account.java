package assignment;

public final class Account implements MonthlyRate, Loan {

	private double loan, rate;
	private int daysActive;
	private AccountType accountType;
	
	private static final int DAYS = 365;
	private static final float BROKER_FEE = 0.0125f;
	
	public Account(double value, double rate, int daysActive, AccountType accountType) throws IllegalArgumentException {
		if (value < 0) {
			throw new IllegalArgumentException();
		}
		else {
			loan = value;
		}
		if (rate < 0) {
			throw new IllegalArgumentException();
		}
		else {
			this.rate = rate;
		}
		if (daysActive < 0) {
			throw new IllegalArgumentException();
		} else {
			this.daysActive = daysActive;
		}
		if (accountType != AccountType.BUDGET || accountType != AccountType.PREMIUM || accountType != AccountType.STANDARD || accountType != AccountType.SUPER_PREMIUM )
			throw new IllegalArgumentException();
		else {
			this.accountType = accountType;
		}
	}

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
	
	public void setLoan(double value) throws IllegalArgumentException {
		if (value < 0) {
			throw new IllegalArgumentException();
		}
		else {
			loan = value;
		}
	}

	public void setRate(double value) throws IllegalArgumentException {
		if (value < 0) {
			throw new IllegalArgumentException();
		}
		else {
			rate = value;
		}
	}
	
	public void setDaysActive(int value) throws IllegalArgumentException {
		if (value < 0) {
			throw new IllegalArgumentException();
		}
		else {
			daysActive = value;
		}
	}
	
	public void setAccountType(AccountType accountType) throws IllegalArgumentException {
		if (accountType != AccountType.BUDGET || accountType != AccountType.PREMIUM || accountType != AccountType.STANDARD || accountType != AccountType.SUPER_PREMIUM) {
			throw new IllegalArgumentException();
		}
		else {
			this.accountType = accountType;
		}
	}

	@Override
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

	public static double calculateTotalFee(Account[] accounts) throws NullPointerException {
		double totalFee = 0.0;
		Account account;
		if(accounts == null) {
			throw new NullPointerException();
		} else {
			for (int i = 0; i < accounts.length; i++) {
				account = accounts[i];
				if (account.isPremium()) {
					totalFee += BROKER_FEE * (account.loan * Math.pow(account.rate, (account.daysActive / DAYS)) - account.loan);
				}
			}
		}
		return totalFee;
	}
	
	public boolean isPremium() {
		if (this.accountType == AccountType.PREMIUM || this.accountType == AccountType.SUPER_PREMIUM) {
			return true;
		}
		return false;
	}

	@Override
	public void printLoan() {
		System.out.println("The loan has a value of " + this.getLoan());
	}

}
