import DTO.markerDTO.GetMarkerDTO;
import DTO.markerDTO.PostMarkerDTO;
import org.json.JSONObject;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AllocationIT {

    private String url = "http://localhost:8080/test/api/allocate";

    @Test
    @Order(1)
    public void allocateTest() {
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
        Client client = clientBuilder.build();
        WebTarget target = client.target(url);

        JSONObject object = new JSONObject();
        object.put("delay", 0);
        object.put("user", "user2");
        object.put("resourceId", "68a577ae-6863-4510-82ce-aadecadb736c");

        target.path("/add").request(MediaType.APPLICATION_JSON).post(Entity.json(object.toString()));

        Response rr = target
                .request()
                .get();
        List<GetMarkerDTO> r = rr.readEntity(new GenericType<List<GetMarkerDTO>>() {});

        assertNotEquals(0, r.size());
        target.path(r.get(r.size()-1).getId().toString()).request(MediaType.APPLICATION_JSON).delete();
    }

    @Test
    @Order(2)
    public void getTest(){
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
        Client client = clientBuilder.build();
        WebTarget target = client.target(url);

        JSONObject object = new JSONObject();
        object.put("delay", 0);
        object.put("user", "user2");
        object.put("resourceId", "68a577ae-6863-4510-82ce-aadecadb736c");

        target.path("/add").request(MediaType.APPLICATION_JSON).post(Entity.json(object.toString()));

        Response rr = target
                .request()
                .get();
        List<GetMarkerDTO> r = rr.readEntity(new GenericType<List<GetMarkerDTO>>() {});

        GetMarkerDTO r1 = target
                .path(r.get(0).getId().toString())
                .request(MediaType.APPLICATION_JSON)
                .get(GetMarkerDTO.class);
        assertNotNull(r1);

        List<GetMarkerDTO> r2 = target
                .path("/user/user2")
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<GetMarkerDTO>>(){});;
        assertNotNull(r2);

        List<GetMarkerDTO> r3 = target
                .path("/user/user2/current")
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<GetMarkerDTO>>(){});
        assertNotNull(r3);

        List<GetMarkerDTO> r4 = target
                .path("/resource/68a577ae-6863-4510-82ce-aadecadb736c")
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<GetMarkerDTO>>(){});;
        assertNotNull(r4);

        target.path(r.get(r.size()-1).getId().toString()).request(MediaType.APPLICATION_JSON).delete();
    }

    @Test
    @Order(3)
    public void endAllocationTest(){
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
        Client client = clientBuilder.build();
        WebTarget target = client.target(url);

        JSONObject object = new JSONObject();
        object.put("delay", 0);
        object.put("user", "user2");
        object.put("resourceId", "68a577ae-6863-4510-82ce-aadecadb736c");

        target.path("/add").request(MediaType.APPLICATION_JSON).post(Entity.json(object.toString()));

        List<GetMarkerDTO> r = target
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<GetMarkerDTO>>(){});

        target.path("/end/" + r.get(0).getId().toString())
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(null));

        GetMarkerDTO r1 = target.path("/" + r.get(0).getId().toString())
                .request(MediaType.APPLICATION_JSON)
                .get(GetMarkerDTO.class);
        assertTrue(r1.isEnded());

        List<GetMarkerDTO> r3 = target
                .path("/user/user2/ended")
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<GetMarkerDTO>>(){});
        assertFalse(r3.isEmpty());

        target.path(r.get(r.size()-1).getId().toString()).request(MediaType.APPLICATION_JSON).delete();
    }

    @Test
    @Order(4)
    public void deleteTest(){
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
        Client client = clientBuilder.build();
        WebTarget target = client.target(url);

        PostMarkerDTO resAllMarkerDTO = new PostMarkerDTO();
        resAllMarkerDTO.setDelay(0);
        resAllMarkerDTO.setUser("user2");
        resAllMarkerDTO.setResourceId(UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c"));
        target.path("/add").request(MediaType.APPLICATION_JSON).post(Entity.json(resAllMarkerDTO));

        List<GetMarkerDTO> r = target
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<GetMarkerDTO>>(){});

        UUID id = r.get(r.size() - 1).getId();

        target.path(id.toString()).request(MediaType.APPLICATION_JSON).delete();

        List<GetMarkerDTO> r1 = target
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<GetMarkerDTO>>(){});

        assertNotEquals(id, r1.get(r1.size() - 1).getId());
    }
}
