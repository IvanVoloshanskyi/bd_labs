package lviv.iot.controller.impl;

import lviv.iot.controller.Controller;
import lviv.iot.model.Data;
import lviv.iot.service.Service;
import lviv.iot.service.impl.DataService;

import java.sql.SQLException;
import java.util.List;

public class DataController implements Controller<Data> {

    private final Service<Data> service = new DataService();

    @Override
    public List<Data> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Data findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Data data) throws SQLException {
        service.create(data);
    }

    @Override
    public void update(Integer id, Data data) throws SQLException {
        service.update(id, data);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
