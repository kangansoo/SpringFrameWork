package springFW.ex01.cooperation;

public class Student extends GeneralPassenger {
	private int money = 0;
	
	public Student(int money) {
		super(money);
		this.money = money;
	}

	public Student(String name, int money) {
		super(name, money);
	}
	
	@Override
	public void deposit(int amount) {
		this.money += amount+(amount*0.2);
	}
}
