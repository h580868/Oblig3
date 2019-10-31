package no.hvl.dat108;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;

@WebServlet("/registration" )
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistrationServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO forward to WEB-INF/paamelding.jsp + plocka upp data och felmedelanden
		
	} 
	

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
		 */
		
		
		RequestDispatcher dispatcher;
		//if (isRegistered || !allFieldsOk) {
		// dispatcher = getServletContext().getNamedDispatcher("registration");	
		//} else {
		dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp"); //change to login later
	//}
		
		dispatcher.forward(request, response);
		//doGet(request, response);
	}

}
