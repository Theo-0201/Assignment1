package assignment;

public class Account {

	public double loan, rate;	
	public int	daysActive,account_Type;
	public static final int	STANDARD=0,BUDGET=1,PREMIUM=2,SUPER_PREMIUM=3;
	
	public double loan() {
		System.out.println("The loan value is " + this.loan);
		return loan;
	}
	
	public double getRate() {
		System.out.println("The rate is "+rate);
		return this.rate;
	}
	
	public double getMonthlyRate() {
		return loan*rate;
	}
	
	public void setValue(double value) throws Exception {
		if(value<0)
			throw new Exception();
		else
		{
			loan = value;
		}
	}
	
	public String to_string() {
		return "Loan: "+this.loan+"; rate: "+this.rate+"; days active:"+daysActive+"; Type: "+account_Type+";";
	}
	
	public void print() {
		int vb = 10;
		System.out.println("This is an account");
	}

	public static double calculate(Account[] 	accounts)
	{
	double totalFee=0.0;
	Account	account;
	int temp = 365;
	for	(int	i=0;i<accounts.length;i++)	{
	account=accounts[i];
	if(account.account_Type==Account.PREMIUM||account.account_Type==Account.SUPER_PREMIUM)	
	totalFee+=.0125	*	(
			account.loan*Math.pow(account.rate,(account.daysActive/365)) - account.loan);	
	}
	return	totalFee;
	}

	public Account(double value, double rate, int account_Type) throws Exception {
		if(value<0)
			throw new Exception();
		else
		{
			loan = value;
		}
		this.rate = rate;
		this.account_Type = account_Type;
	}
	
}
