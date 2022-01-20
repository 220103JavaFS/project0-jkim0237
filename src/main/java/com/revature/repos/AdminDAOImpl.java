package com.revature.repos;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public List<Customer> findAllCustomers() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM customer;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Customer> list = new ArrayList<>();

            while (result.next()) {
                Customer customer = new Customer();
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
    public Customer findByUsername(String username) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            // ? for use of Prepared statement
            String sql = "SELECT * FROM customer WHERE username = ?;";

            PreparedStatement statement = conn.prepareStatement(sql);

            // parameterIndex refers to the number of ? with the value given at the second input
            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            Customer customer = new Customer();

            while (result.next()) {
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
            return false;
        }
    }

    public List<Employee> findAllEmployees() {
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "SELECT * FROM users;";

            Statement statement = conn.createStatement();

            ResultSet result = statement.executeQuery(sql);

            List<Employee> list = new ArrayList<>();

            while (result.next()) {
                Employee employee = new Employee();
                employee.setUserType(result.getString("user_type"));
                employee.setUserName(result.getString("username"));
                employee.setPassword(result.getString("user_password"));
                employee.setFirstName(result.getString("first_name"));
                employee.setLastName(result.getString("last_name"));
                employee.setBirthDate(result.getString("birth_date"));

                list.add(employee);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Employee>();
    }

//    @Override
//    public boolean deleteCustomer(Customer customer) {
//        try (Connection conn = ConnectionUtil.getConnection()) {
//            String sql = "DELETE FROM customer WHERE username = ?;";
//
//            PreparedStatement statement = conn.prepareStatement(sql);
//
//            statement.setObject(1, customer);
//
//            statement.execute();
//
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }

}

