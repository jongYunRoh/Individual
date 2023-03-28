<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header/header.jsp" %>
<%--list.jsp --%>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Insert title here</title>
   
   <link rel="stylesheet" type="text/css" href="aa.css">
    <script src="//code.jquery.com/jquery-3.6.1.min.js"></script>
    <script type="text/javascript" src="aa.js"></script>
</head>
<body>
<%--  <%=request.getRequestURI() %><br> --%>
<%--  <%=request.getContextPath() %><br> --%>
 
 <h2>글목록(전체글:${count})</h2>
 
 <c:if test="${count==0}">
  등록된 글이 없습니다.
  <br><br>
  [<a href="${ctxpath}/board/writeForm.do">글쓰기</a>]
  <br><br>
 </c:if>

 <c:if test="${count>0}"><%--글이 있으면 --%>
  <table border="1" class="wid">
  <tr>
   <td colspan="6" align="right">
    <a href="${ctxpath}/board/writeForm.do">글쓰기</a>
   </td>
  </tr>
  
  <tr height="30" bgcolor="ivory">
   <td>번호</td>
   <td>글제목</td>
   <td>작성자</td>
   <td>작성일</td>
   <td>조회수</td>
   <td>IP</td>
  </tr>
  
  <c:forEach var="dto" items="${list}">
   <tr>
   <td>
   <c:out value="${number}"/>
   <c:set var="number" value="${number-1}"/>
   </td>
   
   
   <td>
   <!-- 답글 -->
   <c:if test="${dto.re_level>0}">
     <img src="${ctxpath}/imgs/level.gif" width="${5*dto.re_level}" height="16">
     <img src="${ctxpath}/imgs/re.gif">
   </c:if>
   
   <!-- 원글 -->
   <c:if test="${dto.re_level==0}">
     <img src="${ctxpath}/imgs/level.gif" width="${5*dto.re_level}" height="16">
   </c:if>
   
   <!-- 글제목을 클릭하면 글 내용보기로 가기 -->
   <a href="${ctxpath}/board/content.do?num=${dto.num}&pageNum=${currentPage}">
     ${dto.subject}
   </a>
   
   <!-- 조횟수가 10번 이상이면 hot.gif 표시 -->
   <c:if test="${dto.readcount>=10}">
     <img src="${ctxpath}/imgs/hot.gif">
   </c:if>
   </td>
   
   <td>${dto.writer}</td>
   <td><fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd"/></td>
   <td>${dto.readcount}</td>
   <td>${dto.ip}</td>
   </tr>
  </c:forEach>
  </table>
</c:if>

 <%--블럭처리, 페이지 처리 --%>
 
 <table class="wid">
   <tr>
     <td align="center">
       <c:if test="${count>0}">
         <%--에러방지 --%>
         <c:if test="${endPage>pageCount}">
           <c:set var="endPage" value="${pageCount}"/>
         </c:if>
         
         <%--이전 블럭 --%>
         <c:if test="${startPage>10}">
           <a href="${ctxpath}/board/list.do?pageNum=${startPage-10}">
           [이전블럭]
           </a>
         </c:if>
         
         <%--페이지 처리 --%>
         <c:forEach var="i" begin="${startPage}" end="${endPage}">
           <a href="${ctxpath}/board/list.do?pageNum=${i}">
           [${i}]
           </a>
         </c:forEach>
         
         <%--다음블럭 --%>
         <c:if test="${endPage<pageCount}">
           <a href="${ctxpath}/board/list.do?pageNum=${(startPage-1)+10}">
           [다음블럭]
           </a>
         </c:if>
         
       </c:if><%--글이 존재 하면 --%>
     </td>
   </tr>
 </table>
</body>
</html>