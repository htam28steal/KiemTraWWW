package fit.iuh.dao;

import java.util.List;

import fit.iuh.entity.NhaCungCap;

public interface NhaCungCapDao {
	List<NhaCungCap> dsNhaCungCap();
	NhaCungCap findNhaCungCapById(int id); 
}
