package stepdef;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.ExecutionException;

import DWP.utils.User;
import org.junit.Assert;
import DWP.utils.App;
import DWP.utils.UserService;
import DWP.utils.UserServiceImpl;

import cucumber.api.java.en.Then;
public class DWPAPITests {
	HttpClient client = HttpClient.newHttpClient();
	HttpRequest request;
	HttpResponse response = null;
	UserService userService = new UserServiceImpl();


	@Then("I trigger get service to fetch userList")
	public void i_trigger_get_service_to_fetch_userList() {
		request = HttpRequest.newBuilder(URI.create("https://bpdts-test-app.herokuapp.com/users")).build();
		try {
			response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
					.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**************** Response from Get" + response.body());

	}

	@Then("I should get {int} success code without errors in body")
	public void i_should_get_success_code_without_errors_in_body(Integer code) {
		int responseCode = response.statusCode();
		System.out.println("Status code*********" + responseCode);
		Assert.assertEquals(code, responseCode, 0.0);

	}

	@Then("I trigger get service to fetch users lives in {string}")
	public void i_trigger_get_service_to_fetch_users_lives_in(String sCity) {
		String baseURL = "https://bpdgts-test-app.herokuapp.com/city/" + sCity + "/users";
		try {
			request = HttpRequest.newBuilder(URI.create(baseURL)).build();
			response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
					.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("**************** Response from Get" + response.body());

	}

	@Then("I trigger get service to fetch users lives in 50 miles radius")
	public void i_trigger_post_service_to_fetch_users_lives_in_50Miles() {
		// Using java.net.http.HttpClient
		List<User> userList = userService.getUsers();
		System.out.println(userList);
		
	}

	


}
