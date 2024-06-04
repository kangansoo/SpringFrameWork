package springFw.ex06.mvc01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardInsertHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// 비즈니스 로직
		System.out.println("게시판 글 등록");
		return "boardList.jsp";
	}

}
