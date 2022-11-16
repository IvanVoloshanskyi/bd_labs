package lviv.iot.controller.impl;

import lviv.iot.controller.Controller;
import lviv.iot.model.Location;
import lviv.iot.model.Meteostation;
import lviv.iot.service.Service;
import lviv.iot.service.impl.LocationService;
import lviv.iot.service.impl.MeteostationService;

import java.sql.SQLException;
import java.util.List;

public class LocationController implements Controller<Location> {

    private final Service<Location> service = new LocationService();

    @Override
    public List<Location> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Location findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Location location) throws SQLException {
        service.create(location);
    }

    @Override
    public void update(Integer id, Location location) throws SQLException {
        service.update(id, location);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
