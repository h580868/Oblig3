package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "innlogging", urlPatterns = { "inlogging" })
public class InnloggingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DeltagerEAO deltagerEAO;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Deltager d = new Deltager();
		//borde sannolikt spara parameter som variablar först för att validera eller gör vi det bara i JS?
		d.setMobil(request.getParameter("mobil"));
		d.setFornavn(request.getParameter("fornavn"));
		d.setEtternavn(request.getParameter("etternavn"));
		
		deltagerEAO.leggTilDeltager(d);

	}
	
	protected class Validator {

	    public boolean validator(String s) {
	        return s != null
	                && s.length() == 8
	                && s.matches("^[0-9]+$");
	    }
	    }

}
