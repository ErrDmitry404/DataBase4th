package lab4.model.dao;

import lab4.DatabaseConnector;
import lab4.model.entity.ITCompany;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ITCompanyDAO implements GeneralDAO<ITCompany> {


    private static final String GET_ALL = "SELECT * FROM dmytro_lab3.it_company";
    private static final String GET_ONE = "SELECT * FROM dmytro_lab3.it_company WHERE id=?";
    private static final String CREATE = "INSERT dmytro_lab3.it_company "
            + "(company_configuration, type_of_devices, server_id, workers_id) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE dmytro_lab3.it_company"
            + " SET company_configuration=?, type_of_devices=?, server_id=?, workers_id=? WHERE id=?";
    private static final String DELETE = "DELETE FROM dmytro_lab3.it_company WHERE id=?";


    @Override
    public List<ITCompany> findAll() {
        List<ITCompany> itCompanies = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ITCompany itCompany = new ITCompany(
                        resultSet.getInt("id"),
                        resultSet.getString("company_configuration"),
                        resultSet.getString("type_of_devices"),
                        resultSet.getInt("server_id"),
                        resultSet.getInt("workers_id")
                );
                itCompanies.add(itCompany);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itCompanies;
    }

    @Override
    public ITCompany findOne(Integer id) {
        ITCompany itCompany = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                itCompany = new ITCompany(
                        resultSet.getInt("id"),
                        resultSet.getString("company_configuration"),
                        resultSet.getString("type_of_devices"),
                        resultSet.getInt("server_id"),
                        resultSet.getInt("workers_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itCompany;
    }

    @Override
    public void create(ITCompany itCompany) {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(itCompany.getCompanyConfiguration()));
            statement.setString(2, String.valueOf(itCompany.getTypeOfDevices()));
            statement.setString(3, String.valueOf(itCompany.getServerId()));
            statement.setString(4, String.valueOf(itCompany.getWorkersId()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, ITCompany itCompany) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(itCompany.getCompanyConfiguration()));
            statement.setString(2, String.valueOf(itCompany.getTypeOfDevices()));
            statement.setString(3, String.valueOf(itCompany.getServerId()));
            statement.setString(4, String.valueOf(itCompany.getWorkersId()));
            statement.setInt(5, id);

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