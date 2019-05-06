<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko" xmlns:padding="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>연대기</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
<div class="container table-bordered" style="padding-top: 20px; width: 80%">
    <table class="table table-striped">
        <thead>
        <h1 style="text-align:center" >연대기</h1>


        </thead>
        <tbody>
        <c:forEach items="${requestScope.boards}" var="board">
            <tr>
                <td style ="text-align: center"><a href="/view?id=${board.id}">${board.regdate}</a><br><br>${board.content}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a class="btn pull-right btn-default" style = "text-align: right" href="/write">글쓰기</a>


        <ul class="pull-left pagination" style = "text-align: center">
            <li><a href="#">이전</a></li>
            <li class="active"><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#">다음</a></li>
    </ul>

</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>