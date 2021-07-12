package DWP.utils;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ObjectMapper;


@Path("/users")
public class UserApi {
	
	
	private UserService userService = new UserServiceImpl();
	private ObjectMapper mapper = new ObjectMapper();
	
		@GET
	    @Path("/")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getUsers() {

		 List<User> userList = userService.getUsers();
		 return Response.status(Response.Status.OK)
                 .entity(userList)
                 .build();
	    }

}
