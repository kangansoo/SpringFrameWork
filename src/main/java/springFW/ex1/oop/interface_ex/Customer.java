package springFW.ex1.oop.interface_ex;

public class Customer implements Buy, Sell{

	@Override
	public void sell() {
		// TODO Auto-generated method stub
		System.out.println("판매하기");
		
	}

	@Override
	public void buy() {
		// TODO Auto-generated method stub
		System.out.println("구매하기");
	}

}
