package lviv.iot.service.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.DAO.impl.AdressDAO;

import lviv.iot.service.Service;
import lviv.iot.model.Adress;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class AdressService implements Service<Adress> {

    private final DAO<Adress> dao = new AdressDAO();

    @Override
    public List<Adress> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Adress findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Adress adress) throws SQLException {
        dao.create(adress);
    }

    @Override
    public void update(Integer id, Adress adress) throws SQLException {
        dao.update(id, adress);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
