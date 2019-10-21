package no.hvl.dat108;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "liste", urlPatterns = {"liste"})
public class ListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	StudentEAO studentEAO;
       
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		/* Todo
		 * sjekk om innlogged if(!innloggingUtil.erInlogget(){ 
		 * använd egna klasser för att minska rot
		 * {else{ redirect til /inlogging + felmedelande}
		 * DeltagerEAO deltagerEAO
		 * deltagerEAO. hentUtAlleDeltagere
		 * sortering, alfabetiskordning?
		 * sortera två gånger med hjälp av comparator en gång på fornavn en på efternavn
		 * formatering? skicka över till annat objekt/extra GETs för formaterad info
		 * forward till WEB-INF/deltagerliste.jsp
		 * ta vare på deltagerliste(från databas) i request
		 * 
		 * web.xml
		 * 
		 */
		String klassekode = request.getParameter("klassekode");
		
		List<Student> liste = studentEAO.hentKlasselisteFor(klassekode);
		
		response.setContentType("text/plain");
		
		PrintWriter out = response.getWriter();
		
		liste.forEach(out::println);
	}
}
