package lviv.iot.controller.impl;

import lviv.iot.controller.Controller;
import lviv.iot.model.Location;
import lviv.iot.model.Meteostation;
import lviv.iot.service.Service;
import lviv.iot.service.impl.LocationService;
import lviv.iot.service.impl.MeteostationService;

import java.sql.SQLException;
import java.util.List;

public class MeteostationController implements Controller<Meteostation> {
    private final Service<Meteostation> service = new MeteostationService();

    @Override
    public List<Meteostation> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Meteostation findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Meteostation meteostation) throws SQLException {
        service.create(meteostation);
    }

    @Override
    public void update(Integer id, Meteostation meteostation) throws SQLException {
        service.update(id, meteostation);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
