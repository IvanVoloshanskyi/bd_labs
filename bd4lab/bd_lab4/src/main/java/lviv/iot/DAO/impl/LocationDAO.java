package lviv.iot.DAO.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.model.Developer;
import lviv.iot.model.Location;
import lviv.iot.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDAO implements DAO<Location> {
    private static final String GET_ALL = "SELECT * FROM mydb.location";
    private static final String GET_BY_ID = "SELECT * FROM mydb.location WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.location (id, city, adress_id, gps_id) VALUES (?,?,?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.location "
            + "SET id = ?, city = ?, adress_id = ?, gps_id = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.location WHERE (`id` = ?);";

    @Override
    public List<Location> findAll() throws SQLException {
        List<Location> locationList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Location location = new Location(
                        resultSet.getInt("id"),
                        resultSet.getString("city"),
                        resultSet.getInt("adress_id"),
                        resultSet.getInt("gps_id"));

                locationList.add(location);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return locationList;
    }

    @Override
    public Location findById(Integer id) throws SQLException {
        Location location = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                location = new Location(
                        resultSet.getInt("id"),
                        resultSet.getString("city"),
                        resultSet.getInt("adress_id"),
                        resultSet.getInt("gps_id"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return location;
    }

    @Override
    public void create(Location location) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, location.getId());
            statement.setString(2, location.getCity());
            statement.setInt(3, location.getAdress_id());
            statement.setInt(4, location.getGps_id());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Location location) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, location.getId());
            statement.setString(2, location.getCity());
            statement.setInt(3, location.getAdress_id());
            statement.setInt(4, location.getGps_id());
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
