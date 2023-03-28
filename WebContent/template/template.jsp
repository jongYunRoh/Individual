<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header/header.jsp" %>
<%--template.jsp --%>

<html>
 <body bgcolor="#f8f8ff">
   <table>
     <tr>
       <td rowspan="2" width="10%">
       <!--  
         <a href="${ctxpath}/template/template.jsp"><font size=5><b>HOME</b></font></a>-->
         
         <a href="${ctxpath}/template/template.jsp"><img src="${ctxpath}/imgs/home.png"></a>
       </td>
       
       <td align="right">
         <jsp:include page="/module/top.jsp" flush="false"/><br>
       </td>
     </tr>
     
     <tr>
       <td align="right">
         <%@ include file="/member/main.jsp" %>
       </td>
     </tr>
     
     <tr>
       <td colspan="2" width="700" height="90%" valign="top" align="center">
         <c:if test="${CONTENT!=null}">
           <jsp:include page="${CONTENT}" flush="false"/>
         </c:if>
         
         <c:if test="${CONTENT==null}">
           <img src="${ctxpath}/imgs/back.png">
         </c:if>
       </td>
     </tr>
    
     <tr height="10%">
       <td width="700"  colspan="2" align="center">
        <br>
        <br>
         <jsp:include page="/module/bottom.jsp"/>
       </td>
     </tr>
   </table>
 </body>
</html>