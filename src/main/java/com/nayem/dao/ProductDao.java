package com.nayem.dao;

import com.nayem.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public static List<Product> getAll(Connection connection) {
        List<Product> products=new ArrayList<Product>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM product");
            while (resultSet.next()) {
                products.add(retrive(resultSet));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    private static Product retrive(ResultSet resultSet) {
        try {
            return new Product(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("type"),resultSet.getDouble("price"),resultSet.getFloat("percentage"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Product getOne(Connection connection,String id) {
        Product product=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM product WHERE id=?");
            preparedStatement.setInt(1,Integer.parseInt(id));
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            product= retrive(resultSet);
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
}
