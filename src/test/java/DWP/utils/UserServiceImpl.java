package DWP.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;

public class UserServiceImpl implements UserService {

	private HttpClient client;
	private HttpRequest request;
	private final double londonLat = 51 + (30 / 60.0) + (26 / 60.0 / 60.0);
	private final double londonLon = 0 - (7 / 60.0) - (39 / 60.0 / 60.0);
	private String url = "https://bpdts-test-app.herokuapp.com/users";

	@Override
	public List<User> getUsers() {
		client = HttpClient.newHttpClient();
		request = HttpRequest.newBuilder(URI.create(url)).build();
		String body = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
			  .thenApply(HttpResponse::body)
			  .join();
		
		return new UserServiceImpl().parse(body);
	}

	// Parse the returned JSON data
	public List<User> parse(String responseBody) {
		System.out.println("People who live with in 50 miles radius of London");
		JSONArray usersLondon = new JSONArray(responseBody);
		List<User> usersWithinRadius = new ArrayList();

		for (int i = 0; i < usersLondon.length(); i++) {

			JSONObject userLondon = usersLondon.getJSONObject(i);
			// ...
			int id = userLondon.getInt("id");
			String first_name = userLondon.getString("first_name");
			double latitude = userLondon.getDouble("latitude");
			double longitude = userLondon.getDouble("longitude");
			String emailId = userLondon.getString("email");
			String ip_address = userLondon.getString("ip_address");

			GeodesicData result = Geodesic.WGS84.Inverse(londonLat, londonLon, latitude, longitude);

			double distanceInMeters = result.s12;
			double distanceInMiles = distanceInMeters / 1609.34;

			if (distanceInMiles <= 50) {
				User user = new User();
				user.setId(id);
				user.setFirstName(first_name);
				user.setEmail(emailId);
				user.setIp_address(ip_address);
				user.setLatitude(latitude);
				user.setLongitude(longitude);

				usersWithinRadius.add(user);
			}
		}

		System.out.println(usersWithinRadius);

		return usersWithinRadius;
	}

}
