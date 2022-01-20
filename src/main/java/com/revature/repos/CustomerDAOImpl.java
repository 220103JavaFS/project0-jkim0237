package com.revature.repos;

import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.models.UserDTO;
import com.revature.utils.ConnectionUtil;

import java.sql.*;

public class CustomerDAOImpl implements CustomerDAO {




    @Override
    public boolean addCustomer(Customer customer) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO customer (user_type, username, user_password, first_name, last_name, birth_date)" +
                    "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, customer.getUserType());
            statement.setString(++count, customer.getUserName());
            statement.setString(++count, customer.getPassword());
            statement.setString(++count, customer.getFirstName());
            statement.setString(++count, customer.getLastName());
            statement.setString(++count, customer.getBirthDate());

            statement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean depositSaving(BankAccount bankAccount) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "UPDATE accounts SET saving_amount = ? WHERE username = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 1;
            statement.setString(count++, bankAccount.getUserName());
            statement.setFloat(count++, bankAccount.getSavingAmount());


            statement.execute();
            return true;
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean Login(String username, String password) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM customer WHERE username = '" + username + "' and user_password = '" + password + "';";
            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);
            if(result.next()){
                return true;
            }else {
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
