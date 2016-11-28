package jpaesim;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

public class TestTuoteKauppaSuhde {

	public static void main(String[] args) throws Exception {
     	// Startataan H2 TCP-serverimoodissa
        org.h2.tools.Server server = org.h2.tools.Server.createTcpServer().start();


		EntityManagerFactory tehdas = Persistence.createEntityManagerFactory("jpa_tuote");
		EntityManager manageri = tehdas.createEntityManager();
		EntityTransaction transaktio = manageri.getTransaction();

		transaktio.begin();
		
		Tuote t1 = new Tuote();
		t1.setNimi("Pesäpallo");
		t1.setHinta(15.56);
		t1.setKoodi("A321");

		Tuote t2 = new Tuote();
		t2.setNimi("Jalkapallo");
		t2.setHinta(19.99);
		t2.setKoodi("A654");

		Tuote t3 = new Tuote();
		t3.setNimi("Koripallo");
		t3.setHinta(24.99);
		t3.setKoodi("B342");
		
		
		manageri.persist(t1);
		manageri.persist(t2);
		manageri.persist(t3);
		
		Kauppa k1 = new Kauppa();
		k1.setNimi("Palloliike");
		k1.setOsoite("Pallokuja 2, Helsinki");
		Kauppa k2 = new Kauppa();
		k2.setNimi("Välineaitta");
		k2.setOsoite("Kauppatie 45, Jyväskylä");

		Kauppa k3 = new Kauppa();
		k3.setNimi("Verkkosportti");
		k3.setOsoite("Kuplahallintie 15, Toijala");

		manageri.persist(k1);
		manageri.persist(k2);
		manageri.persist(k3);
		
		
		
		transaktio.commit();
		
		
		 //Tuotteiden ja kauppien tulostus
        @SuppressWarnings("unchecked")
		List<Tuote> tuotteet = manageri.createNamedQuery("selectTuotteet")
				.getResultList();
		for (Tuote t : tuotteet) {
			System.out.println("Rivi: " + t.getNimi());
		} 
		
		 @SuppressWarnings("unchecked")
			List<Kauppa> kauppaat = manageri.createNamedQuery("selectKauppaat")
					.getResultList();
			for (Kauppa t : kauppaat) {
				System.out.println("Rivi: " + t.toString());
			} 
		
		
		manageri.close();
		tehdas.close();
		// Lopetetaan h2-palvelin
        server.stop();
	}
}
