package fit.iuh.dao;

import java.util.List;

import fit.iuh.entity.LoaiThuoc;

public interface LoaiThuocDao {
	List<LoaiThuoc> getAllLoaiThuoc();
	LoaiThuoc findLoaiThoaiById(int id);
}
