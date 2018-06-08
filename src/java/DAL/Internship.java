package DAL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author denni
 */
@Entity
@Table(name = "internship")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Internship.findAll", query = "SELECT i FROM Internship i")
    , @NamedQuery(name = "Internship.findById", query = "SELECT i FROM Internship i WHERE i.id = :id")
    , @NamedQuery(name = "Internship.findByTitle", query = "SELECT i FROM Internship i WHERE i.title = :title")
    , @NamedQuery(name = "Internship.findByDescription", query = "SELECT i FROM Internship i WHERE i.description = :description")
    , @NamedQuery(name = "Internship.findByStartDate", query = "SELECT i FROM Internship i WHERE i.startDate = :startDate")})
public class Internship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3000)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @JoinColumn(name = "organisationID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Organisation organisationID;

    public Internship() {
    }

    public Internship(Integer id) {
        this.id = id;
    }

    public Internship(Integer id, String title, String description, Date startDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Organisation getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(Organisation organisationID) {
        this.organisationID = organisationID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Internship)) {
            return false;
        }
        Internship other = (Internship) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.Internship[ id=" + id + " ]";
    }
    
}
