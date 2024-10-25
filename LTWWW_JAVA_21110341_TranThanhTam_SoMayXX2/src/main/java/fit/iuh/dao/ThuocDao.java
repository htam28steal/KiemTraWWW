package fit.iuh.dao;

import java.util.List;

import fit.iuh.entity.Thuoc;

public interface ThuocDao {
	List<Thuoc> getAllThuoc();
	List<Thuoc> getThuocTheoTenLoai(String tenLoai);
	boolean themThuoc(Thuoc thuoc);
}
