<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	width: 80%;
	margin: 20px auto;
	border: 1px solid black;
}

.header {
	text-align: center;
	padding: 10px;
	border-bottom: 1px solid black;
}

.menu {
	text-align: left;
	padding: 10px;
}

.menu a {
	margin-right: 20px;
	text-decoration: none;
	color: black;
	border-right: 1px solid black;
	padding-right: 10px;
}

.menu a:last-child {
	border-right: none; /* Loại bỏ đường viền phải cho mục cuối */
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

.form-option {
	width: 200px;
	height: 50px;
	display: 'flex';
	flex-direction: 'row';
	justify-content: 'center';
	align-items: 'center';
	border: 1px solid black;
	justify-content: 'center';
}
</style>
<body>
	<div class="container">
		<div class="header">
			<p>MSSV-HotenSV</p>
		</div>
		<form action="${pageContext.request.contextPath}/ChuyenDoiServlet"
			method="post">
			<div class="menu">
				<input type="submit" value="Danh sách các loại thuốc" name="action">
				<input type="submit" value="Danh sách thuốc" name="action">
				<input type="submit" value="Thêm thuốc mới" name="action">
			</div>
		</form>
		<div class="form-option">
			<form method="post"
				action="${pageContext.request.contextPath}/ThuocServlet">
				<div>
					<select name="option">
						<c:if test="${not empty listLoaiThuoc}">
							<c:forEach items="${listLoaiThuoc}" var="t">
								<option value="${t.tenLoai}">${t.tenLoai}</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
				<input type="submit" value="chọn" name="chon">
			</form>
		</div>
		<table>
			<thead>
				<tr>
					<th>Tên thuốc</th>
					<th>Giá</th>
					<th>Năm sản xuất</th>
					<th>Loại thuốc</th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${listThuocTheoLoai}" var="t">
					<tr>
						<td>${t.tenThuoc}</td>
						<td>${t.gia}</td>
						<td>${t.namSX}</td>
						<td>${t.loaiThuoc.tenLoai}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
