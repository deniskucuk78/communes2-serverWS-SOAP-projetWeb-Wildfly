package fr.gtm.communes;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.gtm.communes.entities.Commune;
import fr.gtm.communes.entities.Region;

@Singleton
public class CommunesDAO {
	@PersistenceContext(name="communes") private EntityManager em; 
	
	public List<Commune> getCommunesByCp(String cp) {
		return em.createNamedQuery("Commune.byCodePostal", Commune.class)
					.setParameter("codePostal", cp+"%")
					.getResultList();
	}
	
	public List<Region> getRegions() {
		return em.createNamedQuery("Region.all", Region.class).getResultList();
	}

}
