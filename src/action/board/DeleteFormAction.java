package action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;

public class DeleteFormAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		//content.jsp ������ �ذ� �ޱ�
		int num=Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		
		//JSP���� ����� �� ����
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		
		return "/board/deleteForm.jsp";//view����
	}//requestPro()-end

}//class-end