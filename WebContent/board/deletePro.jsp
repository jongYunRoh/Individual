<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header/header.jsp" %>
<%--deletePro.jsp --%>
<c:if test="${x==1}">
  <meta http-equiv="Refresh" content="0;url=${ctxpath}/board/list.do?pageNum=${pageNum}">
</c:if>

<c:if test="${x==-1}">
  <script>
  alert("암호틀림");
  history.back();
  </script>
</c:if>