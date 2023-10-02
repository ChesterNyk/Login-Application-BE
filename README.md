# Login Application - BE
## Problem Statement
Login Application BE that handles querying database for valid users

## Technologies Used
Spring Boot
- Java
- H2 (for database)
- Mockito / Junit for testing

## Description / Features
The Login Application BE is a spring-boot application that provides backend services for a Login application. This application works together with a React application that serves as the FE.
- <b>Randomize Selection:</b>
    - <b>EndPoint:</b> `Post` `/login`
    - <b>Purpose:</b> Check DB if login credentials are valid
    - <b>Request Body:</b>
      ```js
      {"username" : "john@example.com", "password" : "password1"}
      ```
    - <b>Response Body:</b>
      ```js
      {
        "result": "Success",
        "data": {
        "response": {
            "message": null,
            "status": "Success",
            "userInfo": {
               "username": "john@example.com",
               "name": "John Tan",
               "role": "MANAGER",
               "permission": [
                  {
                   "code": "V01"
                  },
                  {
                   "code": "VL01"
                  },
                  {
                   "code": "VL02"
                  }
               ]
            }
        }
      },
       "errorMessage": "",
       "errorCode": ""
      }
      ```
    - <b>Get all User:</b>
        - <b>EndPoint:</b> `Get` `/allUsers`
        - <b>Purpose:</b> Get all User
        - <b>Request Body:</b> `null`
    - <b>Response Body:</b>
      ```js
      { "result": "Success", 
         "data": { 
          "response": [
              { 
                "userId": 1,
                "name": "John Tan",
                "username": "john@example.com"
                "role": "MANAGER"
              },
              { 
                "userId": 2,
                "name": "Mark Lee",
                "username": "mark@example.com"
                "role": "USEr"
              },
          ]
        },
       "errorMessage": "",
       "errorCode": ""
      }
## Usage
To Run the application in you local machine, follow these steps
### Prerequisites
Make sure you have the following installed:
- <b>Java 11 or higher</b>: Download and install it from [Oracle's website](https://www.oracle.com/java/technologies/javase-downloads.html) or your preferred package manager.
- <b>Maven</b>: If you don't have Maven installed, download it from [Maven's official website](https://maven.apache.org/download.cgi) and follow the installation instructions.

### Installation & Setup
1. Open Command Prompt:
    - Press the Windows symbol key, type `cmd` and hit Enter to open Command Prompt.
2. Clone the Repository
    - Use the `git clone` command to clone the Lunch Location Randomizer BE repository to your local machine:
    ```sh
    git clone <respository URl>
    ```
3. Navigate to the Project Folder
    - Change your current directory to the project folder:
    ```sh
    cd <project folder>
    ```
4. Build Application:
    - Use `mvn` to build the application using maven:
    ```sh
    mvn clean install
    ```
### Running the Application
Start the Spring-Boot application:
- Run the following command to start the application:
    ```sh
    mvn spring-boot:run
    ```
Start the Spring-Boot application:
- Run the following command to run the unit test of the application:
    ```sh
    mvn test
    ```
## Room For Improvement / Future Features
There are many ways that this app can be improved upon! Here is a list of some ideas for future improvements:
- Implement Spring Security to handle authentication and authorisation
- Custom Exception

## Author
- Name: Chester Ng
- Email: [chesternyk19@gmail.com](mailto:chesternyk19@gmail.com)
- LinkedIn Profile: [linkedin.com/in/chester-ng-b81222214](https://www.linkedin.com/in/chester-ng-b81222214)
