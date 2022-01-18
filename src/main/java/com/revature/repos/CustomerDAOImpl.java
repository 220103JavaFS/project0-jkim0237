package com.revature.repos;

import com.revature.models.Customer;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {


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
