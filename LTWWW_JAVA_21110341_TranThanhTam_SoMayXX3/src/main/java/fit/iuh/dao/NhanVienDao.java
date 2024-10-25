package fit.iuh.dao;

import java.util.List;

import fit.iuh.entity.NhanVien;

public interface NhanVienDao {
	List<NhanVien> getAllNhanVien();
	boolean addNhanVien(NhanVien nv);
	boolean removeNhanVien(int id);
	boolean updateNhanVien(NhanVien nv);
	NhanVien findNhanVienById(int id);
}
