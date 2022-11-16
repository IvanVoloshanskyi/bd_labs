package lviv.iot.service.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.DAO.impl.AdressDAO;
import lviv.iot.DAO.impl.DeveloperDAO;
import lviv.iot.model.Adress;
import lviv.iot.model.Developer;
import lviv.iot.model.Gps;
import lviv.iot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class DeveloperService implements Service<Developer> {

    private final DAO<Developer> dao = new DeveloperDAO();

    @Override
    public List<Developer> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Developer findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Developer developer) throws SQLException {
        dao.create(developer);
    }

    @Override
    public void update(Integer id, Developer developer) throws SQLException {
        dao.update(id, developer);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
