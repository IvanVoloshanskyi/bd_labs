package iot.lviv.domain;

import javax.persistence.*;
import java.util.Objects;

import java.sql.Date;

@Entity
@Table(name = "meteostation", schema = "meteostation")
public class MeteostationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "installation_date")
    private Date installationDate;
    @ManyToOne
    @JoinColumn(name = "data_id", referencedColumnName = "id", nullable = false)
    private DataEntity data;
    @ManyToOne
    @JoinColumn(name = "interval_of_updates_id", referencedColumnName = "id", nullable = false)
    private IntervalOfUpdatesEntity intervalOfUpdates;
    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    private LocationEntity location;
    @ManyToOne
    @JoinColumn(name = "service_work_id", referencedColumnName = "id", nullable = false)
    private ServiceWorkEntity serviceWork;
    @ManyToOne
    @JoinColumn(name = "developer_id", referencedColumnName = "id", nullable = false)
    private DeveloperEntity developer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        this.installationDate = installationDate;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeteostationEntity that = (MeteostationEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(installationDate, that.installationDate) && Objects.equals(data, that.data) && Objects.equals(intervalOfUpdates, that.intervalOfUpdates) && Objects.equals(location, that.location) && Objects.equals(serviceWork, that.serviceWork) && Objects.equals(developer, that.developer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, installationDate, data, intervalOfUpdates,location ,serviceWork ,developer );
    }
    public DataEntity getData() {
        return data;
    }
    public void setData(DataEntity data) {
        this.data = data;
    }

    public IntervalOfUpdatesEntity getIntervalOfUpdates() {
        return intervalOfUpdates;
    }
    public void setIntervalOfUpdates(IntervalOfUpdatesEntity intervalOfUpdates) {
        this.intervalOfUpdates = intervalOfUpdates;
    }

    public LocationEntity getLocation() {
        return location;
    }
    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public ServiceWorkEntity getServiceWork() {
        return serviceWork;
    }
    public void setServiceWork(ServiceWorkEntity serviceWork) {
        this.serviceWork = serviceWork;
    }

    public DeveloperEntity getDeveloper() {
        return developer;
    }
    public void setDeveloper(DeveloperEntity developer) {
        this.developer = developer;
    }

}
