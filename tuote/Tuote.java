package tuote;

import javax.faces.bean.*;
import javax.validation.constraints.*;

@ManagedBean
@SessionScoped
public class Tuote implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Size(min=1,max=40)
	private String nimi;
	@Size(min=1,max=20)
	private String koodi;
	@Min(0)
	@Max(5000)
	private double hinta;

    public Tuote() {
        nimi = "My Tuote";
        koodi =  "9999";
        hinta = 43.90;
    }
    
    public Tuote(String nimi, String koodi, double hinta) {
        this.nimi = nimi;
        this.koodi = koodi;
        this.hinta = hinta;
    }

    @Override
    public String toString() {
        return "tuote: " + nimi + " koodi: " + koodi + ", hinta: " + hinta;
    }
    
    public String getNimi() {
        return nimi;
    }

    public void setName(String nimi) {
        this.nimi = nimi;
    }

    public String getKoodi() {
        return koodi;
    }

    public void setKoodi(String koodi) {
        this.koodi = koodi;
    }
    
    public void setHinta(double hinta){
    	this.hinta = hinta;
    }
    public double getHinta(){
    	return hinta;
    }

    
}
