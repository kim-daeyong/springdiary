<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko" xmlns:padding="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>일기장</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style type="text/css">
        /*#container{width:100%;*zoom:1;text-align:center;}*/
        /*#container:after {content:" "; display:block; clear:both;}*/
        #left{float:left;}
        #top{float:top;}
        #bottom{float:bottom;}
        #right{floay:right;display:inline-block;}
    </style>


    <script src="https://cdn.jsdelivr.net/npm/pikaday/pikaday.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/pikaday/css/pikaday.css">

</head>
<body>
<nav class="navbar navbar" style="vertical-align: middle; margin-bottom: 0px">
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



<div id="container">

    <div id="left" style="width: 40%; text-align: right;">
        <div id="top" style="text-align: center">
            <h1>test</h1>
            <input type="text" id="datepicker">
        </div>
        <div id="bottom">
            <table class="table table-striped">
                <thead>
                <h1 style="text-align:center" >리스트</h1>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.boards}" var="board">
                    <tr>
                        <td style ="text-align: center"><a href="/view?id=${board.id}">${board.regdate}</a></td>
                        <td style ="text-align: center"><a href="/view?id=${board.id}">${board.content}</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div id="right" style="width: 60%; text-align: left">
        <form action="/modify" method="post" style="width: 90%;">
            <h1 style="text-align:center">${board.regdate}</h1>
            <div class="container table-bordered" style="padding-top: 15px; width: 90%;">
                <h2>${board.regdate}</h2><br>
                <div class="form-group">
                    <input type="hidden"  id="id" name="id" value = "${board.id}"/>
                    <label >작성자 : </label>
                    <label>${sessionScope.logininfo.nickname}</label>
                </div>
                <div class="form-group">
                    <label for="content">내용</label>
                    <textarea class="form-control" rows="10" id="content" name="content">${board.content}</textarea>
                </div>
                <button type="cancel" class="pull-right btn btn-default"><a href="/freeboard">취소</a></button>
                <button type="submit" class="pull-right btn btn-default">올리기</button>
            </div>
        </form>

    </div>

</div>



<%--<div class="container table-bordered" style="padding-top: 20px;">--%>
    <%--<table class="table table-striped">--%>
        <%--<thead>--%>
        <%--<h1 style="text-align:center" >일기장</h1>--%>
        <%--<h1> </h1>--%>
        <%--<tr>--%>
            <%--<th scope="col" width="100">번호</th>--%>
            <%--<th scope="col" width="150">작성자</th>--%>
            <%--<th scope="col" width="150">날짜</th>--%>
        <%--</tr>--%>

        <%--</thead>--%>
        <%--<tbody>--%>
        <%--<c:forEach items="${requestScope.boards}" var="board">--%>
            <%--<tr>--%>
                <%--<th scope="row">${board.id}</th>--%>
                <%--<td>${board.nickname}</td>--%>
                <%--<td>${board.regdate}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        <%--</tbody>--%>
    <%--</table>--%>

    <%--<a class="btn pull-right btn-default"  href="/write">글쓰기</a>--%>

    <%--<div class="col-xs-4">--%>
        <%--<div class="input-group">--%>
            <%--<input class="form-control" placeholder="검색" />--%>
            <%--<span class="input-group-addon">찾기</span>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--<ul class="pull-left pagination">--%>
        <%--<li><a href="#">이전</a></li>--%>
        <%--<li class="active"><a href="#">1</a></li>--%>
        <%--<li><a href="#">2</a></li>--%>
        <%--<li><a href="#">3</a></li>--%>
        <%--<li><a href="#">4</a></li>--%>
        <%--<li><a href="#">5</a></li>--%>
        <%--<li><a href="#">다음</a></li>--%>
    <%--</ul>--%>

<%--</div>--%>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


<script src="pikaday.js"></script>
<script>
    var picker = new Pikaday({ field: document.getElementById('datepicker') });

</script>
</body>
</html>


<%--<c:if test ="${sessionScope.logininfo == null}">--%>
    <%--<a class="navbar-brand" href="/index">킴보드</a>--%>
<%--</c:if>--%>
<%--<c:if test ="${sessionScope.logininfo != null}">--%>
    <%--<a class="navbar-brand" href="/welcome">킴보드</a>--%>
<%--</c:if>--%>