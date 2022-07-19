package com.isimtl.animals.models;

public class Animal
{
    private final int id;
    private final int categoryId;
    private final String name;
    private final String imageUrl;

    public Animal(int id, int categoryId, String name, String imageUrl)
    {
        if (name == null)
            throw new IllegalArgumentException("Name must not be null.");
        if (imageUrl == null)
            throw new IllegalArgumentException("Image url must not be null.");
        
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public int getId()
    {
        return id;
    }

    public int getCategoryId()
    {
        return categoryId;
    }
    
    public String getName()
    {
        return name;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }
    
    @Override
    public String toString()
    {
        return "Animal " + id + " " + name;
    }
}
