package iot.lviv.domain;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "adress", schema = "meteostation")
public class AdressEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "adress")
    private String adress;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "build")
    private String build;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdressEntity that = (AdressEntity) o;

        if (id != that.id) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (build != null ? !build.equals(that.build) : that.build != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adress, street, build);
    }


}
