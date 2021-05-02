package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.entities.IReservationDao;
import beans.Reservation;
import beans.User;
import metier.entities.ReservationDaoImplementation;

/**
 * Servlet implementation class ControllerMappings
 */
@WebServlet("/ControllerMappings")
public class ControllerMappings extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	IReservationDao Prd; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerMappings() {
        super();
        // TODO Auto-generated constructor stub
        Prd = new ReservationDaoImplementation();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		  if(path.equals("/Reservation")){
			  try {
				  HttpSession session = request.getSession();
				  User user_2 = (User)session.getAttribute(ATT_SESSION_USER);
				  List<Reservation> a = Prd.getAllReservationAccpet(user_2.getId());  
				  request.setAttribute("rsv",a);
				  request.getRequestDispatcher("Product.jsp").forward(request,response);
			  }catch(Exception e) {
				  
				  System.out.println(e.getMessage());
				  
			  }

			 
		  }else if(path.equals("/Add_Reservation")){
			  request.getRequestDispatcher("Add_product.jsp").forward(request,response);
		  }
		  
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
