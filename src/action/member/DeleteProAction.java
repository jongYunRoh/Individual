package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import member.*;//DTO,DAO
public class DeleteProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		//deleteForm.jsp에서 보내준 데이터 받기
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		MemberDAO dao=MemberDAO.getInstance();//dao객체얻기
		int x=dao.deleteMember(id, pw);//dao메서드 호출
		
		//jsp에서 사용할 속성 설정
		request.setAttribute("x", x);
		//x=1; 삭제
		//x=-1 암호틀림
		return "/member/deletePro.jsp";
	}//requestPro()-end

}//class-end
