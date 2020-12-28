package lab4.model.dao;

import lab4.DatabaseConnector;
import lab4.model.entity.Server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServerDAO implements GeneralDAO<Server> {


    private static final String GET_ALL = "SELECT * FROM dmytro_lab3.server";
    private static final String GET_ONE = "SELECT * FROM dmytro_lab3.server WHERE id=?";
    private static final String CREATE = "INSERT dmytro_lab3.server "
            + "(online_now, monitors_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE dmytro_lab3.server"
            + " SET online_now=?, monitors_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM dmytro_lab3.server WHERE id=?";

    @Override
    public List<Server> findAll() {
        List<Server> servers = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Server server = new Server(
                        resultSet.getInt("id"),
                        resultSet.getString("online_now"),
                        resultSet.getInt("monitors_id")
                );
                servers.add(server);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return servers;
    }

    @Override
    public Server findOne(Integer id) {
        Server server = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                server = new Server(
                        resultSet.getInt("id"),
                        resultSet.getString("online_now"),
                        resultSet.getInt("monitors_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return server;
    }

    @Override
    public void create(Server server) {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(server.getOnlineNow()));
            statement.setString(2, String.valueOf(server.getMonitorsId()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Server server) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(server.getOnlineNow()));
            statement.setString(2, String.valueOf(server.getMonitorsId()));
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
