/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ACER
 */
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
@Table(name = "status_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusRegistration.findAll", query = "SELECT s FROM StatusRegistration s")})
public class StatusRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "status_registration_id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "status_registration_name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusRegistration", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Registration> registrationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusRegistration", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<HistoryRegistration> historyRegistrationList;

    public StatusRegistration() {
    }

    public StatusRegistration(Integer statusRegistrationId) {
        this.id = statusRegistrationId;
    }

    public StatusRegistration(Integer statusRegistrationId, String statusRegistrationName) {
        this.id = statusRegistrationId;
        this.name = statusRegistrationName;
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

    @XmlTransient
    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    @XmlTransient
    public List<HistoryRegistration> getHistoryRegistrationList() {
        return historyRegistrationList;
    }

    public void setHistoryRegistrationList(List<HistoryRegistration> historyRegistrationList) {
        this.historyRegistrationList = historyRegistrationList;
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
        if (!(object instanceof StatusRegistration)) {
            return false;
        }
        StatusRegistration other = (StatusRegistration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mii.co.id.servertrainingmanagement.entities.StatusRegistration[ statusRegistrationId=" + id + " ]";
    }
    
}
