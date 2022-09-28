package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.SellerDao;
import model.Seller;
import services.Service;

@WebServlet("/SellerController")
public class SellerController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equalsIgnoreCase("register")) {
			Seller s = new Seller();
			s.setName(request.getParameter("name"));
			s.setMobile_no(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			System.out.println(s);
			SellerDao.insertSeller(s);
			request.setAttribute("msg","data registered successfully");
			request.getRequestDispatcher("seller-login.jsp").forward(request, response);
			
		}
		else if(action.equalsIgnoreCase("login")) {
			Seller s = new Seller();
			s.setEmail(request.getParameter("email"));
			s.setPassword(request.getParameter("password"));
			Seller s1 = SellerDao.loginSeller(s);
			System.out.println(s1);
			if(s1 == null) {
				request.setAttribute("validate", "email or password is incorrect");
				request.getRequestDispatcher("seller-login.jsp").forward(request, response);
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("data", s1);
				request.getRequestDispatcher("seller-index.jsp").forward(request, response);
				
			}
		}
		else if(action.equalsIgnoreCase("update")) {
			Seller s = new Seller();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setName(request.getParameter("name"));
			s.setMobile_no(Long.parseLong(request.getParameter("contact")));
			s.setAddress(request.getParameter("address"));
			s.setEmail(request.getParameter("email"));
			SellerDao.updateSeller(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("seller-profile.jsp").forward(request, response);
			
		}
		else if(action.equalsIgnoreCase("update password")) {
			String email = request.getParameter("email");
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = SellerDao.checkPassword(email, op);
			if(flag == true) {
				if(np.equals(cnp)) {
					SellerDao.updatePassword(email, np);
					response.sendRedirect("seller-index.jsp");
				}
				else{
					request.setAttribute("msgpass", "new pass and cnp not matched");
					request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "old password not matched");
				request.getRequestDispatcher("seller-change-password.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("get otp")) {
			String email = request.getParameter("email");
			boolean flag = SellerDao.checkEmail(email);
			if(flag == true) {
				Service s = new Service();
	
				Random r = new Random();
				int num = r.nextInt(9999);
				System.out.println(num);
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("seller-verify-otp.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "email id not registred");
				request.getRequestDispatcher("seller-forgot-password.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if(otp1 == otp2) {
				request.setAttribute("email", email);
				
				request.getRequestDispatcher("seller-new-password.jsp").forward(request, response);
			}
			else {
				request.setAttribute("otpmsg", "OTP not matched");
				request.setAttribute("otp", otp1);
				request.getRequestDispatcher("seller-verify-otp.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("New Password")) {
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			if(np.equals(cnp)) {
				SellerDao.updatePassword(email, np);
				response.sendRedirect("seller-login.jsp");
			}
			else {
				request.setAttribute("validatepass", "np and cnp not metched");
				request.getRequestDispatcher("seller-new-password.jsp").forward(request, response);
			}
		}
	}
	
	
}
