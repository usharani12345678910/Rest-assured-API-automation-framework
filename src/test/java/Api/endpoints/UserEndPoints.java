package Api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import Api.payload.User;
import io.restassured.http.ContentType;

public class UserEndPoints {
//post
	
	public static Response createUser(User payload)
	{
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(payload)
		
		
		.when()
		.post(Routes.post_url);
		
		return response;
	}
	
	
	public static Response GetUser(String userName)
	{
		Response response = given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		
		.when()
		.get(Routes.get_url);
		
		return response;
	}
	
	//patch/put
	public static Response UpdateUser(String userName, User payload)
	{
		Response response = given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		
		.when()
		.put(Routes.put_url);
		
		return response;
	}
	
	
	public static Response DeleteUser(String userName)
	{
		Response response = given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
			
		
		.when()
		.delete(Routes.del_url);
		
		return response;
	}



	
}
