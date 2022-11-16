package lviv.iot.controller.impl;

import lviv.iot.controller.Controller;
import lviv.iot.model.IntervalOfUpdates;
import lviv.iot.model.Location;
import lviv.iot.service.Service;
import lviv.iot.service.impl.IntervalOfUpdatesService;
import lviv.iot.service.impl.LocationService;
import java.sql.SQLException;
import java.util.List;

public class IntervalOfUpdatesController implements Controller<IntervalOfUpdates> {

    private final Service<IntervalOfUpdates> service = new IntervalOfUpdatesService();

    @Override
    public List<IntervalOfUpdates> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public IntervalOfUpdates findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(IntervalOfUpdates interval) throws SQLException {
        service.create(interval);
    }

    @Override
    public void update(Integer id, IntervalOfUpdates interval) throws SQLException {
        service.update(id, interval);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
