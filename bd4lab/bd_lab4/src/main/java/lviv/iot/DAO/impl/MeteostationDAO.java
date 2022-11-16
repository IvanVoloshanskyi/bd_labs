package lviv.iot.DAO.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.model.Location;
import lviv.iot.model.Meteostation;
import lviv.iot.persistent.ConnectionManager;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MeteostationDAO implements DAO<Meteostation>{
    private static final String GET_ALL = "SELECT * FROM mydb.meteostation";
    private static final String GET_BY_ID = "SELECT * FROM mydb.meteostation WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.meteostation (id, installation_date, data_id, interval_of_updates_id," +
            "location_id,service_work_id,developer_id) VALUES (?,?,?,?,?,?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.meteostation "
            + "SET id = ?, installation_date = ?, data_id = ?, interval_of_updates_id = ?, location_id = ? , service_work_id = ?,developer_id = ?  WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.meteostation WHERE (`id` = ?);";

    @Override
    public List<Meteostation> findAll() throws SQLException {
        List<Meteostation> meteostationList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Meteostation meteostation = new Meteostation(
                        resultSet.getInt("id"),
                        resultSet.getDate("installation_date"),
                        resultSet.getInt("data_id"),
                        resultSet.getInt("interval_of_updates_id"),
                        resultSet.getInt("location_id"),
                        resultSet.getInt("service_work_id"),
                        resultSet.getInt("developer_id"));
                meteostationList.add(meteostation);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return meteostationList;
    }
    @Override
    public Meteostation findById(Integer id) throws SQLException {
        Meteostation meteostation = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                meteostation = new Meteostation(
                        resultSet.getInt("id"),
                        resultSet.getDate("installation_date"),
                        resultSet.getInt("data_id"),
                        resultSet.getInt("interval_of_updates_id"),
                        resultSet.getInt("location_id"),
                        resultSet.getInt("service_work_id"),
                        resultSet.getInt("developer_id"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return meteostation;
    }
    @Override
    public void create(Meteostation meteostation) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, meteostation.getId());
            statement.setDate(2, (Date) meteostation.getInstallation_date());
            statement.setInt(3, meteostation.getData_id());
            statement.setInt(4, meteostation.getInterval_of_updates_id());
            statement.setInt(5, meteostation.getLocation_id());
            statement.setInt(6, meteostation.getService_work_id());
            statement.setInt(7, meteostation.getDeveloper_id());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public void update(Integer id, Meteostation meteostation) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, meteostation.getId());
            statement.setDate(2, (Date) meteostation.getInstallation_date());
            statement.setInt(3, meteostation.getData_id());
            statement.setInt(4, meteostation.getInterval_of_updates_id());
            statement.setInt(5, meteostation.getLocation_id());
            statement.setInt(6, meteostation.getService_work_id());
            statement.setInt(7, meteostation.getDeveloper_id());
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
