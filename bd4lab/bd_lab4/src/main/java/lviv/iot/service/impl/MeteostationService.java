package lviv.iot.service.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.DAO.impl.AdressDAO;
import lviv.iot.DAO.impl.IntervalOfUpdatesDAO;
import lviv.iot.DAO.impl.MeteostationDAO;
import lviv.iot.DAO.impl.ServiceWorkDAO;
import lviv.iot.model.Adress;
import lviv.iot.model.Meteostation;
import lviv.iot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class MeteostationService implements Service<Meteostation> {
    private final DAO<Meteostation> dao = new MeteostationDAO();


    @Override
    public List<Meteostation> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Meteostation findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Meteostation meteostation) throws SQLException {
        dao.create(meteostation);
    }

    @Override
    public void update(Integer id, Meteostation meteostation) throws SQLException {
        dao.update(id, meteostation);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}