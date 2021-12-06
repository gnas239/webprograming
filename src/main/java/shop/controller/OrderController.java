package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.model.Chitiethoadon;
import shop.utils.HoadonDAO;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		findAll(request, response);
		request.getRequestDispatcher("/admin/orders.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		findAll(request, response);
		request.getRequestDispatcher("/admin/orders.jsp").forward(request, response);
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			HoadonDAO hoadonDAO = new HoadonDAO();
			List<Chitiethoadon> chitiethoadons = hoadonDAO.findAll();
			session.setAttribute("listhoadon", chitiethoadons);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
