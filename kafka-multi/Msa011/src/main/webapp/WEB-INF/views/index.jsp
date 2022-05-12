<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<script src="//code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript">
   let getQuestion = false;
   
   function f1() {
	   
      $.ajax({
         url : "http://54.180.120.214:8080/msa011/t1",
         // url : "http://localhost:8081/t1",
         type : "GET"
      }).then(function(data) {
         console.log(data.factorA);
         console.log(data.factorB);
         let s1 = document.getElementById("span1");
         let s2 = document.getElementById("span2");
         s1.textContent = data.factorA;
         s2.textContent = data.factorB;
         getQuestion = true;
      });
   }
   
   function f3() {
	   
      // 곱한수 2개
      let a = $("#span1").text();
      let b = $("#span2").text();
      console.log(a, b);

      // 닉네임
      let alias4 = $('input[name=alias]').val();
      console.log(alias4);

      // 답안
      let attempt4 = $('input[name=attempt]').val();
      console.log(attempt4);

      if (alias4 != "" && attempt4 != 0 && getQuestion == true) {
         let formData = {
            user : {
               alias : alias4
            },
            multiplication : {
               factorA : a,
               factorB : b
            },
            resultAttempt : attempt4,
         };

         console.log(formData);
         console.log(typeof formData);

         let temp = JSON.stringify(formData);
         console.log(temp);
         console.log(typeof temp);

         $.ajax({
            url : "http://54.180.120.214:8080/msa011/t3",
            type : "POST",
            data : JSON.stringify(formData),
            datatype : "json",
            contentType : "application/json"
         }).then(function(data) {
            console.log(data);
            let s3 = document.getElementById("span3");
            console.log(typeof s3);
            s3.textContent = data;
            getQuestion = false;
         });

      } else {
          if (getQuestion == false) {
            alert("문제를 요청해주세요")
         }
         if (alias4 == "") {
            alert("애칭을 입력해주세요");
         }
         if (attempt4 == 0) {
            alert("정답을 입력해주세요")
         }
      }

   }
   
</script>

<body style="text-align: center;">
   <h1>문제풀기</h1>
   <button onClick="f1()">문제 요청</button>
   <br />
   <span id="span1"></span> *
   <span id="span2"></span> = ?

   <form id="form1" name="form1" method="post">
      	 애칭 : <input type="text" name="alias" placeholder="닉네임을 입력해주세요." required /> <br />
         정답 : <input type="text" name="attempt" placeholder="정답을 입력해주세요." required /> <br />
         <input type="button" value="제출" onclick="f3()" />
   </form>
   <span id="span3"></span>
</body>
</html>