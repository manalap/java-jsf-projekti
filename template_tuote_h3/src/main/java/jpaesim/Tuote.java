package jpaesim;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Language
 *
 */
@javax.persistence.Entity
@Table(name = "TUOTE")
@NamedQuery(name = "selectAll", query = "SELECT t from Tuote t")
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

	@Override
	public String toString() {
		return "Tuote [id=" + id + ", nimi=" + nimi + ", koodi=" + koodi + ", hinta=" + hinta + "]";
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
