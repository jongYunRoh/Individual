package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import member.*;//DTO,DAO
public class InputProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");//첫번째 줄에
		
		//inputForm.jsp넘겨준 자료를 dto에 담고, dto를 dao메서드로 넘겨준다
		MemberDTO dto=new MemberDTO();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		
		dto.setEmail(request.getParameter("email"));
		dto.setTel(request.getParameter("tel"));
		
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setAddr(request.getParameter("addr"));
		dto.setAddr2(request.getParameter("addr2"));
		
		MemberDAO dao=MemberDAO.getInstance();//dao객체얻기
		dao.insertMember(dto);//dao메서드호출
		
		//String id=request.getParameter("id");
		//request.setAttribute("id", id);
		
		return "/member/inputPro.jsp/";//뷰리턴
	}//requestPro()-end

}//class-end
