package iot.lviv.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "data", schema = "meteostation")
public class DataEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "temperature")
    private Integer temperature;
    @Basic
    @Column(name = "humidity")
    private Integer humidity;
    @Basic
    @Column(name = "wind_speed")
    private Integer windSpeed;
    @Basic
    @Column(name = "atmospheric_pressure")
    private Integer atmosphericPressure;
    @Basic
    @Column(name = "wind_direction")
    private String windDirection;
    @ManyToOne
    @JoinColumn(name = "interval_of_updates_id", referencedColumnName = "id", nullable = false)
    private IntervalOfUpdatesEntity intervalOfUpdates;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Integer windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(Integer atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataEntity that = (DataEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(temperature, that.temperature) && Objects.equals(humidity, that.humidity) && Objects.equals(windSpeed, that.windSpeed) && Objects.equals(atmosphericPressure, that.atmosphericPressure) && Objects.equals(windDirection, that.windDirection) && Objects.equals(intervalOfUpdates, that.intervalOfUpdates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, temperature, humidity, windSpeed, atmosphericPressure, windDirection, intervalOfUpdates);
    }

    public IntervalOfUpdatesEntity getIntervalOfUpdates() {
        return intervalOfUpdates;
    }

    public void setIntervalOfUpdates(IntervalOfUpdatesEntity intervalOfUpdates) {
        this.intervalOfUpdates = intervalOfUpdates;
    }

}
