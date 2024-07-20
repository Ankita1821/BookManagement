package RestAssured;

import java.util.HashMap;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class addBook {
	 @BeforeClass
	    public void setup() {
	        // Base URI of the API
	        RestAssured.baseURI = "http://api.example.com";
	    }

	    // Adding a Book with valid inputs
	    @Test(priority=0)
	    public void addBookValidInput() {
	    	 JSONObject requestBody = new JSONObject();
	         requestBody.put("title", "selenium");
	         requestBody.put("ISBN", "ABC");
	     
	        Response response = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .body(requestBody)
	            .when()
	            .post("/books");

	        Assert.assertEquals(response.getStatusCode(), 201);
	        System.out.println(response.getHeader("content-type"));
	        System.out.println(response.getTime());
	        System.out.println("Response: " + response.getBody().asString());
	    }

	    // Adding a Book with invalid inputs
	    @Test
	    public void addBookInvalidInput() {
	    	 JSONObject requestBody = new JSONObject();
	         requestBody.put("title", "87893896");
	         requestBody.put("ISBN", "----");

	        Response response = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .body(requestBody)
	            .when()
	            .post("/books");

	        Assert.assertEquals(response.getStatusCode(), 400);
	        System.out.println(response.getHeader("content-type"));
	        System.out.println(response.getTime());
	        System.out.println("Response: " + response.getBody().asString());
	    }
	    
	    // Retrieving a Book with a valid book ID
	    @Test(priority=1)
	    public void getBookValidID() {
	        int validBookId = 1; // Replace with a valid book ID

	        Response response = RestAssured.given()
	            .when()
	            .get("/books/" + validBookId);

	       
	        System.out.println("Response: " + response.getBody().asString());

	        // Assert that the status code is 200 (OK)
	        Assert.assertEquals(response.getStatusCode(), 200);
	        System.out.println(response.getHeader("content-type"));
	        System.out.println(response.getTime());
	        System.out.println("Response: " + response.getBody().asString());
	        //We can also add validation based on response key 
	     
	    }

	    // Retrieving a Book with an invalid book ID
	    @Test
	    public void getBookInvalidID() {
	        int invalidBookId = 89-9797; // Replace with an invalid book ID

	        Response response = RestAssured.given()
	            .when()
	            .get("/books/" + invalidBookId);

	        System.out.println("Response: " + response.getBody().asString());

	        // Assert that the status code is 404 (Not Found)
	        Assert.assertEquals(response.getStatusCode(), 404);
	        System.out.println(response.getHeader("content-type"));
	        System.out.println(response.getTime());
	        System.out.println("Response: " + response.getBody().asString());
	       
	    }
	    
	    
	    //Update a Book details
	    
	    @Test(priority=2)
	    public void updateBookValidData() {
	        int isbnId = 9876; 

	        // Constructing JSON request body with valid data
	        JSONObject requestBody = new JSONObject();
	        requestBody.put("title", "Selenium");
	        requestBody.put("author", "Updated Author");
	        requestBody.put("publishedDate", "2024-20-01"); 

	        Response response = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .body(requestBody.toString())
	            .when()
	            .put("/books/" + isbnId);

	        System.out.println("Response: " + response.getBody().asString());

	        // Assert that the status code is 200 (OK)
	        Assert.assertEquals(response.getStatusCode(), 200);
	        System.out.println(response.getHeader("content-type"));
	        System.out.println(response.getTime());
	        System.out.println("Response: " + response.getBody().asString());
	    }

	    // Updating Book Details with invalid data
	    @Test
	    public void updateBookInvalidData() {
	        int bookId = 1; // Replace with a valid book ID

	        // Constructing JSON request body with invalid data
	        JSONObject requestBody = new JSONObject();
	        requestBody.put("title", ""); // Invalid: empty title
	        requestBody.put("author", ""); // Invalid: empty author
	        requestBody.put("isbn", ""); // Invalid: empty ISBN
	        requestBody.put("publishedDate", ""); // Invalid: empty date

	        Response response = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .body(requestBody.toString())
	            .when()
	            .put("/books/" + bookId);

	        // Print the response for debugging
	        System.out.println("Response: " + response.getBody().asString());

	        // Assert that the status code is 400 (Bad Request)
	        Assert.assertEquals(response.getStatusCode(), 400);
	        System.out.println(response.getHeader("content-type"));
	        System.out.println(response.getTime());
	        System.out.println("Response: " + response.getBody().asString());

	  
	    }
	    
	    //Deleting a Book with valid and invalid book IDs.
	    
	    @Test(priority=3)
	    public void deleteBookValidID() {
	        int validBookId = 14435;

	        Response response = RestAssured.given()
	            .when()
	            .delete("/books/" + validBookId);

	        System.out.println("Response: " + response.getBody().asString());
	        Assert.assertEquals(response.getStatusCode(), 204);
	        System.out.println(response.getHeader("content-type"));
	        System.out.println(response.getTime());
	        System.out.println("Response: " + response.getBody().asString());
	    }

	    // Deleting a Book with an invalid book ID
	    @Test
	    public void deleteBookInvalidID() {
	        int invalidBookId = 387493-434; 

	        Response response = RestAssured.given()
	            .when()
	            .delete("/books/" + invalidBookId);

	    
	        System.out.println("Response: " + response.getBody().asString());
	        Assert.assertEquals(response.getStatusCode(), 404);
	        System.out.println(response.getHeader("content-type"));
	        System.out.println(response.getTime());
	        System.out.println("Response: " + response.getBody().asString());
	    }
	

}
