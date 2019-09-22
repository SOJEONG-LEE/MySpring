package tommy.spring.polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv") 
public class LgTV implements TV{
	
	// ��ü�� Ÿ������ ������ �����Ѵ�. �ڵ����� Speaker Ÿ���� ��ü�� ����
	@Autowired
	// ���� Ÿ���� bean��ü �߿��� apple��ü�� ���� 
//	@Qualifier("apple")
	// ��ü�� �̸����� ������ �����Ѵ�.
//	@Resource(name="sony")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("LgTV ��ü ����");
	}

	public void powerOn() {
		System.out.println("LgTV ������ �Ҵ�.");
	}
	
	public void powerOff() {
		System.out.println("LgTV ������ ����.");
	}

	@Override
	public void volumeUp() {
		System.out.println("LgTV ������ �ø���.");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		System.out.println("LgTV ������ ������.");
		speaker.volumeDown();
	}

}
