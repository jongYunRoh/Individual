package action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.BoardDAO;
import command.CommandAction;
import mysql.*;
public class UpdateFormAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		//content.jsp ������ ���� �ޱ�
		int num=Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		
		BoardDAO dao=BoardDAO.getInstance();//dao��ü���
		BoardDTO dto=dao.getUpdate(num);//dao�޼���ȣ��
		
		//JSP���� ����� �� ����
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("dto", dto);
		
		return "/board/updateForm.jsp";//view����
	
	}//requestPro()-end

}//class-end
