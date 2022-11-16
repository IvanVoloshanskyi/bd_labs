package lviv.iot.service.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.DAO.impl.AdressDAO;
import lviv.iot.DAO.impl.IntervalOfUpdatesDAO;
import lviv.iot.DAO.impl.LocationDAO;
import lviv.iot.DAO.impl.MeteostationDAO;
import lviv.iot.model.Adress;
import lviv.iot.model.Location;
import lviv.iot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class LocationService implements Service<Location> {

    private final DAO<Location> dao = new LocationDAO();


    @Override
    public List<Location> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Location findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Location location) throws SQLException {
        dao.create(location);
    }

    @Override
    public void update(Integer id, Location location) throws SQLException {
        dao.update(id, location);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}