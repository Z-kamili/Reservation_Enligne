package web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import DAO.entities.IReservationDao;
import beans.Reservation;
import beans.User;
import metier.entities.ReservationDaoImplementation;

/**
 * Servlet implementation class ControllerProduct
 */
@WebServlet("/ControllerReservation")
@MultipartConfig(maxFileSize = 16177215)
public class ControllerReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	private static int id;
	IReservationDao Prd;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerReservation() {
        super();
        Prd = new ReservationDaoImplementation();
        // TODO Auto-generated constructor stub
    }
	public  boolean validate_email(String email) {
		Pattern regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = regex.matcher(email);
		return matcher.find();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = request.getServletPath();
		if(path.equals("/Edit.test")){			
			ControllerReservation.id =  Integer.parseInt(request.getParameter("id"));
			try {
				List<Reservation> rsv = Prd.update(id);
				request.setAttribute("rsv",rsv);
				request.getRequestDispatcher("Adminpanel.jsp").forward(request,response);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	/*	String path = request.getServletPath();
	  if(path.equals("/Add_product.test")){
		  
		  request.getRequestDispatcher("Add_product.jsp").forward(request,response);
		  
	  }else if(path.equals("/Delete.test")){
			System.out.println("hello");
			int id =  Integer.parseInt(request.getParameter("id"));
			try {
				Prd.deleteProduct(id);
				response.sendRedirect("search.test?motCle=");
			}catch(SQLException e) {
				request.getRequestDispatcher("Adminpanel.jsp").forward(request,response);
			}*/

	/*	}else if(path.equals("/search.test")){
			String motCle = request.getParameter("motCle");
			try {
				List<Reservation> product = Prd.PriductParMC("%" +motCle+ "%");
				List<String> imagelist = new ArrayList<String>();
				for (Reservation p : product) {
					//byte[] imageBytes = p.getImage();
					/*System.out.println(imageBytes);
					imagelist.add(Base64.getEncoder().encodeToString(imageBytes));*/
			/*	}
				request.setAttribute("images",imagelist);
				request.setAttribute("product",product);
				request.getRequestDispatcher("Adminpanel.jsp").forward(request,response);
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				request.getRequestDispatcher("Adminpanel.jsp").forward(request,response);	
			}
		}else if(path.equals("/Edit.test")){			
			ControllerProduct.id =  Integer.parseInt(request.getParameter("id"));
			Product p = Prd.getProduct(id);
			request.setAttribute("product",p);
			request.getRequestDispatcher("update_product.jsp").forward(request,response);
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		 User user_2 = (User)session.getAttribute(ATT_SESSION_USER);
		String path = request.getServletPath();
        if(path.equals("/Add_product.test")){
			String email = request.getParameter("email");
			String desc = request.getParameter("Desc");
			String date = request.getParameter("date");
			if(!validate_email(email)) {
				request.setAttribute("error","email incorect");
				request.getRequestDispatcher("Add_product.jsp").forward(request,response);
			}else {
				try {
					System.out.println(user_2.getId());
					Reservation a = Prd.save(new Reservation(email,desc,date,user_2.getId()));
					request.getRequestDispatcher("Product.jsp").forward(request,response);
				}catch(SQLException e){
					System.out.println(e.getMessage());
					request.setAttribute("erreur",e.getMessage());
					request.getRequestDispatcher("Adminpanel.jsp").forward(request,response);
				}
			}

		}

			
       
	}

}
