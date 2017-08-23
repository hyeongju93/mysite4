<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath }/assets/css/guestbook.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.12.4.js"></script>
	<title>ajax-방명록</title>
</head>
<body>
<div id="container">
	

	<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
	<c:import url="/WEB-INF/views/includes/navigataion.jsp"></c:import>
	
	<div id="wrapper">
		<div id="content">
			<div id="guestbook">
				
					<form id="write-form" action="${pageContext.request.contextPath }/guestbook/add" method="post">
						<table border=1 width=500>
							<tr>
								<td>이름</td>
								<td><input id="name"type="text" name="name"></td>
								<td>비밀번호</td>
								<td><input id="password" type="password" name="password"></td>


							</tr>
							<tr>
								<td colspan=4><textarea id="content" name="content" cols=60 rows=5></textarea></td>
							</tr>
							<tr>
								<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
							</tr>
						</table>
						
					</form>
					
					
					
					
				<ul id="guestbook-list">
				
				
				</ul>
			</div>
			<!-- /user -->
		</div>
		<!-- /content -->
	</div>
	<!-- /wrapper -->

	
	<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
</div>
<!-- /container -->
</body>

<script type="text/javascript">	
$(document).ready(function(){
	//리스트 출력
	fetchList();
	
	//저장버튼 클릭
	$("#write-form").on("submit",function(){
		event.preventDefault(); 
		console.log("전송버튼클릭");
		var name=$("#name").val();
		var password=$("[name=password]").val();
		var content=$("[name=content]").val();
		
		var guestbookvo ={
			name : $("#name").val(),
			password : $("[name=password]").val(),
			content : $("[name=content]").val()
		}
		/*json방식  */
		$.ajax({	
			url : "${pageContext.request.contextPath }/api/gb/add",		
			type : "post",
			/*contentType : "application/json",*/
			contentType : "application/json",
			data : JSON.stringify(guestbookvo),
			/* data : guestbookvo,  */

		 	dataType : "json",
			success : function(guestbookvo){	//list-ajax에서 보낸 것을 guestbook으로 받음
				console.log("성공");
		 		console.log(guestbookvo);
		 		render(guestbookvo,"up");
			/*성공시 처리해야될 코드 작성*/
		 		
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
		
	});
	
});

function fetchList(){
	$.ajax({
		
		url : "${pageContext.request.contextPath }/api/gb/list",		
		type : "post",
		/* contentType : "application/json",	이 방식은 json으로 보낸다는 뜻
		data : {name: ”홍길동"}, */

	 	dataType : "json",
		success : function(guestbookList){	//list-ajax에서 보낸 것을 guestbook으로 받음
			for(var i=0;i<guestbookList.length;i++){
				render(guestbookList[i],"down");
			} 
			console.log(guestbookList);
	 		/*성공시 처리해야될 코드 작성*/
	 		
		},
		error : function(XHR, status, error) {
			console.error(status + " : " + error);
		}
	});
}

function render(guestbookvo,updown){
	var str ="";
	str+="<li>";
	str+="	<table>";
	str+="		<tr>";
	str+="			<td>["+guestbookvo.no+"]</td>";
	str+="			<td>["+guestbookvo.name+"]</td>";
	str+="			<td>["+guestbookvo.leg_date+"]</td>";
	str+="			<td><a href='#'>삭제<a/></td>";
	str+="		</tr>";
	str+="		<tr>";
	str+="			<td colspan=4>["+guestbookvo.content+"]</td>";
	str+="		</tr>";
	str+="		</tr>";
	str+="	</table>";
	str+="	<br/>";	
	str+="</li>";
	
	if(updown == "up"){
		$("#guestbook-list").prepend(str);	
	}else if(updown=="down"){
		$("#guestbook-list").append(str);	
	} else{
		
	}
	
}



	</script>	
</html>