package lviv.iot.service.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.DAO.impl.AdressDAO;
import lviv.iot.DAO.impl.DeveloperDAO;
import lviv.iot.DAO.impl.GpsDAO;
import lviv.iot.DAO.impl.LocationDAO;
import lviv.iot.model.Adress;
import lviv.iot.model.Gps;
import lviv.iot.service.Service;
import lviv.iot.model.Developer;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class GpsService implements Service<Gps> {

    private final DAO<Gps> dao = new GpsDAO();


    @Override
    public List<Gps> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Gps findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Gps gps) throws SQLException {
        dao.create(gps);
    }

    @Override
    public void update(Integer id, Gps gps) throws SQLException {
        dao.update(id, gps);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}