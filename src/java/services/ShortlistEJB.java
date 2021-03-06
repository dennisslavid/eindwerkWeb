package services;

import DAL.Internship;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

/**
 *
 * @author denni
 */
@Stateful
@StatefulTimeout(value = 5, unit = TimeUnit.MINUTES)
public class ShortlistEJB {
    
    private final List<Internship> shortlist = new ArrayList<>();
    
    public List<Internship> getShortlist() {
        return shortlist;
    }
    
    public void addToShortlist(Internship internship) {
        shortlist.add(internship);
    }
    
    public boolean containsInternship(final int id){
        return shortlist.stream().filter(o -> o.getId().equals(id)).findFirst().isPresent();
    }
    
    public void removeFromShortlist(int index) {
        shortlist.remove(index);
    }
}
