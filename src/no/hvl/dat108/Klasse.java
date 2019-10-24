package no.hvl.dat108;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "f15demo", name = "klasse")
public class Klasse {

    @Id
    private String kode;
    private String program;

    @OneToMany(mappedBy = "klasse")
    private List<Deltager> studenter;
    
	public String getKode() {
		return kode;
	}

	public String getProgram() {
		return program;
	}

	public List<Deltager> getStudenter() {
		return studenter;
	}
    
    public void addStudent(Deltager s) {
    	studenter.add(s);
    }
    
}