<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<h1>${sessionScope.authUser.no}</h1>
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		<c:import url="/WEB-INF/views/includes/navigataion.jsp"></c:import>
		
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${vo.title }</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								${vo.content }
							</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="${pageContext.request.contextPath }/replyboard/list">글목록</a>
					<a href="${pageContext.request.contextPath }/replyboard/replyform?numb=${vo.numb}&hit=${vo.hit}&orderno=${vo.orderno}">댓글달기</a>
					<c:if test="${sessionScope.authUser.no==vo.user_num }">
						<a href="${pageContext.request.contextPath }/replyboard/modifyform?content=${vo.content }&numb=${vo.numb}&title=${vo.title}">글수정</a>
					</c:if>
				</div>
			</div>
		</div>

		<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
	</div>
</body>
</html>