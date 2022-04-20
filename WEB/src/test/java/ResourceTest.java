import DTO.resourceDTO.GetResourceDTO;
import controller.ResourceController;
import org.junit.jupiter.api.Test;
import org.microshed.testing.jaxrs.RESTClient;
import org.microshed.testing.jupiter.MicroShedTest;
import org.microshed.testing.testcontainers.ApplicationContainer;
import org.testcontainers.junit.jupiter.Container;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicroShedTest
public class ResourceTest {

    @Container
    public static ApplicationContainer app = new ApplicationContainer();

    @RESTClient
    public static ResourceController resourceController;

    @Test
    public void getTest() {
        GetResourceDTO r = resourceController
                .getById("68a577ae-6863-4510-82ce-aadecadb736c")
                .readEntity(GetResourceDTO.class);
        assertNotNull(r);
        assertEquals(1, r.getValueOfResource());
    }

}
