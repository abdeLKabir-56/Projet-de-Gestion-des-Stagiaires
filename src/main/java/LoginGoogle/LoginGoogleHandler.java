package LoginGoogle;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import Persistance.DBConnexion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.catalina.connector.ClientAbortException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;
/**
 * Servlet implementation class loginGoogleHandler
 */

public class LoginGoogleHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection conn = new DBConnexion().getconnexion();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginGoogleHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String accessToken = getToken(code);
		UserGoogleDto user = getUserInfo(accessToken);
		System.out.println(user);
	}

	public static String getToken(String code) throws ClientAbortException, IOException {
		// call api to get token
		String response = Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
				.bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
						.add("client_secret", Constants.GOOGLE_CLIENT_SECRET)
						.add("redirect_uri", Constants.GOOGLE_REDIRECT_URI).add("code", code)
						.add("grant_type", Constants.GOOGLE_GRANT_TYPE).build())
				.execute().returnContent().asString();

		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
		return accessToken;
	}

	public static UserGoogleDto getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		String link = Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
		String response = Request.Get(link).execute().returnContent().asString();

		UserGoogleDto googlePojo = new Gson().fromJson(response, UserGoogleDto.class);

		return googlePojo;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
		
		String accessToken = getToken(code);
		UserGoogleDto user = getUserInfo(accessToken);
		System.out.println(user);
		request.setAttribute("google_email", user.getEmail());
		//Connection conn = null;
		String password = null;
		try {
			
            String query = "select password from users where email = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setString(1, user.getEmail());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
            	
            	 password = rs.getString("password");
            	
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		request.setAttribute("google_password", password);
		request.setAttribute("picture", user.getPicture());
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
