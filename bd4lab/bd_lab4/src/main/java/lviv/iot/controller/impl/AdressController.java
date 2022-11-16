package lviv.iot.controller.impl;

import lviv.iot.controller.Controller;
import lviv.iot.model.Adress;
import lviv.iot.service.Service;
import lviv.iot.service.impl.AdressService;

import java.sql.SQLException;
import java.util.List;

public class AdressController implements Controller<Adress> {

    private final Service<Adress> service = new AdressService();

    @Override
    public List<Adress> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public Adress findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(Adress adress) throws SQLException {
        service.create(adress);
    }

    @Override
    public void update(Integer id, Adress adress) throws SQLException {
        service.update(id, adress);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
