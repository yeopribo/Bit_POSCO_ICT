<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>

<script src="//code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function f1(){
		$.ajax( {
			url:"http://localhost:8081/t1",
			type:"GET"
		} ).then( function(data){
			console.log(data.factorA);
			console.log(data.factorB);
			let s1 = document.getElementById("span1");
			let s2 = document.getElementById("span2");
			s1.textContent = data.factorA;
			s2.textContent = data.factorB;
		} );
	}
	function f2(){
		// ���Ѽ� 2��
		let a = $("#span1").text();
		let b = $("#span2").text();
		console.log(a,b);
		
		// �г���
		let alias4 = $('input[name=alias]').val();
		console.log(alias4);
		
		// ���
		let attempt4 = $('input[name=attempt]').val();
		console.log(attempt4);
		
		let formData = { 
			user:{alias:alias4},
			multiplication:{factorA:a, factorB:b},
			resultAttempt:attempt4,
		};
		
		console.log(formData);
		console.log(typeof formData);
		
		// user
		// multiplication
		// resultAttempt
		let temp = JSON.stringify(formData);
		console.log(temp);
		console.log(typeof temp);
		
		$.ajax( {
			url:"http://localhost:8081/t2",
			type:"POST",
			data:JSON.stringify(formData),
			datatype:"json",
			contentType:"application/json"
		} ).then( function(data){
			console.log(data);
			let s3 = document.getElementById("span3");
			console.log(typeof s3);
			s3.textContent = data;
		} );
	}
	function f3(){
		// ���Ѽ� 2��
		let a = $("#span1").text();
		let b = $("#span2").text();
		console.log(a,b);
		
		// �г���
		let alias4 = $('input[name=alias]').val();
		console.log(alias4);
		
		// ���
		let attempt4 = $('input[name=attempt]').val();
		console.log(attempt4);
		
		let formData = { 
			user:{alias:alias4},
			multiplication:{factorA:a, factorB:b},
			resultAttempt:attempt4,
		};
		
		console.log(formData);
		console.log(typeof formData);
		
		// user
		// multiplication
		// resultAttempt
		let temp = JSON.stringify(formData);
		console.log(temp);
		console.log(typeof temp);
		
		$.ajax( {
			url:"http://localhost:8081/t3",
			type:"POST",
			data:JSON.stringify(formData),
			datatype:"json",
			contentType:"application/json"
		} ).then( function(data){
			console.log(data);
			let s3 = document.getElementById("span3");
			console.log(typeof s3);
			s3.textContent = data;
		} );
	}
	
</script>

<body>
	<h1>index</h1>
	<a href="t1">�⺻ ��Ʈ�ѷ� Ȯ��</a><br/>
	<button onClick="f1()">���� ��û</button><br/>
	<span id="span1"></span> *
	<span id="span2"></span> = ?
	
	<form id="form1" name="form1" method="post">
		��Ī : <input type="text" name="alias" value="tiger"/><br/>
		���� : <input type="text" name="attempt" value="200"/><br/>
		<input type="button" value="����" onclick="f2()"/>
		<input type="button" value="�䳢" onclick="f3()"/>
	</form>
	
	<span id="span3"></span>
</body>
</html>