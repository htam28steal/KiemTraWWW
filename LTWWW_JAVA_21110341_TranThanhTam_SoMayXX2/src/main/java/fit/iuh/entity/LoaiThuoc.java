package fit.iuh.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="getAllLoaiThuoc", query = "Select t from LoaiThuoc t")
})

public class LoaiThuoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenLoai;
	@OneToMany(mappedBy = "loaiThuoc")
	private List<Thuoc> thuoc;

	public LoaiThuoc() {
		super();
	}

	public LoaiThuoc( String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public List<Thuoc> getThuoc() {
		return thuoc;
	}

	public void setThuoc(List<Thuoc> thuoc) {
		this.thuoc = thuoc;
	}

	@Override
	public String toString() {
		return "LoaiThuocDaoImpl [id=" + id + ", tenLoai=" + tenLoai + "]";
	}

}
