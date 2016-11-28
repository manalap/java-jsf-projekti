package jpaharkat;

import javax.persistence.*;



import java.util.*;

/*
 Harjoituksissa voi käyttää pohjana esimerkkejä, joita löytyy osoitteesta:
 
 http://www.objectdb.com/java/jpa/query/execute
 
 1. Lisätään JPA-luokkaan SimpleEntity uusi ominaisuus.
 
 String desc;
  
  Muuta ohjelmaa siten, että saat tallennettua tiedot tietokantaan.

2. Haku - haetaan ja tulostetaan kaikki kannassa olevat SimpleEntity-entiteetit
Käytetään metodia createNamedQuery("selectAll")

3. Haku 

Haetaan ja tulostetaan kaikki kannassa olevat kirjaimella K alkavat entiteetit.
Tehdään haku käyttäen TypedQuery -luokkaa

		TypedQuery<String> kysely = manageri.createQuery("kysely", TulosLuokkasi.class);
		List<String> tulokset = kysely.getResultList();


4. Haku 
haetaan ja tulostetaan kaikki kannassa olevat kirjaimen A sisältävät entiteetit


5. Haku - Käytätään parametrisoitua kyselyä, jossa kyselylle voidaan antaa parametri

kysely.setParameter("name", "%l%").getResultList();

		
6. Poista kaikki ne, jotka sisältävät ä-kirjaimen ja  poista myös ne rivit, jotka sisältävät l-kirjaimen.
Tee ensin kysely.

*/

class Main {
	public static void main(String[] args) throws Exception {
		 // Startataan H2 TCP-serverimoodissa
         org.h2.tools.Server server = org.h2.tools.Server.createTcpServer().start();


		EntityManagerFactory tehdas = Persistence
				.createEntityManagerFactory("jpa_SimpleEntity_harjoitus");
		EntityManager manageri = tehdas.createEntityManager();

		EntityTransaction transaktio = manageri.getTransaction();

		transaktio.begin();

		SimpleEntity p1 = new SimpleEntity();
		p1.setName("Kurre");
		p1.setDesc("Merkki 1");
		SimpleEntity p2 = new SimpleEntity();
		p1.setName("pekka");
		p1.setDesc("Merkki 2");
		SimpleEntity p3 = new SimpleEntity();
		p1.setName("Kukka");
		p1.setDesc("Merkki 3");
		SimpleEntity p4 = new SimpleEntity();
		p1.setName("pekka");
		p1.setDesc("Merkki 4");
		
		
	 
		for(int i=0;i<10;i++){
			SimpleEntity p = new SimpleEntity("kalle",String.valueOf(i));
			manageri.persist(p);
		}
	 
		manageri.persist(p1);
		manageri.persist(p2);
		manageri.persist(p3);
		manageri.persist(p4);

		transaktio.commit();
		
		// 1. Lisätään JPA-luokkaan uusi ominaisuus. Muuta ohjelmaa siten, että saat
		// tallennettua tiedot tietokantaan.

		// 2. Haku - haetaan ja tulostetaan kaikki kannassa olevat
		// SimpleEntity-entiteetit
		@SuppressWarnings("unchecked")
		List<SimpleEntity> entiteetit = manageri.createNamedQuery("selectAll")
				.getResultList();
		for (SimpleEntity e : entiteetit) {
			System.out.println("Rivi: " + e);
		}
		
		System.out.println("************ p kirjaimella alkavat nimet ****************");
		
		TypedQuery<String> query = manageri.createQuery(
				"SELECT p.name FROM SimpleEntity AS p where p.name LIKE 'p%'",
				String.class);
		List<String> result = query.getResultList();
		
		System.out.println("p:   ");
		for (String t : result) {
			System.out.println(t);
		}		
		
		System.out.println("************** Remove ***********************************");
		@SuppressWarnings("unchecked")
		List<SimpleEntity> entity = manageri.createQuery("select p from SimpleEntity p"
				+ " where p.name like 'p%'")
				.getResultList();
		for (SimpleEntity e : entity) {
			System.out.println("Rivi: " + e.getName() +" Removed !");
			transaktio.begin();
			manageri.remove(e);
			transaktio.commit();
			
		}

			    
						
		manageri.close();
		tehdas.close();

        // Lopetetaan h2-palvelin
        server.stop();

	}
}