<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>상세보기</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar"style="vertical-align: middle; margin-bottom: 0px">
    <div class="container-fluid">
        <div class="navbar-header">
            <c:if test ="${sessionScope.logininfo == null}">
                <a class="navbar-brand" href="/index">킴보드</a>
            </c:if>
            <c:if test ="${sessionScope.logininfo != null}">
                <a class="navbar-brand" href="/welcome">킴보드</a>
            </c:if>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/calendar">다이어리</a></li>
            <li><a href="/diarylist">연대기</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test ="${sessionScope.logininfo == null}">
                <li><a href="/joinform"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="/loginform"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </c:if>
            <c:if test ="${sessionScope.logininfo != null}">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span>${sessionScope.logininfo.nickname}</a></li>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
            </c:if>
        </ul>
        <form class="navbar-form navbar-left" action="/action_page.php">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="전체검색" name="search">
            </div>
            <button type="submit" class="btn btn-default">찾기</button>
        </form>
    </div>
</nav>

<div class="container table-bordered" style="padding-top: 15px;">
    <h2>${board.regdate}</h2><br>

    <div class="form-group">
        <label for="nickname" >작성자 : </label>
        <label id ="nickname" value="${sessionScope.logininfo.nickname}">${sessionScope.logininfo.nickname}</label>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">내용</h3>
        </div>
        <div class="panel-body">
            ${board.content}
        </div>
    </div>
    <button type="cancel" class="pull-right btn btn-default"><a href="/diarylist">목록</a></button>
    <button type="submit" class="pull-right btn btn-default"><a href="/modify?id=${board.id}">수정</a></button>
    <%--<button type="button" class="pull-right btn btn-default" id="deletebutton">모달삭제</button>--%>
    <button type="button" class="btn btn-default"><a href="/delete?id=${board.id}">삭제</a></button>

    <!-- Modal  -->
    <div class="modal fade" id="delete" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Real True Delete?</h4>
                </div>
                <div class="modal-body">
                    </form>
                    <div class="form-group">
                        <label>정말로 삭제 하시겠습니까?</label>

                    </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default"><a href="/delete?id=${board.id}">확인</a></button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>

        </div>
    </div>

</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script>
$(function() {

$("#delete").dialog({
autoOpen: false,
modal: true
});

$("#deletebutton").on("click", function(e) {
e.preventDefault();
$("#delete").dialog("open");
});

});
</script>
</body>
</html>