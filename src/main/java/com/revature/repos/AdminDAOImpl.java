package com.revature.repos;

import com.revature.models.Customer;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public List<Customer> findAllCustomers() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM customer_info;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Customer> list = new ArrayList<>();

            while (result.next()) {
                Customer customer = new Customer();
                customer.setUserName(result.getString("username"));
                customer.setPassword(result.getString("user_password"));
                customer.setFirstName(result.getString("first_name"));
                customer.setLastName(result.getString("last_name"));
                customer.setDoa(result.getString("birth_date"));
                customer.setSavingAccount(result.getBoolean("open_saving_account"));
                customer.setCheckingAccount(result.getBoolean("open_checking_account"));
                customer.setAmountSaving(result.getDouble("saving_account"));
                customer.setAmountChecking(result.getDouble("checking_account"));
                list.add(customer);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Customer>();
    }

    @Override
    public Customer findByUsername(String username) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM customer_info WHERE username = ?;"; // ? for use of Prepared statement

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            Customer customer = new Customer();

            while (result.next()) {
                customer.setUserName(result.getString("username"));
                customer.setPassword(result.getString("user_password"));
                customer.setFirstName(result.getString("first_name"));
                customer.setLastName(result.getString("last_name"));
                customer.setDoa(result.getString("birth_date"));
                customer.setSavingAccount(result.getBoolean("open_saving_account"));
                customer.setCheckingAccount(result.getBoolean("open_checking_account"));
                customer.setAmountSaving(result.getDouble("saving_account"));
                customer.setAmountChecking(result.getDouble("checking_account"));
            }

            return customer;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Customer();
    }

    @Override
    public boolean addCustomer(Customer customer) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO customer_info (username, user_password, first_name, last_name, birth_date," +
                    "saving_account, checking_account) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);

            int count = 0;
            statement.setString(++count, customer.getUserName());
            statement.setString(++count, customer.getPassword());
            statement.setString(++count, customer.getFirstName());
            statement.setString(++count, customer.getLastName());
            statement.setString(++count, customer.getDoa());
            statement.setDouble(++count, customer.getAmountSaving());
            statement.setDouble(++count, customer.getAmountChecking());

            statement.execute();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}

