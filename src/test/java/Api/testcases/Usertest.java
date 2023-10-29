package Api.testcases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Api.endpoints.UserEndPoints;


import io.restassured.response.Response;

import Api.payload.User;

public class Usertest {

	Faker faker;
	User userPayload;

	public static Logger logg;
	@BeforeClass
	public void generateTestData()
	{
		logg = Logger.getLogger("RestAssuredAutomationFramework_test");
  		PropertyConfigurator.configure("Log4j.properties");
		//create fake data
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());


		//obtain logger

	}

	@Test(priority=1)
	public void testCreateUser()
	{
		Response response = UserEndPoints.createUser(userPayload);

		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);

		//log
		logg.info("Create User executed.");
	}


	@Test(priority=2)
	public void testGetUserData()
	{
		Response response = UserEndPoints.GetUser(this.userPayload.getUsername());

		System.out.println("Read User Data.");
		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);

		//log
		logg.info("Get User Data executed.");
	}

	@Test(priority=3)
	public void testUpdateUser()
	{
		userPayload.setFirstName(faker.name().firstName());
		Response response = UserEndPoints.UpdateUser(this.userPayload.getUsername(),userPayload);


		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);

		//Read User data to check if first name is updated 

		Response responsePostUpdate = UserEndPoints.GetUser(this.userPayload.getUsername());

		System.out.println("After Update User Data.");

		responsePostUpdate.then().log().all();

		//log
		logg.info("Update User executed.");

	}

	@Test(priority=4)
	public void testDeleteUser()
	{

		Response response = UserEndPoints.DeleteUser(this.userPayload.getUsername());

		System.out.println("Delete User Data.");

		//log response
		response.then().log().all();


		//validation
		Assert.assertEquals(response.getStatusCode(),200);

		
		//log
				logg.info("Delete User executed.");


	}

	
		

		
}
