package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CustomerDao;
import Dao.SellerDao;
import model.Customer;
import model.Seller;



/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equalsIgnoreCase("register")) {
			Customer c = new Customer();
			c.setName(request.getParameter("name"));
			c.setMobile_no(Long.parseLong(request.getParameter("contact")));
			c.setAddress(request.getParameter("address"));
			c.setEmail(request.getParameter("email"));
			c.setPassword(request.getParameter("password"));
			System.out.println(c);
			CustomerDao.insertCustomer(c);
			request.setAttribute("msg","data registered successfully");
			request.getRequestDispatcher("customer-login.jsp").forward(request, response);
			
		}
		else if(action.equalsIgnoreCase("login")) {
			Customer c = new Customer();
			c.setEmail(request.getParameter("email"));
			c.setPassword(request.getParameter("password"));
			Customer c1 = CustomerDao.loginCustomer(c);
			System.out.println(c1);
			if(c1 == null) {
				request.setAttribute("validate", "email or password is incorrect");
				request.getRequestDispatcher("customer-login.jsp").forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("data", c1);
				request.getRequestDispatcher("customer-index.jsp").forward(request, response);
				
			}
		}
		else if(action.equalsIgnoreCase("update")) {
			Customer c = new Customer();
			c.setId(Integer.parseInt(request.getParameter("id")));
			c.setName(request.getParameter("name"));
			c.setMobile_no(Long.parseLong(request.getParameter("contact")));
			c.setAddress(request.getParameter("address"));
			c.setEmail(request.getParameter("email"));
			CustomerDao.updateCustomer(c);
			HttpSession session = request.getSession();
			session.setAttribute("data", c);
			request.getRequestDispatcher("customer-profile.jsp").forward(request, response);
			
		}
		else if(action.equalsIgnoreCase("update password")) {
			String email = request.getParameter("email");
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = CustomerDao.checkPassword(email, op);
			if(flag == true) {
				if(np.equals(cnp)) {
					CustomerDao.updatePassword(email, np);
					response.sendRedirect("customer-index.jsp");
				}
				else{
					request.setAttribute("msgpass", "new pass and cnp not matched");
					request.getRequestDispatcher("customer-change-password.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "old password not matched");
				request.getRequestDispatcher("customer-change-password.jsp").forward(request, response);
			}
		}
	}

}


