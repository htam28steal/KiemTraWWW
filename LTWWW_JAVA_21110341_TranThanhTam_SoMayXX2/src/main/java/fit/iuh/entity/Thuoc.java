package fit.iuh.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "listAllThuoc", query = "Select t from Thuoc t"),
				@NamedQuery(name="getThuocTheoTheLoai", query = "Select t from Thuoc t Join t.loaiThuoc lt 	"
						+ "WHERE lt.tenLoai LIKE :tenLoai")
})
public class Thuoc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "nvarchar(255)")
	private String tenThuoc;
	private double gia;
	private int namSX;
	@ManyToOne
	@JoinColumn(name = "maLoai")
	private LoaiThuoc loaiThuoc;

	public Thuoc() {
		super();
	}

	public Thuoc( String tenThuoc, double gia, int namSX, LoaiThuoc loaiThuoc) {
		super();
		this.tenThuoc = tenThuoc;
		this.gia = gia;
		this.namSX = namSX;
		this.loaiThuoc = loaiThuoc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenThuoc() {
		return tenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getNamSX() {
		return namSX;
	}

	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}

	public LoaiThuoc getLoaiThuoc() {
		return loaiThuoc;
	}

	public void setLoaiThuoc(LoaiThuoc loaiThuoc) {
		this.loaiThuoc = loaiThuoc;
	}

	@Override
	public String toString() {
		return "Thuoc [id=" + id + ", tenThuoc=" + tenThuoc + ", gia=" + gia + ", namSX=" + namSX + ", loaiThuoc="
				+ loaiThuoc + "]";
	}
}
