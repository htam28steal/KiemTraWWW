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
 * Servlet implementation class ThuocServlet
 */
@WebServlet("/ThuocServlet")
public class ThuocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManager;
	private ThuocDao thuocDao;
	private LoaiThuocDao loaiThuoc;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThuocServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		this.entityManager = new EntityManagerFactoryUtil();
		this.thuocDao = new ThuocDaoImpl(this.entityManager.getEntityManager());
		this.loaiThuoc = new LoaiThuocDaoImpl(entityManager.getEntityManager());
	}

	@Override
	public void destroy() {
		this.entityManager.close();
		this.thuocDao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Thuoc> listThuoc = thuocDao.getAllThuoc();
		request.setAttribute("listThuoc", listThuoc);
		request.getRequestDispatcher("/views/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tenLoai = request.getParameter("option").trim();
		List<Thuoc> listThuocTheoLoai = thuocDao.getThuocTheoTenLoai(tenLoai);
		List <LoaiThuoc> listLoai = loaiThuoc.getAllLoaiThuoc();
		request.setAttribute("listLoaiThuoc", listLoai);
		request.setAttribute("listThuocTheoLoai", listThuocTheoLoai);
		request.getRequestDispatcher("/views/danhsachthuoc.jsp").forward(request, response);
	}

}
