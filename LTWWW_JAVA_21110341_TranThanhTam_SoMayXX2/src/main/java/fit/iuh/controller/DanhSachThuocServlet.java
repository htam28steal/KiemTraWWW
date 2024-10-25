package fit.iuh.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import fit.iuh.dao.LoaiThuocDao;
import fit.iuh.dao.ThuocDao;
import fit.iuh.dao.impl.LoaiThuocDaoImpl;
import fit.iuh.entity.LoaiThuoc;
import fit.iuh.entity.Thuoc;
import fit.iuh.persistence.EntityManagerFactoryUtil;

/**
 * Servlet implementation class DanhSachThuocServlet
 */
@WebServlet("/DanhSachThuocServlet")
public class DanhSachThuocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManager;
	private LoaiThuocDao loaiThuocDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachThuocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.entityManager = new EntityManagerFactoryUtil();
		this.loaiThuocDao = new LoaiThuocDaoImpl(entityManager.getEntityManager());
	}
	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		this.entityManager.close();
		this.loaiThuocDao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LoaiThuoc> listLoaiThuoc  = loaiThuocDao.getAllLoaiThuoc();
		request.setAttribute("listLoaiThuoc", listLoaiThuoc);
		request.getRequestDispatcher("/views/danhsachthuoc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
