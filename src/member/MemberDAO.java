package member;
import java.sql.*;//con pstmt stmt rs

import javax.sql.*;//DataSource
import javax.naming.*;//lookup


//DAO : 비즈니스 로직 처리 
public class MemberDAO {
   //싱글톤 객체사용
   private static MemberDAO instance=new MemberDAO();//객체사용
   
   
   //생성자:외부에서 객체 생성 못하게 한다.
   private MemberDAO(){}
   
   
   //JSP에서 사용할 메서드
   
   public static MemberDAO getInstance(){
      return instance;
   }
   //---------------------------
    //커넥션 사용
   //---------------------------
   private Connection getCon() throws Exception{
      Context ct=new InitialContext();
      DataSource ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql");
      return ds.getConnection();
   }
   
   //전역변수
   Connection con=null;
   Statement stmt=null;
   PreparedStatement pstmt=null;
   ResultSet rs= null;
   String sql="";
   //-----------------------------
   // id 중복 체크
   //-----------------------------
   
   public int confirmID(String id){
      int x=-100;
      
      try{
         con=getCon();//커넥션 얻기
         pstmt=con.prepareStatement("select id from member where id=?");//문자열일떈 물음표가 편하다.
         pstmt.setString(1, id);
         
         rs=pstmt.executeQuery();//select할때만 rs 쓴다
         
         if(rs.next()){
            x=1;//이미 사용중인 id
            
         }else{
            x=-1;//사용 가능한 id
         }
         
         
      }catch(Exception ex){
         System.out.println("conFirmID() 예외발생:"+ex);
      }finally{
         try{
            if(rs!=null){rs.close();}
            if(pstmt!=null){pstmt.close();}
            if(con!=null){con.close();}
            
         }catch(Exception ex2){}
      }//finally end
      
      return x;
         
   }//conFirmID() end
   //----------------------------------
   // 회원가입
   //----------------------------------
   public void insertMember(MemberDTO dto){
      System.out.println("addr2:"+dto.getAddr2());
      try{
         con=getCon();
         pstmt=con.prepareStatement("insert into member values(?,?,?,?,?,?,?,?,NOW())");
         
         pstmt.setString(1, dto.getId());
         pstmt.setString(2, dto.getPw());
         pstmt.setString(3, dto.getName());
         pstmt.setString(4, dto.getEmail());
         
         pstmt.setString(5, dto.getTel());
         pstmt.setString(6, dto.getZipcode());
         pstmt.setString(7, dto.getAddr());
         pstmt.setString(8, dto.getAddr2());
         
         pstmt.executeUpdate();//insert , update , delete  rs=.pstmt.exectuetQuery() = > select
         
         
      }catch(Exception ex){
         System.out.println("insertMember() 예외발생:"+ex);
         
      }finally{//예외 발생과 상관없이 무조건 처리한다.
         try{
            //if(rs!=null){rs.close();}
            if(pstmt!=null){pstmt.close();}
            if(con!=null){con.close();}
            
         }catch(Exception ex2){}
         
      }//finally end
      
   }//insertMember() end
   //----------------------------
   //로그인
   //----------------------------
   public int userCheck(String id,String pw){
      int x=-100;
      String dbpw="";
      
      try{
         con=getCon();
         pstmt=con.prepareStatement("select pw from member where id=?");
         pstmt.setString(1, id);
         rs=pstmt.executeQuery();
         
         if(rs.next()){
            dbpw=rs.getString("pw");
            if(pw.equals(dbpw)){//암호 일치하면
               x=1;
            }else{
               x=0;//암호 틀릴 때 인증 실패
            }//else end
         }else{//없는 id
            x=-1;
         }//else end
         
      }catch(Exception ex){
         System.out.println("userCheck() 예외발생:"+ex);
      }finally{
         try{
            if(rs!=null){rs.close();}
            if(pstmt!=null){pstmt.close();}
            if(con!=null){con.close();}
            
         }catch(Exception ex2){}
      }//finally end
      return x;
   }//userCheck() end
   //--------------
   //암호체크
   //----------------
   
   public int pwCheck(String id,String pw){
	  
      int x=-100;
      
      try{
         con=getCon();
         pstmt=con.prepareStatement("select * from member where id=? and pw=?");
         pstmt.setString(1, id);
         pstmt.setString(2, pw);
         rs=pstmt.executeQuery();//쿼리실행
         
         if(rs.next()){
        	 x=1;//암호 확인 한 것
         }else{
        	 x=-1;
         }
      }catch(Exception ex){
         System.out.println("pwCheck() 예외발생:"+ex);
      }finally{
    	  try{
    		  if(rs!=null){rs.close();}
              if(pstmt!=null){pstmt.close();}
              if(con!=null){con.close();}
    	  }catch(Exception ex2){}
      }//finally-end
      
      return x;
   }//pwCheck() end
   
   //-------------------
   // 내 정보 수정 front-end보낼것
   //-------------------
   public MemberDTO getMember(String id){
	   MemberDTO dto=null;
	   try{
		   con=getCon();//커넥션 얻기
		   pstmt=con.prepareStatement("select * from member where id=?");
		   pstmt.setString(1, id);
		   rs=pstmt.executeQuery();
		   
		   if(rs.next()){
			   //rs내용을 dto에 넣는다
			   dto=new MemberDTO();
			   
			   dto.setId(rs.getString("id"));
			   dto.setPw(rs.getString("pw"));
			   dto.setName(rs.getString("name"));
			   dto.setEmail(rs.getString("email"));
			   dto.setTel(rs.getString("tel"));
			   dto.setZipcode(rs.getString("zipcode"));
			   dto.setAddr(rs.getString("addr"));
			   dto.setAddr2(rs.getString("addr2"));
			   dto.setRegdate(rs.getString("regdate"));
			   
			  
		   }//if-end
	   }catch(Exception ex){
		   System.out.println("getMember() 예외:"+ex);
		   
	   }finally{
		   try{
			   if(rs!=null){rs.close();}
	           if(pstmt!=null){pstmt.close();}
	           if(con!=null){con.close();}
		   }catch(Exception ex){}
	   }//finally
	   
	   return dto;
   }//getMember()-end
   //--------------------
   // DB 내 정보 수정
   //--------------------
   public void updateMember(MemberDTO dto){
	   try{
		   con=getCon();
		   sql="update member set pw=?, name=?, email=?, tel=?, zipcode=?, addr=?, addr2=? where id=?";//나열된 순서대로 넣어야함
		   pstmt=con.prepareStatement(sql);
		   
		   pstmt.setString(1, dto.getPw());
		   pstmt.setString(2, dto.getName());
		   pstmt.setString(3, dto.getEmail());
		   pstmt.setString(4, dto.getTel());
		   pstmt.setString(5, dto.getZipcode());
		   pstmt.setString(6, dto.getAddr());
		   pstmt.setString(7, dto.getAddr2());
		   pstmt.setString(8, dto.getId());
		   
		   pstmt.executeUpdate();//쿼리실행
		   
	   }catch(Exception ex){
	         System.out.println("updateMember() 예외발생:"+ex);
	      }finally{
	    	  try{
	    		  if(rs!=null){rs.close();}
	              if(pstmt!=null){pstmt.close();}
	              if(con!=null){con.close();}
	    	  }catch(Exception ex2){}
	      }//finally-end
   }//updateMember()-end
   //---------------------
   // DB글 삭제
   //---------------------
   public int deleteMember(String id,String pw){
	   int x=-100;
	   try{
		   con=getCon();
		   pstmt=con.prepareStatement("select pw from member where id=?");
		   pstmt.setString(1, id);
		   rs=pstmt.executeQuery();
		   
		   if(rs.next()){
			   String dbpw=rs.getString("pw");
			   if(pw.equals(dbpw)){//암호가 일치 하면 삭제
				   pstmt=con.prepareStatement("delete from member where id=?");
				   pstmt.setString(1, id);
				   pstmt.executeUpdate();
				   
				   x=1;//삭제성공
			   }else{
				   x=-1;//암호 틀림
			   }//else-end
		   }//if-end
		   
	   }catch(Exception ex){
		   System.out.println("deleteMember() 예외:"+ex);
	   }finally{
	    	  try{
	    		  if(rs!=null){rs.close();}
	              if(pstmt!=null){pstmt.close();}
	              if(con!=null){con.close();}
	    	  }catch(Exception ex2){}
	      }//finally-end
	   return x;
   }//deleteMember()-end
   
   

}//class end 