package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import member.*;//DTO,DAO
public class UpdateFormAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		//modify.jsp���� ������ ������ �ޱ�
		String id=request.getParameter("id");
		MemberDAO dao=MemberDAO.getInstance();//dao��ü���
		MemberDTO dto=dao.getMember(id);//dao�޼��� ȣ��
		
		//JSP���� ����� �� ����
		request.setAttribute("dto", dto);
		
		
		return "/member/updateForm.jsp";
	}//requestPro()-end

}//class-end
