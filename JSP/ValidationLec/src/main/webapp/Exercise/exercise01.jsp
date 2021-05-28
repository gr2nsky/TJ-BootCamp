<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function validationCheck(){
		var form = document.exerciseLogin;
		//id check
		var idPattern = /^[A-Za-z]{1}[A-Za-z0-9]{3,19}$/;
		var id = form.userID.value;
		//password check
		var passwordPattern = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
		var pw = form.userPW.value;
		//phoneNo check
 		var phonePattern = /^\d{3}-\d{3,4}-\d{4}$/;
		var phoneNo = form.phone1.value + "-" + form.phone2.value + "-" + form.phone3.value;
		//email check
		var emailPattern= /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var email = form.email.value;
		
		if(!check(idPattern, id, "아이디는 4~12자의 영문 대소문자와 숫자로만 입력")) {
			return false;
		}
		if(!check(passwordPattern, pw, "비밀번호는 8~15자리의 영문, 숫자, 특수문자로 조합해야 합니다.")) {
			return false;
		}
		if(!check(phonePattern, phoneNo, "유효하지 않은 핸드폰 번호입니다.")) {
			return false;
		} 
		//name check
 		if(form.name.value == "" || form.name.value.length < 2){
			alert("유효하지 않은 이름입니다. 두글자이상 입력해주세요.");
			form.name.focus();
			return false;
		}
		if(!check(emailPattern, email, "유효하지 않은 이메일 주소입니다.")) {
			return false;
		}
		form.submit(); 
	}
	
	function check(pattern, taget, message) {
		if(pattern.test(taget)) {
	    	return true;
	    }
	    alert(message);
	    taget.focus();
	}
	
</script>
<body>
<h2> 회원가입 </h2>
	<form name="exerciseLogin" action="exercise01_process.jsp" method="post" >
		아이디 <input type="text" name="userID" maxlength="12">
		<br>
		비밀번호 <input type="password" name="userPW" maxlength="15">
		<br>
		이름 <input type="text" name="name">
		<br>
		연락처
		<select name="phone1">
			<option value="010"> 010
			<option value="011"> 011
			<option value="018"> 018
		</select>
		<input type="text" name="phone2" size="4" maxlength="4">
		<input type="text" name="phone3" size="4" maxlength="4">
		<br>
		이메일 <input type="text" name="email">
		<br>
		<br>
		<input type="button" value="가입하기" onclick="validationCheck()">
	</form>

</body>
</html>