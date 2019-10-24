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

	// Jeg burde *absolutt* brukt doPost her, men da m�tte jeg
	// laget en html-side med en <form> for � kj�re den.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Deltager d = new Deltager();
		d.setMobil("34546789");
		d.setFornavn("Donald");
		d.setEtternavn("Trump");
		deltagerEAO.leggTilDeltager(d);

	}

}
