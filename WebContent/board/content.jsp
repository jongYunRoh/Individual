<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header/header.jsp" %>
<%--content.jsp --%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<link rel="stylesheet" type="text/css" href="aa.css">
    <script src="//code.jquery.com/jquery-3.6.1.min.js"></script>
    <script type="text/javascript" src="aa.js"></script>
</head>
<body>
  <h2>글내용보기</h2>
  <table border="1" class="wid">
    <tr>
      <td class="tdcolor">글번호</td>
      <td>${dto.num}</td>
      <td class="tdcolor">조횟수</td>
      <td>${dto.readcount}</td>
    </tr>
    
    <tr>
      <td class="tdcolor">작성자</td>
      <td>${dto.writer}</td>
      <td class="tdcolor">작성일</td>
      <td>${dto.regdate}</td>
    </tr>
    
    <tr>
      <td class="tdcolor">글제목</td>
      <td colspan="3">${dto.subject}</td>
    </tr>
    
    <tr height="200">
      <td class="tdcolor">글내용</td>
      <td colspan="3"><pre>${dto.content}</pre></td>
    </tr>
    
    <tr>
      <td colspan="4" align="right">
        <a href="${ctxpath}/board/updateForm.do?num=${num}&pageNum=${pageNum}">[글수정]</a>
        <a href="${ctxpath}/board/deleteForm.do?num=${num}&pageNum=${pageNum}">[글삭제]</a>
        <a href="${ctxpath}/board/writeForm.do?num=${num}&pageNum=${pageNum}&ref=${dto.ref}
        &re_step=${dto.re_step}&re_level=${dto.re_level}">[답글쓰기]</a>
        <a href="${ctxpath}/board/list.do?pageNum=${pageNum}">[리스트]</a>
      </td>
    </tr>
  </table>
</body>
</html>