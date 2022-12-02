package iot.lviv.domain;

import javax.persistence.*;
import java.util.Objects;

import java.sql.Date;

@Entity
@Table(name = "service_work", schema = "meteostation")
public class ServiceWorkEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "description")
    private String description;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceWorkEntity that = (ServiceWorkEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, description);
    }


}
