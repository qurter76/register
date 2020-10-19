<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<title>クローリング</title>
</head>
<script type="text/javascript">

</script>
<body>
	<div class="container">
<h1>クローリング</h1>
		<c:if test="${member != null }">
			<div>
				<p>${member.userId}様お帰りなさい。</p>

			</div>
		</c:if>
<div id="nav">
 <%@ include file="../include/nav.jsp" %>
</div>
<section id="container">

	<table class="table table-hover">
	 <thead>
<c:forEach items="${list}" var="list">
<c:if test="${sessionScope.userId == member.userId}">
 <tr>
  <td>URL : ${list.url}</td>
  <td>SITE NAME : ${list.sitename}</td>
  <td>KEYWORD : ${list.keyword}</td>
  <td><a href="/board/view?USERID=${member.userId}">修正</a></td>
 </tr>
 </c:if>
</c:forEach>
	 </thead>
	 
	 <tbody>
	  
	 </tbody>
	
	</table>
	</section>
	</div>
</body>
</html>