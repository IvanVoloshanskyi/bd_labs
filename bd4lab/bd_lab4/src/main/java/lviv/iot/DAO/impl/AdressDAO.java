package lviv.iot.DAO.impl;

import lviv.iot.DAO.DAO;
import lviv.iot.model.Adress;

import lviv.iot.persistent.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdressDAO implements DAO<Adress> {
    private static final String GET_ALL = "SELECT * FROM mydb.adress";
    private static final String GET_BY_ID = "SELECT * FROM mydb.adress WHERE id=?";
    private static final String CREATE = "INSERT INTO mydb.adress (adress, street, build) VALUES (?,?,?);";
    private static final String UPDATE = "" + "UPDATE mydb.adress "
            + "SET adress = ?, street = ?, build = ? WHERE (id = ?);";
    private static final String DELETE = "DELETE FROM mydb.adress WHERE (`id` = ?);";

    @Override
    public List<Adress> findAll() throws SQLException {
        List<Adress> adresses = new ArrayList<>();
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Adress adress = new Adress(
                        resultSet.getInt("id"),
                        resultSet.getString("adress"),
                        resultSet.getString("street"),
                        resultSet.getString("build"));

                adresses.add(adress);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return adresses;
    }

    @Override
    public Adress findById(Integer id) throws SQLException {
        Adress adress = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                adress = new Adress(
                        resultSet.getInt("id"),
                        resultSet.getString("adress"),
                        resultSet.getString("street"),
                        resultSet.getString("build"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return adress;
    }

    @Override
    public void create(Adress adress) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setInt(1, adress.getId());
            statement.setString(2, adress.getAdress());
            statement.setString(3, adress.getStreet());
            statement.setString(4, adress.getBuild());
            statement.executeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Adress adress) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, adress.getId());
            statement.setString(2, adress.getAdress());
            statement.setString(3, adress.getStreet());
            statement.setString(4, adress.getBuild());
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