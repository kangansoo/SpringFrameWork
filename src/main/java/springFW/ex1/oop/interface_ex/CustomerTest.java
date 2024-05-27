package springFW.ex1.oop.interface_ex;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer cust = new Customer();
		cust.buy();
		cust.sell();
		
		Buy buy = cust;
		buy.buy();
	}

}
