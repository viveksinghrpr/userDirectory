Change Port & Database:

1. Edit application.properties in src/main/resources.
2. Set port: server.port=8080 (replace 8080 with your desired port).
3. 
4. Configure database
5. spring.datasource.url=jdbc:mysql://localhost:5432/users
6. spring.datasource.username=your_username
7. spring.datasource.password=your_password
   
9. Run & Open in browser
10. Navigate to your project's root directory in the terminal.
11. Use mvn spring-boot:run to execute the application
12. Open your web browser and navigate to http://localhost:your_port to view users list and add users. 
  

