package lviv.iot.DAO.impl;
import lviv.iot.DAO.DAO;
import lviv.iot.model.Adress;

import lviv.iot.model.Gps;
import lviv.iot.model.IntervalOfUpdates;
import lviv.iot.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IntervalOfUpdatesDAO implements DAO<IntervalOfUpdates> {
    private static final String GET_ALL = "SELECT * FROM mydb.gps";
    private static final String GET_BY_ID = "SELECT * FROM mydb.gps WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.gps (id, interval) VALUES (?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.gps "
            + "SET id = ?, interval = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.gps WHERE (`id` = ?);";

    @Override
    public List<IntervalOfUpdates> findAll() throws SQLException {
        List<IntervalOfUpdates> intervalOfUpdatesList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                IntervalOfUpdates interval = new IntervalOfUpdates(
                        resultSet.getInt("id"),
                        resultSet.getInt("interval"));
                intervalOfUpdatesList.add(interval);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return intervalOfUpdatesList;
    }

    @Override
    public IntervalOfUpdates findById(Integer id) throws SQLException {
        IntervalOfUpdates interval = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                interval = new IntervalOfUpdates(
                        resultSet.getInt("id"),
                        resultSet.getInt("interval"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return interval;
    }

    @Override
    public void create(IntervalOfUpdates interval) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, interval.getId());
            statement.setInt(2, interval.getInterval());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, IntervalOfUpdates interval) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, interval.getId());
            statement.setInt(2, interval.getInterval());
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


