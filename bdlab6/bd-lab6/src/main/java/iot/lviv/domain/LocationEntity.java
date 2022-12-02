package iot.lviv.domain;

import javax.persistence.*;
import java.util.Objects;

@lombok.Setter
@lombok.Getter
@Entity
@Table(name = "location", schema = "meteostation")
public class LocationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "city")
    private String city;
    @ManyToOne
    @JoinColumn(name = "adress_id", referencedColumnName = "id", nullable = false)
    private AdressEntity adress;
    @ManyToOne
    @JoinColumn(name = "gps_id", referencedColumnName = "id", nullable = false)
    private GpsEntity gps;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationEntity that = (LocationEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(city, that.city)&& Objects.equals(adress, that.adress)&& Objects.equals(gps, that.gps);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, city, adress, gps);
    }

}
