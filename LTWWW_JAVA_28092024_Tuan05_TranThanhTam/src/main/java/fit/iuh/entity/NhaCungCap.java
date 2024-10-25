package fit.iuh.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "NhaCungCap")
@NamedQueries({
	@NamedQuery(name="listNhaCC", query="Select ncc From NhaCungCap ncc")
})
public class NhaCungCap implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nhaCC_id")
	private int id;
	private String tenNhaCungCap;
	private String diaChi;
	private String soDienThoai;

	@OneToMany(mappedBy = "nhaCungCap",fetch = FetchType.LAZY)
	List<DienThoai> dsDienThoai;

	public NhaCungCap() {
		super();
	}

	public NhaCungCap(int id, String tenNhaCungCap, String diaChi, String soDienThoai, List<DienThoai> dsDienThoai) {
		super();
		this.id = id;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.dsDienThoai = dsDienThoai;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String nhaCungCung) {
		this.tenNhaCungCap = nhaCungCung;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public List<DienThoai> getDsDienThoai() {
		return dsDienThoai;
	}

	public void setDsDienThoai(List<DienThoai> dsDienThoai) {
		this.dsDienThoai = dsDienThoai;
	}

	@Override
	public String toString() {
		return "NhaCungCap [id=" + id + ", nhaCungCung=" + tenNhaCungCap + ", diaChi=" + diaChi + ", soDienThoai="
				+ soDienThoai + ", dsDienThoai=" + dsDienThoai + "]";
	}

}
