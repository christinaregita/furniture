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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import mii.co.id.servertrainingmanagement.dto.StatusPresence;

/**
 *
 * @author ACER
 */
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
@Table(name = "presences")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presence.findAll", query = "SELECT p FROM Presence p")})
public class Presence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "presence_id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "status_presence")
    @Enumerated(EnumType.STRING)
    private StatusPresence statusPresence;
    @JoinColumn(name = "presence_id", referencedColumnName = "registration_id", insertable = false, updatable = false)
    @OneToOne(optional = true, fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Registration registration;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presence", fetch = FetchType.LAZY)
//    private List<HistoryPresence> historyPresenceList;
//    @JoinColumn(name = "status_presence_id", referencedColumnName = "status_presence_id")
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
//    private StatusPresence statusPresence;

    public Presence() {
    }

    public Presence(Integer presenceId) {
        this.id = presenceId;
    }

    public Presence(Integer id, StatusPresence statusPresence) {
        this.id = id;
        this.statusPresence = statusPresence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatusPresence getStatusPresence() {
        return statusPresence;
    }

    public void setStatusPresence(StatusPresence statusPresence) {
        this.statusPresence = statusPresence;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
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
        if (!(object instanceof Presence)) {
            return false;
        }
        Presence other = (Presence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mii.co.id.servertrainingmanagement.entities.Presence[ presenceId=" + id + " ]";
    }

}

