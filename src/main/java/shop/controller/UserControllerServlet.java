package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import shop.model.User;
import shop.utils.UserDAO;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet({"/UserControllerServlet" , "/UserControllerServlet/create" ,
	"/UserControllerServlet/update","/UserControllerServlet/delete","/UserControllerServlet/edit"})
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlString = request.getRequestURI();
		User user = null;
		if(urlString.contains("delete")) {
			delete(request, response);
			user = new User();
			request.setAttribute("user", user);
		}
		findAll(request, response);
		request.getRequestDispatcher("/admin/user.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlString = request.getRequestURI();
		if(urlString.contains("create")) {
			insert(request, response);
		}else if(urlString.contains("delete")) {
			delete(request, response);
			request.setAttribute("user", new User());
		}
		findAll(request, response);
		request.getRequestDispatcher("/admin/user.jsp").forward(request, response);
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			UserDAO dao = new UserDAO();
			dao.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String userName = request.getParameter("userName");
			UserDAO dao = new UserDAO();
			dao.delete(userName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDAO dao = new UserDAO();
			List<User> listuser = dao.findAll();
			request.setAttribute("listuser", listuser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
