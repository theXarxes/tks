//import DTO.userDTO.GetUserDTO;
//import DTO.userDTO.PUserDTO;
//import org.junit.jupiter.api.Test;
//
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.Entity;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.GenericType;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//public class UserTest {
//
//    @Test
//    public void getAllTest(){
//        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
//        Client client = clientBuilder.build();
//        WebTarget target = client.target("http://localhost:8080/WEB-0.1/api/user");
//
//        List<GetUserDTO> u = target.request(MediaType.APPLICATION_JSON).get().readEntity(new GenericType<List<GetUserDTO>>() {
//        });
//        assertNotNull(u);
//        assertEquals(3, u.size());
//    }
//
//    @Test
//    public void getByNameTest(){
//        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
//        Client client = clientBuilder.build();
//        WebTarget target = client.target("http://localhost:8080/WEB-0.1/api/user");
//
//        GetUserDTO u = target.path("/user2")
//                .request(MediaType.APPLICATION_JSON)
//                .get(GetUserDTO.class);
//        assertNotNull(u);
//        assertEquals("Lolek", u.getName());
//    }
//
//    @Test
//    public void getAllPartLoginTest(){
//        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
//        Client client = clientBuilder.build();
//        WebTarget target = client.target("http://localhost:8080/WEB-0.1/api/user");
//
//        List<GetUserDTO> u = target
//                .path("/part/user")
//                .request(MediaType.APPLICATION_JSON)
//                .get()
//                .readEntity(new GenericType<List<GetUserDTO>>() {});
//        assertNotNull(u);
//        assertEquals(3, u.size());
//    }
//
//    @Test
//    public void updateTest() {
//        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
//        Client client = clientBuilder.build();
//        WebTarget target = client.target("http://localhost:8080/WEB-0.1/api/user");
//
//        PUserDTO u = new PUserDTO();
//        u.setLogin("user1");
//        u.setName("test");
//        target.request().put(Entity.json(u));
//        GetUserDTO u1 = target
//                .path("/user1")
//                .request(MediaType.APPLICATION_JSON)
//                .get(GetUserDTO.class);
//        assertNotNull(u);
//        assertEquals("test", u1.getName());
//    }
//
//    @Test
//    public void createTest() {
//        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
//        Client client = clientBuilder.build();
//        WebTarget target = client.target("http://localhost:8080/WEB-0.1/api/user");
//
//        PUserDTO u = new PUserDTO();
//        u.setLogin("test1");
//        u.setName("test1");
//        target.path("/addAdmin")
//                .request()
//                .post(Entity.json(u));
//
//        PUserDTO u1 = new PUserDTO();
//        u1.setLogin("test2");
//        u1.setName("test2");
//        target.path("/addData")
//                .request()
//                .post(Entity.json(u1));
//
//        PUserDTO u2 = new PUserDTO();
//        u2.setLogin("test3");
//        u2.setName("test3");
//        target.path("/addClient")
//                .request().
//                post(Entity.json(u2));
//
//        GetUserDTO test1 = target.path("/test1")
//                .request(MediaType.APPLICATION_JSON)
//                .get(GetUserDTO.class);
//        assertNotNull(test1);
//        assertEquals("test1", test1.getName());
//
//        GetUserDTO test2 = target.path("/test2")
//                .request(MediaType.APPLICATION_JSON)
//                .get(GetUserDTO.class);
//        assertNotNull(test2);
//        assertEquals("test2", test2.getName());
//
//        GetUserDTO test3 = target.path("/test3")
//                .request(MediaType.APPLICATION_JSON)
//                .get(GetUserDTO.class);
//        assertNotNull(test3);
//        assertEquals("test3", test3.getName());
//    }
//
//    @Test
//    public void createNoUniqueTest() {
//        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
//        Client client = clientBuilder.build();
//        WebTarget target = client.target("http://localhost:8080/WEB-0.1/api/user");
//
//        PUserDTO u = new PUserDTO();
//        u.setLogin("test1");
//        u.setName("test1");
//        Response r = target
//                .request()
//                .put(Entity.json(u));;
//        assertNotNull(r);
//        assertEquals(409, r.getStatus());
//    }
//}
