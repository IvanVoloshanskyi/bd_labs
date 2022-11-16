package lviv.iot.service.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.DAO.impl.AdressDAO;
import lviv.iot.DAO.impl.DataDAO;
import lviv.iot.DAO.impl.GpsDAO;
import lviv.iot.model.Adress;
import lviv.iot.model.Data;
import lviv.iot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class DataService implements Service<Data> {

    private final DAO<Data> dao = new DataDAO();


    @Override
    public List<Data> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Data findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Data data) throws SQLException {
        dao.create(data);
    }

    @Override
    public void update(Integer id, Data data) throws SQLException {
        dao.update(id, data);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}