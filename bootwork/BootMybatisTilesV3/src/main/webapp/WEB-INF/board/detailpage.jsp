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
        .comment_text textarea {
            width: 90%;
            height: 100px;
        }
        #btnansweradd {

        }
    </style>
    <script type="text/javascript">
        $(function(){
            //처음 로딩시 댓글 목록 출력
            answer_list();

            //댓글 추가 버튼
            $("#btnansweradd").click(function(){
                let num=${dto.num};
                let content=$("#acontent").val();
                if(content==''){
                    alert("댓글을 입력후 등록해주세요");
                    return;
                }

                $.ajax({
                    type:'post',
                    dataType:'text',
                    url:"./ainsert",
                    data:{"num":num,"content":content},
                    success:function(){
                        //댓글 목록 다시 출력
                        answer_list();
                        //초기화
                        $("#acontent").val("");
                    }
                });
            });

            //댓글 삭제 이벤트
            $(document).on("click",".adel",function (){
               let aidx=$(this).attr("aidx");
               let a=confirm("해당 댓글을 삭제할까요?");
               if(a){
                   $.ajax({
                     type:"get",
                     dataType:"text",
                     data:{"aidx":aidx},
                     url:"./adelete",
                     success:function (){
                         //댓글을 삭제 후 목록 다시 출력
                         answer_list();
                     }
                   })
               }
            });
        });

        function answer_list(){
            let num=${dto.num};
            //로그인중인지 로그인중일경우 로그인 아이디 얻기
            let loginok='${sessionScope.loginok}';
            let loginid='${sessionScope.loginid}';
            console.log(loginok+","+loginid);

            $.ajax({
                type:"get",
                dataType:"json",
                data:{"num":num},
                url:"./alist",
                success:function(data){
                    //댓글 갯수 출력
                    $(".answercount").text(data.length);
                    //목록 출력
                    let s="";
                    $.each(data,function(idx,ele){
                        s+=
                            `
					  \${ele.writer}(\${ele.myid})
					  <span class="aday">\${ele.writeday}</span>
                       `;

                        //로그인중이면서 댓글 아이디와 로그인 아이디가 같을 경우 삭제 아이콘 추가
                        if(loginok=='yes' && loginid==ele.myid)
                        {
                            s+=
                                `
                                <i class="bi bi-trash adel" aidx="\${ele.aidx}" style="cursor:pointer;"></i>
                                `
                        }

                        s+=`
					  <br>
					  <pre class="adata">\${ele.content}</pre>
					  <br>
					  `;
                    });
                    $(".answerlist").html(s);
                }
            })
        }
    </script>
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
                            조회 &nbsp;${dto.readcount}
                        </span>
                </div>
            </div>
            <div class="article_tool">
                <i class="bi bi-chat-dots-fill"></i>
                &nbsp;
                댓글 <span class="answercount">0</span>
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
        <div class="answerlist"></div>
    </div>
    <footer class="comment_container" style="padding: 20px;">
        <c:if test="${sessionScope.loginok!=null}">
            <div class="comment_text">
                <b>댓글</b><br>
                <textarea id="acontent" placeholder="댓글을 남겨보세요"></textarea>
                <button type="button" id="btnansweradd">등록</button>
            </div>
        </c:if>
    </footer>
</div>
<div class="article_button">
    <button type="button" onclick="location.href='./form'"><i class="bi bi-pencil-fill"></i>글쓰기</button>
    <button type="button" onclick="location.href='./form?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">
        답글</button>
    <!-- 수정,삭제는 로그인중이며 자기가 쓴글에만 나타나게 하기 -->
    <c:if test="${sessionScope.loginok!=null and sessionScope.loginid==dto.myid}">
        <button type="button" onclick="location.href='./updateform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
        <button type="button" onclick="del()">삭제</button>
    </c:if>
    <button type="button" onclick="location.href='./list?currentPage=${currentPage}'">목록</button>
</div>
<script>
    function del()
    {
        let num=${dto.num};
        let currentPage=${currentPage};

        let a=confirm("정말 삭제하시겠습니까?");
        if(a){
            location.href="./delete?num="+num+"&currentPage="+currentPage;

        }
    }
</script>
</body>
</html>