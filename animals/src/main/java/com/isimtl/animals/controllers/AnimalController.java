package com.isimtl.animals.controllers;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isimtl.animals.models.Animal;
import com.isimtl.animals.services.AnimalService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AnimalController", urlPatterns = { "", "/animals" })
public class AnimalController extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException
    {
        String path = "WEB-INF/animals.jsp";
        
        String categoryId = request.getParameter("categoryId");
        String animalId = request.getParameter("animalId");
        
        AnimalService service = new AnimalService();
        request.setAttribute("categories", service.getCategories());
        
        if (animalId != null)
        {
            Animal animal = service.getAnimal(Integer.parseInt(animalId));
            request.setAttribute("animal", animal);
            path = "WEB-INF/animal.jsp";
        }
        else if (categoryId != null)
        {
            ArrayList<Animal> animals = service.getAnimalsByCategory(Integer.parseInt(categoryId));
            request.setAttribute("animals", animals);
        }
        else
        {
            ArrayList<Animal> animals = service.getAnimals();
            request.setAttribute("animals", animals);
        }
        
        request.getRequestDispatcher(path).forward(request, response);
    }
}
