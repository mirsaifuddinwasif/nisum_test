# Persona Info "Nisum Test"
This project is a simple implementation of **Spring Boot** concepts via CRUD Rest Api's for Nisum Chile technical test.

**Java 1.8 JDK**

[H2 Console](http://localhost:8082/h2-console)

## Getting Started
To start this application go to the root folder and run this command in terminal/cmd
* **mvn clean install**
* **mvn spring-boot:run**
###REST CRUD operations
######GET 
http://localhost:8082/persona/
http://localhost:8082/persona/1

######POST
http://localhost:8082/persona

{
	"name" : "Saif",
	"lastName" : "Wasif",
	"address" : "Flat 22 Al Walja Ruwi Muscat Oman",
	"phoneNumber" : "94817282",
	"hairColor" : "black"
}

######PUT
http://localhost:8082/persona/1

{
	"name" : "Mir",
	"lastName" : "Uddin",
	"address" : "Flat 22 Azaiba Muscat Oman",
	"phoneNumber" : "94817282",
	"hairColor" : "black"
}

######DELETE
http://localhost:8082/persona/1

### Prerequisites
You need to install these dependencies for running Persona Info project.

Spring-boot-starter-web

spring-boot-starter-tomcat

spring-boot-starter-test

spring-boot-starter-data-jpa

h2

lombok

modelmapper

springfox-swagger2

### Running the tests
For test Rest Api Services go to: [Persona Info - Swagger](http://localhost:8082/swagger-ui.html)

### Built With
* [Spring Boot](https://spring.io/) - End-to-end support for reactive & servlet based apps on the JVM.
* [Maven](https://maven.apache.org/) - Dependency Management.
* [Swagger](https://swagger.io/) - Simplify API development for users.
* [H2](https://www.h2database.com/html/main.html) - Database Engine

### Versioning
Persona Info used [git](https://git-scm.com/) for version controlling. For the versions available, see the tags on [this](https://github.com/mirsaifuddinwasif/nisum_test) repository.

### Authors
* **Mir Saif Uddin Wasif** email : mirsaifuddinwasif@gmail.com

### License
This project is licensed under the MIT License - see the [LICENSE.md]() file for details.

### Acknowledgments
* [cave of programming](https://caveofprogramming.com/)