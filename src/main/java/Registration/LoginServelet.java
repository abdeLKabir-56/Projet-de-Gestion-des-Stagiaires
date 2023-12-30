package Registration;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import Persistance.DBConnexion;
import usermanagment.model.User;
/**
 * Servlet implementation class LoginServelet
 */
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private ArrayList<User>Users;
      private Connection conn = new DBConnexion().getconnexion();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//testing
		PrintWriter out = response.getWriter();
//		out.write("working ...");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String position = request.getParameter("postion");
//		out.write(position);
//		out.write(email);
//		out.write(password);
		RequestDispatcher dispatcher = null;
		//Connection conn = null;
		HttpSession session = request.getSession();
		Users = new ArrayList<>();
		try {
			
            String query = "select * from user where email = ? and password = ? and position = ?";
            PreparedStatement ps = conn.prepareStatement(query);
             
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, position);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	System.out.println("here...");
            	session.setAttribute("name", rs.getString("name"));
            	String pos = rs.getString("position");
            	if(pos.equals("chefDrh"))
            	{
            		dispatcher = request.getRequestDispatcher("user-list.jsp");
            	}else if (pos.equals("adminDrh")) {
            		dispatcher = request.getRequestDispatcher("user-list.jsp");
				}else {
					dispatcher = request.getRequestDispatcher("stagiareProfile.jsp");
				}
            	request.setAttribute("email", rs.getString("email"));
            	request.setAttribute("password",rs.getString("password"));
            	request.setAttribute("position", rs.getString("position"));
            	
            	//dispatcher = request.getRequestDispatcher("index.jsp");
			}else
			{
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
            dispatcher.forward(request, response);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
