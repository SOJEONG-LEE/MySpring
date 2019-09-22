package tommy.spring.polymorphism;

public class SamsungTV implements TV{
	
	private Speaker speaker;
	private int price; 
	
	public SamsungTV() {
		System.out.println("SamsungTV 객체 생성");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("SamsungTV 객체 생성 : 생성자 인젝션");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("SamsungTV 객체 생성 : 생성자 인젝션 - 다중매핑");
		this.speaker = speaker;
		this.price = price;
	}
	
//	public int getPrice() {
//		return price;
//	}

	public void setPrice(int price) {
		System.out.println("setPrice() 메서드 호출");
		this.price = price;
	}
	
//	public Speaker getSpeaker() {
//	return speaker;
//	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker() 메서드 호출");
		this.speaker = speaker;
	}
	
//	public void start() {
//		System.out.println("객체 초기화 작업 처리");
//	}
//	
//	public void stop() {
//		System.out.println("객체 삭제 전에 처리할  로직 처리");
//	}
	
	public void powerOn() {
//		System.out.println("SamsungTV 전원을 켠다.");
		System.out.println("SamsungTV 전원을 켠다. (가격 : " + price + ")");

	}
	
	public void powerOff() {
		System.out.println("SamsungTV 전원을 끈다.");
	}
	
//	public void volumeUp() {
//		System.out.println("SamsungTV 볼륨을 올린다.");
//	}
//	
//	public void volumeDown() {
//		System.out.println("SamsungTV 볼륨을 내린다.");
//	}
	
	public void volumeUp() {
//		speaker= new SonySpeaker();
		speaker.volumeUp();
	}
	
	public void volumeDown() {
//		speaker = new SonySpeaker();
		speaker.volumeDown();
	}

}
