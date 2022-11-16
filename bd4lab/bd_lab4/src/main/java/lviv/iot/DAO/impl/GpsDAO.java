package lviv.iot.DAO.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.model.Data;
import lviv.iot.model.Gps;
import lviv.iot.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GpsDAO implements DAO<Gps> {
    private static final String GET_ALL = "SELECT * FROM mydb.gps";
    private static final String GET_BY_ID = "SELECT * FROM mydb.gps WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.gps (id, latitude, longtitude) VALUES (?,?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.gps "
            + "SET id = ?, latitude = ?, longtitude = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.gps WHERE (`id` = ?);";

    @Override
    public List<Gps> findAll() throws SQLException {
        List<Gps> gpsList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Gps gps = new Gps(
                        resultSet.getInt("id"),
                        resultSet.getString("latitude"),
                        resultSet.getString("longtitude"));


                gpsList.add(gps);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return gpsList;
    }

    @Override
    public Gps findById(Integer id) throws SQLException {
        Gps gps = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                gps = new Gps(
                        resultSet.getInt("id"),
                        resultSet.getString("latitude"),
                        resultSet.getString("longtitude"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return gps;
    }

    @Override
    public void create(Gps gps) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, gps.getId());
            statement.setString(2, gps.getLatitude());
            statement.setString(3, gps.getLongtitude());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Gps gps) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, gps.getId());
            statement.setString(2, gps.getLatitude());
            statement.setString(3, gps.getLongtitude());
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
