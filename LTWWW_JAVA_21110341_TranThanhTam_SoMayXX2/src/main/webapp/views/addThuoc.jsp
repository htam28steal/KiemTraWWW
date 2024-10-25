<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm Thuốc Mới</title>
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

form {
	margin-top: 20px;
}

label {
	display: inline-block;
	width: 150px;
	margin-bottom: 10px;
}

input[type="text"], input[type="number"], select {
	width: 300px;
	padding: 5px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
<body>
	<div class="container">
		<div class="header">
			<h2>Thêm Thuốc Mới</h2>
		</div>

		<form action="${pageContext.request.contextPath}/ChuyenDoiServlet"
			method="post">
			<div class="menu">
				<input type="submit" value="Danh sách các loại thuốc" name="action">
				<input type="submit" value="Danh sách thuốc" name="action">
				<input type="submit" value="Thêm thuốc mới" name="action">
			</div>
		</form>

		<form action="${pageContext.request.contextPath}/ThemThuocServlet"
			method="post">
			<div>
				<label for="tenThuoc">Tên thuốc:</label> <input type="text"
					id="tenThuoc" name="tenThuoc" >
			</div>

			<div>
				<label for="gia">Giá:</label> <input type="text" id="gia"
					name="gia" >
			</div>

			<div>
				<label for="namSX">Năm sản xuất:</label> <input type="text"
					id="namSX" name="namSX" >
			</div>

			<div>
				<label for="loaiThuoc">Loại thuốc:</label> <select id="loaiThuoc"
					name="loaiThuoc" >
					<c:forEach items="${listLoaiThuoc}" var="loai">
						<option value="${loai.id}">${loai.tenLoai}</option>
					</c:forEach>
				</select>
			</div>

			<div>
				<input type="submit" value="Thêm thuốc">
			</div>
		</form>
	</div>
</body>
</html>
