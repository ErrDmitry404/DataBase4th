package lab4.model.dao;

import lab4.DatabaseConnector;
import lab4.model.entity.Worker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WorkerDAO implements GeneralDAO<Worker> {


    private static final String GET_ALL = "SELECT * FROM dmytro_lab3.workers";
    private static final String GET_ONE = "SELECT * FROM dmytro_lab3.workers WHERE id=?";
    private static final String CREATE = "INSERT dmytro_lab3.workers "
            + "(full_name, amount, ir_phones_id) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE dmytro_lab3.workers"
            + " SET full_name=?, amount=?, ir_phones_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM dmytro_lab3.workers WHERE id=?";

    @Override
    public List<Worker> findAll() {
        List<Worker> workers = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Worker worker = new Worker(
                        resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getInt("amount"),
                        resultSet.getInt("ir_phones_id")
                );
                workers.add(worker);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workers;
    }

    @Override
    public Worker findOne(Integer id) {
        Worker worker = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                worker = new Worker(
                        resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getInt("amount"),
                        resultSet.getInt("ir_phones_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return worker;
    }

    @Override
    public void create(Worker worker) {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(worker.getFullName()));
            statement.setString(2, String.valueOf(worker.getAmount()));
            statement.setString(3, String.valueOf(worker.getIrPhonesId()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Worker worker) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(worker.getFullName()));
            statement.setString(2, String.valueOf(worker.getAmount()));
            statement.setString(3, String.valueOf(worker.getIrPhonesId()));
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
