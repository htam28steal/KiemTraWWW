<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th,td {
            border: 1px solid black;
        }
       
    </style>
</head>

<body>
    <table>
        <tr>
            <th  colspan="6"> Số Máy - Trần Thanh Tâm -21110341 </th>
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
        <c:forEach items="${listNhanVien}" var="nv">
        	<tr>
            	<td>${nv.phongBan.tenPhongBan}</td>
            	<td>${nv.maNV}</td>
            	<td>${nv.tenNV}</td>
            	<td>${nv.email}</td>
            	<td>${nv.diaChi}</td>
            	<td>${nv.dienThoai}</td>
        	</tr>
        </c:forEach>
        
    </table>
</body>
</html>