package lviv.iot.service.impl;
import lviv.iot.DAO.DAO;
import lviv.iot.DAO.impl.AdressDAO;
import lviv.iot.DAO.impl.ServiceWorkDAO;
import lviv.iot.model.Adress;
import lviv.iot.model.ServiceWork;
import lviv.iot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;
public class ServiseWorkService implements Service<ServiceWork> {

    private final DAO<ServiceWork> dao = new ServiceWorkDAO();

    @Override
    public List<ServiceWork> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public ServiceWork findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(ServiceWork serviceWork) throws SQLException {
        dao.create(serviceWork);
    }

    @Override
    public void update(Integer id, ServiceWork serviceWork) throws SQLException {
        dao.update(id, serviceWork);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}