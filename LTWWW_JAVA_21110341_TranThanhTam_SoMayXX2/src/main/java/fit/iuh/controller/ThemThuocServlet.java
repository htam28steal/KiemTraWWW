package fit.iuh.controller;

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
import fit.iuh.dao.impl.ThuocDaoImpl;
import fit.iuh.entity.LoaiThuoc;
import fit.iuh.entity.Thuoc;
import fit.iuh.persistence.EntityManagerFactoryUtil;

/**
 * Servlet implementation class ThemThuocServlet
 */
@WebServlet("/ThemThuocServlet")
public class ThemThuocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EntityManagerFactoryUtil entityManager;
    private LoaiThuocDao loaiThuocDao;
    private ThuocDao thuocDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemThuocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	this.entityManager = new EntityManagerFactoryUtil();
    	this.loaiThuocDao = new LoaiThuocDaoImpl(entityManager.getEntityManager());
    	this.thuocDao = new ThuocDaoImpl(entityManager.getEntityManager());
    }
    @Override
    public void destroy() {
    	this.entityManager.close();
    	this.loaiThuocDao = null;
    	this.thuocDao = null;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LoaiThuoc> listLoaiThuoc  = loaiThuocDao.getAllLoaiThuoc();
		request.setAttribute("listLoaiThuoc", listLoaiThuoc);
		request.getRequestDispatcher("/views/addThuoc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenThuoc = request.getParameter("tenThuoc");
		String gia = request.getParameter("gia");
		String namSX = request.getParameter("namSX");
		String loaiThuoc = request.getParameter("loaiThuoc");
		LoaiThuoc loaiThuoc1 = loaiThuocDao.findLoaiThoaiById(Integer.parseInt(loaiThuoc));
		Thuoc thuoc = new Thuoc(tenThuoc,Double.parseDouble(gia),Integer.parseInt(namSX),loaiThuoc1);
		System.out.println(thuoc);
		boolean add = thuocDao.themThuoc(thuoc);
		
		response.sendRedirect(request.getContextPath()+"/ThuocServlet");
		
	}

}
