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
import shop.model.Hoadonsanpham;
import shop.model.Sanpham;
import shop.model.User;
import shop.utils.ChitietDAO;
import shop.utils.HoadonDAO;
import shop.utils.SanphamDAO;
import shop.utils.UserDAO;
/**
 * Servlet implementation class CheckoutController
 */
@WebServlet("/CheckoutController")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		insert(request, response);
		HttpSession session = request.getSession();
		String listProduct = session.getAttribute("cart").toString();
		//lấy thông tin giỏ hàng về gồm có sản phẩm số lượng
		int size = listProduct.length();
		listProduct = listProduct.substring(2, size - 2);
		String[] output = listProduct.split("\\,");
		for (String string : output) {
			String string2 = string.trim();
			int maSP =Integer.parseInt(string2.substring(1,2));
			int soluong = Integer.parseInt(string2.substring(3, 4));
			//tại vì mahoadon được tự sinh ra nên ta tìm mã hoá đơn của khách hàng vừa ghi vào bản chitiethoadon
			Chitiethoadon chitiethoadon = findAll(request, response);
			ChitietDAO chitietDAO = new ChitietDAO();
			Hoadonsanpham hoadonsanpham = new Hoadonsanpham();
			SanphamDAO sanphamDAO = new SanphamDAO();
			//lấy sản phẩm thêm vào hoadonsanpham
			Sanpham sanpham = sanphamDAO.findByID(maSP);
			hoadonsanpham.setChitiethoadon(chitiethoadon);
			hoadonsanpham.setSanpham(sanpham);
			hoadonsanpham.setSoluong(soluong);
			chitietDAO.insert(hoadonsanpham);
		}
		session.removeAttribute("cart");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//bấm checkout session của server
			HttpSession session = request.getSession();
			Chitiethoadon chitiethoadon = new Chitiethoadon();
			int total = Integer.parseInt(session.getAttribute("totalMoney").toString());
			String userName = session.getAttribute("userName").toString();
			chitiethoadon.setTongtien(total);
			UserDAO userDAO = new UserDAO();
			User user = userDAO.findByID(userName);
			chitiethoadon.setUser(user);
			HoadonDAO daoHD = new HoadonDAO();
			daoHD.insert(chitiethoadon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected Chitiethoadon findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			HoadonDAO dao = new HoadonDAO();
			List<Chitiethoadon> hoadon = dao.findAll();
			//lấy ra hoadon cuối cùng được điền vào bảng
			return hoadon.get(hoadon.size()-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
