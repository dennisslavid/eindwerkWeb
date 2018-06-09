package services;

import DAL.Internship;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author denni
 */
@Stateful
public class ShortlistEJB {
    
    private final ArrayList shortlist = new ArrayList<>();
    
    public List<Internship> getShortlist() {
        return this.shortlist;
    }
    
    public void addToShortlist(Internship internship) {
        this.shortlist.add(internship);
    }
}
