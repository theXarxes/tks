package service;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.UUID;

@ApplicationScoped
public class ResourceService {

//    @Inject
//    ResourceRepository resourceRepository;
//
//    public void addResource(PostResourceDTO resourceDTO){
//        resourceRepository.addResource(new Resource(resourceDTO.getValueOfResource()));
//    }
//
//    public GetResourceDTO findById(UUID id) throws ResourceException {
//            Resource r = resourceRepository.findById(id);
//            if (r == null){
//                throw new ResourceException("Invalid resource id...");
//            }
//            return ResourceMapper.resourceMapper(r);
//    }
//
//    public ArrayList<GetResourceDTO> findAll(){
//        ArrayList<GetResourceDTO> list = new ArrayList<>();
//        for (Resource r : resourceRepository.findAll()){
//            list.add(ResourceMapper.resourceMapper(r));
//        }
//        return list;
//    }
//
//    public void update(PutResourceDTO resourceDTO) throws ResourceAllocationException {
//            if (!resourceRepository.update(resourceDTO)){
//                throw new ResourceAllocationException("Invalid resource id...");
//            }
//    }
//
//    public void delete(UUID id) throws ResourceException {
//            if (!resourceRepository.delete(id)){
//                throw new ResourceException("Invalid resource id...");
//            }
//    }
}
