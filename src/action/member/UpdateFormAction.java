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
		//modify.jsp에서 보내준 데이터 받기
		String id=request.getParameter("id");
		MemberDAO dao=MemberDAO.getInstance();//dao객체얻기
		MemberDTO dto=dao.getMember(id);//dao메서드 호출
		
		//JSP에서 사용할 값 설정
		request.setAttribute("dto", dto);
		
		
		return "/member/updateForm.jsp";
	}//requestPro()-end

}//class-end
