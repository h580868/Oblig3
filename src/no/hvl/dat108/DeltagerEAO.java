package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DeltagerEAO {
	
	@PersistenceContext(name = "deltagerPU")
    private EntityManager em;
	
//	public Klasse hentKlasse(String klassekode) {
//		return em.find(Klasse.class, klassekode);
//	}
	
	public void leggTilDeltager(Deltager d) {
		em.persist(d);
	}
	

	//public List<Deltager> hentDeltagerListe() {
// 		Her utnytter jeg toveis navigasjon!
	//	return em.find(Deltager.class, null).getDeltager();
	//}


}
