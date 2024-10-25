package fit.iuh.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.print.attribute.HashPrintRequestAttributeSet;

import org.apache.taglibs.standard.lang.jstl.GreaterThanOrEqualsOperator;

import fit.iuh.dao.DienThoaiDao;
import fit.iuh.dao.NhaCungCapDao;
import fit.iuh.daoimpl.DienThoaiImpl;
import fit.iuh.daoimpl.NhaCungCapImpl;
import fit.iuh.entity.DienThoai;
import fit.iuh.entity.NhaCungCap;
import fit.iuh.entityManagerFactoryUtil.EntityManagerFactoryUtil;

@WebServlet("/NhaCungCapServlet")
public class NhaCungCapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManager;
	private NhaCungCapDao nhaCCDao;
	private DienThoaiDao dienThoaiDao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhaCungCapServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.entityManager = new EntityManagerFactoryUtil();
		this.nhaCCDao = new NhaCungCapImpl(this.entityManager.getEntityManager());
		this.dienThoaiDao = new DienThoaiImpl(this.entityManager.getEntityManager());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		this.entityManager.close();
		this.nhaCCDao = null;
		this.dienThoaiDao = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<NhaCungCap> listNhaCC = nhaCCDao.dsNhaCungCap();
		request.setAttribute("listNCC", listNhaCC);
		request.getRequestDispatcher("/views/addSanPham.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strAction = request.getParameter("action");
		if (strAction.equals("Thêm")) {
			String nameDT = request.getParameter("nameDienThoai");
			String namSX = request.getParameter("namSX");
			String nhaCungCap = request.getParameter("ncc_id");
			String cauHinh = request.getParameter("cauHinh");
			String hinhAnh = request.getParameter("image");
			NhaCungCap ncc = nhaCCDao.findNhaCungCapById(Integer.parseInt(nhaCungCap));
			DienThoai phone = new DienThoai();
			phone.setTenDT(nameDT);
			phone.setNamSanXuat(namSX);
			phone.setNhaCungCap(ncc);
			phone.setHinhAnh(hinhAnh);
			phone.setThongTinCauHinh(cauHinh);

			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<DienThoai>> violations = validator.validate(phone);
			if (violations.isEmpty()) {
				dienThoaiDao.addPhone(phone);
				response.sendRedirect("DanhSachDienThoaiNCCServlet");
			} else {
				List<NhaCungCap> listNhaCC = nhaCCDao.dsNhaCungCap();
				request.setAttribute("listNCC", listNhaCC);
				RequestDispatcher rq = request.getRequestDispatcher("/views/addSanPham.jsp");
				StringBuilder stringBuilder = new StringBuilder();
				violations.forEach(validation -> {
					stringBuilder.append(validation.getPropertyPath()+": "+validation.getMessage());
				});
				request.setAttribute("error", stringBuilder);
				rq.forward(request, response);
			}
		}

	}
}