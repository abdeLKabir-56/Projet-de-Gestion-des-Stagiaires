package Registration;

import jakarta.servlet.ServletException;
import com.itextpdf.text.Document;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class generatePdf
 */
public class generatePdf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public generatePdf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=attestation.pdf");

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();

            // Add content to the PDF
            document.add(new Paragraph("Daily Briefing Sheet"));
            document.add(new Paragraph("Name: " + request.getParameter("name")));
            document.add(new Paragraph("User Id: " + request.getParameter("userId")));
            document.add(new Paragraph("Email: " + request.getParameter("email")));
            document.add(new Paragraph("Phone: " + request.getParameter("phone")));
            document.add(new Paragraph("Profession: " + request.getParameter("profession")));

            document.close();
        } catch (Exception e) {
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
