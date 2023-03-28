package action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import mysql.*;
public class UpdateProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		//updateForm.jsp 보내준 데이터 받기
		String pageNum=request.getParameter("pageNum");
		BoardDTO dto=new BoardDTO();
		
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setWriter(request.getParameter("writer"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setPw(request.getParameter("pw"));
		
		BoardDAO dao=BoardDAO.getInstance();//dao객체생성
		int x=dao.updateBoard(dto);//dao메서드 호출
		//x=1;//정상 수정
		//x=-1;//암호 틀림
		
		request.setAttribute("x", x);
		request.setAttribute("pageNum", pageNum);
		
		return "/board/updatePro.jsp";//view리턴
	
	}//requestPro()-end

}//class-end
