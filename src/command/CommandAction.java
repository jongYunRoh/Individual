package command;
import javax.servlet.http.*;
//인터페이스
public interface CommandAction {
	//메서드 선언
	public String requestPro(HttpServletRequest request,HttpServletResponse response) throws Throwable;
}//interface-end
