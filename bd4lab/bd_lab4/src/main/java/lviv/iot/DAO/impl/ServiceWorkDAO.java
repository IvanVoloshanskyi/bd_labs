package lviv.iot.DAO.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.model.Meteostation;
import lviv.iot.model.ServiceWork;
import lviv.iot.persistent.ConnectionManager;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceWorkDAO implements DAO<ServiceWork>{
    private static final String GET_ALL = "SELECT * FROM mydb.service_work";
    private static final String GET_BY_ID = "SELECT * FROM mydb.service_work WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.service_work (id, date, description) VALUES (?,?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.service_work "
            + "SET id = ?, date = ?, description = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.service_work WHERE (`id` = ?);";

    @Override
    public List<ServiceWork> findAll() throws SQLException {
        List<ServiceWork> serviceWorkList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ServiceWork serviceWork = new ServiceWork(
                        resultSet.getInt("id"),
                        resultSet.getDate("date"),
                        resultSet.getString("description"));

                serviceWorkList.add(serviceWork);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return serviceWorkList;
    }
    @Override
    public ServiceWork findById(Integer id) throws SQLException {
        ServiceWork serviceWork = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                serviceWork = new ServiceWork(
                        resultSet.getInt("id"),
                        resultSet.getDate("date"),
                        resultSet.getString("description"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return serviceWork;
    }
    @Override
    public void create(ServiceWork serviceWork) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, serviceWork.getId());
            statement.setInt(2, serviceWork.getId());
            statement.setDate(3, (Date) serviceWork.getDate());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public void update(Integer id, ServiceWork serviceWork) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, serviceWork.getId());
            statement.setInt(2, serviceWork.getId());
            statement.setDate(3, (Date) serviceWork.getDate());
            statement.executeUpdate();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }







}
