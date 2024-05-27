package springFW.ex02.dp01;

public class LoggerConsole implements LoggerInterface{

	@Override
	public void writeLog(String log) throws Exception {
		System.out.println("입력 전압: " + log);
	}

}
