Hospital Management System (JDBC)
Overview

The Hospital Management System is a Java-based application developed using JDBC (Java Database Connectivity) to manage hospital operations such as patient records, doctor details, and appointments.

This project is created for learning and practicing Java, JDBC, and database management concepts in a real-world scenario.

Features

Add new patient records
View all patients
Add doctor details
Schedule appointments
Update patient information
Delete patient records
Search patient by ID or name
Simple console-based interface

Technologies Used

Java
JDBC (Java Database Connectivity)
MySQL Database
IDE (Eclipse / IntelliJ IDEA / VS Code)

Database Setup

Install MySQL and open MySQL Workbench or terminal.
Create database:
CREATE DATABASE hospital_db;
USE hospital_db;

Create tables:

CREATE TABLE patients (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    gender VARCHAR(10),
    disease VARCHAR(100)
);
CREATE TABLE doctors (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    specialization VARCHAR(100)
);
CREATE TABLE appointments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    FOREIGN KEY (patient_id) REFERENCES patients(id),
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);
JDBC Configuration

Update your database credentials inside DBConnection.java:

String url = "jdbc:mysql://localhost:3306/hospital_db";
String user = "root";
String password = "your_password";
How to Run
Clone the repository:
git clone https://github.com/your-username/hospital-management-system.git
Open the project in your IDE.
Add MySQL Connector JAR file to the project.
Run Main.java.

Sample Operations

Add Patient
View Patients
Add Doctor
Book Appointment
Update Patient Details
Delete Patient
Learning Outcomes
Understanding JDBC concepts
Performing CRUD operations
Managing relationships between tables
Building real-world database applications
