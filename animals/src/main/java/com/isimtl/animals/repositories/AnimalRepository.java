/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isimtl.animals.repositories;

import com.isimtl.animals.models.Animal;
import com.isimtl.animals.models.Category;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author isi
 */
public class AnimalRepository {
    private final String connectionUrl;
    private final String username;
    private final String password;

    public AnimalRepository() {
        String databaseName="animals_db";
        connectionUrl="jdbc:mariadb://localhost:3315/"+databaseName;
        username="root";
        password="admin";
    }
    
    public Category getCategory(int id) throws SQLException, ClassNotFoundException{
        Class.forName("org.mariadb.jdbc.Driver");
       try(Connection connection = DriverManager.getConnection(connectionUrl, username, password)){
            String query = "select id,name,plural_name from categories" +
                           "where id=?";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet resultSet =  statement.executeQuery();
            if (resultSet.next()) {
                return readNextCategory(resultSet);
            }
            return null;
        }
    }
    
    public ArrayList<Category> getCategories() throws SQLException, ClassNotFoundException{
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl, username, password)){
            String query = "select id,name,plural_name from categories";
            PreparedStatement statement =  connection.prepareStatement(query);
        
            ResultSet resultSet =  statement.executeQuery();
            ArrayList<Category> categories = new ArrayList<>();
            while (resultSet.next()) {
                categories.add(readNextCategory(resultSet));
            }
            return categories;
        }
    }
    
    private Category readNextCategory(ResultSet resultSet) throws SQLException{
        
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String plural_name = resultSet.getString("plural_name");
        return new Category(id, name, plural_name);
    }
    
    public Animal getAnimal(int id) throws SQLException, ClassNotFoundException{
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl, username, password)){
            String query = "select id,category_id,name,image_url from animals " +
                           "where id=?";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setInt(1,id);
            ResultSet resultSet =  statement.executeQuery();
            if (resultSet.next()) {
                return readNextAnimal(resultSet);
            }
            return null;
        }
    }
    public ArrayList<Animal> getAnimals() throws SQLException, ClassNotFoundException{
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl, username, password)){
            String query = "select id,category_id,name,image_url from animals";
            PreparedStatement statement =  connection.prepareStatement(query);
        
            ResultSet resultSet =  statement.executeQuery();
            ArrayList<Animal> animals = new ArrayList<>();
            while (resultSet.next()) {
                animals.add(readNextAnimal(resultSet));
            }
            return animals;
        }
    }
    public ArrayList<Animal> getAnimalsByCategory(int categoryId) throws SQLException, ClassNotFoundException{
        Class.forName("org.mariadb.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl, username, password)){
            String query = "select id,category_id,name,image_url from animals where category_id = ?";
            PreparedStatement statement =  connection.prepareStatement(query);
            statement.setInt(1,categoryId);
            ResultSet resultSet =  statement.executeQuery();
            ArrayList<Animal> animals = new ArrayList<>();
            while (resultSet.next()) {
                animals.add(readNextAnimal(resultSet));
            }
            return animals;
        }
    }

     private Animal readNextAnimal(ResultSet resultSet) throws SQLException{
        int id = resultSet.getInt("id");
        int category_id = resultSet.getInt("category_id");
        String name = resultSet.getString("name");
        String image_url = resultSet.getString("image_url");
        return new Animal(id,category_id,name,image_url);
    }
}
