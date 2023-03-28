package action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import mysql.*;//DTO,DAO
public class ContentAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		//list.jsp ������ ������ �ް�
		int num=Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		
		BoardDAO dao=BoardDAO.getInstance();//dao��ü���
		BoardDTO dto=dao.getBoard(num);//dao�޼���ȣ��
		
		//jsp(view)����� �� ����
		request.setAttribute("num", num);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("dto", dto);
		
		return "/board/content.jsp";//view����
	}//requestPro()-end

}//class-end
