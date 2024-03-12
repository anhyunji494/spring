<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	pageContext.setAttribute("ln", "\n");
	%>
	<div class="container">
		<h2>Spring version 1.</h2>
		<div class="panel panel-default">
			<div class="panel-heading">Board</div>
			<div class="panel-body">
				<table class="table">
					<tbody>
						<tr>
							<td>제목</td>
							<td>${vo.title}</td>
						</tr>
						<tr>
							<td>내용</td>
							<td>${fn:replace(vo.content, ln, "<br>")}</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td>${vo.writer}</td>
						</tr>
						<tr>
							<td>작성일</td>
							<td>${fn:split(vo.indate," ")[0]}</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<a href="boardUpdateForm.do?idx=${vo.idx}" class="btn btn-info">수정화면</a>
								<a href="boardDelete.do?idx=${vo.idx}" class="btn btn-danger">삭제화면</a>
								<a href="boardList.do" class="btn btn-warning">목록</a>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="panel-footer">스프링게시판 - 박병관</div>
		</div>
	</div>

</body>
</html>
