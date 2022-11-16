package lviv.iot.controller.impl;

import lviv.iot.controller.Controller;
import lviv.iot.model.Developer;
import lviv.iot.service.Service;
import lviv.iot.service.impl.DeveloperService;
import lviv.iot.service.impl.GpsService;

import java.sql.SQLException;
import java.util.List;

public class DeveloperController implements Controller<Developer> {

    private final Service<Developer> service = new DeveloperService();

    @Override
    public List<Developer> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Developer findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Developer developer) throws SQLException {
        service.create(developer);
    }

    @Override
    public void update(Integer id, Developer developer) throws SQLException {
        service.update(id, developer);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}