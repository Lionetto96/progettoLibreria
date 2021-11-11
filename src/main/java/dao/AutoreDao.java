package dao;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Autore;

@Model
public class AutoreDao implements Dao<Autore>{
	
	@PersistenceContext(unitName = "persistenceUnit1") // tipo 'inject'
	private EntityManager em;
	
	public Autore get(int id) {
		return em.find(Autore.class, id);
	}

//	@Override
	public List<Autore> getAll() {
		return em.createNamedQuery("findAllAutori", Autore.class)
				.getResultList();
	}

//	@Override
	public void save(Autore autoreNuovo) {
		//autore esiste nel DB?
		Autore autoreEsistente = em.find(Autore.class, autoreNuovo.getId());
		if(autoreEsistente != null) {
		// entita gia esiste nel DB
			autoreEsistente.setNome(autoreNuovo.getNome());
			autoreEsistente.setCognome(autoreNuovo.getCognome());
			
			em.merge(autoreEsistente);

		 } else {
		// entita prima volta che la vedo nel DB!
			 em.persist(autoreNuovo);
		}
		}
//	@Override
	public void update(Autore t) {//
		em.merge(t);
	}

//	@Override
	public void delete(Autore t) {
		em.remove(t);
	}

	@Override
	public void update(Autore t, String[] params) {
		// TODO Auto-generated method stub
		
	}
}
