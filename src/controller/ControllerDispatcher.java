package controller;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import command.CommandAction;

//컨트롤러(서블릿+java문법)
public class ControllerDispatcher extends HttpServlet{
  private Map map=new HashMap();
  
  //init():초기화 작업
  public void init(ServletConfig config) throws ServletException{
     String path=config.getServletContext().getRealPath("/");//실제 경로 얻기
     
     //WEB-INF/command.properties
     String pros=path+config.getInitParameter("proFile");
     Properties pp=new Properties();
     FileInputStream ff=null;
     
     try{
        ff=new FileInputStream(pros);
        pp.load(ff);//key value
     }catch(Exception ex){
        System.out.println("파일 읽기 에러:"+ex);
     }
     
     //Iterator는 Enumeration과 Collection(Vector,List,Properties...)를 통합하여 받아낼 수 있는 기능을 가지고 있다
     Iterator keyIter=pp.keySet().iterator();//System.out.println();
     while(keyIter.hasNext()){//자료가 있는 동안 반복 처리
        String key=(String)keyIter.next();
        String className=pp.getProperty(key);//key에 해당하는 값을 받는다
        
        //  key                  value=className
        //board/writeForm.do=action.board.WriteFormAction
        
        try{
           Class commandClass=Class.forName(className);//클래스를 만든다 
           Object commandObject=commandClass.newInstance();//클래스 객체 생성
           map.put(key, commandObject);
           
        }catch(Exception ex){
          System.out.println("properties파일 내용을 클래스로 만들던 중 예외 발생:"+ex); 
        }
     }//while-end
  }//init()-end
  
  //웹 브라우저 요청시. get,post
  public void doGet(HttpServletRequest request,HttpServletResponse response) 
        throws IOException,ServletException{
     reqPro(request,response);//메서드 호출
  }//doGet()-end
  
  public void doPost(HttpServletRequest request,HttpServletResponse response) 
        throws IOException,ServletException{
     reqPro(request,response);//메서드 호출
  }//doPost()-end
  
  //사용자 정의 메서드 
  private void reqPro(HttpServletRequest request,HttpServletResponse response) 
        throws IOException,ServletException{
     String view="";
     CommandAction commandAction=null;//상위 클래스 변수로 하위 객체 처리
     
     try{
        String uri=request.getRequestURI();//  /context패스=프로젝트이름
        
        //요청URI:       /02_jsp/ch04_innerObject/03_request.jsp
        //ContextPath:  /02_jsp
        
        if(uri.indexOf(request.getContextPath())==0){
          uri=uri.substring(request.getContextPath().length());
        }//if-end
        
        //commandAction=(CommandAction)map.get(key);
        commandAction=(CommandAction)map.get(uri);
        view=commandAction.requestPro(request, response); //  /board/list.jsp
                           
     }catch(Throwable ex){
        throw new ServletException(ex);
     }
     
     request.setAttribute("CONTENT", view);
     
     RequestDispatcher rd=request.getRequestDispatcher("/template/template.jsp");
     rd.forward(request, response);//jsp로 포워딩 
  }//reqPro()-end
}//class-end