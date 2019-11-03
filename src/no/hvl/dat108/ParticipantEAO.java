package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ParticipantEAO {
	
	@PersistenceContext(name = "guestPU")
    private EntityManager em;
	
//	public Klasse hentKlasse(String klassekode) {
//		return em.find(Klasse.class, klassekode);
//	}
	
	public void addParticipant(Participant participant) {
		em.persist(participant);
	}
	

	//public List<Participant> getListOfParticipants() {
// 		Her utnytter jeg toveis navigasjon!
	//return em.find(Participant.class, null).getParticipant();
	//}


}
