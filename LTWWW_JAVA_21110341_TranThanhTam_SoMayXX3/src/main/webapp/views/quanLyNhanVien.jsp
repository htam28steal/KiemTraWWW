<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
}

input {
	width: 300px;
}

.control {
	width: 100px;
	height: 20px;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th></th>
		</tr>
		<tr>
			<th colspan="7">
				<form action="${pageContext.request.contextPath}/ChuyenTrangServlet"
					method="post">
					<input type="submit" value="Danh sách Nhân viên" name="action">
					<input type="submit" value="Thêm Nhân viên mới" name="action">
					<input type="submit" value="Quản lý Nhân viên" name="action">
				</form> Danh Sách Nhân Viên
			</th>
		</tr>
		<c:forEach items="${listNhanVien}" var="nv" varStatus="index">

			<tr>
				<form action="${pageContext.request.contextPath}/XoaNhanVienServlet"
					method="post">
				<td>${nv.phongBan.tenPhongBan}</td>
				<td><input type="text" value="${nv.maNV}" name="idNV"></td>
				<td>${nv.tenNV}</td>
				<td>${nv.email}</td>
				<td>${nv.diaChi}</td>
				<td>${nv.dienThoai}</td>
				<td><input type="submit" value="xoa" name="control"
					class="control" />
					<input type="submit" value="chinh sua" name="control" class="control" />
					</td>
				</form>
			</tr>

		</c:forEach>
	</table>
</body>
</html>