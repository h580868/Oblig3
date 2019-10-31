package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GuestEAO {
	
	@PersistenceContext(name = "guestPU")
    private EntityManager em;
	
//	public Klasse hentKlasse(String klassekode) {
//		return em.find(Klasse.class, klassekode);
//	}
	
	public void addGuest(Guest guest) {
		em.persist(guest);
	}
	

	//public List<Deltager> hentDeltagerListe() {
// 		Her utnytter jeg toveis navigasjon!
	//	return em.find(Deltager.class, null).getDeltager();
	//}


}
