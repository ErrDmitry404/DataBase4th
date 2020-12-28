package lab4.model.dao;

import lab4.DatabaseConnector;
import lab4.model.entity.IrPhones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IrPhonesDAO implements GeneralDAO<IrPhones> {


    private static final String GET_ALL = "SELECT * FROM dmytro_lab3.ir_phones";
    private static final String GET_ONE = "SELECT * FROM dmytro_lab3.ir_phones WHERE id=?";
    private static final String CREATE = "INSERT dmytro_lab3.ir_phones "
            + "(phone_types, phone_model) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE dmytro_lab3.ir_phones"
            + " SET phone_types=?, phone_model=? WHERE id=?";
    private static final String DELETE = "DELETE FROM dmytro_lab3.ir_phones WHERE id=?";

    @Override
    public List<IrPhones> findAll() {
        List<IrPhones> irPhones = new ArrayList<>();
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                IrPhones irPhone = new IrPhones(
                        resultSet.getInt("id"),
                        resultSet.getString("phone_types"),
                        resultSet.getString("phone_model")
                );
                irPhones.add(irPhone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return irPhones;
    }

    @Override
    public IrPhones findOne(Integer id) {
        IrPhones irPhone = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE)) {

            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                irPhone = new IrPhones(
                        resultSet.getInt("id"),
                        resultSet.getString("phone_types"),
                        resultSet.getString("phone_model")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return irPhone;
    }

    @Override
    public void create(IrPhones irPhone) {

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE)) {

            statement.setString(1, String.valueOf(irPhone.getPhoneModel()));
            statement.setString(2, String.valueOf(irPhone.getPhoneTypes()));

            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, IrPhones irPhones) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE)) {

            statement.setString(1, String.valueOf(irPhones.getPhoneTypes()));
            statement.setString(2, String.valueOf(irPhones.getPhoneModel()));
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
