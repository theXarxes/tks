import adapter.repositories.data.resources.ResourceEnt;
import adapter.repositories.repository.ResourceRepository;
import exception.ResourceAllocationException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ResourceRepositoryIT {

    private final ResourceRepository rep = new ResourceRepository();

    @Test
    public void findByIdTest(){
        assertEquals(1, rep.findById(UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c")).getValueOfResource());
    }

    @Test
    public void findAllTest(){
        assertEquals(5, rep.findAll().get(4).getValueOfResource());
    }

    @Test
    public void addResourceTest(){
        rep.addResource(new ResourceEnt(420));
        assertEquals(420, rep.findAll().get(5).getValueOfResource());
    }

    @Test
    public void updateTest() {
        try {
            rep.update(new ResourceEnt(UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c"), 123));
            assertEquals(123, rep.findById(UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c")).getValueOfResource());
        } catch (ResourceAllocationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void changeAllocationTest() {
        rep.changeAllocation((UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c")));
        assertTrue(rep.findById(UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c")).isAllocated());
    }

    @Test
    public void deleteTest() {
        try {
            rep.delete(UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c"));
            assertNull(rep.findById(UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c")));
        } catch (ResourceAllocationException e) {
            e.printStackTrace();
        }
    }
}
