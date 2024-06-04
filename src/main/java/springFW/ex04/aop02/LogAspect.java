package springFw.ex04.aop02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	// 핵심코드(target) Method
	@Pointcut(value="execution(* springFw.ex04..HelloService.sayHello(..))")
	private void helloPointcut() {}

	@Pointcut(value="execution(* springFw.ex04..HelloService.sayGoodbye(..))")
	private void goodbyePointcut() {}
	
	
	//공통코드(aspect)
	@Before("helloPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		System.out.println(">>> Log: " + new java.util.Date());
	}
	
	@Before("goodbyePointcut()")
	public void afterLog(JoinPoint joinPoint) {
		System.out.println(">>> Log: " + new java.util.Date());
	}
	
//	@Around("execution(* springFw.ex04..HelloService.sayHello(..))")
	@Around("helloPointcut() || goodbyePointcut()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
		
		Object result = null;
		
		Signature s = joinPoint.getSignature();
		String methodName = s.getName();
		System.out.println("[Log]Before: " + methodName + " time check start");
		
		long startTime = System.nanoTime();
		
		try {
			result = joinPoint.proceed();
		} catch(Exception e) {
			System.out.println("[Log]Exception: " + methodName);
		} finally {
			System.out.println("[Log]Finally: " + methodName);
		}
		
		
		long endTime = System.nanoTime();
		
		System.out.println("[Log]After: " + methodName + " time check start");
		System.out.println("[Log]" + methodName + ": " + (endTime-startTime)+"ns");
		
		return result;
	};
}
