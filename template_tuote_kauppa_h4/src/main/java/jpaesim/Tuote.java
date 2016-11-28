package jpaesim;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Language
 *
 */
@javax.persistence.Entity
@Table(name = "TUOTE2")
@NamedQuery(name = "selectTuotteet", query = "SELECT t from Tuote t")
//@NamedQuery(name = "selectKauppaat", query = "SELECT t from Kauppa t")

public class Tuote implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nimi;
	private String koodi;
	private double hinta;
	
	
	
	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getKoodi() {
		return koodi;
	}

	public void setKoodi(String koodi) {
		this.koodi = koodi;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	// Määrittelee tuote - kauppa suhteen 1 - n 
	@OneToMany // ( targetEntity=Kauppa.class )
	private List<Kauppa> kaupat;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
