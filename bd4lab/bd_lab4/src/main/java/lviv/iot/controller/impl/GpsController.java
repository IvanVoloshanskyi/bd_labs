package lviv.iot.controller.impl;

import lviv.iot.controller.Controller;
import lviv.iot.model.Gps;
import lviv.iot.service.Service;
import lviv.iot.service.impl.GpsService;

import java.sql.SQLException;
import java.util.List;

public class GpsController implements Controller<Gps> {

    private final Service<Gps> service = new GpsService();

    @Override
    public List<Gps> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Gps findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Gps gps) throws SQLException {
        service.create(gps);
    }

    @Override
    public void update(Integer id, Gps gps) throws SQLException {
        service.update(id, gps);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
