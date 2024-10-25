package fit.iuh.dao;

import java.util.List;

import fit.iuh.entity.DienThoai;

public interface DienThoaiDao {
	List<DienThoai> dsDienThoai();
	boolean addPhone(DienThoai dienThoai);
	boolean updateSp();
	boolean removeSp(int id);
}
