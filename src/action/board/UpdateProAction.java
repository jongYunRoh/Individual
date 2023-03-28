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
		
		//updateForm.jsp ������ ������ �ޱ�
		String pageNum=request.getParameter("pageNum");
		BoardDTO dto=new BoardDTO();
		
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setWriter(request.getParameter("writer"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setPw(request.getParameter("pw"));
		
		BoardDAO dao=BoardDAO.getInstance();//dao��ü����
		int x=dao.updateBoard(dto);//dao�޼��� ȣ��
		//x=1;//���� ����
		//x=-1;//��ȣ Ʋ��
		
		request.setAttribute("x", x);
		request.setAttribute("pageNum", pageNum);
		
		return "/board/updatePro.jsp";//view����
	
	}//requestPro()-end

}//class-end
