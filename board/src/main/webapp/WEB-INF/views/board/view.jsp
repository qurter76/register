<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>サイト登録 確認</title>
</head>
<body>

<form method="post">
<h1>サイト登録</h1>
<input type="hidden" id="USERID" name="USERID" value="${member.userId}">
<label>URL</label>
${view.url}<br />

<label>SITENAME</label>
${view.sitename}<br />

<label>keyword</label>
${view.keyword}<br />

<!-- <button type="submit">登録</button>  -->

</form>
<div>
<a href="/board/modify?USERID=${view.USERID}">修正</a>
</div>


</body>
</html>