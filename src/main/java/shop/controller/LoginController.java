package shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;


import shop.domain.LoginForm;
import shop.model.User;
import shop.utils.UserDAO;
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LoginForm form = new LoginForm();
			BeanUtils.populate(form, request.getParameterMap());
			UserDAO dao = new UserDAO();
			User user = dao.findByID(form.getUserName());
			if (user != null && user.getPassword().equals(form.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("name", user.getHoten());
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				
				session.setAttribute("userName", form.getUserName());
				return;
			}
			request.setAttribute("errorLogin", "Sai tài khoản hoặc mật khẩu");
			
		} catch (Exception e) {
			request.setAttribute("errorLog", e.getMessage());
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
