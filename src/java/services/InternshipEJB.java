package services;

import DAL.Internship;
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
        Query query = em.createNamedQuery("Internship.findAll");
        resultList = query.getResultList();
        return resultList;
    }
    
    public Internship getInternshipById(int id) {
        Internship result = em.find(Internship.class, id);
        return result;
    }
}
