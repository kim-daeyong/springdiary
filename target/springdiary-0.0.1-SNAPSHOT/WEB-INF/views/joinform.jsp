<%--
  Created by IntelliJ IDEA.
  User: bigyo
  Date: 2019-05-05
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko" xmlns:padding="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원가입</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar"style="vertical-align: middle; margin-bottom: 0px">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/index">킴보드</a>
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

<div class="info" style = "text-align: center; vertical-align: middle">
    <h3> 회원 가입 </h3>

    <div class="board"></div>

    <form action="/join" method="post">

        <%--<fieldset id="sec">--%>
            <ul>
                <li><label class="email" for="email">이메일</label>
                    <input type="text" id="email" name="email" placeholder="이메일을 입력해주세요." required>
                </li>

                <li><label for="passwd" class="labelStyle">비밀번호</label>
                    <input type="password" name = "passwd" id="passwd" placeholder="8~12자입력해주세요."  maxLength="12" required />
                </li>

                <li><label for="repasswd" class="labelStyle">비밀번호 확인</label>
                    <input type="password" id="repasswd" name="repasswd" placeholder="8~12자입력해주세요."  maxLength="12" required /> &nbsp; <span id = "check" style="color:red;"></span>
                </li>

                <li><label class="userId" for="nickName">이름</label>
                    <input type="text" id="name" name = "name" placeholder="이름을 입력해주세요" autofocus required>
                </li>
                <li><label class="userId" for="nickName">닉네임</label>
                    <input type="text" id="nickname" name = "nickname" placeholder="닉네임을 입력해주세요" autofocus required>
                </li>


            </ul>
        </fieldset>

        <div class="bord"></div>

        <div class="bt">

            <div class="before button"><a href="#">이전 </a></div>
            <input type="submit" value="완료" id="btnjoin"/>

        </div>


    </form>
</div>
<script type="text/javascript">
    function tocheckpw() {
        var userpw = document.getElementById("passwd").value;
        var userrepw = document.getElementById("repasswd").value;
        if (userpw != userrepw) {
            document.getElementById('check').innerHTML = '비밀번호가 틀렸습니다. 다시 입력해 주세요';
            return false;
        }
    }
</script>


</body>
</html>
