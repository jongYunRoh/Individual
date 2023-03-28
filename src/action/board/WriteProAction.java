package action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import mysql.*;//DTO,DAO

public class WriteProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");//writeForm에서 보내준 한글 인코딩
		
		BoardDTO dto=new BoardDTO();
		//front-end보낸 데이터를 dto에 저장
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setWriter(request.getParameter("writer"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setPw(request.getParameter("pw"));
		
		dto.setRef(Integer.parseInt(request.getParameter("ref")));
		dto.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		dto.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		
		dto.setIp(request.getRemoteAddr());//ip
		
		BoardDAO dao=BoardDAO.getInstance();//dao객체얻기
		dao.insertBoard(dto);//dao메서드 호출
		
		return "/board/writePro.jsp";//뷰리턴-->properties로
	}//requestPro()-end

}//class-end
