<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
background-image:url(https://www.poscoict.com/images/main/main_visual2.jpg);
}
.vote-form{
   margin-top: 30px;
   align: center;
}
.vote-box{
   background-color: #ffffff;
   margin: 150px 1200px ;   
   width: 250px;
   height: 130px;
   border-radius: 20px;
   padding: 20px 40px 40px;
}
.vote-button{
   background-color: #ffffff;
   width: 200px;
   display: block;
   margin-left:10px; 
   margin-top:30px;
   height: 70px;
   line-height: 70px;
   border-radius: 80px;
   color: #0020f0;
   font-size: 16px;
   font-weight: 700;
}
</style>

</head>
<body>
<img src="https://biz.chosun.com/resizer/15rHyQGMpgxl4L6HePAMYYmZM9Y=/601x500/smart/cloudfront-ap-northeast-1.images.arcpublishing.com/chosunbiz/XM62ZAO6SQOLVNHOP4HQGFFBAU.jpg" width=100 height=100>
   <form method="post" action="loginJsp.jsp">
      <div class="vote-box">
         <ul class="vote-form">
            <li>
               <strong class="vote-guide">ID</strong>&ensp;&emsp;&emsp;&emsp;&emsp;
               <input type="text" name="id"/><br/><br/>
            </li>
            <li>
               <strong class="vote-guide">PASSWORD</strong>
               <input type="text" name="pwd"/><br/><br/>
            </li>
         </ul>
         <input class="vote-button" type="submit" value="로그인">
         <input class="vote-button" type="button" value="뒤로가기" onclick="history.back(-1);">
      </div>
   </form>
</body>
</html>