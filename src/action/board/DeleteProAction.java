package action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import mysql.*;//DTO,DAO

public class DeleteProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		//deleteForm.jsp보내준 값 받기
		int num=Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		String pw=request.getParameter("pw");
		
		BoardDAO dao=BoardDAO.getInstance();//dao객체얻기
		int x=dao.deleteArticle(num, pw);//dao메서드 호출
		
		//x==1 삭제성공
		//x==-1 암호틀림
		request.setAttribute("x", x);
		request.setAttribute("pageNum", pageNum);
		
		return "/board/deletePro.jsp";
	}//requestPro()-end

}//class-end
