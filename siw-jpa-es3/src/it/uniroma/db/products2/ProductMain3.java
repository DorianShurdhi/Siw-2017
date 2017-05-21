package it.uniroma.db.products2;

import javax.persistence.*;

public class ProductMain3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("products-unit");
		EntityManager em = emf.createEntityManager();
		
		Address a1 = new Address("Via di Valleranello", "Rome", null, "00128", "Italy");
		Address a2 = new Address("Via della vittoria", "Terni", null, "05034", "Italy");
		
		Provider prov1 = new Provider("Dollaroni SPA", "info@dollaroni.com", a1);
		Provider prov2 = new Provider("Ching Chong", "inter@milan.cina", null);
		
		Product p1 = new Product("Xiaomi Air 13", 242F, "the best one", "XA13");
		Product p2 = new Product("Mi Band 2", 800F, "Do everything", "MiB2");
		
		prov1.getProducts().add(p1);
		prov1.getProducts().add(p2);
		
		prov2.getProducts().add(p1);

		Customer c1 = new Customer("Lorenzo", "Sullivan", "lg@siw.net", null, a2);
	
		OrderLine ol1 = new OrderLine(p1, 2, 10F);
		OrderLine ol2 = new OrderLine(p2, 1, 50F);
		OrderLine ol3 = new OrderLine(p2, 5, 300F);
		
		Order o1 = new Order();
		Order o2 = new Order();
		
		o1.setCustomer(c1);
		o1.getOrderLines().add(ol1);
		o1.getOrderLines().add(ol2);
		o1.getOrderLines().add(ol3);
		
		o2.setCustomer(c1);
		o2.getOrderLines().add(ol2);
		o2.getOrderLines().add(ol3);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(prov1);
		em.persist(prov2);
		em.persist(p1);
		em.persist(p2);
		em.persist(c1);
		em.persist(ol1);
		em.persist(ol2);
		em.persist(ol3);
		em.persist(o1);
		em.persist(o2);
		
		tx.commit();
		
		em.close();
		emf.close();
	}
}