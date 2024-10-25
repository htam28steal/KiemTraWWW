package fit.iuh.dao;

import java.util.List;

import fit.iuh.entity.PhongBan;

public interface PhongBanDao {
	List<PhongBan> getAllPhongBan();
	PhongBan findPhongBanById(int id);
}
