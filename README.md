<h1>Animals: JDBC</h1><br>
Create a copy of the Animals folder. Modify the project to use a database for persistent storage<br>
<h3>Database</h3>
• In DBeaver, ensure there is a connection to your MariaDB database server (should be called “localhost”)<br>
• Create a database called “animals_db”<br>
• Use the provided SQL script to generate the “animals” and “categories” tables<br>
<h3>Animal repository</h3>
Write a CRUD repository class to handle communication with the database. For now, all you need is to add query 
methods (no adding, removing, or updating required).<br>
Public query methods<br>
• Category getCategory(int id)<br>
• ArrayList<Category> getCategories()<br>
• Animal getAnimal(int id)<br>
• ArrayList<Animal> getAnimals()<br>
• ArrayList<Animal> getAnimalsByCategory(int categoryId)<br>
<h3>Test</h3>
• Ensure that all of your public repository methods work correctly<br>
• To do so, it might be helpful to create a simple console application (not web application) for testing<br>
<h3>Animal service</h3>
Modify the implementation of the AnimalService class to use a repository to access the database. Previously it 
was using static hash maps of categories and animals to simulate a database<br>
• Delete the hash maps<br>
• Replace them with an AnimalRepository instance variable (not a static variable)<br>
• Initialize the repository in the default constructor<br>
• Rewrite the definition of all the public methods in the class (no need to add or remove any public 
methods) to use the repository instead of the hash maps to access the animals and categories<br>
• Keep the code that sorts the lists of animals and categories<br>
<h3>Test</h3>
• Test the web application to make sure that everything works correctly
