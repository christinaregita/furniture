/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mii.co.id.servertrainingmanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ACER
 */
@Entity
@JsonIgnoreProperties("hibernateLazyInitializer")
@Table(name = "events")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "event_id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "event_name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "trainer")
    private String trainer;
    @Basic(optional = false)
    @Column(name = "quota")
    private int quota;
    @Basic(optional = false)
    @Column(name = "applicant")
    private int applicant;
    @Basic(optional = false)
    @Lob
    @Column(name = "requirement")
    private String requirement;
    @Basic(optional = false)
    @Column(name = "point")
    private int point;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Registration> registrationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<HistoryEvent> historyEventList;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category category;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "event", fetch = FetchType.LAZY)
    private Schedule schedule;
    @JoinColumn(name = "status_event_id", referencedColumnName = "status_event_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private StatusEvent statusEvent;

    public Event() {
    }

    public Event(Integer eventId) {
        this.id = eventId;
    }

    public Event(Integer eventId, String eventName, String description, String trainer, int quota, int applicant, String requirement, int point) {
        this.id = eventId;
        this.name = eventName;
        this.description = description;
        this.trainer = trainer;
        this.quota = quota;
        this.applicant = applicant;
        this.requirement = requirement;
        this.point = point;
    }

    public Event(Integer id, String name, String description, String trainer, int quota, int applicant, String requirement, int point, Category category, Schedule schedule, StatusEvent statusEvent) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.trainer = trainer;
        this.quota = quota;
        this.applicant = applicant;
        this.requirement = requirement;
        this.point = point;
        this.category = category;
        this.schedule = schedule;
        this.statusEvent = statusEvent;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getApplicant() {
        return applicant;
    }

    public void setApplicant(int applicant) {
        this.applicant = applicant;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @XmlTransient
    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    @XmlTransient
    public List<HistoryEvent> getHistoryEventList() {
        return historyEventList;
    }

    public void setHistoryEventList(List<HistoryEvent> historyEventList) {
        this.historyEventList = historyEventList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public StatusEvent getStatusEvent() {
        return statusEvent;
    }

    public void setStatusEvent(StatusEvent statusEvent) {
        this.statusEvent = statusEvent;
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
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mii.co.id.servertrainingmanagement.entities.Event[ eventId=" + id + " ]";
    }
    
}
