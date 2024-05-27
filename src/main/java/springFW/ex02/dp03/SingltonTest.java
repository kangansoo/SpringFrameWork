package springFW.ex02.dp03;

public class SingltonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.getInstance();
		singleton.showCount();
		Singleton singleton1 = Singleton.getInstance();
		singleton1.showCount();
	}

}
