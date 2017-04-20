package ce.simple.spring_boot.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 日志处理
 * @author zss
 * @date 2017年4月20日
 */
@Component
@Aspect
public class LogAspect {
	
	/**
	 * 切面定义
	 */
	@Pointcut("@within(org.springframework.stereotype.Controller)")
	private void pointCutMethod() {
	}
	
	//声明前置通知
	@Before("pointCutMethod()")
	public void doBefore(JoinPoint point) {
		return;
	}

	//声明后置通知
	@AfterReturning(pointcut = "pointCutMethod()", returning = "returnValue")
	public void doAfterReturning(JoinPoint point,Object returnValue) {
	}

	//声明例外通知
	@AfterThrowing(pointcut = "pointCutMethod()", throwing = "e")
	public void doAfterThrowing(Exception e) {
	}

	//声明最终通知
	@After("pointCutMethod()")
	public void doAfter() {
	}

	//声明环绕通知
	@Around("pointCutMethod()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		System.out.println("args:"+Arrays.asList(args));
		
		Object o = pjp.proceed();
		
		System.out.println("return :"+o);
		return o;
	}
}
