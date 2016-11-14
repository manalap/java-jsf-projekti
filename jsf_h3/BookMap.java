package book;

import java.util.*;

import javax.faces.bean.*;



@ManagedBean
public class BookMap implements java.io.Serializable{
	
		private TreeMap<String, Book> kirjat;
	
	public BookMap(){
		kirjat = new TreeMap<String, Book>();
		
        Book kirja1 = new Book();
        kirja1.setIsbn("951-0-23861-9");
        kirja1.setTekijat("Arto Paasilinna");
        kirja1.setNimi("Hirnuva maailmanloppu: kylmäverinen totuus suomenhevostenjalostuksen yltiöpäisistä saavutuksista");
        Book kirja2 = new Book();
        kirja2.setIsbn("951-1-05939-4");
        kirja2.setTekijat("Veikko Huovinen");
        kirja2.setNimi("Koirankynnen leikkaaja");
        Book kirja3 = new Book();
        kirja3.setIsbn("951-1-762-102-7");
        kirja3.setTekijat("Tietotekniikan liiton sanastoryhmä");
        kirja3.setNimi("ATK-sanakirja");
        Book kirja4 = new Book();
        kirja4.setIsbn("978-951-846-264-7");
        kirja4.setTekijat("Ari Rantala");
        kirja4.setNimi("Web-ohjelmointi");
        kirjat.put(kirja1.getIsbn(), kirja1);
        kirjat.put(kirja2.getIsbn(), kirja2);
        kirjat.put(kirja3.getIsbn(), kirja3);
        kirjat.put(kirja4.getIsbn(), kirja4);
		
	}


	
	
	public ArrayList<Book> getBookList() {
		
		ArrayList<Book> kirjalista = new ArrayList<Book>(kirjat.values());
		for(Map.Entry<String,Book> entry : kirjat.entrySet()){
			Book kirja = entry.getValue();
		kirjalista.add(kirja);
		
		}
		
		return kirjalista;
	}
	

}
