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
	GuestEAO guestEAO;


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
		String username = request.getParameter("username");

	    if (username == null || !Validator.isValidUsername(username)) {
	        response.sendRedirect(LOGIN_URL + "?invalidUsername");
	    } else {

	        HttpSession sesjon = request.getSession(false);
	        if (sesjon != null) {
	            sesjon.invalidate();
	        }
	        sesjon = request.getSession(true);
	        sesjon.setMaxInactiveInterval(10);

	        sesjon.setAttribute("username", username);
	        sesjon.setAttribute("cart", new Cart());

	        response.sendRedirect(WEBSHOP_URL);
	    }
		Guest guest = new Guest();
		//borde sannolikt spara parameter som variablar först för att validera eller gör vi det bara i JS?
		guest.setMobil(request.getParameter("mobil"));
		guest.setFornavn(request.getParameter("fornavn"));
		guest.setEtternavn(request.getParameter("etternavn"));
		
		guestEAO.addGuest(guest);

	}
	
	protected class Validator {

	    public boolean validator(String s) {
	        return s != null
	                && s.length() == 8
	                && s.matches("^[0-9]+$");
	    }
	    }

}

