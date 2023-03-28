package action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.CommandAction;
import member.*;//DTO,DAO
public class InputProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");//ù��° �ٿ�
		
		//inputForm.jsp�Ѱ��� �ڷḦ dto�� ���, dto�� dao�޼���� �Ѱ��ش�
		MemberDTO dto=new MemberDTO();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		
		dto.setEmail(request.getParameter("email"));
		dto.setTel(request.getParameter("tel"));
		
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setAddr(request.getParameter("addr"));
		dto.setAddr2(request.getParameter("addr2"));
		
		MemberDAO dao=MemberDAO.getInstance();//dao��ü���
		dao.insertMember(dto);//dao�޼���ȣ��
		
		//String id=request.getParameter("id");
		//request.setAttribute("id", id);
		
		return "/member/inputPro.jsp/";//�丮��
	}//requestPro()-end

}//class-end
