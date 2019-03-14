package io.orten.nano.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eventId")
    private long eventId;

    @Column(name = "projectId")
    private long projectId;
    @Column(name = "eventTitle")
    private String eventTitle;
    @Column(name = "eventDescription")
    private String eventDescription;
    @Column(name = "eventDate")
    private Date eventDate;
    @Column(name = "eventImage")
    private String eventImage;

    public Event(){}

    public long getEventId() {return eventId;}

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventImage() {
        return eventImage;
    }

    public void setEventImage(String eventImage) {
        this.eventImage = eventImage;
    }
}