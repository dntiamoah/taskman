package com.ntiamoah.springboot.taskman.task;

import com.ntiamoah.springboot.taskman.common.Status;
import com.ntiamoah.springboot.taskman.common.Title;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by dntiamoah on 17/05/2018.
 */
@Entity
@Table(name = "task")
public class Task implements Serializable {

    private Long Id;
    private Title title;
    private String firstName;
    private String lastName;
    private LocalDate scheduledDate;
    private String notes;
    private Status status;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Enumerated(EnumType.ORDINAL)
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Enumerated(EnumType.ORDINAL)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @NotNull
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "task{" +
                "Id=" + Id +
                ", title=" + title +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", scheduledDate=" + scheduledDate +
                ", notes='" + notes + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (firstName != null ? !firstName.equals(task.firstName) : task.firstName != null) return false;
        if (lastName != null ? !lastName.equals(task.lastName) : task.lastName != null) return false;
        return scheduledDate != null ? scheduledDate.equals(task.scheduledDate) : task.scheduledDate == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (scheduledDate != null ? scheduledDate.hashCode() : 0);
        return result;
    }
}
