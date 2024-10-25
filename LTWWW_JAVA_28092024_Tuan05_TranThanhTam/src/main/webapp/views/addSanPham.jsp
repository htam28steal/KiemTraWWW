<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@  taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh Sách Điện Thoại</title>
<style>
.table-container {
	margin: 0 auto;
	width: 50%;
	text-align: center;
}

table {
	width: 100%;
	border-collapse: collapse;
}

td, th {
	width:100%;
	border: 1px solid black;
	padding: 10px;
	display:flex;
    align-items: center; 
}
td{
	width:100%;
	display:flex;
	flex-wrap: wrap;
}
th {
    display: flex;
    justify-content: center; 
    align-items: center;     
}
img {
	width: 100%;
}
.spPhone {
	height: 32px;
	width: 32px;
}
label{
    width: 300px;
    font-weight: bold;
    font-size: 18px;
    display:flex;
    justifly-content:start;
}
select{
    height: 32px;
    width: 300px;
    border-radius: 5px;
}
.op {
	color: black;
	padding: 10px;
	background-color:white;
	border: hidden;
}
form{
	display: flex;
    justify-content: space-between; 
    gap: 100px;
    margin-left:50px;
}
.info{
	width:375px;
	height: 32px;
	border-radius:5px;
}
.op:hover {
	background-color: lightgray;
}
.them{
	display:flex;
	justifly-content:center;
	margin-left:200px;
	width:200px;
}
span {
	color:red;
}
select{
	width: 380px;
}

</style>
</head>
<body>
	<div class="table-container">
		<table>
			<!-- Logo Row -->
			<tr>
				<td><img src="imgs/logo.jpg" alt="logo"></td>
			</tr>

			<!-- Navigation Links Row -->
			<tr>
				<td>
					<form action="${pageContext.request.contextPath}/ChuyenDoiServlet" method="post">
						<input type="submit" value = "Danh Sách Sản Phẩm" name ="action" class="op"/>
				 		<input type="submit" value = "Thêm Sản Phẩm" name="action" class="op"/> 
				 		<input type="submit" value = "Chức Năng Quản Lý" name = "action" class="op" />
				 	</form>
				 </td>
			</tr>

			<!-- Header Row -->
			<!-- Data Rows -->
            <tr>
                    <form action="${pageContext.request.contextPath}/NhaCungCapServlet" method="post" id="formAdd">
                    	<c:if test="${error != null }">
                    		<td><span><c:out value= "${error}"/></span></td>
                    	</c:if>
                            <td>
                                <label for="">Name điện thoại</label>
                                <input type="text" name="nameDienThoai" id="ipNameDT" class="info">
                                <span id="tbNameDT">*</span>
                            </td>
                            <td>
                                <label for="">Năm sản xuất: </label>
                                <input type="text" name="namSX" id="ipNamSX" class="info">
                                <span id="tbNamSX">*</span>
                            </td>
                             <td>
                                <label for="">Cấu hình: </label>
                                <input type="text" name="cauHinh" id="ipCauHinh" class="info" maxlength="255">
                                <span id="tbCauHinh">*</span>
                            </td>
                            <td>
                                <label for="">Nhà cung cấp</label>
                                <select name="ncc_id" id="cars">
                                   <c:forEach items="${listNCC}" var="ncc">
										<option value="${ncc.id}">${ncc.tenNhaCungCap}</option>
                                   </c:forEach>
                                </select>
                                <span id="tbNhaCC">*</span>
                            </td>
                            <td>
                                <label for="">Hình ảnh:</label>
                                <input type="file" accept=".jpg, .png" name="image" class="info" id="ipHinhAnh">
                                <span id="tbHinhAnh">*</span>
                            </td>
                    	<tr>
							<td> <input class="them"  type="submit" value="Thêm" name="action"/> </td>
						</tr>
                    </form>
                  </tr>
			<!-- Footer Row -->
			<tr>
				<th><div class="mssv">Trần Thanh Tâm - 21110341 - DHKTPM17BTT</div></th>
			</tr>
		</table>
	</div>
</body>
</html>
