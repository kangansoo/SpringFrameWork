package springFW.ex01.cooperation;

public class Bus {
	private int busNumber = 0;
	private int passengerCount = 0;
	private int money = 0;
	
	public Bus(int busNumber) {
		this.busNumber = busNumber;
		this.passengerCount = 0;
		this.money = 0;
	}
	
	public void getIn(Passenger pass) {
		++this.passengerCount;
		this.money += 1000;
		pass.withdraw(1000);
		
		System.out.println("버스 승차");
		pass.showInfo();
		this.showInfo();
	}

	public void getIn(Student pass) {
		++this.passengerCount;
		this.money += 800;
		pass.withdraw(800);
		
		System.out.println("버스 학생 승차");
		pass.showInfo();
		this.showInfo();
	}

	public void getOut(Passenger pass) {
		--this.passengerCount;
		System.out.println("버스 하차");
		pass.showInfo();
		this.showInfo();
	}
	
	public void showInfo() {
		System.out.println("버스" + this.busNumber + "번의 승객은 " + this.passengerCount +
		"명이고, 수입은 " + this.money + "입니다.");
	}
}
