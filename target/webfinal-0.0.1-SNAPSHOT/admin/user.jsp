<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin</title>
<base href="/webfinal/">
<link rel="stylesheet" href="/webfinal/assets/css/style.css">

</head>
<body>
<div style="display:flex; justify-content: space-around">
	<div style="line-height: 70px; font-size: 50px" class="header">User</div>
	<a style="line-height: 70px; font-size: 50px" href ="/webfinal/SanphamController">Product</a>
	<a style="line-height: 70px; font-size: 50px" href ="/webfinal/OrderController">Orders</a>
	</div>
	<div class="info">
		<form action="UserControllerServlet" method="post">
			<div class="form-field-wrap">
				<div class="form-field">
					<input type="text" name="diachi" id="diachi" 
						class="form-input" placeholder=" "> <label for="diachi"
						class="form-label">Address</label>
				</div>
				<div class="form-field">
					<input type="text" name="userName" id="userName"
						value="${user.userName}" class="form-input" placeholder=" ">
					<label for="userName" class="form-label">User Name</label>
				</div>
				<div class="form-field">
					<input type="text" name="hoten" id="hoten" 
						class="form-input" placeholder=" "> <label for="hoten"
						class="form-label">Full Name</label>
				</div>
			</div>
			<div class="form-field-wrap">
				
				<div class="form-field">
					<input type="text" name="sdt" id="sdt" 
						class="form-input" placeholder=" "> <label for="sdt"
						class="form-label">Phone Number</label>
				</div>
				<div class="form-field">
					<input type="text" name="password" id="password"
						value="${user.password}" class="form-input" placeholder=" ">
					<label for="password" class="form-label">Password</label>
				</div>
				<button type="submit" formaction="./UserControllerServlet/create"
				class="form-btn-product">Add User</button>
			</div>
			
		</form>
		<table class="styled-table" style="width: 100%">
			<tr>
				<th style="width: 15%">UserName</th>
				<th style="width: 15%">Full Name</th>
				<th style="width: 25%">Address</th>
				<th style="width: 10%">Phone</th>
				<th style="width: 15%">Password</th>
				<th></th>
				<th style="width: 15%"></th>
				<th style="width: 15%"></th>
			</tr>
			<c:forEach var="listuser" items="${listuser}">

				<tr>
					<td>${listuser.userName}</td>
					<td>${listuser.hoten}</td>
					<td>${listuser.diachi}</td>
					<td>${listuser.sdt}</td>
					<td>${listuser.password}</td>
					<td>
						<a href="UserControllerServlet/delete?userName=${listuser.userName}">Delete</a>
					</td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>
