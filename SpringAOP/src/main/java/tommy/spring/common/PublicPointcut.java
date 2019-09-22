package tommy.spring.common;

import org.aspectj.lang.annotation.Pointcut;

public class PublicPointcut {

	// id = Pointcut 메서드 이름
	@Pointcut("execution(public * tommy.spring..*(..))")
	public void publicMethod() {
	}

}
