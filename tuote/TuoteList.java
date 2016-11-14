package tuote;

import java.util.*;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;



@ManagedBean
@SessionScoped
public class TuoteList implements java.io.Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Tuote> tuotteet;

    public TuoteList() {
        tuotteet = new ArrayList<Tuote>();
        tuotteet.add(new Tuote("hp elite","#HP1299",900.99));
        tuotteet.add(new Tuote("iphone 7","#IPHONE777",350.42));
        tuotteet.add(new Tuote("Apple watch","#APPLE999",60.9));
        tuotteet.add(new Tuote("External Hardware","#LENOVO888",160.20));
        tuotteet.add(new Tuote("Microsoft Surface Pro","#MS02717",950.99));
    }
    public ArrayList<Tuote> getTuotteet() {
        return tuotteet;
    }
    public void setTuotteet(String nimi, String koodi, double hinta) {
        tuotteet.add(new Tuote(nimi, koodi, hinta));
    }
    
    public String sorted(){
    	Collections.sort(tuotteet, new Comparator<Tuote>() {
            
            public int compare(Tuote tuote1, Tuote tuote2) {
                return tuote1.getNimi().compareTo(tuote2.getNimi());
            }
    	});
    	
    	return tuotteet.toString();
    }

    public String lisaaUusi() {
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		Tuote tuote = (Tuote) ctx.getExternalContext().getRequestMap().get("tuote");
		tuotteet.add(tuote);
		return tuotteet.toString();
		
	}


   
 

}
