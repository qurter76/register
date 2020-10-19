<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
	li {list-style: none; display:inline; padding: 6px;}
</style>

<ul> 
<div>
<a class="click" onclick="location='/board/list?USERID=${member.userId}'">
${member.userId}[${member.userName}]</a>

</div>
 <li>
  <a href="/board/list">クローリングページへ</a> 
 </li>
 
 <li>
 
  <a href="/board/write">サイト登録</a> 
 </li> 
</ul>
