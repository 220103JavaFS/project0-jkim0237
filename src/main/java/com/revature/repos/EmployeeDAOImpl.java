package com.revature.repos;

import com.revature.models.BankAccount;
import com.revature.models.Customer;
import com.revature.utils.ConnectionUtil;
import java.sql.PreparedStatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Customer> findAllCustomers() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM customer;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Customer> list = new ArrayList<>();

            while (result.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(result.getInt("customer_id"));
                customer.setUserType(result.getString("user_type"));
                customer.setUserName(result.getString("username"));
                customer.setPassword(result.getString("user_password"));
                customer.setFirstName(result.getString("first_name"));
                customer.setLastName(result.getString("last_name"));
                customer.setBirthDate(result.getString("birth_date"));
                list.add(customer);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Customer>();
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM customer WHERE username = ?;"; // ? for use of Prepared statement

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            Customer customer = new Customer();

            while (result.next()) {
                customer.setCustomerID(result.getInt("customer_id"));
                customer.setUserType(result.getString("user_type"));
                customer.setUserName(result.getString("username"));
                customer.setPassword(result.getString("user_password"));
                customer.setFirstName(result.getString("first_name"));
                customer.setLastName(result.getString("last_name"));
                customer.setBirthDate(result.getString("birth_date"));
            }

            return customer;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Customer();
    }

    @Override
    public List<BankAccount> findAllBankAccounts() {
        List<BankAccount> list = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts;");

            ResultSet result = ps.executeQuery();

            while (result.next()) {

                String userName = result.getString("username");

                Boolean savingAccount = result.getBoolean("open_saving_account");

                Boolean checkingAccount = result.getBoolean("open_checking_account");

                Float savingAmount = result.getFloat("saving_amount");

                Float checkingAmount = result.getFloat("checking_amount");


                BankAccount bankAccount = new BankAccount(userName, savingAccount, checkingAccount, savingAmount, checkingAmount);

                list.add(bankAccount);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

