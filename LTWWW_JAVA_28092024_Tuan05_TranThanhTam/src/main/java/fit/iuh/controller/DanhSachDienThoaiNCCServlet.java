package fit.iuh.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import fit.iuh.daoimpl.DienThoaiImpl;
import fit.iuh.entity.DienThoai;
import fit.iuh.entityManagerFactoryUtil.EntityManagerFactoryUtil;

/**
 * Servlet implementation class DanhSachDienThoaiNCCServlet
 */
@WebServlet("/DanhSachDienThoaiNCCServlet")
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManager;
	private DienThoaiImpl dienThoaiDao;
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */
    public void DanhSachDienThoaiNCCServlet() {
        // TODO Auto-generated constructor stub
    }
	public void init(ServletConfig config) throws ServletException {
		this.entityManager = new EntityManagerFactoryUtil();
		this.dienThoaiDao = new DienThoaiImpl(this.entityManager.getEntityManager());
	}
	public void destroy() {
		this.entityManager.close();
		this.dienThoaiDao = null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DienThoai> dsPhone = dienThoaiDao.dsDienThoai();
		request.setAttribute("listPhone", dsPhone);
		request.getRequestDispatcher("/views/home.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
