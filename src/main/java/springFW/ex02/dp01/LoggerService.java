package springFW.ex02.dp01;

import java.util.Scanner;

public class LoggerService {
	private LoggerInterface logger;
	
	//public LoggerService() {}
	
	public LoggerService(LoggerInterface logger) {
		this.logger = logger;
	}
	
	public void start() throws Exception {
		System.out.println("전압을 입력해주세요");
		Scanner sc = new Scanner(System.in);
		
		try {
			while(true) {
				String v = sc.next().toUpperCase();
				
				if ("Q".equals(v)) {
					System.out.println("종료되었습니다.");
					break;
				}
				//System.out.println("입력 전압: " + v);
				logger.writeLog(v);
			}
		} catch(Exception e) {
			throw new Exception("입력값 오류");
		} finally {
			sc.close();
		}
	}
}
