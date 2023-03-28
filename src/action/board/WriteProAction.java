package action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import mysql.*;//DTO,DAO

public class WriteProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");//writeForm���� ������ �ѱ� ���ڵ�
		
		BoardDTO dto=new BoardDTO();
		//front-end���� �����͸� dto�� ����
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setWriter(request.getParameter("writer"));
		dto.setSubject(request.getParameter("subject"));
		dto.setContent(request.getParameter("content"));
		dto.setPw(request.getParameter("pw"));
		
		dto.setRef(Integer.parseInt(request.getParameter("ref")));
		dto.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		dto.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		
		dto.setIp(request.getRemoteAddr());//ip
		
		BoardDAO dao=BoardDAO.getInstance();//dao��ü���
		dao.insertBoard(dto);//dao�޼��� ȣ��
		
		return "/board/writePro.jsp";//�丮��-->properties��
	}//requestPro()-end

}//class-end
