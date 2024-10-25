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
 * Servlet implementation class XoaNhanVienServlet
 */
@WebServlet("/XoaNhanVienServlet")
public class XoaNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManager;
	private PhongBanDao phongBanDao;
	private NhanVienDao nhanVienDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XoaNhanVienServlet() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<NhanVien> listNhanVien = nhanVienDao.getAllNhanVien();
		request.setAttribute("listNhanVien", listNhanVien);
		request.getRequestDispatcher("/views/quanLyNhanVien.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idNV = request.getParameter("idNV");
		String strAction = request.getParameter("control");
		System.out.println(idNV);
		if("xoa".equals(strAction)) {
			boolean remove = nhanVienDao.removeNhanVien(Integer.parseInt(idNV));
		}else {
			NhanVien nv = nhanVienDao.findNhanVienById(Integer.parseInt(idNV));
			nv.setDiaChi("Long Hai");
			nv.setDienThoai("(884)12 884");
			nv.setEmail("industrial@gmail.com");
			nv.setTenNV("Khanh Quang");
			boolean updateNhanVien = nhanVienDao.updateNhanVien(nv);
		}
		response.sendRedirect("XoaNhanVienServlet");

	}

}
