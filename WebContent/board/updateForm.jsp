<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header/header.jsp" %>
<%--updateForm.jsp --%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<link rel="stylesheet" type="text/css" href="aa.css">
    <script src="//code.jquery.com/jquery-3.6.1.min.js"></script>
    <script>
      function pwcheck(){
    	  if(document.updateForm.pw.value==""){
    		  alert("암호는 필수 입력");
    		  document.updateForm.pw.focus();
    		  return false;
    	  }//if
    	  return true;
      }
    </script>
</head>
<body>
  <h2>글수정 폼</h2>
  <form name="updateForm" method="post" action="${ctxpath}/board/updatePro.do?pageNum=${pageNum}" onSubmit="return pwcheck()">
    <table class="wid">
      
      <tr>
        <td>이름</td>
        <td>
        <input type="text" name="writer" id="writer" value="${dto.writer}">
        <input type="hidden" name="num" value="${dto.num}">
        </td>
      </tr>
      
      <tr>
        <td>글제목</td>
        <td><input type="text" name="subject" id="subject" value="${dto.subject}"></td>
      </tr>
      
      <tr>
        <td>글내용</td>
        <td>
        <textarea name="content" id="content" rows="10" cols="45">${dto.content}</textarea>
        </td>
      </tr>
      
      <tr>
        <td>암호</td>
        <td><input type="password" name="pw" id="pw"></td>
      </tr>
      
      <tr>
        <td colspan="2" align="center">
          <input type="submit" value="글수정">
          <input type="reset" value="다시쓰기">
          <input type="button" value="리스트" onClick="location='${ctxpath}/board/list.do?pageNum=${pageNum}'">
        </td>
      </tr>
    </table>
  </form>
</body>
</html>