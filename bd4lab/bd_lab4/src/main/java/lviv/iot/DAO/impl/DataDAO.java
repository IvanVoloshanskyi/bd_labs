package lviv.iot.DAO.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.model.Adress;
import lviv.iot.model.Data;
import lviv.iot.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataDAO implements DAO<Data> {
    private static final String GET_ALL = "SELECT * FROM mydb.data";
    private static final String GET_BY_ID = "SELECT * FROM mydb.data WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.data (temperature, humidity, wind_speed," +
            "atmospheric_pressure,wind_direction,interval_of_updates_id) VALUES (?,?,?,?,?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.data "
            + "SET temperature = ?, humidity = ?, wind_speed = ?,atmospheric_pressure = ?," +
            "wind_direction = ?,interval_of_updates_id = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.data WHERE (`id` = ?);";

    @Override
    public List<Data> findAll() throws SQLException {
        List<Data> dataList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Data data = new Data(
                        resultSet.getInt("id"),
                        resultSet.getInt("temperature"),
                        resultSet.getInt("wind_speed"),
                        resultSet.getInt("humidity"),
                        resultSet.getInt("atmospheric_pressure"),
                        resultSet.getInt("wind_direction"),
                        resultSet.getInt("interval_of_updates_id"));


                dataList.add(data);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return dataList;
    }

    @Override
    public Data findById(Integer id) throws SQLException {
        Data data = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                data = new Data(
                        resultSet.getInt("id"),
                        resultSet.getInt("temperature"),
                        resultSet.getInt("wind_speed"),
                        resultSet.getInt("humidity"),
                        resultSet.getInt("atmospheric_pressure"),
                        resultSet.getInt("wind_direction"),
                        resultSet.getInt("interval_of_updates_id"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return data;
    }

    @Override
    public void create(Data data) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, data.getId());
            statement.setInt(2, data.getTemperature());
            statement.setInt(3, data.getHumidity());
            statement.setInt(4, data.getAtmospheric_pressure());
            statement.setInt(5, data.getWind_direction());
            statement.setInt(6, data.getInterval_of_updates_id());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Data data) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, data.getId());
            statement.setInt(2, data.getTemperature());
            statement.setInt(3, data.getHumidity());
            statement.setInt(4, data.getAtmospheric_pressure());
            statement.setInt(5, data.getWind_direction());
            statement.setInt(6, data.getInterval_of_updates_id());
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
