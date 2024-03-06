Change Port & Database:

1. Edit application.properties in src/main/resources.
2. Set port: server.port=8080 (replace 8080 with your desired port).
3. Configure database
  spring.datasource.url=jdbc:mysql://localhost:5432/users
  spring.datasource.username=your_username
  spring.datasource.password=your_password
4.Run & Open in browser
  4.1 Navigate to your project's root directory in the terminal.
  4.2 Use mvn spring-boot:run to execute the application
  4.3 Open your web browser and navigate to http://localhost:your_port to view users list and add users. 
