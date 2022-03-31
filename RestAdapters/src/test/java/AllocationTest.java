import DTO.markerDTO.GetMarkerDTO;
import DTO.markerDTO.PostMarkerDTO;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AllocationTest {

//    @Test
//    public void allocateTest() {
//        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
//        Client client = clientBuilder.build();
//        WebTarget target = client.target("http://localhost:8080/RestPAS-1.0-SNAPSHOT/api/allocate");
//
////        PostMarkerDTO resAllMarkerDTO = new PostMarkerDTO();
////        resAllMarkerDTO.setDelay(0);
////        resAllMarkerDTO.setUser("user2");
////        resAllMarkerDTO.setResourceId(UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c"));
//
//        JSONObject object = new JSONObject();
//        object.put("delay", 0);
//        object.put("user", "user2");
//        object.put("resourceId", "68a577ae-6863-4510-82ce-aadecadb736c");
//
//        target.path("/add").request(MediaType.APPLICATION_JSON).post(Entity.json(object.toString()));
//        List<GetMarkerDTO> r = target
//                .request()
//                .get()
//                .readEntity(new GenericType<List<GetMarkerDTO>>() {});
//        assertNotEquals(0, r.size());
//    }
//
//    @Test
//    public void getTest(){
//        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
//        Client client = clientBuilder.build();
//        WebTarget target = client.target("http://localhost:8080/RestPAS-1.0-SNAPSHOT/api/allocate");
//
//        List<GetMarkerDTO> r = target.request(MediaType.APPLICATION_JSON).get().readEntity(new GenericType<List<GetMarkerDTO>>(){});
//        GetMarkerDTO r1 = target
//                .path(r.get(0).getId().toString())
//                .request(MediaType.APPLICATION_JSON)
//                .get(GetMarkerDTO.class);
//        assertNotNull(r1);
//
//        GetMarkerDTO r2 = target
//                .path("/user/user2")
//                .request(MediaType.APPLICATION_JSON)
//                .get(GetMarkerDTO.class);
//        assertNotNull(r2);
//
//        GetMarkerDTO r3 = target
//                .path("/user/user2/current")
//                .request(MediaType.APPLICATION_JSON)
//                .get(GetMarkerDTO.class);
//        assertNotNull(r3);
//
//        GetMarkerDTO r4 = target
//                .path("/resource/68a577ae-6863-4510-82ce-aadecadb736c")
//                .request(MediaType.APPLICATION_JSON)
//                .get(GetMarkerDTO.class);
//        assertNotNull(r4);
//    }
//
//    @Test
//    public void endAllocationTest(){
//        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
//        Client client = clientBuilder.build();
//        WebTarget target = client.target("http://localhost:8080/RestPAS-1.0-SNAPSHOT/api/allocate");
//
//        List<GetMarkerDTO> r = target
//                .request(MediaType.APPLICATION_JSON)
//                .get()
//                .readEntity(new GenericType<List<GetMarkerDTO>>(){});
//
//        target.path("/end/" + r.get(0).getId().toString()).request(MediaType.APPLICATION_JSON).post(Entity.json(null));
//
//        GetMarkerDTO r1 = target.path("/" + r.get(0).getId().toString())
//                .request(MediaType.APPLICATION_JSON)
//                .get(GetMarkerDTO.class);
//        assertTrue(r1.isEnded());
//    }
//
//    @Test
//    public void findEndedUserTest(){
//        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
//        Client client = clientBuilder.build();
//        WebTarget target = client.target("http://localhost:8080/RestPAS-1.0-SNAPSHOT/api/allocate");
//
//        GetMarkerDTO r3 = target
//                .path("/user/user2/ended")
//                .request(MediaType.APPLICATION_JSON)
//                .get(GetMarkerDTO.class);
//        assertNotNull(r3);
//    }
//
//    @Test
//    public void deleteTest(){
//        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
//        Client client = clientBuilder.build();
//        WebTarget target = client.target("http://localhost:8080/RestPAS-1.0-SNAPSHOT/api/allocate");
//
//        PostMarkerDTO resAllMarkerDTO = new PostMarkerDTO();
//        resAllMarkerDTO.setDelay(0);
//        resAllMarkerDTO.setUser("user2");
//        resAllMarkerDTO.setResourceId(UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c"));
//        target.path("/add").request(MediaType.APPLICATION_JSON).post(Entity.json(resAllMarkerDTO));
//
//        List<GetMarkerDTO> r = target
//                .request(MediaType.APPLICATION_JSON)
//                .get()
//                .readEntity(new GenericType<List<GetMarkerDTO>>(){});
//
//        UUID id = r.get(r.size() - 1).getId();
//
//        target.path(id.toString()).request(MediaType.APPLICATION_JSON).delete();
//
//        List<GetMarkerDTO> r1 = target
//                .request(MediaType.APPLICATION_JSON)
//                .get()
//                .readEntity(new GenericType<List<GetMarkerDTO>>(){});
//
//        assertFalse(id.equals(r1.get(r1.size()-1).getId()));
//    }
}
