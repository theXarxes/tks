package service;



import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.UUID;

@ApplicationScoped
public class ResAllMarkerService {

//    public void allocateResource(UUID resourceId, int allocationDelay, String user) throws ResourceException, UserException {
//        User u = userRepository.getUser(user);
//        if(u != null){
//            if(u.isActive()){
//                Resource r = resourceRepository.findById(resourceId);
//                if(r != null){
//                    if(!r.isAllocated()){
//                        Resource res = resourceRepository.findById(resourceId);
//                        ResourceAllocationMarker marker = new ResourceAllocationMarker(res, allocationDelay, u);
//                        r.setAllocated(true);
//                        allMarkerRepository.getMarkers().add(marker);
//                        return;
//                    }
//                    throw new ResourceAllocationException("Resource already allocated...");
//                }
//                throw new ResourceAllocationException("Invalid resource id...");
//            }
//            throw new UserException("User is inactive...");
//        }
//        throw new UserException("Invalid user login...");
//    }
//
//    public void allocateResource(PostMarkerDTO dto) throws ResourceException, UserException {
//        User u = userRepository.getUser(dto.getUser());
//        if(u != null){
//            if(u.isActive()){
//                Resource r = resourceRepository.findById(dto.getResourceId());
//                if(r != null){
//                    if(!r.isAllocated()){
//                        Resource res = resourceRepository.findById(dto.getResourceId());
//                        ResourceAllocationMarker marker = new ResourceAllocationMarker(res, dto.getDelay(), u);
//                        r.setAllocated(true);
//                        allMarkerRepository.getMarkers().add(marker);
//                        return;
//                    }
//                    throw new ResourceAllocationException("Resource already allocated...");
//                }
//                throw new ResourceAllocationException("Invalid resource id...");
//            }
//            throw new UserException("User is inactive...");
//        }
//        throw new UserException("Invalid user login...");
//    }
//
//    public void endAllocation(UUID id) throws ResourceException {
//            ResourceAllocationMarker r = allMarkerRepository.findById(id);
//            if (r == null) throw new ResourceException("Invalid marker id...");
//            resourceRepository.changeAllocation(r.getResource().getId());
//            r.setEnded(true);
//    }

}
