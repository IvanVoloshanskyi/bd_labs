package lviv.iot.DAO.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.model.Developer;
import lviv.iot.model.Gps;
import lviv.iot.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeveloperDAO implements DAO<Developer>{
    private static final String GET_ALL = "SELECT * FROM mydb.developer";
    private static final String GET_BY_ID = "SELECT * FROM mydb.developer WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.developer (name, surname, telephone_num) VALUES (?,?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.developer "
            + "SET name = ?, surname = ?, telephone_num = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.developer WHERE (`id` = ?);";

    @Override
    public List<Developer> findAll() throws SQLException {
        List<Developer> developerList = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Developer developer = new Developer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("telephone_num"));
                developerList.add(developer);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return developerList;
    }
    @Override
    public Developer findById(Integer id) throws SQLException {
        Developer developer = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                developer = new Developer(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("telephone_num"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return developer;
    }
    @Override
    public void create(Developer developer) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, developer.getId());
            statement.setString(2, developer.getName());
            statement.setString(3, developer.getSurname());
            statement.setString(4, developer.getTelephone_num());


            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    @Override
    public void update(Integer id, Developer developer) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, developer.getId());
            statement.setString(2, developer.getName());
            statement.setString(3, developer.getSurname());
            statement.setString(4, developer.getTelephone_num());
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
