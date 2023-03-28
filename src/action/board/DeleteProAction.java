package action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import mysql.*;//DTO,DAO

public class DeleteProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		//deleteForm.jsp������ �� �ޱ�
		int num=Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		String pw=request.getParameter("pw");
		
		BoardDAO dao=BoardDAO.getInstance();//dao��ü���
		int x=dao.deleteArticle(num, pw);//dao�޼��� ȣ��
		
		//x==1 ��������
		//x==-1 ��ȣƲ��
		request.setAttribute("x", x);
		request.setAttribute("pageNum", pageNum);
		
		return "/board/deletePro.jsp";
	}//requestPro()-end

}//class-end
