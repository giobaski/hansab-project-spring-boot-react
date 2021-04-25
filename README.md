# Hansab project with Spring Boot and React
Restfull Api for for querying information about users and cars. 

# To run this you need:
- Java 11
- Maven
- node.js
- npm

# Building and running the app
- To build the Java app run `./mvnw clean package`
- To run the Java app run `java -jar target/cars-rest-api-0.0.1-SNAPSHOT.jar`
- To start the front end, cd into frontend-react and run `npm start`



# OR check project deployed on Heroku server

- `API docs`: https://hansab-cars-api.herokuapp.com/v2/api-docs 

- `Swagger UI`: https://hansab-cars-api.herokuapp.com/swagger-ui.html#

- `FRONT`: https://hansab-cars-frontend.herokuapp.com/

- `Example 1.  get all users`: https://hansab-cars-api.herokuapp.com/api/users

- `Example 2. Filter&Sort users:`  https://hansab-cars-api.herokuapp.com/api/users?find=Teet&sort=name:desc



CI/CD is implemented using Github Actions. 
If all tests pass successfully, package will be deployed/updated on Heroku
![Screen Shot 2021-04-25 at 9 52 23 PM](https://user-images.githubusercontent.com/4931346/116005757-0c8aa600-a611-11eb-8a5c-b092a0d4a553.png)
