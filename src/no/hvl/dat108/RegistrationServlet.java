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
import javax.servlet.http.HttpSession;
import javax.ejb.EJB;

@WebServlet(name ="registration", urlPatterns="/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	ParticipantEAO participantEAO; //should this be here?
       
    
    public RegistrationServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO forward to WEB-INF/paamelding.jsp + plocka upp data och felmedelanden
		RequestDispatcher dispatcher;
		
		dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp"); //change to login later
		dispatcher.forward(request, response);
				//doGet(request, response);
	} 
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fornavn =    request.getParameter("fornavn");
		String etternavn =  request.getParameter("etternavn");
		String password =   request.getParameter("passord");
		String mobilnr =    request.getParameter("mobil");
	//	String kjonn =      request.getParameter("kjonn");
		
		 if (!Validator.isValidName(fornavn) || !Validator.isValidName(etternavn)) {
		        response.sendRedirect("" + "?invalidUsername");
		        
		 }else if(!Validator.isValidMobile(mobilnr)) { //se om mobiltel finns från förr?
			 response.sendRedirect("" + "?invalidMobileNumber");
			 
		 }else if(!Validator.isValidPass(password)) {
			 response.sendRedirect("" + "?invalidPassword"); 
		        	
		        }else {

		            HttpSession session = request.getSession(false);
		            if (session != null) {
		                session.invalidate();
		            }
		            session = request.getSession(true);
		            session.setMaxInactiveInterval(10);
		            
		            //Generate passwordSalt
		            //Hash password
		            
		            Participant participant = new Participant();
		    		//borde sannolikt spara parameter som variablar först för att validera eller gör vi det bara i JS?
		    		participant.setMobil(mobilnr);
		    		participant.setPassord(password);
		    		participant.setFornavn(fornavn);
		    		participant.setEtternavn(etternavn);
		    		participant.setKjonn(request.getParameter("kjonn").charAt(0));
		    		
		    		
		    		participantEAO.addParticipant(participant);
		    		request.getRequestDispatcher("confirmation").forward(request, response);
		            //join the party, + exception handeling
		            //register in DB
		            
		           // login (inloggingsUtil)
		            
		            //redirect or forward to confirmationServlet
		            //

		        	doGet(request, response);
		    }
		
		}
	}

