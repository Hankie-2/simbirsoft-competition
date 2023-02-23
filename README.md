# :dragon_face: Legend
Our company "Drip-Chip" is engaged in chipping animals in the country "Wonderland" to track their movement and life cycles. The movement of animals on the planet is extremely important, including to protect them from death.

This year, our company decided to create a single database in which the records of past years will be transferred, in order to conduct multi-year experiments related to animal migrations, as well as to track changes in habitats and keep history.
___
# :white_check_mark: System functionality
## The system has the following components
- Account
- Animal
- Animal Type
- Location Point
- Animal Visited Location

## The following functionality available in controllers
- Authentication:
    - Account Registration
- Account:
    - View account information
    - Find/change/delete an account

- Animal
    - Viewing information about an animal
    - Find/create/modify/delete an animal
    - Creating/changing/deleting an animal type

- Animal Type:
    - Viewing Animal Type Information
    - Creating/changing/deleting an animal type

- Location Point:
    - Viewing information about a locate point
    - Creating/changing/deleting a location point

- Animal Visited Location:
    - Viewing Animal Movement Information
    - Creating/changing/deleting a location point for an animal

____
# Technologies
## This application is written in Java using the following technologies:
- **Spring Framework** - for building Restful APIs and managing dependencies.
- **Spring Boot** - for automatically configuring an application and running it.
- **Hibernate** - to work with the database and ORM.
- **PostgreSQL** - an open-source relational database management system that is used for storing the data for this application
- **Spring Boot Starter Data JPA** - a starter module that provides support for using Spring Data JPA with Hibernate as the persistence provider.
- **Spring Boot Starter Validation** - a starter module that provides a set of annotations and utilities for validating data in Spring Boot applications.
- **MapStruct** - a code generator that simplifies the mapping of Java beans to each other, without requiring manual mapping code.
- **Lombok** - a Java library that helps to reduce boilerplate code by providing annotations that generate getters, setters, constructors, and other code at compile time.

# Installation
## To run this application on your computer, you need to follow the following steps:
1) Install Java and PostgreSQL on your computer if they are not already installed.
2) Clone the repository on your computer.
3) Create a PostgreSQL database and configure its settings in the **application.properties** file.
4) Run the application using Maven with the mvn _spring-boot:run_ command.

# Usage
## After launching the application, you can use any tool to work with the API, such as Postman or cURL.
## The API is available at http://localhost:8080/*

# Contribution
## If you have any ideas or fixes for this application, please create a Pull Request or Issue in this repository.