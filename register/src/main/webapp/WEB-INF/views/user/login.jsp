<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 

<style>


* {padding:0; margin:0} 

header h1 {width:150px; text-align:left;}

nav  {display:inline-block;width:100px;padding:2px 5px 5px 5px; margin:5px;

  text-align:center; color:white; 
 } 
main {width:1200px; height:900px; box-sizing:border-box; margin:auto;}

.left-box {
  display: flex;
  height: 100vh;
    justify-content: center; 
    margin: 20px;
    top: 5%;
  
}
.right-box {
  display: flex;
    height: 100vh;
    justify-content: center; 
    margin: 20px;
    top: 5%;

}

footer {width:1200px; height:50px; background:#666; margin:auto; clear:both;}    /* 하단정렬 */

html, body {margin: 0; padding: 0;}

#header {
    border-top:7px solid #505559;
    margin:0 auto;
    width:1200px;
    background: #eee;
    height: 45px;
    padding: 20px 0;
    font: 12px arial, sans-serif;
}

#header h1 {
    margin-left: 30px; 
    float: left;
    width: 197px;
    height: 45px;
    background: url(http://dummyimage.com/197x45/fe63a5/000&text=LOGOPIC) no-repeat 0 0;
    text-indent: -9999px;
}

#header form {
    float: right; 
    margin-right: 30px; 
    height: 40px; 
    padding-top: 8px;
}

#header form label {
    display: inline-block; 
    margin: 0 2px;
  
}

#header form input {}

#header form #s-user, 
#header form #s-pass {
    display: block;
    width: 250px;
    border: 1px solid #eee;
    padding: 3px 0 3px 0;
    margin-bottom: -1px;
}

#header form .submit {
    height: 23px;
    vertical-align: bottom;
    background: #d743ae; 
    color: #fff;
    border: 1px solid #ddd;
    -moz-border-radius: 5px;    
    border-radius: 5px;
}
.layer {

    position: absolute;
    text-align:center;
    width: 600px;
    height: 100px;
    top: 0;
    bottom: 30%;
    left: 0;
    right: 0;
    margin: auto;
}
ul {
	list-style:none;
  margin-left: auto;
  margin-right: auto;
	display:table;
  padding: 30px;
}
ul li {
	float:left;
}
ul li a {
	float:left;
	padding:4px;
	margin-right:3px;
	width:15px;
	color:#000;
	font:bold 12px tahoma;
	border:1px solid #eee;
	text-align:center;
	text-decoration:none;
}
ul li a:hover, ul li a:focus {
	color:#fff;
	border:1px solid #f40;
	background-color:#f40;
}
table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    text-align: center;
    border-bottom: 1px solid #444444;
    padding: 10px;
  }

  button {
    width: 120px;
  height: 40px;
  background: #767676;
  color: #fff;
  border: 0;
  border-radius: 3px;
}
button:hover,
button:focus{
  background: #222;
  box-shadow: 0 0 5px blue;
}

.head{
  text-align:center;
}


</style>

<script type="text/javascript">

function loginValidation(){
	
	var userId = $("#loginuserId").val();
	var password = $("#loginpassword").val();
	
	if(!userId){
		alert("メールアドレスを入力してください。");
		$("#loginuserId").focus();
		return false;
	}else if(!password){
		alert("パスワードを入力してください。");
		$("#loginpassword").focus();
		return false;
	}else {
		login(loginuserId,loginpassword);
	}
	
}

function login(userId,password){
	
	$.ajax({
		
		url : "/jquery/login",
		type : 'POST',
		data : { userId : userId, 
				password : password	
		},
		success:function(data){
			if(data == 2){
				alert("메일 주소나 비밀번호가 틀립니다.");
				return false;
			}else if(data == 3){
				location.href="/view/dashboard";
			}
		}
		
	})
	
}

function enterKeyCheck(){
	
 if(event.keyCode == 13)
	  {
	 loginValidation();
	  }
	
	
}

function signUpValidation(){
	
	var userId = $("#userId").val();
	var userPw = $("#password").val();
	var userPwCheck = $("#passwordCheck").val();
	var nickName = $("#nickname").val();
	var email = $("#email").val();
	
	if(!userId){
		alert("메일주소를 입력해주세요");
		$("#userId").focus();
	}else if(!userPw){
		alert("비밀번호를 입력해주세요");
		$("#password").focus();
	}else if(!userPwCheck){
		alert("비밀번호를 재입력해주세요");
		$("#passwordCheck").focus();
	}else if(userPw != userPwCheck){
		alert("비밀번호가 다릅니다");
		$("#userPwCheck").focus();		
	}else if(!nickName){
		alert("닉네임을 입력해주세요");
		$("#nickname").focus();
	}else {
		signUp()
	}
	
}

function signUp(){
	
	$.ajax({
		
		url : "/jquery/signUp",
		type:'POST',
		data :  $("#registerform").serialize(),
		success:function(data){
			if(data == 1){
				alert("회원등록이 완료되었습니다");
				location.href = "/dashboard"
			}else if(data == 2){
				alert("이미 존재하는 메일 주소입니다.");
				return false;
			}else if(data == 3){
				alert("이미 존재하는 닉네임입니다.");
				return false;
			}
		}
		
	})
}

</script>

</head>
<body>

<header>
    
    <div id="header">
        <h1>Logo</h1>
        <form class="signUp" id="signupForm">
          <label>メールアドレス <input type="text" id="loginuserId" class="signUpInput" placeholder="ID" autofocus onkeyup="enterKeyCheck()"></label>
          <label>パスワード<input type="password" id="loginpassword" class="signUpInput" placeholder="Password" onkeyup="enterKeyCheck()"></label>
          <input type="button" onclick="loginValidation()" class="loginButton" value="ログイン">
        </form>
      </div>

</header>

<main>

    <div class='left-box' style="border: 1px solid red; float: left; width: 500px; padding:10px;">
        <form>
            <span class="nameLabel" style = " font-size:2.5em;">ㅁㅁㅁ</span><br>  
            <div class="left-content">
                <label for="content" class="left-content-label">ㅁㅁㅁㅁ</label>
            </div>
        </form>
    </div>
    
    <div class='right-box' style="border: 1px solid red; float: right; width: 300px; padding:10px;">

        <form id="registerform">
            
            <span class="nameLabel" style = " font-size:2em;">어카운트등록</span><br>  
            
                <div class="form-group">
                <label for="staticEmail" class="col-sm-2 col-form-label">메일주소</label>  
                <div class="formfield">
                    <input type="text" id="userId" name="userId" maxlength="20" placeholder="ex) email@email.com" required>
                </div><br>
                </div>
                
                <div class="form-group">
                <label for="staticName" class="col-sm-2 col-form-label">닉네임</label>
                <div class="col-sm-10">
                    <input type="text" id="nickname" name="nickname" maxlength="20" value="">
                </div><br>
                </div>
                
                <div class="form-group">
                <label for="staticPassword" class="col-sm-2 col-form-label">비밀번호</label>
                <div class="col-sm-10">
                    <input type="password" id="password" name="password" maxlength="20" autocomplete="off">
                </div><br>
                </div>
                
                <div class="form-group">
                <label for="staticRePassword" class="col-sm-2 col-form-label">비밀번호&nbsp; 재입력</label>
                <div class="col-sm-10">
                    <input type="password" id="passwordCheck" name="passwordCheck" maxlength="20" autocomplete="off">
                </div>
                </div><br> 
                         
                <div class="btnfield">
            <input type="button" onclick="signUpValidation()" value="회원등록">
      			</div>
            
        </form>
    </div>



</main>

<footer>

 <h3>footer</h3>
 <A HREF=index.html> "0" index page </A>

</footer>

</body>
</html>