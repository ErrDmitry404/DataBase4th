package lab4.model.dao;

import lab4.DatabaseConnector;
import lab4.model.entity.Computer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComputerDAO implements GeneralDAO<Computer> {

    private static final String GET_ALL = "SELECT * FROM dmytro_lab3.computers";
    private static final String GET_ONE = "SELECT * FROM dmytro_lab3.computers WHERE id=?";
    private static final String CREATE = "INSERT dmytro_lab3.computers "
            + "(amount, manufacturer, monitors_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE dmytro_lab3.computers"
            + " SET amount=?, manufacturer=?, monitors_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM dmytro_lab3.computers WHERE id=?";

    @Override
    public List<Computer> findAll() {
        List<Computer> computers = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Computer computer = new Computer(
                        resultSet.getInt("id"),
                        resultSet.getInt("amount"),
                        resultSet.getString("manufacturer"),
                        resultSet.getInt("monitors_id")
                );
                computers.add(computer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return computers;
    }

    @Override
    public Computer findOne(Integer id) {
        Computer computer = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                computer = new Computer(
                        resultSet.getInt("id"),
                        resultSet.getInt("amount"),
                        resultSet.getString("manufacturer"),
                        resultSet.getInt("monitors_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return computer;
    }

    @Override
    public void create(Computer computer) {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(computer.getAmount()));
            statement.setString(2, String.valueOf(computer.getManufacturer()));
            statement.setInt(3, computer.getMonitorsId());

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Computer computer) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(computer.getAmount()));
            statement.setString(2, String.valueOf(computer.getManufacturer()));
            statement.setInt(3, computer.getMonitorsId());
            statement.setInt(4, id);

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
