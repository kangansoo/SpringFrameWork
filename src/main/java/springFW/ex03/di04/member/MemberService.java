package springFW.ex03.di04.member;

public class MemberService implements IMemberService {

	@Override
	public MemberVO getMemberInfo() {
		MemberVO vo = new MemberVO();
		vo.setMemberID("1234");
		vo.setName("홍길동");
		vo.setAge(22);
		vo.setEmail("1234@gmail.com");
		
		return vo;
	}

}
