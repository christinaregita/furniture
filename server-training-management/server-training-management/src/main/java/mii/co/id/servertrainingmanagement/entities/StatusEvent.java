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
@Table(name = "status_event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusEvent.findAll", query = "SELECT s FROM StatusEvent s")})
public class StatusEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "status_event_id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "status_event_name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusEvent", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<HistoryEvent> historyEventList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusEvent", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Event> eventList;

    public StatusEvent() {
    }

    public StatusEvent(Integer statusEventId) {
        this.id = statusEventId;
    }

    public StatusEvent(Integer statusEventId, String statusEventName) {
        this.id = statusEventId;
        this.name = statusEventName;
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
    public List<HistoryEvent> getHistoryEventList() {
        return historyEventList;
    }

    public void setHistoryEventList(List<HistoryEvent> historyEventList) {
        this.historyEventList = historyEventList;
    }

    @XmlTransient
    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
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
        if (!(object instanceof StatusEvent)) {
            return false;
        }
        StatusEvent other = (StatusEvent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mii.co.id.servertrainingmanagement.entities.StatusEvent[ statusEventId=" + id + " ]";
    }
    
}
