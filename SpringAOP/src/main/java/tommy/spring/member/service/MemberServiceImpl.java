package tommy.spring.member.service;

import tommy.spring.member.vo.MemberVO;
import tommy.spring.member.vo.UpdateInfo;

public class MemberServiceImpl implements MemberService {
	
	// 여기서 원래는 MemberDAO를 주입
	
	@Override
	public void regist(MemberVO member) {
		System.out.println("[핵심로직] MemberServiceImpl.regist() 메서드 실행");
	}

	@Override
	public boolean update(String memberId, UpdateInfo info) {
		System.out.println("[핵심로직] MemberServiceImpl.update() 메서드 실행");
		return true;
	}

}
