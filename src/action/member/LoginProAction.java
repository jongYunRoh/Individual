package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import member.*;//DTO,DAO
public class LoginProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		//loginForm.jsp���� ������ �ޱ�
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		MemberDAO dao=MemberDAO.getInstance();//dao��ü����
		int x=dao.userCheck(id, pw);//dao�޼���ȣ��
		
		//JSP���� ����� �Ӽ� ����
		request.setAttribute("x", x);// x=1; ��������// x=0; ��ȣƲ��// x=-1; ��������
		request.setAttribute("id", id);//session�� ��� JSP���� 
		
		return "/member/loginPro.jsp";//�丮��
	}//requestPro()-end

}//class-end
