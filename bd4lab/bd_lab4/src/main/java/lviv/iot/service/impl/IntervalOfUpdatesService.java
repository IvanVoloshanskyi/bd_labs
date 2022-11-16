package lviv.iot.service.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.DAO.impl.AdressDAO;
import lviv.iot.DAO.impl.IntervalOfUpdatesDAO;
import lviv.iot.model.Adress;
import lviv.iot.model.IntervalOfUpdates;
import lviv.iot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class IntervalOfUpdatesService implements Service<IntervalOfUpdates> {
    private final DAO<IntervalOfUpdates> dao = new IntervalOfUpdatesDAO();

    @Override
    public List<IntervalOfUpdates> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public IntervalOfUpdates findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(IntervalOfUpdates intervalOfUpdates) throws SQLException {
        dao.create(intervalOfUpdates);
    }

    @Override
    public void update(Integer id, IntervalOfUpdates intervalOfUpdates) throws SQLException {
        dao.update(id, intervalOfUpdates);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}