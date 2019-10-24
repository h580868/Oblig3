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
		
//		Klasse klasse = hentKlasse("17hData");
//		evt. inlinet som:
//		Klasse klasse = em.find(Klasse.class, klassekode);
//		s.setKlasse(klasse);
//		klasse.addStudent(s);
		
		em.persist(d);
	}
	

//		public List<Deltager> hentKlasselisteFor(String klassekode) {
// 		Her utnytter jeg toveis navigasjon!
//		return em.find(Klasse.class, klassekode).getStudenter();
//	}
	
// Alt for tungvint:
//	public List<Student> hentKlasselisteFor2(String klassekode) {
//		TypedQuery<Student> query = em.createQuery(
//				"SELECT s FROM Student s WHERE s.klasse.kode = :klassekode", Student.class);
//		query.setParameter("klassekode", klassekode);
//		return query.getResultList();
//	}

}
