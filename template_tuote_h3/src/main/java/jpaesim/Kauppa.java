package jpaesim;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Language
 *
 */
@javax.persistence.Entity
@Table(name = "Kauppa")
public class Kauppa {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	private String nimi;
	private String osoite;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getOsoite() {
		return osoite;
	}
	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}
	@Override
	public String toString() {
		return "Kauppa [Id=" + Id + ", nimi=" + nimi + ", osoite=" + osoite + "]";
	}
	
	
	

}
