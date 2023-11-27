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

/**
 * Servlet implementation class LoginServelet
 */
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		Connection conn = null;
		HttpSession session = request.getSession();
		try {
			Class.forName("com.mysql.jdbc.Driver");
            
            //creating connection with the database 
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_login", "root", "abc123abc");
            System.out.println("connected succefully");
            String query = "select * from users where email = ? and password = ? and position = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, position);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	System.out.println("here...");
            	session.setAttribute("name", rs.getString("username"));
            	String pos = rs.getString("position");
            	if(pos.equals("chefDrh"))
            	{
            		dispatcher = request.getRequestDispatcher("chefdrh_dash.jsp");
            	}else if (pos.equals("adminDrh")) {
            		dispatcher = request.getRequestDispatcher("adminDashbord.jsp");
				}else {
					dispatcher = request.getRequestDispatcher("stagiareProfile.jsp");
				}
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
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
