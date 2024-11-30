package cz.qve.attendance.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name="attendances")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "is_present")
    private boolean isPresent;
    @Column(name = "worked_hours")
    private float workedHours;

    private LocalDateTime date;

    public Attendance(String name, boolean isPresent, float workedHours, String date) {
        this.name = name;
        this.isPresent = isPresent;
        this.workedHours = workedHours;
        this.date = dateFromString(date);
    }
    private LocalDateTime dateFromString(String string){

        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(string , formatter);
        return dateTime;
    }
    public Attendance() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public float getWorkedHours() {
        return workedHours;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public void setWorkedHours(float workedHours) {
        this.workedHours = workedHours;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isPresent=" + isPresent +
                ", workedHours=" + workedHours +
                ", date=" + date +
                '}';
    }
}
