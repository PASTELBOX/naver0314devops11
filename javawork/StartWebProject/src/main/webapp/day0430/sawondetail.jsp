<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SawonDto"%>
<%@page import="data.dao.SawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        
        
        
        td>h5 {
        	height : 50px;
        	margin-left:20px;
        	margin-top:5px;
        }
        
        button {
        	margin:10px 5px;
        	width:100px;
        	height:40px;
        }
        
    </style>

</head>
<%
	int num=Integer.parseInt(request.getParameter("num"));

	SawonDao dao=new SawonDao();
	
	SawonDto dto=dao.getData(num);
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
%>
<body>
	<div style="margin :10px;width : 500px; text-align:center; border:5px solid black">
		<h2>
			<b><%=dto.getName() %> 사원</b>
		</h2>
		<table style="border-top:5px solid black;width:490px;">
			<tr>
				<td>
					<img src='<%=dto.getPhoto().equals("no")?"../image/noimage1.png":dto.getPhoto() %>' style="width:300px;">
				</td>
				<td>
					<h5>사원명 : <%=dto.getName() %></h5>
					<h5>주 소 : <%=dto.getAddr() %></h5>
					<h5>나 이 : <%=dto.getAge() %></h5>
					<h5>입사일 : <%=dto.getBirthday() %></h5>
					<h5>부서명 : <%=dto.getBuseo() %></h5>
					<h5>성 별 : <%=dto.getGender() %></h5>
				</td>
			</tr>
			<tr class="detail-button" style="border-top:5px solid black">
				<td colspan="2" align="center">
				
				<button type="button" class="btn btn-sm btn-warning"
				onclick="location.href='sawonform.jsp'">사원추가</button>
				
				<button type="button" class="btn btn-sm btn-warning"
				onclick="location.href='sawonlist.jsp'">사원목록</button>
				
				<button type="button" class="btn btn-sm btn-warning"
				onclick="location.href='sawonupdateform.jsp?num=<%=dto.getNum()%>'">정보수정</button>
				
				<button type="button" class="btn btn-sm btn-warning" id="delsawon"
				num="<%=dto.getNum() %>" sawonname="<%=dto.getName() %>">사원삭제</button>
			
			</td>
			</tr>
		</table>
	</div>
<script type="text/javascript">
$("#delsawon").click(function(){
	let num=$(this).attr("num");
	let sawonname=$(this).attr("sawonname");
	let a=confirm(`\${sawonname} 사원정보를 삭제할까요?`);
	if(a){
		location.href="sawondelete.jsp?num="+num;
	}
});
</script>
</body>
</html>