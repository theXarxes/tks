import DTO.resourceDTO.GetResourceDTO;
import DTO.resourceDTO.PostResourceDTO;
import DTO.resourceDTO.PutResourceDTO;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ResourceIT {

    @Test
    public void getTest() {
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
        Client client = clientBuilder.build();
        WebTarget target = client.target("http://localhost:8080/test/api/resource");

        GetResourceDTO r = target
                .path("/68a577ae-6863-4510-82ce-aadecadb736c")
                .request(MediaType.APPLICATION_JSON)
                .get(GetResourceDTO.class);
        assertNotNull(r);
        assertEquals(1, r.getValueOfResource());
    }

    @Test
    public void getAllTest() {
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
        Client client = clientBuilder.build();
        WebTarget target = client.target("http://localhost:8080/test/api/resource");

        List<GetResourceDTO> r = target
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<GetResourceDTO>>() {});
        assertNotNull(r);
        assertEquals(5, r.size());
    }

    @Test
    public void updateTest() {
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
        Client client = clientBuilder.build();
        WebTarget target = client.target("http://localhost:8080/test/api/resource");

        PutResourceDTO resourceDTO = new PutResourceDTO();
        resourceDTO.setId(UUID.fromString("f01221d3-c14b-4c40-adfb-509238ed26a4"));
        resourceDTO.setValueOfResource(420);
        target.request(MediaType.APPLICATION_JSON).put(Entity.json(resourceDTO));

        GetResourceDTO r1 = target
                .path("/f01221d3-c14b-4c40-adfb-509238ed26a4")
                .request(MediaType.APPLICATION_JSON)
                .get(GetResourceDTO.class);
        assertNotNull(r1);
        assertEquals(420, r1.getValueOfResource());
    }

    @Test
    public void createTest() {
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
        Client client = clientBuilder.build();
        WebTarget target = client.target("http://localhost:8080/test/api/resource");

        PostResourceDTO resourceDTO = new PostResourceDTO();
        resourceDTO.setValueOfResource(4);
        target.request(MediaType.APPLICATION_JSON).post(Entity.json(resourceDTO));
        List<GetResourceDTO> r = target
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<GetResourceDTO>>() {});
        assertNotNull(r);

        assertEquals(4, r.get(r.size()-1).getValueOfResource());
    }

    @Test
    public void deleteTest() {
        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
        Client client = clientBuilder.build();
        WebTarget target = client.target("http://localhost:8080/test/api/resource");

        List<GetResourceDTO> r = target
                .request(MediaType.APPLICATION_JSON)
                .get()
                .readEntity(new GenericType<List<GetResourceDTO>>() {});
        target.path(r.get(r.size()-1).getId().toString()).request().delete();

        GetResourceDTO r1 = target.path("/f01221d3-c14b-4c40-adfb-509238ed26a4")
                .request()
                .get()
                .readEntity(GetResourceDTO.class);
        assertNotNull(r1);
        assertEquals(420, r1.getValueOfResource());
    }
}
