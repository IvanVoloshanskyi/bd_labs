package iot.lviv.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "interval_of_updates", schema = "meteostation")
public class IntervalOfUpdatesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "interval")
    private Integer interval;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntervalOfUpdatesEntity that = (IntervalOfUpdatesEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(interval, that.interval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, interval);
    }



}
