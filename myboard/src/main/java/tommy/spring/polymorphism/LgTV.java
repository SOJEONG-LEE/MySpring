package tommy.spring.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv") 
public class LgTV implements TV{
	
	// 객체의 타입으로 의존성 주입한다. 자동으로 Speaker 타입의 객체를 주입
	@Autowired
	// 동일 타입의 bean객체 중에서 apple객체를 선택 
//	@Qualifier("apple")
	// 객체의 이름으로 의존성 주입한다.
//	@Resource(name="sony")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("LgTV 객체 생성");
	}

	public void powerOn() {
		System.out.println("LgTV 전원을 켠다.");
	}
	
	public void powerOff() {
		System.out.println("LgTV 전원을 끈다.");
	}

	@Override
	public void volumeUp() {
		System.out.println("LgTV 볼륨을 올린다.");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV 볼륨을 내린다.");
		speaker.volumeDown();
	}

}
