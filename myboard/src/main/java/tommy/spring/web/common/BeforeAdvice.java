package tommy.spring.web.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
// Asepct = Pointcut + Advice 
@Aspect
public class BeforeAdvice {

//	@Pointcut("execution(* tommy.spring.web..*Impl.*(..))")
//	public void allPointcut() {
//	}
//
//	@Before("allPointcut()")
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().getName();
//		String method = joinPoint.getSignature().toLongString();
		Object[] args = joinPoint.getArgs();
		System.out.println("[사전처리-Before] : " + method + "() 메서드의 ARGS 정보 : " + args[0].toString());
	}

//	public void beforeLog() {
//		System.out.println("[사전처리] : 비즈니스 로직 수행 전 동작");
//	}

}
