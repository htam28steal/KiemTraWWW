package fit.iuh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import fit.iuh.dao.NhanVienDao;
import fit.iuh.daoimpl.NhanVienDaoImpl;
import fit.iuh.entity.NhanVien;
import fit.iuh.entityManager.EntityManagerFactoryUtil;

/**
 * Servlet implementation class NhanVienServlet
 */
@WebServlet("/NhanVienServlet")
public class NhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManager;
	private NhanVienDaoImpl nhanVienDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NhanVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	this.entityManager = new EntityManagerFactoryUtil();
    	this.nhanVienDao = new NhanVienDaoImpl(this.entityManager.getEntityManager());
    }
    @Override
    public void destroy() {
    	this.entityManager.close();
    	this.nhanVienDao = null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<NhanVien> listNhanVien = nhanVienDao.getAllNhanVien();
		request.setAttribute("listNhanVien", listNhanVien);
		request.getRequestDispatcher("/views/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
