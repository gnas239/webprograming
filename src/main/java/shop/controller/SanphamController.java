package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import shop.model.Sanpham;
import shop.utils.SanphamDAO;

@WebServlet({"/SanphamController","/SanphamController/create","/SanphamController/delete"})
public class SanphamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlString = request.getRequestURI();
		Sanpham sanpham = null;
		if(urlString.contains("delete")) {
			delete(request, response);
			sanpham = new Sanpham();
			request.setAttribute("sanpham", sanpham);
		}
		findAll(request, response);
		request.getRequestDispatcher("/admin/product.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlString = request.getRequestURI();
		if(urlString.contains("create")) {
			insert(request, response);
		}else if(urlString.contains("delete")) {
			delete(request, response);
			request.setAttribute("user", new Sanpham());
		}
		findAll(request, response);
		request.getRequestDispatcher("/admin/product.jsp").forward(request, response);
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Sanpham sanpham = new Sanpham();
			BeanUtils.populate(sanpham, request.getParameterMap());
			SanphamDAO dao = new SanphamDAO();
			dao.insert(sanpham);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int maSP = Integer.parseInt(request.getParameter("maSP"));
			SanphamDAO dao = new SanphamDAO();
			dao.delete(maSP);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			SanphamDAO dao = new SanphamDAO();
			List<Sanpham> listsanpham = dao.findAll();
			request.setAttribute("listsanpham", listsanpham);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
