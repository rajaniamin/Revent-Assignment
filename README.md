# Revent-Assignment

# Student Data Management Application

## Introduction

This is a comprehensive student data management application that combines both backend and frontend components. The backend is developed using Java Spring Boot and utilizes an H2 database, while the frontend is created using HTML, CSS, JavaScript, and Bootstrap. This README provides a detailed overview of the application, its components, available APIs, and instructions on how to interact with them using Postman and Swagger UI.

[Explanation Video](https://drive.google.com/file/d/1FAO9bripymO_uG27VrsdU9239kb0ePQg/view?usp=sharing)

## Getting Started

To get started with our Student Data Management Application, follow these simple steps:

### 1. Clone the Repository

- Click the "Clone" button on our GitHub repository, or run this command in your terminal:
  ```bash
  git clone (https://github.com/rajaniamin/Revent-Assignment.git)
-Run index.htm.html which is resent inside the frontend folder , together run the spring boot application as well

## Backend (Java Spring Boot)

### Dependencies

The backend of this application relies on several key dependencies:

- **Spring Web:** Provides essential web-related functionalities.
- **Spring JPA:** A Java Persistence API that simplifies database operations.
- **H2 Database:** An in-memory database for convenient data storage and retrieval during development.

### APIs

The backend offers a range of APIs for managing student data:

1. **Add a Single Student Data:**
   - HTTP Method: POST
   - URL: `/addData`
   - Function: Adds a single student data record.
   - Request Body: JSON representation of the student data.
   - Example Request:
     ```json
     {
       "id": 1,
       "name": "John Doe",
       "age": 20,
       "grade": "A"
     }
     ```
   - Example Response: Returns the added student data.

2. **Add Multiple Student Data:**
   - HTTP Method: POST
   - URL: `/addDatas`
   - Function: Adds multiple student data records.
   - Request Body: JSON array of student data objects.
   - Example Request:
     ```json
     [
       {
         "id": 1,
         "name": "Rajani",
         "subject": "sceince,
         "marks": 95
       },
       {
         "id": 2,
         "name": "Rachana",
         "subject": "maths,
         "marks": 95
       }
     ]
     ```
   - Example Response: Returns the added student data records.

3. **Get Student Data by ID:**
   - HTTP Method: GET
   - URL: `/student/{id}`
   - Function: Retrieves a student's data by their ID.
   - Example Request: `/student/1`
   - Example Response: Returns the student data with the specified ID.

4. **Get All Student Data:**
   - HTTP Method: GET
   - URL: `/studentslist`
   - Function: Retrieves a list of all student data records.
   - Example Request: `/studentslist`
   - Example Response: Returns a list of all student data.

5. **Update Student Data:**
   - HTTP Method: PUT
   - URL: `/updatedata`
   - Function: Updates a student's data.
   - Request Body: JSON representation of the updated student data.
   - Example Request:
     ```json
     {
         "id": 1,
         "name": "Rajani",
         "subject": "sceince,
         "marks": 95
       }
     ```
   - Example Response: Returns the updated student data.

6. **Delete Student Data by ID:**
   - HTTP Method: DELETE
   - URL: `/student/{id}`
   - Function: Deletes a student's data by their ID.
   - Example Request: `/student/1`
   - Example Response: Returns a confirmation message.

## Frontend (HTML, CSS, JavaScript, Bootstrap)

The frontend is a user-friendly interface for interacting with student data. It's developed using HTML, CSS, JavaScript, and Bootstrap to provide a clean and responsive design. The frontend enables users to:

1. Add new student data records.
2. View details of a specific student.
3. Access a list of all students.
4. Update student information.
5. Delete student data.

The frontend communicates with the backend through the mentioned APIs.

## Interacting with the APIs

You can easily interact with the APIs using popular tools like Postman or Swagger UI.

### Using Postman

1. Launch Postman.
2. Create a new request.
3. Choose the appropriate HTTP method (e.g., POST, GET, PUT, DELETE).
4. Enter the API URL (e.g., `http://localhost:8080/addData`).
5. If necessary, define the request body in JSON format.
6. Send the request and examine the response.

### Using Swagger UI

1. Start the application.
2. Access the Swagger UI documentation at `http://localhost:8080/swagger-ui.html`.
3. Here, you can explore the available APIs, make requests, and view responses directly from the UI.

