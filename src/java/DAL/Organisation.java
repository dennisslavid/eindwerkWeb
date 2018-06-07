/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author denni
 */
@Entity
@Table(name = "organisation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organisation.findAll", query = "SELECT o FROM Organisation o")
    , @NamedQuery(name = "Organisation.findById", query = "SELECT o FROM Organisation o WHERE o.id = :id")
    , @NamedQuery(name = "Organisation.findByName", query = "SELECT o FROM Organisation o WHERE o.name = :name")
    , @NamedQuery(name = "Organisation.findByStreetAddress", query = "SELECT o FROM Organisation o WHERE o.streetAddress = :streetAddress")
    , @NamedQuery(name = "Organisation.findByZipCode", query = "SELECT o FROM Organisation o WHERE o.zipCode = :zipCode")
    , @NamedQuery(name = "Organisation.findByCity", query = "SELECT o FROM Organisation o WHERE o.city = :city")
    , @NamedQuery(name = "Organisation.findByContactPerson", query = "SELECT o FROM Organisation o WHERE o.contactPerson = :contactPerson")
    , @NamedQuery(name = "Organisation.findByEmail", query = "SELECT o FROM Organisation o WHERE o.email = :email")})
public class Organisation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "streetAddress")
    private String streetAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "zipCode")
    private String zipCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contactPerson")
    private String contactPerson;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organisationID", fetch = FetchType.EAGER)
    private List<Internship> internshipList;

    public Organisation() {
    }

    public Organisation(Integer id) {
        this.id = id;
    }

    public Organisation(Integer id, String name, String streetAddress, String zipCode, String city, String contactPerson, String email) {
        this.id = id;
        this.name = name;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.city = city;
        this.contactPerson = contactPerson;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public List<Internship> getInternshipList() {
        return internshipList;
    }

    public void setInternshipList(List<Internship> internshipList) {
        this.internshipList = internshipList;
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
        if (!(object instanceof Organisation)) {
            return false;
        }
        Organisation other = (Organisation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DAL.Organisation[ id=" + id + " ]";
    }
    
}
