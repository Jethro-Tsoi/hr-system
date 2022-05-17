public class Housing {

	private int balance;

	public Housing() {
		balance = 0;
	}

	public Housing(int b) {
		balance = b;
	}

	public void add(int amount) {
		balance += amount;
		System.out.println(this.toString());
	}

	public void use(int amount) {
		if(balance > amount)
			balance -= amount;
		else
			System.out.println("Not enough balance!!");
		System.out.println(this.toString());
	}

	public int getbalance() {
		return balance;
		
	}

	@Override
	public String toString() {
		return "Housing balance is $" + balance;
	}

}