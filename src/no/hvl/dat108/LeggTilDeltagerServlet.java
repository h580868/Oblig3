package no.hvl.dat108;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "leggtil", urlPatterns = {"leggtil"})
public class LeggTilDeltagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DeltagerEAO studentEAO;

	//Jeg burde *absolutt* brukt doPost her, men da m�tte jeg
	//laget en html-side med en <form> for � kj�re den.
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		Deltager s = new Deltager();
		s.setId("3456789");
		s.setNavn("Donald");
		studentEAO.leggTilStudent(s, "17hData");
		
	}

}
