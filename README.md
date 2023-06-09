# Student Management System - Back End <img src="assets/sms-logo.png" alt="drawing" width="27px"/>

This project was developed using **Spring Boot** framework with having **n-tier architecture** in order to understand and improve the 
knowledge of spring boot and software architectures.
The fundamental **CRUD activities** of a student management system are present in this project.
Web services are exposed as APIs under the **students** resource in this project.

More information on the exposed web services with example test cases can be found in the below API documentation.
- [**Students API documentation**](https://documenter.getpostman.com/view/25306703/2s93JtQPYm)

See the **React JS** front end of the project from [here.](https://github.com/PubuduJ/student-management-system-front-end)<br>
See the **React** with **TypeScript** front end of the project from [here.](https://github.com/PubuduJ/student-management-system-front-end-ts)

#### Highlighted features of the application,
- Students are registered to the system by their NIC number.
- A system administrator can enter, amend, remove, and retrieve student information.

#### Few snapshots of the documentation
- An attempt to update a student that does not exist in the database.<br>

<img src="assets/update-error.png" alt="update-error" width="800px"/>

- Send incorrect JSON in request payload.<br>

<img src="assets/invalid-json.png" alt="invalid-json" width="800px"/>

- An attempt to register a student that already exist in the database.<br>

<img src="assets/register-error.png" alt="register-error" width="800px"/>

- An attempt to delete a student that does not exist in the database.<br>

<img src="assets/delete-error.png" alt="delete-error" width="800px"/>


#### ERD of the database

<img src="assets/SMS-ERD.png" alt="erd" width="400px"/>

## Used Technologies

- Java SE 11
- Spring Boot 2.7.8
- Apache Maven 3.8.6
- MySQL Community Server 8.0.31
- Added dependencies to pom.xml
    - spring-boot-starter-web 2.7.8
    - spring-boot-starter-validation 2.7.8
    - spring-boot-starter-data-jpa 2.7.8
    - spring-boot-starter-aop 2.7.8
    - spring-boot-starter-test 2.7.8
    - spring-boot-devtools
    - lombok 1.18.24
    - mysql-connector-j 8.0.31
    - modelmapper 3.1.0

#### Used Integrated Development Environment
- IntelliJ IDEA

## How to use ?
This project can be used by cloning the 
project to your local computer.

Make sure to create a **student_app_db** database in the MySQL community server.
If neglect to create, the project will automatically generate it when it is firstly executed.

#### Clone this repository
1. Clone the project using `https://github.com/PubuduJ/student-management-system-back-end.git` terminal command.
2. Open the `pom.xml` file from **IntelliJ IDEA**, make sure to open this as a project.
3. Change the `spring.datasource.password` in the `application.properties` to your local machine MySQL server password.

## Credits
This project was carried out under the guidance of the [IJSE](https://www.ijse.lk/) Direct Entry Program 9.

## Version
v1.0.2

## License
Copyright &copy; 2023 [Pubudu Janith](https://www.linkedin.com/in/pubudujanith94/). All Rights Reserved.<br>
This project is licensed under the [MIT license](LICENSE.txt).