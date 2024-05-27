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
<!-- admin이 아닌 계정으로 로그인을 했거나 로그인 상태가 아닐경우 보여질 메세지 -->
<c:if test="${sessionScope.loginok==null or sessionScope.loginid!='admin'}">
   <h2>
      <b>
         전체 회원 명단은 관리자만 확인 가능합니다
      </b>
   </h2>
</c:if>
<!-- admin 계정으로 로그인시에만 전체 명단을 확인 할 수 있다 -->
<c:if test="${sessionScope.loginok!=null and sessionScope.loginid=='admin'}">
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
               <img src="../save/${dto.photo}" style="border-radius : 50%;
               width:50px; height:50px; background-color:black;"
               onerror="this.src='../image/noimage1.png'">
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
</c:if>
</body>
</html>