package fit.iuh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ChuyenTrangServlet
 */
@WebServlet("/ChuyenTrangServlet")
public class ChuyenTrangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChuyenTrangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strAction = request.getParameter("action");
		if("Danh sách Nhân viên".equals(strAction)) {
			response.sendRedirect(request.getContextPath()+"/NhanVienServlet");
		}else {
			if("Thêm Nhân viên mới".equals(strAction)) {
				response.sendRedirect(request.getContextPath()+"/ThemNhanVienServlet");
			}else {
				response.sendRedirect(request.getContextPath()+"/XoaNhanVienServlet");
			}
		}
	}

}
