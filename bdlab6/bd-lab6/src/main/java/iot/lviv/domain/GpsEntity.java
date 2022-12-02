package iot.lviv.domain;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "gps", schema = "meteostation")
public class GpsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "latitude")
    private String latitude;
    @Basic
    @Column(name = "longtitude")
    private String longtitude;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GpsEntity gpsEntity = (GpsEntity) o;
        return Objects.equals(id, gpsEntity.id) && Objects.equals(latitude, gpsEntity.latitude) && Objects.equals(longtitude, gpsEntity.longtitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, latitude, longtitude);
    }

}
