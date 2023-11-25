package Registration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/**
 * Servlet implementation class RegistrationServelet
 */

public class RegistrationServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		String repeat_password=request.getParameter("re_pass");
		String contact=request.getParameter("contact");
		String position=request.getParameter("postion");
		RequestDispatcher dispatcher = null;
		Connection conn = null;
		//String checkbox=request.getParameter("agree-term");
//		out.write(name);
//		out.write(email);
//		out.write(password);
//		out.write(repeat_password);
//		out.write(contact);
//		out.write(position);
		try {
			Class.forName("com.mysql.jdbc.Driver");
            
            //creating connection with the database 
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users_login", "root", "abc123abc");
            System.out.println("connected succefully");
            String query="INSERT INTO users (username,password,email,numero_tele,position) VALUES(?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, contact);
            ps.setString(5, position);
            int i = ps.executeUpdate();
            dispatcher = request.getRequestDispatcher("registration.jsp");
            if(i>0)
            {
            	request.setAttribute("status", "success");
            	//dispatcher = request.getRequestDispatcher("login.jsp");
            }else {
            	request.setAttribute("status", "failed");
			}
            dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//clear the resources
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