package springFW.ex02.dp03;

public class Singleton {
	private static Singleton singleton = null;
	private int count = 0;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}
	
	public void showCount() {
		count++;
		System.out.println("count: " + count);
	}
}
