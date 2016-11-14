package book;



import javax.faces.bean.ManagedBean;  

@ManagedBean

public class Book implements java.io.Serializable{

	private String isbn, tekijat, nimi;
    


    public Book() {
        isbn = "123456";
        tekijat = "manu";
    	nimi = "My Book";
        
    }
    
    public Book(String isbn, String tekija, String nimi) {
        this.isbn = isbn;
        this.tekijat = tekija;
    	this.nimi = nimi;
        
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + "  tekijä: " + tekijat + "  nimi: "+nimi;
    }

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String iSBN) {
		isbn = iSBN;
	}

	public String getTekijat() {
		return tekijat;
	}

	public void setTekijat(String tekija) {
		this.tekijat = tekija;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	
   


    
}
