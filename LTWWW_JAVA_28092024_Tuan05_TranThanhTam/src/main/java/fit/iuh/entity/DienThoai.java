package fit.iuh.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "DienThoai")
@NamedQueries({
		@NamedQuery(name="listDienThoai", query="Select p from DienThoai p")
})
public class DienThoai implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dienThoai_id")
	private int id;
	
	@NotNull(message = "Tên điện thoại không được rỗng!")
	@NotEmpty(message = "Tên điện thoại không được rỗng!")
	private String tenDT;
	
	@NotNull(message = "Năm sản xuất không được rỗng!")
	@NotEmpty(message = "Năm sản xuất không được rỗng!")
	@Size(max = 4, min = 4, message = "Không khác 4 ký tự!")  
	private String namSanXuat;
	
	@NotNull(message = "Cấu hình không được rỗng!")
	@NotEmpty(message = "Cấu hình không được rỗng!")
	@Column(name="cau_hinh")
	private String thongTinCauHinh;
	private String hinhAnh;

	@ManyToOne
	@JoinColumn(name = "nhaCC_id")
	private NhaCungCap nhaCungCap;
	
	public DienThoai() {
		super();
	}

	

	public DienThoai(int id, String tenDT, String namSanXuat, String thongTinCauHinh, String hinhAnh,
			NhaCungCap nhaCungCap) {
		super();
		this.id = id;
		this.tenDT = tenDT;
		this.namSanXuat = namSanXuat;
		this.thongTinCauHinh = thongTinCauHinh;
		this.hinhAnh = hinhAnh;
		this.nhaCungCap = nhaCungCap;
	}



	public String getThongTinCauHinh() {
		return thongTinCauHinh;
	}



	public void setThongTinCauHinh(String thongTinCauHinh) {
		this.thongTinCauHinh = thongTinCauHinh;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public String getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(String namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}



	@Override
	public String toString() {
		return "DienThoai [id=" + id + ", tenDT=" + tenDT + ", namSanXuat=" + namSanXuat + ", thongTinCauHinh="
				+ thongTinCauHinh + ", hinhAnh=" + hinhAnh + ", nhaCungCap=" + nhaCungCap + "]";
	}
}
