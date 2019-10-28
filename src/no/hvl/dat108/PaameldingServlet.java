package no.hvl.dat108;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;

@WebServlet(name="paamelding" , urlPatterns= {"paamelding"})
public class PaameldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaameldingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO forward to WEB-INF/paamelding.jsp + plocka upp data och felmedelanden
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* TODO 
		 * hemta alla parametrar (i ett objekt snarare än enskilda variablar kanske)
		 * validera alla parametrar
		 * 
		 * if(!allaErGyldige || erPaameltFraFor) {
		 * göra klar felmedelanden ++
		 * redirekt till sig själv
		 * 
		 * Hovedide: ...
		 * 
		 * 
		 * }else{
		 * generera passwordSalt
		 * Hash password
		 * 
		 * DeltagarObjekt
		 * 
		 * melde på festen (+ exception handling?)
		 * - registrera i databasen
		 * -
		 * logga in (InloggingsUtil...)
		 * redirect till bekreftelse(kan göra forward)
		 * 
		 * 
		 * 
		 */
		doGet(request, response);
	}

}
