package no.hvl.dat108;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	ParticipantEAO participantEAO;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String loginMessage = "";
		    
		    if (request.getParameter("requiresLogin") != null) {
		    	loginMessage = "Foresporselen krever pålogging. ";
		    	
		    } else if (request.getParameter("invalidUsername") != null) {
		    	loginMessage = "Manglende eller ugyldig brukernavn"; 
		    }

		    request.setAttribute("loginMessage", loginMessage);
		    
		    request.getRequestDispatcher("WEB-INF/login.jsp")
		    		.forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fornavn = request.getParameter("fornavn");
		String etternavn = request.getParameter("etternavn");

	    if (!Validator.isValidName(fornavn) || !Validator.isValidName(etternavn)) {
	        response.sendRedirect("" + "?invalidUsername");
	    } else {

	        HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.invalidate();
	        }
	        session = request.getSession(true);
	        session.setMaxInactiveInterval(10);

	       // session.setAttribute("username", username);
	        //sesjon.setAttribute("cart", new Cart());

	        //response.sendRedirect(WEBSHOP_URL);
	    }
	    char Kjonn =request.getParameter("kjonn").charAt(0);
	    
	    
		Participant participant = new Participant();
		//borde sannolikt spara parameter som variablar först för att validera eller gör vi det bara i JS?
		participant.setMobil(request.getParameter("mobil"));
		participant.setPassord(request.getParameter("passord"));
		participant.setFornavn(request.getParameter("fornavn"));
		participant.setEtternavn(request.getParameter("etternavn"));
		participant.setKjonn(request.getParameter("kjonn").charAt(0));
		
		
		participantEAO.addParticipant(participant);

	}
	

}

