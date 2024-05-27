package springFW.ex01.cooperation;

public class GeneralPassenger implements Passenger{
	private String name = "";
	private int money = 0;
	
	public GeneralPassenger(int money) {
		this.money = money;
	}

	public GeneralPassenger(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	@Override
	public void withdraw(int amount) {
		this.money -= amount;
		
	}
	
	public void deposit(int amount) {
		this.money += amount;
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.println(this.name + "의 소지금은 " + this.money + "입니다.");
	}	
	
}
