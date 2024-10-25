package fit.iuh.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="getAllPhongBan", query = "Select pb from PhongBan pb")
})
public class PhongBan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maPhongBan;
	private String tenPhongBan;

	@OneToMany(mappedBy = "phongBan")
	private List<NhanVien> nhanVien;

	public PhongBan() {
		super();
	}

	public PhongBan(int maPhongBan, String tenPhongBan, List<NhanVien> nhanVien) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.nhanVien = nhanVien;
	}

	public int getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(int maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public List<NhanVien> getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(List<NhanVien> nhanVien) {
		this.nhanVien = nhanVien;
	}

	@Override
	public String toString() {
		return "PhongBan [maPhongBan=" + maPhongBan + ", tenPhongBan=" + tenPhongBan + "]";
	}
}
