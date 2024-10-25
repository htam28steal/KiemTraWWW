const ipNameDT = document.getElementById("ipNameDT");
const ipNamSX = document.getElementById("ipNamSX");
const ipCauHinh = document.getElementById("ipCauHinh");
const tbNameDT = document.getElementById("tbNameDT");
const tbNamSX = document.getElementById("tbNamSX");
const tbCauHinh = document.getElementById("tbCauHinh");
const formAdd = document.getElementById("formAdd");
const ipNhaCC = document.getElementById("cars");
const tbNhaCC = document.getElementById("tbNhaCC");
const ipHinhAnh = document.getElementById("ipHinhAnh");
const tbHinhAnh = document.getElementById("tbHinhAnh");
let checkName = false;
let checkNSX = false;
let checkCauHinh = false;
let checkNhaCC = false;
let checkHinhAnh = false;
ipNameDT.addEventListener('blur', function() {
	const valueNameDT = ipNameDT.value.trim();
	if (valueNameDT === '') {
		tbNameDT.textContent = "Bắt buộc nhập tên sản phẩm !";
		checkName = false;
	} else {
		tbNameDT.textContent = "*";
		checkName = true;
	}
	return checkName;
});

ipNamSX.addEventListener('blur', function() {
	const valueNamSX = ipNamSX.value;
	const regex = /^\d{4}$/;
	if (valueNamSX === '' || !regex.test(valueNamSX)) {
		tbNamSX.textContent = "Bắt buộc nhập năm sản xuất và {4} chữ số";
		checkNSX = false;
	} else {
		tbNamSX.textContent = "*";
		checkNSX = true;
	}
	return checkNSX;
});

ipCauHinh.addEventListener('blur', function() {
	const valueCauHinh = ipCauHinh.value.trim();
	if (valueCauHinh === '' || valueCauHinh.length > 255) {
		tbCauHinh.textContent = "Bắt buộc nhập cấu hình! giới hạn 255 ký tự";
		checkCauHinh = false;
	} else {
		tbCauHinh.textContent = "*";
		checkCauHinh = true;
	}
	return checkCauHinh;
});

ipNhaCC.addEventListener('blur', function() {
	let valueNhaCC = ipNhaCC.value.trim();
	if (valueNhaCC === '') {
		tbNhaCC.textContent = "Vui lòng chọn nhà cung cấp !";
		checkNhaCC = false;
	} else {
		tbNhaCC.textContent = "*";
		checkNhaCC = true;
	}
	return checkNhaCC;
});
ipHinhAnh.addEventListener('blur', function() {
	const valueImage = ipHinhAnh.value.trim();
	const imgEnd = [".png", ".jpg", ".jpeg"];
	if (valueImage === '' || !valueImage.includes(imgEnd)) {
		tbHinhAnh.textContent = "Vui lòng chọn ảnh! {.png, .jpg, .jpeg}";
		checkHinhAnh = false;
	} else {
		tbHinhAnh.textContent = "*";
		checkHinhAnh = true;
	}
	return checkHinhAnh;
})
formAdd.addEventListener('submit', function(event) {
	if (!checkName || !checkNSX || !checkCauHinh || !checkNhaCC || !checkHinhAnh) {
		event.preventDefault();
	}
})
