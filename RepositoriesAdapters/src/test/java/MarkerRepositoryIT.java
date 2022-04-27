import adapter.repositories.data.resources.ResourceAllocationMarkerEnt;
import adapter.repositories.repository.ResAllMarkerRepository;
import exception.ResourceAllocationException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class MarkerRepositoryIT {

    private final ResAllMarkerRepository rep = new ResAllMarkerRepository();

    private final UUID uuid = UUID.randomUUID();

    @Test
    @Order(1)
    public void addMarkerTest(){
        ResourceAllocationMarkerEnt test = new ResourceAllocationMarkerEnt(
                uuid,
                LocalDate.now(),
                UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c"),
                false,
                "user1"
        );
        rep.addMarker(test);
        assertEquals("user1", rep.findById(uuid).getUser());
        assertNotEquals(0, rep.getMarkers().size());
    }

    @Test
    @Order(3)
    public void findAllByUserTest(){
        for (ResourceAllocationMarkerEnt e: rep.findAllByUser("user1")){
            assertEquals("user1", e.getUser());
        }
    }

    @Test
    @Order(4)
    public void findAllResourceTest(){
        for (ResourceAllocationMarkerEnt e: rep.findAllByResource(UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c"))){
            assertEquals(e.getResource(), UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c"));
        }
    }

    @Test
    @Order(5)
    public void delete(){
        try {
            rep.delete(uuid);
            assertNull(rep.findById(uuid));
        } catch (ResourceAllocationException e) {
            e.printStackTrace();
        }
    }
}
