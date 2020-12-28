package lab4.model.dao;

import lab4.DatabaseConnector;
import lab4.model.entity.Monitor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MonitorDAO implements GeneralDAO<Monitor> {


    private static final String GET_ALL = "SELECT * FROM dmytro_lab3.monitors";
    private static final String GET_ONE = "SELECT * FROM dmytro_lab3.monitors WHERE id=?";
    private static final String CREATE = "INSERT dmytro_lab3.monitors "
            + "(monitors_resolution, model) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE dmytro_lab3.monitors"
            + " SET monitors_resolution=?, model=? WHERE id=?";
    private static final String DELETE = "DELETE FROM dmytro_lab3.monitors WHERE id=?";

    @Override
    public List<Monitor> findAll() {
        List<Monitor> monitors = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Monitor monitor = new Monitor(
                        resultSet.getInt("id"),
                        resultSet.getString("monitors_resolution"),
                        resultSet.getString("model")
                );
                monitors.add(monitor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monitors;
    }

    @Override
    public Monitor findOne(Integer id) {
        Monitor monitor = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                monitor = new Monitor(
                        resultSet.getInt("id"),
                        resultSet.getString("monitors_resolution"),
                        resultSet.getString("model")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monitor;
    }

    @Override
    public void create(Monitor monitor) {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(monitor.getMonitorsResolution()));
            statement.setString(2, String.valueOf(monitor.getModel()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Monitor monitor) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(monitor.getMonitorsResolution()));
            statement.setString(2, String.valueOf(monitor.getModel()));
            statement.setInt(3, id);

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(DELETE)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
