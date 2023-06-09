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
		
		//loginForm.jsp에서 데이터 받기
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		
		MemberDAO dao=MemberDAO.getInstance();//dao객체생성
		int x=dao.userCheck(id, pw);//dao메서드호출
		
		//JSP에서 사용할 속성 설정
		request.setAttribute("x", x);// x=1; 인증성공// x=0; 암호틀림// x=-1; 인증실패
		request.setAttribute("id", id);//session에 등록 JSP에서 
		
		return "/member/loginPro.jsp";//뷰리턴
	}//requestPro()-end

}//class-end
