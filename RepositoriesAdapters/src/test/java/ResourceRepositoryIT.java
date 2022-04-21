//import adapter.adapters.ResourceRepositoryAdapter;
//import adapter.repositories.data.resources.ResourceEnt;
//import adapter.repositories.repository.ResourceRepository;
//import entity.resources.Resource;
//import infrastructure.resourcePorts.EditResourcePort;
//import infrastructure.resourcePorts.ReadResourcePort;
//import org.junit.jupiter.api.Test;
//
//import javax.inject.Inject;
//import java.util.List;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ResourceRepositoryIT {
//
//    @Inject
//    ResourceRepository repository;
//
//    @Test
//    public void getAllTest(){
//        List<ResourceEnt> r = repository.findAll();
//        assertEquals(5, r.size());
//    }
//
//    @Test
//    public void getByIdTest(){
//        ResourceEnt r = repository.findById(UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c"));
//        assertEquals(1, r.getValueOfResource());
//    }
//
//
//}
