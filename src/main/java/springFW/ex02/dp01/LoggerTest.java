package springFw.ex02.dp01;

public class LoggerTest {

	public static void main(String[] args) {
		//LoggerInterface를 상속받는 class를 만들어서 LoggerService에 new 연산자로 생성하면 됨
		//LoggerService svc = new LoggerService(new LoggerConsole());
		LoggerService svc = new LoggerService(new LoggerFile());
		
		try {
			svc.start();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
