package dao;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Libro;

@Model
//requires_new
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
//prova con 1 o piu transazioni contemporane
public class LibroDao implements Dao<Libro>{
	//The name of the persistence unit as defined in the persistence.xml file. 
	//If the unitName element is specified, the persistence unit for the entity manager that is accessible in JNDI must have the same name.
	@PersistenceContext(unitName = "persistenceUnit1")
	private EntityManager em;

	@Override
	public Libro get(int id) {		
		Libro libroVar = em.find(Libro.class, id);
		return libroVar;
	}

	@Override
	public List<Libro> getAll() {
		return em.createNamedQuery("findAllLibri", Libro.class)
				.getResultList();
	}

	@Override
	public void save(Libro libroNuovo) {
		//padrone esiste nel DB?
		Libro libroEsistente = em.find(Libro.class, libroNuovo.getId_libro());
		if(libroEsistente != null) {
		// entita gia esiste nel DB
			libroEsistente.setTitolo(libroNuovo.getTitolo());
			//libroEsistente.setIdAutore(libroNuovo.getIdAutore());
			libroEsistente.setNumeroPagine(libroNuovo.getNumeroPagine());
		em.merge(libroEsistente);

		 } else {
		// entita prima volta che la vedo nel DB!
		em.persist(libroNuovo);
		}
		}
//	@Override
	public void update(Libro t) {//
		em.merge(t);
	}

//	@Override
	public void delete(Libro t) {
		em.remove(t);
	}

	@Override
	public void update(Libro t, String[] params) {
		// TODO Auto-generated method stub
		
	}

}
