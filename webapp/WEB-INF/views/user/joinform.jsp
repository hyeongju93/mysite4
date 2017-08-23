<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
	<title>mysite</title>
</head>
<body>

	<div id="container">
		
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/navigataion.jsp"></c:import>
		
		<div id="wrapper">
			<div id="content">
				<div id="user">
	
					<form id="join-form" name="joinForm" method="post" action="${pageContext.request.contextPath }/user/join">
						
						<label class="block-label" for="name">이름</label>
						<input id="name" name="names" type="text" value="">
	
						<label class="block-label" for="email">이메일</label>
						<input id="email" name="email" type="text" value="">
						<input id="button" type="button" value="id 중복체크">
						<ul id="check">
						</ul>
						
						<label class="block-label">패스워드</label>
						<input name="passwords" type="password" value="">
						
						<fieldset>
							<legend>성별</legend>
							<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
							<label>남</label> <input type="radio" name="gender" value="male">
						</fieldset>
						
						<fieldset>
							<legend>약관동의</legend>
							<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
							<label>서비스 약관에 동의합니다.</label>
						</fieldset>
						
						<input type="submit" value="가입하기">
						
					</form>
					
				</div><!-- /user -->
			</div><!-- /content -->
		</div><!-- /wrapper -->
		
		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		
	</div> <!-- /container -->

</body>
<script type="text/javascript">	
$(document).ready(function(){
	
	//저장버튼 클릭
	$("#button").on("click",function(){
		
		console.log("전송버튼클릭");
		var email=$("#email").val();
		console.log(email);
		
		/*json방식  */
		 $.ajax({	
			url : "${pageContext.request.contextPath }/api/user/check",		
			type : "post",
			data : {email: email},  
		 	dataType : "json", 
			success : function(result){	//list-ajax에서 보낸 것을 guestbook으로 받음
				console.log("성공");
				console.log(name);
				render(result);
		 		
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		}); 
		
	});
	
});

function render(result){
	var zero ="";
	zero+="<li>";
	zero+="	<table>";
	zero+="		<tr>";
	zero+="			<td>사용이 가능합니다</td>";
	zero+="		</tr>";
	zero+="	</table>";
	zero+="	<br/>";	
	zero+="</li>";
	
	var one ="";
	one+="<li>";
	one+="	<table>";
	one+="		<tr>";
	one+="			<td>중복되는 이메일입니다.</td>";
	one+="		</tr>";
	one+="	</table>";
	one+="	<br/>";	
	one+="</li>";
	
	if(result==1){
		console.log("1");
		
		$("#check").html(one);	
	}else if(result==0){
		console.log("0");

		$("#check").html(zero);	
	} else {
	}
	
	
}




</script>
</html>