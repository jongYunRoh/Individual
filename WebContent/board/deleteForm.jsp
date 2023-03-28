<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header/header.jsp" %>    
<%--deleteForm.jsp --%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="aa.css">
	
	<script>
	  function pwcheck(){
		  if(document.delForm.pw.value==""){
			  alert("암호는 필수 입력");
			  document.delForm.pw.focus();
			  return false;
		  }//if
		  return true;
	  }
	</script>
</head>
<body>
	<h2>글삭제 폼</h2>
	<form name="delForm" method="post" action="${ctxpath}/board/deletePro.do?pageNum=${pageNum}" onSubmit="return pwcheck()">
	  <table border="1" width="350">
	    <tr>
	      <td colspan="2">
	        <h4>암호를 입력 하세요</h4>
	      </td>
	    </tr>
	    
	    <tr>
	      <td>암호</td>
	      <td>
	      <input type="password" name="pw" id="pw" size="12">
	      <input type="hidden" name="num" value="${num}">
	      </td>
	    </tr>
	    
	    <tr>
	      <td colspan="2" align="center">
	        <input type="submit" value="글삭제">
	        <input type="button" value="리스트" onClick="location='${ctxpath}/board/list.do?pageNum=${pageNum}'">
	      </td>
	    </tr>
	  </table>	
	</form>
</body>
</html>