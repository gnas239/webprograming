package shop.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.model.*;
import shop.utils.SanphamDAO;



@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SanphamDAO productDao;

    /**
     * Default constructor. 
     */
    public CartController() {
        // TODO Auto-generated constructor stub
    	productDao = new SanphamDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
				ServletContext sc = getServletContext();
		        
		        // get current action
		        String action = request.getParameter("action");
		        if (action == null) {
		            action = "CartController";  // default action
		        }
		        
	            String productId = request.getParameter("productId");
	            String quantityString = request.getParameter("quantity");

	            HttpSession session = request.getSession(false);
	            Cart cart = (Cart) session.getAttribute("cart");
	            if (cart == null) {
	                cart = new Cart();
	            }
	            //if the user enters a negative or invalid quantity,
	            //the quantity is automatically reset to 1.
	            int quantity;
	            try {
	                quantity = Integer.parseInt(quantityString);
	                if (quantity < 0) {
	                    quantity = 1;
	                }
	            } catch (NumberFormatException nfe) {
	                quantity = 1;
	            }

	            // JDBC
	            Sanpham product = null;
				product = productDao.findByID(Integer.parseInt(productId));
	            

	            LineItem lineItem = new LineItem();
	            lineItem.setProduct(product);
	            lineItem.setQuantity(quantity);
	            if (quantity > 0) {
	                cart.addItem(lineItem);
	            } else if (quantity == 0) {
	                cart.removeItem(lineItem);
	            }
	            long totalMoney = cart.totalMoney();
	            session.setAttribute("cart", cart);
	            session.setAttribute("totalMoney", totalMoney);
		        sc.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
