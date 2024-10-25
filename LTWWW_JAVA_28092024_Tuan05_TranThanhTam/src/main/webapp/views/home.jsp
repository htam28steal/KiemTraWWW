<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sách Điện Thoại</title>
<style>
.table-container {
	margin: 0 auto;
	width: 80%;
	text-align: center;
}

h4 {
	margin: 10px;
}

table {
	width: 100%;
	border-collapse: collapse;
}

td, th {
	border: 1px solid black;
	padding: 10px;
	text-align: center;
}

.logo {
	width: 128px;
	height: 50px;
}
.imgSP {
	width: 50px;
	height: 50px;
}
input[type="submit"] {
	justifly-content:space-between;
	color: black;
	padding: 5px;
	background-color: white;
	border:none;
}

input[type="submit"]:hover {
	background-color: lightgray;
}
</style>
</head>
<body>
	<div class="table-container">
		<table>
			<!-- Logo Row -->
			<tr>
				<td colspan="6"><img src="${pageContext.request.contextPath}/imgs/logo.jpg" alt="logo" class="logo"></td>
			</tr>

			<!-- Navigation Links Row -->
			<tr>
				<td colspan="6">
					<form action="${pageContext.request.contextPath}/ChuyenDoiServlet" method="post">
						<input type="submit" value="Danh Sách Sản Phẩm" name="action" />
						<input type="submit" value="Thêm Sản Phẩm" name="action" />
						<input type="submit" value="Chức Năng Quản Lý" name="action" />
					</form>
				</td>
			</tr>

			<!-- Header Row -->
			<tr>
				<th>STT</th>
				<th>Tên Điện Thoại</th>
				<th>Năm Sản Xuất</th>
				<th>Nhà Cung Cấp</th>
				<th>Cấu Hình</th>
				<th>Hình Ảnh</th>
			</tr>

			<!-- Data Rows -->
			<c:if test="${not empty listPhone}">
				<c:forEach items="${listPhone}" var="phone" varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${phone.tenDT}</td>
						<td>${phone.namSanXuat}</td>
						<td>${phone.nhaCungCap.tenNhaCungCap}</td>
						<td>${phone.thongTinCauHinh}</td>
						<td><img class="imgSP" alt="Hình ảnh điện thoại" src="imgs/${phone.hinhAnh}" /></td>
					</tr>
				</c:forEach>
			</c:if>

			<!-- Footer Row -->
			<tr>
				<th colspan="6">Trần Thanh Tâm - 21110341 - DHKTPM17BTT</th>
			</tr>
		</table>
	</div>
</body>
</html>
