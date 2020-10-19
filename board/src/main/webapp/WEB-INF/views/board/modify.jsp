<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>サイト登録修正</title>
<script type="text/javascript">
	function siteadd(){
		var siteaddForm = document.siteaddForm;
		var url = siteaddForm.url.value;
		var sitename = siteaddForm.sitename.value;
		var keyword = siteaddForm.keyword.value;

		if(!url || !sitename || !keyword){
				alert("空欄があります。全部入力してください。")
		}else{
			siteaddForm.submit();
		}
	}
</script>
</head>
<body>

<form name="siteaddForm" method="post">
<h1>サイト登録修正</h1>
<input type="hidden" id="USERID" name="USERID" value="${member.userId}">
<label>URL</label>
<input type="text" name="url" value="${view.url}" /><br />

<label>SITENAME</label>
<input type="text" name="sitename" value="${view.sitename}"/><br />

<label>keyword</label>
<input type="text" name="keyword" value="${view.keyword}"/><br />

<input type ="button" onclick="siteadd()" value="登録">

</form>


</body>
</html>