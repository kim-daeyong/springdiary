<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>게시글 작성</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
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

<h1 style="text-align:center"> 일기 작성 </h1>
<form action="/write" method="post">
<div class="container table-bordered" style="padding-top: 15px;">
        <h2 id="time-result"></h2><br>
        <div class="form-group">
            <label for="nickname" >작성자 : </label>
            <label id ="nickname" value="${sessionScope.logininfo.nickname}">${sessionScope.logininfo.nickname}</label>
        </div>
        <div class="form-group">
            <label for="content">내용</label>
            <textarea class="form-control" rows="10" id="content" name="content"></textarea>
        </div>
        <button type="cancel" class="pull-right btn btn-default"><a href="/diarylist">취소</a></button>
        <button type="submit" class="pull-right btn btn-default">올리기</button>
</div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <script type="text/javascript">
        var d = new Date();
        var currentDate = d.getFullYear() + "년 " + ( d.getMonth() + 1 ) + "월 " + d.getDate() + "일";

        var result = document.getElementById("time-result");
        result.innerHTML = "오늘은 " + currentDate;
    </script>
</form>
</body>
</html>



