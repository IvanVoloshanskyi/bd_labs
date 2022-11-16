package lviv.iot.controller.impl;
import lviv.iot.controller.Controller;
import lviv.iot.model.ServiceWork;
import lviv.iot.service.Service;
import lviv.iot.service.impl.ServiseWorkService;
import java.sql.SQLException;
import java.util.List;

public class ServiceWorkController implements Controller<ServiceWork> {
    private final Service<ServiceWork> service = new ServiseWorkService();

    @Override
    public List<ServiceWork> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public ServiceWork findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void create(ServiceWork serviceWork) throws SQLException {
        service.create(serviceWork);
    }

    @Override
    public void update(Integer id, ServiceWork serviceWork) throws SQLException {
        service.update(id, serviceWork);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
