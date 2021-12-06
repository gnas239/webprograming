<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./assets/css/stylecart.css">
    <title>Cart</title>
    <base href="/webfinal/">
</head>
<body>
    <div class="head">
        <div class="head-left"><h1>giỏ hàng</h1></div>
        <div class="head-right">
        <form action="." method="post">
          <input type="hidden" name="action" value="shop">
          <input type="submit" id="c-btn" value="Continue Shopping">
        </form>
        </div>
    </div>
    <div class="container">
    <table class="styled-table">
        <tr>
          <th style="width :40%">Số lượng</th>
          <th style="width :30%">Tên sản phẩm</th>
          <th style="width :15%">Số tiền</th>
          <th style="width :15%">Tổng cộng</th>
        </tr>
          <c:forEach var="item" items="${cart.items}">
            <tr>
              <td>
                <form action="" method="post">
                  <input type="hidden" name="productId" 
                         value="<c:out value='${item.product.maSP}'/>">
                  <input type=text name="quantity" 
                         value="<c:out value='${item.quantity}'/>" id="quantity">
                  <input type="submit" id="update-btn" value="Update">
                </form>
              </td>
              <td><c:out value='${item.product.tenSP}'/></td>
              <td><c:out value='${item.product.giaSP}'/></td>
              <td><c:out value='${item.total}'/></td>
              <td>
                <form action="" method="post">
                  <input type="hidden" name="productId" 
                         value="<c:out value='${item.product.maSP}'/>">
                  <input type="hidden" name="quantity" value="0">
                  <input type="submit" id="delete-btn" value="Xóa">
                </form>
              </td>
            </tr>
            <tr>
          
      </c:forEach>
      </table>
    </div>
    <div class="thanh-toan">
      <p><c:out value="Tổng tiền cần thanh toán"></c:out></p>
      <p><c:out value="${totalMoney}đ"></c:out></p>
      <form action="CheckoutController" method="post">
      <button type="submit" id="tt">Mua hàng</button>
      </form>
    </div>
</body>
</html>