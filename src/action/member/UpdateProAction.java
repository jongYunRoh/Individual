package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import member.*;
public class UpdateProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");//첫줄에
		
		//updateForm.jsp에서 보내준 데이터를 dto에 담고, dto를 dao메서드로 호출해서 dao로 보낸다
		
		String id=request.getParameter("id");
		MemberDTO dto=new MemberDTO();
		dto.setId(id);
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setTel(request.getParameter("tel"));
		
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setAddr(request.getParameter("addr"));
		dto.setAddr2(request.getParameter("addr2"));
		
		MemberDAO dao=MemberDAO.getInstance();//dao객체얻기
		dao.updateMember(dto);//dao메서드 호출
		request.setAttribute("id", id);
		
		return "/member/updatePro.jsp";//뷰리턴
	}//requestPro()-end

}//class-end
