<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">
    <link href="https://fonts.googleapis.com/css2?family=Caveat:wght@400..700&family=Dancing+Script:wght@400..700&family=East+Sea+Dokdo&family=Jua&family=Gaegu&family=Gamja+Flower&family=Pacifico&family=Single+Day&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body * {
            font-family: 'Jua';
        }
        .title_text {
            font-size: 26px;
            font-weight: 400;
        }

        .detail_container {
            display: flex;
            flex-direction: column;
            border: 2px solid #ebecef;
        }

        .profile_image {
            float: left;
        }
        .profile_area {
            float: left;
        }
        .article_tool {
            float: right;
        }
        .article_header {
            padding: 20px;
        }
        .article_main {
            display: block;
            margin-top: 40px;
            padding: 20px;
        }
        .article_button {
            padding-top: 14px;
        }
        .comment_text {
            border: 2px solid #ebecef;
            width: 100%;
            height: 80px;
        }
        .comment_text textarea {
            width: 100%;
            height: 80px;
           vertical-align: center;
        }
    </style>
</head>
<body>
    <div class="detail_container">
        <header class="article_header">
            <div class="article_title">
                <h3 class="title_text">
                    ${dto.subject}
                </h3>
            </div>
            <div class="writer_info">
                <div class="profile_image">
                    <img src="../save/${profile_photo}" style="border-radius : 50%;
               width:50px; height:50px; background-color:black;"
                         onerror="this.src='../image/noimage1.png'">
                </div>
                <div class="profile_area" style="padding-left: 10px;">
                    <div class="profile_info" style="font-size: 15px;">
                        ${dto.writer}
                    </div>
                    <div class="article_info" style="font-size: 12px;color: lightgray">
                    <span>
                        <fmt:formatDate value="${dto.writeday}" pattern="yyyy.MM.dd"/>
                    </span>
                        <span>
                            ${dto.readcount}
                        </span>
                    </div>
                </div>
                <div class="article_tool">
                    <i class="bi bi-chat-dots-fill"></i>
                    댓글 0
                </div>
            </div>
        </header>
        <div class="article_main">
            <c:if test="${dto.uploadphoto!='no'}">
                <img src="../save/${dto.uploadphoto}"
                     onerror="this.src='../image/noimage2.png'"
                     style="max-width: 300px;">
                <br><br>
            </c:if>
            <pre style="font-size: 17px;">${dto.content}</pre>
        </div>
        <footer class="comment_container" style="padding: 20px;">
            댓글
            <div class="comment_text">
                <textarea placeholder="댓글을 남겨보세요"></textarea>
            </div>
        </footer>
    </div>
    <div class="article_button">
        <button type="button" onclick="location.href='./form'"><i class="bi bi-pencil-fill"></i>글쓰기</button>
        <button type="button" onclick="location.href='./form?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">
            답글</button>
        <!-- 수정,삭제는 로그인중이며 자기가 쓴글에만 나타나게 하기 -->
        <c:if test="${sessionScope.loginok!=null and sessionScope.loginid==dto.myid}">
            <button type="button" onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
            <button type="button" onclick="location.href='./deleteform?num-${dto.num}&currentPage=${currentPage}'">삭제</button>
        </c:if>
        <button type="button" onclick="location.href='./list?currentPage=${currentPage}'">목록</button>
    </div>
<script>
    function del()
    {
        let num=#{dto.num};
        let currentPage=#{currentPage};
        let a=confirm("정말 삭제하시겠습니까?");
        if(a){
            location.href="./delete?num="+num+"&currentPage="+currentPage;

        }
    }
</script>
</body>
</html>