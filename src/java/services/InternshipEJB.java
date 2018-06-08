package services;

import DAL.Internship;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author denni
 */
@Stateless
public class InternshipEJB {

    @PersistenceContext(unitName = "internshipWebPU")
    private EntityManager em;
    
    public List<Internship> getAllInternships() {
        List<Internship> resultList;
        em.getEntityManagerFactory().getCache().evictAll();
        Query query = em.createNamedQuery("Internship.findAll");
        resultList = query.getResultList();
        return resultList;
    }
    
    public Internship getInternshipById(int id) {
        em.getEntityManagerFactory().getCache().evictAll();
        Internship result = em.find(Internship.class, id);
        return result;
    }
    
    public List<Internship> searchInternships(String searchQuery) {
        List<Internship> all = this.getAllInternships();
        List<Internship> result = new ArrayList<>();
        all.forEach((i) -> {
            String searchable = i.toSearchableString();
            if (searchable.contains(searchQuery.toLowerCase())) {
                result.add(i);
            }
        });
        return result;
    }
}
