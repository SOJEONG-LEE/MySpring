package tommy.spring.web.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
//Asepct = Pointcut + Advice
@Aspect
public class LogAdvice {

//	@Pointcut("execution(* tommy.spring.web..*Impl.*(..))")
//	public void allPointcut() {
//	}
//
//	@Before("allPointcut()")
	@Before("PointcutCommon.allPointcut()")
	public void printLog() {
		System.out.println("[로그] : 비즈니스 로직 수행 전 동작");
	}
}
