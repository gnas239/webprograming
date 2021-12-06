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
<link rel="stylesheet" href = "../assets/css/style.css">
<link rel="stylesheet" href = "./assets/css/style.css">
<base href="/">
</head>
<body>
    <div class ="header">
		<a href="index.jsp" id="home-page-link">NSQUNIQUE</a>
		<a href ="<c:url value = "/OrderController"/>">Order</a>
		<a href ="<c:url value = "/SanphamController"/>">Product</a>
		<a href ="<c:url value ="/UserControllerServlet"/>">User</a>
	</div>
	<div class="info">
		<form action="SanphamController" method="post">
			<div class="form-field-wrap">
				<div class="form-field">
					<input type="text" name="maSP" id="maSP" 
						class="form-input" placeholder=" "> <label for="maSP"
						class="form-label">Mã SP</label>
				</div>
				<div class="form-field">
					<input type="text" name="tenSP" id="tenSP" 
						class="form-input" placeholder=" "> <label for="tenSP"
						class="form-label">Tên SP</label>
				</div>
				<div class="form-field">
					<input type="text" name="giaSP" id="giaSP"
						class="form-input" placeholder=" "> <label for="giaSP"
						class="form-label">Giá SP</label>
				</div>
			</div>
			<div class="form-field-wrap">
				<div class="form-field">
					<input type="text" name="soluong" id="soluong"
						value="${user.soluong}" class="form-input" placeholder=" ">
					<label for="soluong" class="form-label">Số Lượng</label>
				</div>
				<div class="form-field">
					<input type="text" name="hinhSP" id="hinhSP"
						value="${user.soluong}" class="form-input" placeholder=" ">
					<label for="hinhSP" class="form-label">Link Hình</label>
				</div>
				<button type="submit" formaction="./SanphamController/create"
					class="form-btn-product">Thêm Sản Phẩm</button>
			</div>
			<table class="styled-table">
				<tr>
					<th style="width: 10%">Mã SP</th>
					<th style="width: 50%">Tên sản phẩm</th>
					<th style="width: 15%">Giá</th>
					<th style="width: 10%">Số lượng</th>
					<th style="width: 15%"></th>
				</tr>
				<c:forEach var="listsanpham" items="${listsanpham}">
					<tr>
						<td>${listsanpham.maSP}</td>
						<td>${listsanpham.tenSP}</td>
						<td>${listsanpham.giaSP}</td>
						<td>${listsanpham.soluong}</td>
						<td><a
							href="SanphamController/delete?maSP=${listsanpham.maSP}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>
