<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
   <style>
       body *{
           font-family: 'Jua';
       }
       
       .table {
       	width : 500px;
       	text-align : center;
       }
       
       .member_list-body {
       	vertical-align : middle;
       }
   </style>
</head>
<body>
	<h2 class="alert alert-danger" style="width:500px;">
		총 ${totalCount}명의 회원이 있습니다
		<span style="float:right;">
			<button type="button" class="btn btn-sm btn-success"
			onclick="location.href='./form'">멤버등록</button>
		</span>
	</h2>
	<form action="./detail" method="post">
		<table class="table table-bordered">
			<tr class="table-primary">
				<td colspan="5">
					회원명단
				</td>
			</tr>
			<tr class="table-primary">
				<td>
					번호
				</td>
				<td>
					회원명
				</td>
				<td>
					아이디
				</td>
				<td>
					핸드폰
				</td>
				<td>
					상세보기
				</td>
			</tr>
			<c:forEach var="dto" items="${list}">
				<tr class="member_list-body">
					<td>
						${dto.num}
					</td>
					<td>
						<img src="../image/${dto.photo}" style="border-radius : 50%; width:50px; height:50px; background-color:black;">
						${dto.name}
					</td>
					<td>
						${dto.myid}
					</td>
					<td>
						${dto.hp}
					</td>
					<td>
						<button type="button" class="btn btn-sm btn-success"
						onclick="location.href='./detail?num=${dto.num}'">Detail</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>