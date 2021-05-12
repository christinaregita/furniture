/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ACER
 */
@Entity
@Table(name = "history_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoryRegistration.findAll", query = "SELECT h FROM HistoryRegistration h")})
public class HistoryRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "history_registration_id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "registration_id", referencedColumnName = "registration_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Registration registration;
    @JoinColumn(name = "status_registration_id", referencedColumnName = "status_registration_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StatusRegistration statusRegistration;

    public HistoryRegistration() {
    }

    public HistoryRegistration(Integer historyRegistrationId) {
        this.id = historyRegistrationId;
    }

    public HistoryRegistration(Integer historyRegistrationId, Date date) {
        this.id = historyRegistrationId;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public StatusRegistration getStatusRegistration() {
        return statusRegistration;
    }

    public void setStatusRegistration(StatusRegistration statusRegistration) {
        this.statusRegistration = statusRegistration;
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
        if (!(object instanceof HistoryRegistration)) {
            return false;
        }
        HistoryRegistration other = (HistoryRegistration) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mii.co.id.servertrainingmanagement.entities.HistoryRegistration[ historyRegistrationId=" + id + " ]";
    }
    
}
