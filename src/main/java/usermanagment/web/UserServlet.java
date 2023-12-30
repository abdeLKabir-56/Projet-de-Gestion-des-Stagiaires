package usermanagment.web;
import java.io.OutputStream;

import jakarta.servlet.RequestDispatcher;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import AdminOperations.Stagiaire;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import usermanagment.dao.UserDao;
import usermanagment.model.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
        userDao = new UserDao();
    }
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		int count = userDao.countStagiaires();
		request.setAttribute("count", count);
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                case "/view":
                    viewUser(request, response);
                case "/search":
                	searchUser(request, response);
                    break;
                case "/generate-pdf":
                    generatePdfAndRespond(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
	}
	public void listUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException, ServletException {
		        List<Stagiaire> listUser = userDao.getAllStagiaire();
		        request.setAttribute("listStagiaire", listUser);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		        dispatcher.forward(request, response);
		    }
	public void searchUser(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException, ServletException {
	    String search = request.getParameter("searchInput");

	    List<Stagiaire> searchResults = userDao.searchStagiaire(search);

	    // Handle potential errors from DAO
	    if (searchResults == null) {
	        // Show error message or handle appropriately
	        request.setAttribute("errorMessage", "User search failed");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("Error.jsp");
	        dispatcher.forward(request, response);
	        return;
	    }

	    // Store search results and redirect to list page
	    request.setAttribute("listStagiaire", searchResults);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
	    dispatcher.forward(request, response);
	}
	
  
	public void showNewForm(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		        dispatcher.forward(request, response);
		    }

		    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, ServletException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        Stagiaire existingUser = userDao.getStagiaire(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		        request.setAttribute("user", existingUser);
		        dispatcher.forward(request, response);

		    }
		    private void viewUser(HttpServletRequest request, HttpServletResponse response)
				    throws SQLException, ServletException, IOException {
				        int id = Integer.parseInt(request.getParameter("id"));
				        Stagiaire existingUser = userDao.getStagiaire(id);
				        RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
				        request.setAttribute("user", existingUser);
				        dispatcher.forward(request, response);

				 }
		    public void insertUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    	
		    	String nom = request.getParameter("nom");
		        String prenom = request.getParameter("prenom");
		        String cin = request.getParameter("CIN");
		        String etablissment = request.getParameter("etablissment");
		        String filiere = request.getParameter("filiere");
		        String adresse = request.getParameter("adresse");
		        String numero_tele = request.getParameter("numero_tele");
		        String stage = request.getParameter("stage");

		        Stagiaire newStagiaire = new Stagiaire(nom, prenom, cin, etablissment, filiere, adresse, numero_tele, stage);
		        userDao.saveStagiaire(newStagiaire);
		        response.sendRedirect("list");
		    }

		    public void updateUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        String nom = request.getParameter("nom");
		        String prenom = request.getParameter("prenom");
		        String cin = request.getParameter("CIN");
		        String etablissment = request.getParameter("etablissment");
		        String filiere = request.getParameter("filiere");
		        String adresse = request.getParameter("adresse");
		        String numero_tele = request.getParameter("numero_tele");
		        String stage = request.getParameter("stage");
		        Stagiaire newStagiaire = new Stagiaire(id,nom, prenom, cin, etablissment, filiere, adresse, numero_tele, stage);
		        userDao.updateStagiaire(newStagiaire);
		        response.sendRedirect("list");
		    }

		    public void deleteUser(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        int id = Integer.parseInt(request.getParameter("id"));
		        userDao.deleteStagiaire(id);
		        response.sendRedirect("list");
		    }
		    public void generatePdfAndRespond(HttpServletRequest request, HttpServletResponse response)
		            throws SQLException, IOException {
		        List<Stagiaire> listStagiaire = userDao.getAllStagiaire();

		        // Set the response content type
		        response.setContentType("application/pdf");

		        // Set the header to force download
		        response.setHeader("Content-Disposition", "attachment; filename=stagiaireList.pdf");

		        try (OutputStream out = response.getOutputStream()) {
		            generatePdf(listStagiaire, out);
		            out.flush();
		        } catch (Exception e) {
		            e.printStackTrace();
		            // Handle exception appropriately
		            response.getWriter().write("Error generating PDF");
		        }
		    }

		    private void generatePdf(List<Stagiaire> stagiaireList, OutputStream outputStream) {
		        Document document = new Document();

		        try {
		            PdfWriter.getInstance(document, outputStream);
		            document.open();

		            PdfPTable table = new PdfPTable(9);  // Adjust the number of columns
		            table.setWidthPercentage(100);

		            addTableHeader(table);
		            addRows(table, stagiaireList);

		            document.add(table);
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            document.close();
		        }
		    }

		    private void addTableHeader(PdfPTable table) {
		        String[] headers = {"ID", "Nom", "Prenom", "CIN", "Etablissment", "Filiere", "Adresse", "Numero Tele", "Stage"};
		        for (String header : headers) {
		            PdfPCell cell = new PdfPCell(new Paragraph(header));
		            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            table.addCell(cell);
		        }
		    }

		    private void addRows(PdfPTable table, List<Stagiaire> stagiaireList) {
		        for (Stagiaire stagiaire : stagiaireList) {
		            table.addCell(String.valueOf(stagiaire.getId()));
		            table.addCell(stagiaire.getNom());
		            table.addCell(stagiaire.getPrenom());
		            table.addCell(stagiaire.getCIN());
		            table.addCell(stagiaire.getEtablissment());
		            table.addCell(stagiaire.getFiliere());
		            table.addCell(stagiaire.getAdresse());
		            table.addCell(stagiaire.getNumero_tele());
		            table.addCell(stagiaire.getStage());
		        }
		    }

}
