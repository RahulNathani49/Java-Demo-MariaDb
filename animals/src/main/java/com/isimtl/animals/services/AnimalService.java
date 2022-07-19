package com.isimtl.animals.services;

import java.util.ArrayList;
import java.util.HashMap;

import com.isimtl.animals.models.Animal;
import com.isimtl.animals.models.Category;
import com.isimtl.animals.repositories.AnimalRepository;
import java.sql.SQLException;

public class AnimalService
{
    private AnimalRepository repository;
    public AnimalService() {
        repository = new AnimalRepository();
    }
      
    public Category getCategory(int id) throws SQLException, ClassNotFoundException
    {
        return repository.getCategory(id);
    }
    
    public ArrayList<Category> getCategories() throws SQLException, ClassNotFoundException
    {
       return repository.getCategories();
    }

    private int compareCategoriesByName(Category first, Category second)
    {
        return first.getName().compareTo(second.getName());
    }
    
    public Animal getAnimal(int id) throws SQLException, ClassNotFoundException
    {
        return repository.getAnimal(id);
    }

    public ArrayList<Animal> getAnimals() throws SQLException, ClassNotFoundException
    {
        return repository.getAnimals();
    }
    
    public ArrayList<Animal> getAnimalsByCategory(Category category) throws SQLException, ClassNotFoundException
    {
        return repository.getAnimalsByCategory(category.getId());
    }

    public ArrayList<Animal> getAnimalsByCategory(int categoryId) throws SQLException, ClassNotFoundException
    {
        return repository.getAnimalsByCategory(categoryId);
    }
    
    private int compareAnimalsByName(Animal first, Animal second)
    {
        return first.getName().compareTo(second.getName());
    }
}
