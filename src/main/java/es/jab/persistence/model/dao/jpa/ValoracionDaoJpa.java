package es.jab.persistence.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;

import es.jab.persistence.model.dao.ValoracionDao;
import es.jab.persistence.model.entities.Tema;
import es.jab.persistence.model.entities.Valoracion;

public class ValoracionDaoJpa extends GenericDaoJpa<Valoracion, Integer> implements ValoracionDao {

	public ValoracionDaoJpa() {
        super(Valoracion.class);
    }
	
	
	public void deleteByTema(int id) {
        EntityManager entityManager = DaoFactoryJpa.getEntityManagerFactory().createEntityManager();
        Tema entity = entityManager.find(Tema.class, id);
        if (entity != null) {
            try {
                entityManager.getTransaction().begin();
                CriteriaBuilder builder = entityManager.getCriteriaBuilder();
                CriteriaQuery<Valoracion> query = builder.createQuery(Valoracion.class);
        		Root<Valoracion> root = query.from(Valoracion.class);
        		query.select(root);
        		query.where(builder.equal(root.get("tema"), entity));
        		TypedQuery<Valoracion> typedQuery = entityManager.createQuery(query);
        		List<Valoracion> valocionesTema = typedQuery.getResultList();
        		
        		for (Valoracion valoracion: valocionesTema) {  
        			entityManager.remove(valoracion);
        		}
                entityManager.getTransaction().commit();
                LogManager.getLogger(GenericDaoJpa.class).debug("delete: " + entity);
            } catch (Exception e) {
                LogManager.getLogger(GenericDaoJpa.class).error("delete: " + e);
                if (entityManager.getTransaction().isActive())
                    entityManager.getTransaction().rollback();
            } finally {
                entityManager.close();
            }
        }
    }

}
