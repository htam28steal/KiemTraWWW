package fit.iuh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import fit.iuh.dao.NhanVienDao;
import fit.iuh.dao.PhongBanDao;
import fit.iuh.daoimpl.NhanVienDaoImpl;
import fit.iuh.daoimpl.PhongBanDaoImpl;
import fit.iuh.entity.NhanVien;
import fit.iuh.entity.PhongBan;
import fit.iuh.entityManager.EntityManagerFactoryUtil;

/**
 * Servlet implementation class ThemNhanVienServlet
 */
@WebServlet("/ThemNhanVienServlet")
public class ThemNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManager;
	private PhongBanDao phongBanDao;
	private NhanVienDao nhanVienDao;
	
    public ThemNhanVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	this.entityManager = new EntityManagerFactoryUtil();
    	this.phongBanDao = new PhongBanDaoImpl(this.entityManager.getEntityManager());
    	this.nhanVienDao = new NhanVienDaoImpl(this.entityManager.getEntityManager());
    }
    @Override
    public void destroy() {
    	this.entityManager.close();
    	this.phongBanDao = null;
    	this.nhanVienDao = null;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PhongBan> listPhongBan = phongBanDao.getAllPhongBan();
		request.setAttribute("listPhongBan", listPhongBan);
		request.getRequestDispatcher("/views/themNhanVien.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenNV = request.getParameter("tenNV");
		String diaChi = request.getParameter("diaChi");
		String email = request.getParameter("email");
		String dienThoai = request.getParameter("dienThoai");
		String maPhongBan = request.getParameter("phongBan");
		PhongBan pb = phongBanDao.findPhongBanById(Integer.parseInt(maPhongBan));
		NhanVien nv  = new NhanVien(tenNV, email, diaChi, dienThoai, pb);
		boolean add = nhanVienDao.addNhanVien(nv);
		if(add) {
			response.sendRedirect(request.getContextPath()+"/NhanVienServlet");
		}
	}

}
