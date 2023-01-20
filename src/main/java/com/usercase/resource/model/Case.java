package com.usercase.resource.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer caseId;
    private String title;
    private String description;
    private Integer severity;

    public Case(String title, String description, Integer severity, Status status) {
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = status;

    }

    private Status status;
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "noteId")
    private List<Note> notes;
    public enum Status {
        OPEN,
        CLOSED
    }
    public Case() {
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
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

    public Integer getSeverity() {
        return severity;
    }

    public void setSeverity(Integer severity) {
        this.severity = severity;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }



}

