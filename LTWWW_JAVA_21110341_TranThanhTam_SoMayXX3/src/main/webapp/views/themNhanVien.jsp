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
</style>
</head>
<body>
	<table>
		<tr>
			<th>Thêm Nhân Viên</th>
		</tr>
		<tr>
			 <th  colspan="6">
                <form action="${pageContext.request.contextPath}/ChuyenTrangServlet" method="post">
                    <input type="submit" value="Danh sách Nhân viên" name="action">
                    <input type="submit" value="Thêm Nhân viên mới" name="action">
                    <input type="submit" value="Quản lý Nhân viên" name="action">
                </form>
                Danh Sách Nhân Viên
            </th>
		</tr>
		<tr>
			<th colspan="2">

				<form action="${pageContext.request.contextPath}/ThemNhanVienServlet" method="post">
					<label id="label-1">Tên NV:</label> <input type="text" name="tenNV">
					</br> <label id="label-2">Địa chỉ:</label> <input type="text" name="diaChi">
					 </br> <label id="label-2">Email:</label> <input type="text" name="email"
					 > </br> <label id="label-2">Điện thoại:</label> <input type="text" name="dienThoai"> </br> 
					 <label	id="label-2">Phòng ban:</label> 
					 <select name="phongBan">
					 	<c:forEach items="${listPhongBan}" var="pb">
					 		<option value="${pb.maPhongBan}">${pb.tenPhongBan}</option>
					 	</c:forEach>
					</select> </br>
					<input type="submit" value="Thêm" name="them">
				</form>
			</th>
		</tr>

	</table>

</body>
</html>