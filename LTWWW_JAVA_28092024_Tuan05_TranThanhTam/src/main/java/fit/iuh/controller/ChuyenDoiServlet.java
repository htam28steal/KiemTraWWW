package fit.iuh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ChuyenDoiServlet
 */
@WebServlet("/ChuyenDoiServlet")
public class ChuyenDoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChuyenDoiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strAction = request.getParameter("action");
		if (strAction.equals("Danh Sách Sản Phẩm")) {
			response.sendRedirect(request.getContextPath()+"/DanhSachDienThoaiNCCServlet");
		} else {
			if (strAction.equals("Thêm Sản Phẩm")) {
				response.sendRedirect(request.getContextPath()+"/NhaCungCapServlet");
			} else {
				if (strAction.equals("Chức Năng Quản Lý")) {
					response.sendRedirect(request.getContextPath()+"/QuanLyFormServlet");
				}
			}
		}
	}
}
