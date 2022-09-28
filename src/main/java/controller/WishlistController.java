package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.WishlistDao;
import model.wishlist;

/**
 * Servlet implementation class WishlistController
 */
@WebServlet("/WishlistController")
public class WishlistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishlistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("Add to Wishlist")) {
			wishlist w = new wishlist();
			w.setCusid(Integer.parseInt(request.getParameter("cusid")));
			w.setPid(Integer.parseInt(request.getParameter("pid")));
			WishlistDao.insertWishLIst(w);
			response.sendRedirect("customer-index.jsp");
	}

	}
}
