# Book Management Test

## Description

Book Management is a service that contains following:
1. Option to register a user
2. Login page for the users
3. Dashboard for the book management

This project consists of UI as well as API automated test cases for the book management service.
For API automation, we have used the RestAssured framework. For the UI automation, we have used Selinium with Java.

## Guidelines to run the tests
### Setup
To setup this repo, we need to make sure following packages are installed in the system
1. Java sdk version 11.x
To run the test cases, we need to install an IDE to run the xml files. Recomended IDE - eclipse, intelij
All the required dependencies are present in BookManagement/pom.xml file

### Execute
To execute the book management UI test cases, run the BookManagement/testng.xml file.
To execute the book management API test cases, run the BookManagement/Api.xml file.

## Sample tests
Sample test data is present in BookManagement/testdata/TestData.xlsx file. Corresponsing to that, the output will be present in BookManagement/testng report and BookManagement/test-output/output.xlsx folder

## Assignment Requirement
This project involves automating the book management service for different roles such as Admin, Bookkeeper, and Searcher. It handles various test cases, including both positive and negative scenarios, based on login credentials and role-based permissions.
