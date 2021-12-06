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
	<div style="line-height: 70px; font-size: 50px" class="header">Orders</div>
	<a style="line-height: 70px; font-size: 50px" href ="/webfinal/SanphamController">Product</a>
	<a style="line-height: 70px; font-size: 50px" href ="/webfinal/UserControllerServlet">User</a>
	</div>
	<div class="info">

		<table class="styled-table" style="width: 100%">
			<tr>
				<th style="width: 15%">Họ tên</th>
				<th style="width: 35%">Tên sản phẩm</th>
				<th style="width: 10%">số lượng</th>
				<th style="width: 10%">Tổng tiền</th>
				<th style="width: 30%">Địa chỉ</th>
			</tr>
			<c:forEach var="listhoadon" items="${listhoadon}">
				<tr>
					<td><h3>${listhoadon.user.hoten}</h3></td>
					<td><c:forEach var="hoadonsanpham"
							items="${listhoadon.hoadonsanphams}">
							<h3 style="line-height: 40px">${hoadonsanpham.sanpham.tenSP}</h3>
						</c:forEach></td>
					<td><c:forEach var="hoadonsanpham"
							items="${listhoadon.hoadonsanphams}">
							<h3 style="line-height: 40px">${hoadonsanpham.soluong}</h3>
						</c:forEach>
					</td>
					<td>${listhoadon.tongtien}đ</td>
					<td><h3>${listhoadon.user.diachi}</h3></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
