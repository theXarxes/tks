package adapter.repositories.repository;
import adapter.repositories.data.resources.ResourceEnt;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class ResourceRepository {

//    List<ResourceEnt> resources = Collections.synchronizedList(new ArrayList<>(Arrays.asList(
//            new ResourceEnt(UUID.fromString("68a577ae-6863-4510-82ce-aadecadb736c"),1),
//            new ResourceEnt(UUID.fromString("71900926-0ab8-454f-abba-cf49a73ef503"),2),
//            new ResourceEnt(UUID.fromString("185fa974-fb7c-4d57-bf53-51ef5fd9563e"),3),
//            new ResourceEnt(UUID.fromString("b40fe46b-ba62-498a-a1d3-5a7ca4feae1a"), 4),
//            new ResourceEnt(UUID.fromString("f01221d3-c14b-4c40-adfb-509238ed26a4"), 5)
//    )));
//
//    public void addResource(ResourceEnt r){
//            resources.add(r);
//    }
//
//    public ResourceEnt findById(UUID id){
//        for(ResourceEnt x: resources){
//            if(x.getId().equals(id)){
//                return x;
//            }
//        }
//        return null;
//    }
//
//    public List<ResourceEnt> findAll(){
//        return resources;
//    }
//
//    public boolean update(PutResourceDTO resourceDTO) throws ResourceAllocationException {
//        ResourceEnt x = findById(resourceDTO.getId());
//        if(!x.isAllocated()){
//            x.setValueOfResource(resourceDTO.getValueOfResource());
//            return true;
//        }
//        throw new ResourceAllocationException("Allocated ResourceEnt cannot be changed...");
//    }
//
//    public boolean delete(UUID id) throws ResourceAllocationException{
//        ResourceEnt x = findById(id);
//        if(!x.isAllocated()){
//            resources.remove(x);
//            return true;
//        }
//        throw new ResourceAllocationException("Allocated ResourceEnt cannot be deleted...");
//    }
//
//    public void changeAllocation(UUID id){
//        ResourceEnt x = findById(id);
//        x.setAllocated(!x.isAllocated());
//    }

}
