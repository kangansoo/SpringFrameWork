package springFw.ex04.aop01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerformanceAspect {
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
