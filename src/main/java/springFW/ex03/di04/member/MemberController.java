package springFW.ex03.di04.member;

public class MemberController {
	private IMemberService memberService;
	
	public void setMemberService(IMemberService memberService) {
		this.memberService = memberService;
	}
	
	public void printInfo() {
		MemberVO vo = memberService.getMemberInfo();
		System.out.println(vo);
	}
	
}
